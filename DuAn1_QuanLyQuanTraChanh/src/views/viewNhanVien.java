
package views;

import domainmodels.NhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.LuongSV;
import services.QLNVServices;
import services.impl.LuongSVimpl;
import services.impl.QLNVImpl;


public class viewNhanVien extends javax.swing.JPanel {
private DefaultTableModel dtm = new DefaultTableModel();
    private QLNVServices qLNVServices = new QLNVImpl();
    private ArrayList<NhanVien> list = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private LuongSV lsv = new LuongSVimpl();
    public viewNhanVien() {
        initComponents();
         gt();
        tt();
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

    void loadTableSearch(String ma) {
        //dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (NhanVien nv : qLNVServices.listSearch(ma)) {
            Object[] row = {
                i, nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(),
                nv.getSdt(), nv.getTrangThai() == 0 ? "Đang làm" : "Đã nghỉ", nv.getAnh()
            };
            dtm.addRow(row);
            i++;
        }
    }

    void loadTable() {
        dtm = (DefaultTableModel) tbNhanVien.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (NhanVien nv : qLNVServices.listAll()) {
            Object[] row = {
                i, nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(),
                nv.getSdt(), nv.getTrangThai() == 0 ? "Đang làm" : "Đã nghỉ", nv.getAnh()
            };
            dtm.addRow(row);
            i++;
        }
    }
//    public String idLuong(String luong){
//        String idString="";
//        String idLuong="";
//        for(luong lg: lsv.getlist()){
//            if(luong.equals(lg.getMucLuong()){
//                
//            }
//        }
//    }

//    private NhanVien getForm() {
//        try {
//            NhanVien nv = new NhanVien();
//            String ma = txtMaNV.getText();
//            String ten = txtTenNV.getText();
//            String ngaySinh1 = txtNgaySinh.getText();
//            String diaChi = txtDiachi.getText();
//            String sdt = txtSDT.getText();
//            String anh = lbImage.getText();
////        String luong = cbbLuong.getSelectedItem().toString();
//            if (ma.length() == 0 || ten.length() == 0 || ngaySinh1.length() == 0 || diaChi.length() == 0 || sdt.length() == 0) {
//                JOptionPane.showMessageDialog(this, "Du lieu trong. Moi nhap lai!");
//                return null;
//            }
//            Date ngaySinh = sdf.parse(ngaySinh1);
////        double luong1 = Double.parseDouble(luong);
//            if (rdNam.isSelected()) {
//                nv.setGioiTinh("Nam");
//            } else {
//                nv.setGioiTinh("Nu");
//            }
//            if (rdDangLam.isSelected()) {
//                nv.setTrangThai(0);
//            } else {
//                nv.setTrangThai(1);
//            }
//            nv.setMa(ma);
//            nv.setHoTen(ten);
//            nv.setNgaySinh(ngaySinh);
//            nv.setDiaChi(diaChi);
//            nv.setSdt(sdt);
//            nv.setAnh(anh);
//
//            return nv;
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//    void clear() {
//        txtMaNV.setText("");
//        txtTenNV.setText("");
//        txtNgaySinh.setText("");
//        txtDiachi.setText("");
//        txtSDT.setText("");
//        lbImage.setText("Thêm hình ảnh");
//        bt.clearSelection();
//        bt1.clearSelection();
//    }
    
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
        jPanel2 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtSDT1 = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtMaNV1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("CMND");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xoa.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Mã nhân viên");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Anh");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(131, 131, 131)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(rdDangLam)
                                            .addGap(97, 97, 97)
                                            .addComponent(rdDaNghi)
                                            .addGap(32, 32, 32))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(rdNam)
                                                    .addGap(52, 52, 52)
                                                    .addComponent(rdNu))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                                    .addComponent(txtSDT1, javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtMaNV1))
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(btnXoa))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnclear, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdDangLam)
                            .addComponent(rdDaNghi))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "SDT", "CMND", "Trạng thái", "Mật khẩu", "Địa chỉ", "Ảnh"
            }
        ));
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
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
//        NhanVien nv = getForm();
//        if (nv == null) {
//            return;
//        }
//        qLNVServices.insert(nv);
//        loadTable();
//        clear();
//        JOptionPane.showMessageDialog(this, "Them thanh cong");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        int row = tbNhanVien.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Chon dong can Xoa");
//            return;
//        }
//        String ma = tbNhanVien.getValueAt(row, 1).toString();
//        qLNVServices.delete(ma);
//        loadTable();
//        clear();
//        JOptionPane.showMessageDialog(this, "Xoa thanh cong");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

//        int row = tbNhanVien.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Chon dong can Sua");
//            return;
//        }
//        NhanVien nv = getForm();
//        String ma = tbNhanVien.getValueAt(row, 1).toString();
//        qLNVServices.update(ma, nv);
//        loadTable();
//        clear();
//        JOptionPane.showMessageDialog(this, "Sua thanh cong");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
//        clear();
//        JOptionPane.showMessageDialog(this, "Clear Form thanh cong");
    }//GEN-LAST:event_btnclearActionPerformed

    private void rdDaNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDaNghiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDaNghiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnclear;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rdDaNghi;
    private javax.swing.JRadioButton rdDangLam;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private com.raven.swing.table.Table tbNhanVien;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaNV1;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT1;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
