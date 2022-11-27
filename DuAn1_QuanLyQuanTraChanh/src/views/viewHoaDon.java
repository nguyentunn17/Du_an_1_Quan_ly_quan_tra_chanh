package views;

import domainmodels.HoaDon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.HoaDon_sv;
import services.impl.HoaDon_Imlp;

public class viewHoaDon extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private HoaDon_sv hoaDon_sv = new HoaDon_Imlp();

    public viewHoaDon() {
        initComponents();
        loatTable();
    }
//    private HoaDon getData() {
//        String ma = txt_ma.getText().trim();
//        String ngaytao = txt_ngaytao.getText().trim();
//        String ngaytt = txt_ngaytt.getText().trim();
//        String ngayship = txt_ngays.getText().trim();
//        String ngaynhan = txt_ngayn.getText().trim();
//        String tt = txt_trangthai.getText().trim();
//        String ten = txt_ten.getText().trim();
//        String diachi = txt_diachi.getText().trim();
//        String sdt = txt_sdt.getText().trim();
//        if (ma.length() == 0
//                || ten.length() == 0
//                || ngaynhan.length() == 0 || ngayship.length() == 0 || ngaytao.length() == 0 || ngaytt.length() == 0) {
//            JOptionPane.showMessageDialog(this, "Ko được để trống");
//            return null;
//        }
//
//        int trangthai = -1;
//        trangthai = Integer.parseInt(tt);
//
//        HoaDon hoaDon = new HoaDon(ma, ngaytao, ngaytt, ngayship, ngaynhan, trangthai, ten, diachi, sdt);
//        return hoaDon;
//    }

    public void loatTable() {
        defaultTableModel = (DefaultTableModel) this.tbl_hoadon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : this.hoaDon_sv.getAll()) {
            Object[] rowdata = {
                hoaDon.getId(),
                hoaDon.getMa(),
                hoaDon.getNgaytao(),
                hoaDon.getNgaythanhtoan(), 
                hoaDon.getNgayship(), 
                hoaDon.getNgaynhap(), 
                hoaDon.getTrangthai(), 
                hoaDon.getTen(), 
                hoaDon.getDiachi(), 
                hoaDon.getSdt()

            };
            defaultTableModel.addRow(rowdata);

        }

    }

    private String getid(String ma) {
        for (HoaDon hoaDon : this.hoaDon_sv.getAll()) {
            if (hoaDon.getMa().equals(ma)) {
                return hoaDon.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoadon = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_hoadon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.swing.table.Table tbl_hoadon;
    // End of variables declaration//GEN-END:variables
}
