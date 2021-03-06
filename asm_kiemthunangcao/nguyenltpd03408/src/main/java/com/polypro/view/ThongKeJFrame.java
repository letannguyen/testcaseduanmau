/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polypro.view;

import com.polypro.dao.KhoaHocDAO;
import com.polypro.dao.ThongKeDAO;
import com.polypro.helper.ShareHelper;
import com.polypro.model.KhoaHoc;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ThongKeJFrame extends javax.swing.JFrame {
    KhoaHocDAO khdao = new KhoaHocDAO();
    ThongKeDAO dao = new ThongKeDAO();
    /**
     * Creates new form ThongKeJFrame
     */
    public ThongKeJFrame(int tabIndex) {
        initComponents();
        setLocationRelativeTo(null);
        init();
        windowOpened();
        jTabbedPane1.setSelectedIndex(tabIndex);
    }
    
    void init(){
        setIconImage(ShareHelper.APP_ICON);
    }
 
    void windowOpened() {
        fillComboBoxKhoaHoc();
        fillComboBoxNam();
        fillTableBangDiem();
        fillTableDoanhThu();
        fillTableKhoaHoc();
        fillTableNguoiHoc();
    }
    

    void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoahoc.getModel();
        model.removeAllElements();
        List<KhoaHoc> list = khdao.select();
        for (KhoaHoc kh : list) {
            model.addElement(kh);
        }
        cboKhoahoc.setSelectedIndex(0);
    }

    void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<KhoaHoc> list = khdao.select();
        for (KhoaHoc kh : list) {
            int nam = kh.getNgayKG().getYear() + 1900;
            if (model.getIndexOf(nam) < 0) {
                model.addElement(nam);
            }
        }
        cboNam.setSelectedIndex(0);
    }

    void fillTableBangDiem() {
        DefaultTableModel model = (DefaultTableModel) tblBangdiem.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cboKhoahoc.getSelectedItem();
        List<Object[]> list = dao.getBangDiem(kh.getMaKH());
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
    
    void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoihoc.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getNguoiHoc();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    void fillTableKhoaHoc() {
        DefaultTableModel model = (DefaultTableModel) tblTonghop.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getDiemTheoChuyenDe();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    void fillTableDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhthu.getModel();
        model.setRowCount(0);
        int nam = Integer.parseInt(cboNam.getSelectedItem().toString());
        List<Object[]> list = dao.getDoanhThu(nam);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlNguoihoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoihoc = new javax.swing.JTable();
        pnlBangdiem = new javax.swing.JPanel();
        lblKhoahoc = new javax.swing.JLabel();
        cboKhoahoc = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangdiem = new javax.swing.JTable();
        pnlTongdiem = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTonghop = new javax.swing.JTable();
        pnlDoanhthu = new javax.swing.JPanel();
        lblNam = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhthu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 255));
        lblTitle.setText("T???NG H???P TH???NG K??");

        tblNguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N??M", "S??? NG?????I H???C", "?????U TI??N", "SAU C??NG"
            }
        ));
        jScrollPane1.setViewportView(tblNguoihoc);

        javax.swing.GroupLayout pnlNguoihocLayout = new javax.swing.GroupLayout(pnlNguoihoc);
        pnlNguoihoc.setLayout(pnlNguoihocLayout);
        pnlNguoihocLayout.setHorizontalGroup(
            pnlNguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        pnlNguoihocLayout.setVerticalGroup(
            pnlNguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguoihocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NG?????I H???C", pnlNguoihoc);

        lblKhoahoc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblKhoahoc.setText("KH??A H???C:");

        cboKhoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoahocActionPerformed(evt);
            }
        });

        tblBangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "M?? NH", "H??? V?? T??N", "??I???M", "X???P LO???I"
            }
        ));
        jScrollPane2.setViewportView(tblBangdiem);

        javax.swing.GroupLayout pnlBangdiemLayout = new javax.swing.GroupLayout(pnlBangdiem);
        pnlBangdiem.setLayout(pnlBangdiemLayout);
        pnlBangdiemLayout.setHorizontalGroup(
            pnlBangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhoahoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboKhoahoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        pnlBangdiemLayout.setVerticalGroup(
            pnlBangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKhoahoc)
                    .addComponent(cboKhoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("B???NG ??I???M", pnlBangdiem);

        tblTonghop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CHUY??N ?????", "T???NG S??? HV", "CAO NH???T", "TH???P NH???T", "??I???M TB"
            }
        ));
        jScrollPane3.setViewportView(tblTonghop);

        javax.swing.GroupLayout pnlTongdiemLayout = new javax.swing.GroupLayout(pnlTongdiem);
        pnlTongdiem.setLayout(pnlTongdiemLayout);
        pnlTongdiemLayout.setHorizontalGroup(
            pnlTongdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        pnlTongdiemLayout.setVerticalGroup(
            pnlTongdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("T???NG H???P ??I???M", pnlTongdiem);

        lblNam.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNam.setText("N??M:");

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        tblDoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CHUY??N ?????", "S??? KH??A", "DOANH THU", "HP CAO NH???T", "HP TH???P NH???T", "HP TRUNG B??NH"
            }
        ));
        jScrollPane4.setViewportView(tblDoanhthu);

        javax.swing.GroupLayout pnlDoanhthuLayout = new javax.swing.GroupLayout(pnlDoanhthu);
        pnlDoanhthu.setLayout(pnlDoanhthuLayout);
        pnlDoanhthuLayout.setHorizontalGroup(
            pnlDoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNam)
                .addGap(18, 18, 18)
                .addComponent(cboNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        pnlDoanhthuLayout.setVerticalGroup(
            pnlDoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNam)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DOANH THU", pnlDoanhthu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        fillTableDoanhThu();
    }//GEN-LAST:event_cboNamActionPerformed

    private void cboKhoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoahocActionPerformed
        // TODO add your handling code here:
        fillTableBangDiem();
    }//GEN-LAST:event_cboKhoahocActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeJFrame(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboKhoahoc;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblKhoahoc;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBangdiem;
    private javax.swing.JPanel pnlDoanhthu;
    private javax.swing.JPanel pnlNguoihoc;
    private javax.swing.JPanel pnlTongdiem;
    private javax.swing.JTable tblBangdiem;
    private javax.swing.JTable tblDoanhthu;
    private javax.swing.JTable tblNguoihoc;
    private javax.swing.JTable tblTonghop;
    // End of variables declaration//GEN-END:variables
}
