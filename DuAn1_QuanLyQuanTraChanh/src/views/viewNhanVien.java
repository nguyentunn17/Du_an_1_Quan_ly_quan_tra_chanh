package views;

import domainmodels.ChucVu;
import domainmodels.NhanVien;
import domainmodels.NhanVienVMD;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ChucVuSevrice;
import services.QLNVServices;
import services.impl.ChucVuImpl;

import services.impl.QLNVImpl;

public class viewNhanVien extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private QLNVServices qLNVServices = new QLNVImpl();
    private ArrayList<NhanVien> list = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private ChucVuSevrice cvs = new ChucVuImpl();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    public viewNhanVien() {
        initComponents();
        gt();
        tt();
        cbbChucVu();
        loadTable();
    }
    ButtonGroup bt = new ButtonGroup();
    ButtonGroup bt1 = new ButtonGroup();

    void gt() {
        bt.add(rdNu);
        bt.add(rdNam);
    }

    void tt() {
        bt1.add(rdDangLam);
        bt1.add(rdDaNghi);
    }

    public void loadTableSearch(String ma) {
        //dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVienVMD nv : qLNVServices.listSearch(ma)) {
            Object[] row = {
                nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSdt(), nv.getChucVu(), nv.getDiaChi(),
                nv.getTrangThai() == 0 ? "Đang làm" : "Đã nghỉ", nv.getDiaChi(), nv.getAnh()
            };
            dtm.addRow(row);
        }
    }

    public void loadTable() {
        dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVienVMD nv : qLNVServices.listViewMoDel()) {
            Object[] row = {
                nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSdt(), nv.getChucVu(), nv.getMatKhau(),
                nv.getTrangThai() == 0 ? "Đang làm" : "Đã nghỉ", nv.getDiaChi(), nv.getAnh()
            };
            dtm.addRow(row);
        }
    }

    public String IdCV() {
        String idString = "";
        int row = tbNhanVien.getSelectedRow();
        if (row == -1) {
            return null;
        }
        String ma = tbNhanVien.getValueAt(row, 0).toString();
        String ten = tbNhanVien.getValueAt(row, 1).toString();
        String gt = tbNhanVien.getValueAt(row, 2).toString();
        String ngaySinh = tbNhanVien.getValueAt(row, 3).toString();
        String sdt = tbNhanVien.getValueAt(row, 4).toString();
        String cv = tbNhanVien.getValueAt(row, 5).toString();
        String mk = tbNhanVien.getValueAt(row, 6).toString();
        String trangThai = tbNhanVien.getValueAt(row, 7).toString();
        String diaChi = tbNhanVien.getValueAt(row, 8).toString();
        String anh = tbNhanVien.getValueAt(row, 9).toString();
        String idCV = "";
        for (ChucVu cv1 : cvs.listAll()) {
            if (cv.trim().equals(cv1.getTenCV().trim()) == true) {
                idCV = cv1.getId();
                break;
            }
        }
        for (NhanVien nv : qLNVServices.listAll()) {
            if (idCV.trim().equals(nv.getIdCV().trim())) {
                idString = nv.getId();
                break;
            }
        }
        return idString;
    }

    public String idCV(String chucVu) {
        String idString = "";
        for (ChucVu cv : cvs.listAll()) {
            if (chucVu.trim().equals(cv.getTenCV().trim())) {
                idString = cv.getId();
                break;
            }
        }
        return idString;
    }

    public NhanVien getForm() {
        NhanVien nv = new NhanVien();
        String ma = txtMaNV.getText().trim();
        String ten = txtTenNV.getText().trim();
        Date ngaySinh = dscNgaySinh.getDate();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();
        String mk = txtPass.getText().trim();
        String anh = lblImage.getText().trim();
        String cv = cbbChucVu.getSelectedItem().toString();
        if (ma.length() == 0 || ten.length() == 0 || diaChi.length() == 0 || sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống. Nhập lại!");
            return null;
        }
        if (rdNam.isSelected()) {
            nv.setGioiTinh("Nam");
        } else {
            nv.setGioiTinh("Nu");
        }
        if (rdDangLam.isSelected()) {
            nv.setTrangThai(0);
        } else {
            nv.setTrangThai(1);
        }
        nv.setIdCV(idCV(cv));
        nv.setMa(ma);
        nv.setHoTen(ten);
        nv.setNgaySinh(ngaySinh);
        nv.setDiaChi(diaChi);
        nv.setSdt(sdt);
        nv.setAnh(anh);
        nv.setMatKhau(mk);
        return nv;
    }

    public void cbbChucVu() {
        dcbm = (DefaultComboBoxModel) cbbChucVu.getModel();
        ArrayList<String> listChucVu = new ArrayList<>();
        for (ChucVu cv : cvs.listAll()) {
            listChucVu.add(cv.getTenCV());
        }
        for (String addCV : listChucVu) {
            dcbm.addElement(addCV);
        }
    }

    public void clear() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        dscNgaySinh.setDate(null);
        txtDiaChi.setText("");
        txtSDT.setText("");
        lblImage.setText("");
        bt.clearSelection();
        bt1.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        rdDangLam = new javax.swing.JRadioButton();
        rdDaNghi = new javax.swing.JRadioButton();
        dscNgaySinh = new com.toedter.calendar.JDateChooser();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnChucVu = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVien = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Ngày sinh");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Số điện thoại");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Địa chỉ:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Trạng thái");

        rdNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdNam.setText("Nam");

        rdNu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Họ và tên");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Mật khẩu");

        rdDangLam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdDangLam.setText("Đang làm");
        rdDangLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDangLamActionPerformed(evt);
            }
        });

        rdDaNghi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdDaNghi.setText("Đã nghỉ");
        rdDaNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDaNghiActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Mã nhân viên");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblImage.setBackground(new java.awt.Color(204, 204, 204));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Chức vụ:");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xoa.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus-6-24.png"))); // NOI18N
        btnChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChucVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(226, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10))
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addGap(0, 2, Short.MAX_VALUE)
                                            .addComponent(rdDangLam)
                                            .addGap(97, 97, 97)
                                            .addComponent(rdDaNghi)
                                            .addGap(32, 32, 32))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdNam)
                                                    .addGap(133, 133, 133)
                                                    .addComponent(rdNu))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(dscNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel12))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                        .addComponent(txtMaNV)))))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtPass))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnChucVu)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(rdNam)
                                    .addComponent(rdNu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dscNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdDangLam)
                            .addComponent(rdDaNghi))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnChucVu))
                        .addGap(48, 48, 48)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "SDT", "Chức vụ", "Mật khẩu", "Trạng thái", "Địa chỉ", "Ảnh"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbNhanVien);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdDangLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDangLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDangLamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        // TODO add your handling code here:
        NhanVien nv = getForm();
        if (nv == null) {
            return;
        }
        qLNVServices.insert(nv);
        loadTable();
        clear();
        JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tbNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn nhân viên cần xóa trong bảng");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không", "select an choosen", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            qLNVServices.delete(IdCV());
            loadTable();
            clear();
            JOptionPane.showMessageDialog(this, "Xóa thanh công");
        } else {
            return;
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        int row = tbNhanVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can Sua");
            return;
        }
        NhanVien nv = getForm();
        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa không", "select an choosen", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            qLNVServices.update(IdCV(), nv);
            loadTable();
            clear();
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
        } else {
            return;
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
//        clear();
//        JOptionPane.showMessageDialog(this, "Clear Form thanh cong");
    }//GEN-LAST:event_btnclearActionPerformed

    private void rdDaNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDaNghiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDaNghiActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            Icon icon = new ImageIcon(file.getAbsolutePath());
            lblImage.setIcon(icon);
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        try {
            // TODO add your handling code here:
            int row = tbNhanVien.getSelectedRow();
            txtMaNV.setText(tbNhanVien.getValueAt(row, 0).toString());
            txtTenNV.setText(tbNhanVien.getValueAt(row, 1).toString());
            String gioiTinh = tbNhanVien.getValueAt(row, 2).toString();
            if (gioiTinh.equals("Nam")) {
                rdNam.setSelected(true);
            } else if (gioiTinh.equals("Nữ")) {
                rdNu.setSelected(true);
            }
            String ns = tbNhanVien.getValueAt(row, 3).toString();
            dscNgaySinh.setDate(sdf.parse(ns));

            txtSDT.setText(tbNhanVien.getValueAt(row, 4).toString());
            cbbChucVu.setSelectedItem(tbNhanVien.getValueAt(row, 5));
            txtPass.setText(tbNhanVien.getValueAt(row, 6).toString());
            String trangThai = tbNhanVien.getValueAt(row, 7).toString();
            if (trangThai.equals("Đang làm")) {
                rdDangLam.setSelected(true);
            } else if (trangThai.equals("Đã nghỉ")) {
                rdDaNghi.setSelected(true);
            }
            txtDiaChi.setText(tbNhanVien.getValueAt(row, 8).toString());
            lblImage.setText(tbNhanVien.getValueAt(row, 9).toString());
        } catch (ParseException ex) {
            Logger.getLogger(viewNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChucVuActionPerformed
        // TODO add your handling code here:
        ViewChucVu vcv = new ViewChucVu();
        vcv.setVisible(true);
    }//GEN-LAST:event_btnChucVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChucVu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnclear;
    private javax.swing.JComboBox<String> cbbChucVu;
    private com.toedter.calendar.JDateChooser dscNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdDaNghi;
    private javax.swing.JRadioButton rdDangLam;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private com.raven.swing.table.Table tbNhanVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
