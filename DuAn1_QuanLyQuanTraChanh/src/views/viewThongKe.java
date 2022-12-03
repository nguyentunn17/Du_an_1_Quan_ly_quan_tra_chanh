/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodels.QuanLyThongKe;
import domainmodels.ThongKe;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import services.ThongKe_sv;
import services.impl.ThongKe_impl;

/**
 *
 * @author Inspiron
 */
public class viewThongKe extends javax.swing.JPanel {

    private ThongKe_sv thongKe_sv = new ThongKe_impl();
//    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form ThongKe_JFrame
     */
    public viewThongKe() {
        initComponents();

        //loadTable();
    }

//    public void loadTable(){
//        defaultTableModel=(DefaultTableModel) this.tbl_thongke.getModel();
//        defaultTableModel.setRowCount(0);
//        for(ThongKe thongKe: this.thongKe_sv.getList()){
//            Object[] rowdata={
//                thongKe.getNgayThanhToan(),thongKe.getTongtien()
//            
//            
//            };
//defaultTableModel.addRow(rowdata);
//        
//        }
//    
//    
//    }
//    private  ThongKe getdata(){
//        Date ngaythanhtoan= dc_ngay.getDate();
//        String tongtiennn=txt_tongtien.getText();
//        double tongtien=Double.parseDouble(tongtiennn);
//        ThongKe ke=new ThongKe(ngaythanhtoan, tongtien);
//        return ke;
//        
//    
//    
//    
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chiu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dc_ngaychon = new com.toedter.calendar.JDateChooser();
        btn_tim = new javax.swing.JButton();
        btn_chon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout chiuLayout = new javax.swing.GroupLayout(chiu);
        chiu.setLayout(chiuLayout);
        chiuLayout.setHorizontalGroup(
            chiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1295, Short.MAX_VALUE)
        );
        chiuLayout.setVerticalGroup(
            chiuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("Chon Ngay");

        btn_tim.setText("Tim");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        btn_chon.setText("ThongKe");
        btn_chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(dc_ngaychon, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btn_chon, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(dc_ngaychon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_chon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(chiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        // TODO add your handling code here:
        Date ngay = dc_ngaychon.getDate();
        QuanLyThongKe ke = new QuanLyThongKe();
        ke.setDateTo(ngay, chiu);


    }//GEN-LAST:event_btn_timActionPerformed

    private void btn_chonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonActionPerformed
        // TODO add your handling code here:
        QuanLyThongKe lyThongKe = new QuanLyThongKe();
        lyThongKe.setDateToChartl(chiu);
    }//GEN-LAST:event_btn_chonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chon;
    private javax.swing.JButton btn_tim;
    private javax.swing.JPanel chiu;
    private com.toedter.calendar.JDateChooser dc_ngaychon;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
