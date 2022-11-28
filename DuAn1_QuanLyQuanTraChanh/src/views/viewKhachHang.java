/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodels.KhachHang;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.KhachSV;
import services.impl.KhachSVimpl;

/**
 *
 * @author Phuong
 */
public class viewKhachHang extends javax.swing.JFrame {

    private KhachSV ksv = new KhachSVimpl();
    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form viewKhachHang
     */
    public viewKhachHang() {
        initComponents();
        gioitinh();
    }

    void gioitinh() {
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rd_nam);
        btnGroup.add(rd_nu);
    }

    void loaddat() {
        defaultTableModel = (DefaultTableModel) tb_kh.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : ksv.getlist()) {
            defaultTableModel.addRow(new Object[]{
                kh.getMakh(), kh.getTenkh(), kh.getNgaysinh(), kh.getSdt(), kh.getDiachi(), kh.getGioitinh(), kh.getGhichu()
            });
        }

    }

    private KhachHang getdata() {
        KhachHang kh = new KhachHang();
        String maKh = txt_makh.getText().trim();
        String Tenkh = txt_tenkh.getText().trim();
        String ngaysinh = txt_ngaysinh.getText().trim();
        String sodt = txt_sdt.getText().trim();
        String diachi = txt_diachi.getText().trim();

        String ghichu = txt_ghichu.getText().trim();
        if (maKh.length() == 0 || Tenkh.length() == 0 || ngaysinh.length() == 0 || sodt.length() == 0 || diachi.length() == 0 || ghichu.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return null;
        }
        kh.setMakh(maKh);
        kh.setTenkh(Tenkh);
        kh.setNgaysinh(ngaysinh);
        kh.setSdt(sodt);
        kh.setDiachi(diachi);
        if (rd_nam.isSelected()) {
            kh.setGioitinh("Nam");
        } else {
            kh.setGioitinh("Nữ");
        }
        kh.setGhichu(ghichu);
        return kh;
    }

    void clear() {
        txt_makh.setText("");
        txt_tenkh.setText("");
        txt_ngaysinh.setText("");
        txt_sdt.setText("");
        txt_diachi.setText("");
        txt_ghichu.setText("");
        rd_nam.setSelected(true);
        rd_nu.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_makh = new javax.swing.JTextField();
        txt_tenkh = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_ghichu = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        btn_moi = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thongke = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_kh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("KHÁCH HÀNG");

        jLabel2.setText("Mã Khách hàng:");

        jLabel3.setText("Tên Khách hàng:");

        jLabel4.setText("SĐT:");

        jLabel5.setText("Ngày sinh:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Giới tính:");

        jLabel8.setText("Ghi chú:");

        rd_nam.setText("Nam");

        rd_nu.setText("Nữ");

        btn_moi.setText("MỚI");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_capnhat.setText("CẬP NHẬT");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btn_xoa.setText("XÓA");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_thongke.setText("THỐNG KÊ");
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        tb_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Ngày sinh", "SDT", "Địa chỉ", "Giới tính", "Ghi chú", "Trạng Thái"
            }
        ));
        tb_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_kh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_makh)
                    .addComponent(txt_tenkh)
                    .addComponent(txt_sdt)
                    .addComponent(txt_ngaysinh)
                    .addComponent(txt_diachi)
                    .addComponent(txt_ghichu, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_moi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_capnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_thongke))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_moi))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btn_capnhat)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_xoa)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rd_nam)
                        .addComponent(rd_nu)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btn_thongke))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, ksv.insert(getdata()));
        loaddat();
        clear();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
        KhachHang kh = this.getdata();
        this.ksv.Update(kh.getMakh(), kh);
        this.loaddat();
        clear();
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int i = tb_kh.getSelectedRow();

        String idStr = tb_kh.getValueAt(i, 0).toString();
        this.ksv.delete(idStr);
        this.loaddat();
        clear();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        // TODO add your handling code here:
        loaddat();
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void tb_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khMouseClicked
        // TODO add your handling code here:
        int row = tb_kh.getSelectedRow();
        txt_makh.setText(tb_kh.getValueAt(row, 0).toString());
        txt_tenkh.setText(tb_kh.getValueAt(row, 1).toString());
        txt_ngaysinh.setText(tb_kh.getValueAt(row, 2).toString());
        txt_sdt.setText(tb_kh.getValueAt(row, 3).toString());
        txt_diachi.setText(tb_kh.getValueAt(row, 4).toString());
        txt_ghichu.setText(tb_kh.getValueAt(row, 6).toString());
        String check= tb_kh.getValueAt(row, 5).toString();
        if(check.equalsIgnoreCase("Nam")){
            rd_nam.setSelected(true);
        }else if(check.equalsIgnoreCase("Nữ")){
            rd_nu.setSelected(true);
        }else{
            JOptionPane.showMessageDialog(this,"Dữ liệu giới tính lưu không trùng khớp!!");
        }
    }//GEN-LAST:event_tb_khMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_kh;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_ghichu;
    private javax.swing.JTextField txt_makh;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenkh;
    // End of variables declaration//GEN-END:variables
}
