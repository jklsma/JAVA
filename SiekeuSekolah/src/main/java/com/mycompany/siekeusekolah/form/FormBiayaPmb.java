/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.siekeusekolah.form;

import com.mycompany.siekeusekolah.Koneksi;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rico
 */
public class FormBiayaPmb extends javax.swing.JInternalFrame {
    Koneksi kon;
    ResultSet rs;
    String mode;
    
    /**
     * Creates new form FormAkun
     */
    public FormBiayaPmb() {
        initComponents();
        kon = new Koneksi(); //Buat Koneksi
        tampilData(""); //menampilkan Data
        cbjurusan();
        cbakun();
        cbangkatan();
    }
    
    private void tampilData(String filter){
        Object[] judulKolom = {"No", "id", "Akun id", "Nama Akun","Nama Biaya","Jumlah","Jurusan","Gelombang","Angkatan"};
        DefaultTableModel modelAkun = new DefaultTableModel(null,judulKolom);
        tableData.setModel(modelAkun);

        try{
            String sql="select biaya_pmb.id, akun_id, nama_akun, nama_biaya, jumlah, jurusan, gelombang, tahun_angkatan, nama_jurusan from biaya_pmb INNER JOIN jurusan on biaya_pmb.jurusan=jurusan.id INNER JOIN akun on biaya_pmb.akun_id=akun.kode where akun_id like '%"+filter+"%' or nama_akun like '%"+filter+"%'";
            rs = kon.perintah.executeQuery(sql);
            int no = 0;
            while (rs.next()) {
                no++;
                String txtId =rs.getString("id");
                String txtAkunId =rs.getString("akun_id");
                String txtNamaAkun =rs.getString("nama_akun");
                String txtNamaBiaya =rs.getString("nama_biaya");
                String txtJumlah =rs.getString("jumlah");
                String txtNamaJurusan =rs.getString("nama_jurusan");
                String txtGelombang =rs.getString("gelombang");
                String txtTahunAngkatan =rs.getString("tahun_angkatan");
                String[] barisBaru = {Integer.toString(no), txtId, txtAkunId, txtNamaAkun, txtNamaBiaya, txtJumlah, txtNamaJurusan, txtGelombang, txtTahunAngkatan};
                modelAkun.addRow(barisBaru);
            }
        }catch(Exception salahe){
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
        }
    }
    
    public void cbjurusan(){
     try{
         String sql="select * from jurusan";
         rs = kon.perintah.executeQuery(sql);
         cbjurusan.addItem("-Pilih Jurusan-");
         while (rs.next()) {
             cbjurusan.addItem(rs.getString("id"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
    
    public void cbakun(){
     try{
         String sql="select * from akun";
         rs = kon.perintah.executeQuery(sql);
         cbakun.addItem("-Pilih Akun-");
         while (rs.next()) {
             cbakun.addItem(rs.getString("kode"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
       }
    }
    
    public void cbangkatan(){
     try{
         String sql="select * from angkatan";
         rs = kon.perintah.executeQuery(sql);
         cbangkatan.addItem("-Pilih Angkatan-");
         while (rs.next()) {
             cbangkatan.addItem(rs.getString("tahun"));
         }
        }catch(Exception e){
            System.err.println("Gagal Tampil data: "+e.getMessage());
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

        dialogForm = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        gelombang = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nama_biaya = new javax.swing.JTextField();
        cbjurusan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbakun = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbangkatan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Id");

        jLabel3.setText("Jumlah");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jLabel4.setText("Gelombang");

        jLabel5.setText("T.Angkatan");

        jLabel6.setText("Akun ID");

        cbakun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbakunMouseClicked(evt);
            }
        });

        jLabel7.setText("Nama Biaya");

        jLabel8.setText("Jurusan");

        cbangkatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbangkatanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dialogFormLayout = new javax.swing.GroupLayout(dialogForm.getContentPane());
        dialogForm.getContentPane().setLayout(dialogFormLayout);
        dialogFormLayout.setHorizontalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gelombang, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48)
                        .addComponent(cbjurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dialogFormLayout.createSequentialGroup()
                        .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogFormLayout.createSequentialGroup()
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(2, 2, 2)
                                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dialogFormLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(dialogFormLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(cbakun, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(dialogFormLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(nama_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialogFormLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(cbangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(simpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogFormLayout.setVerticalGroup(
            dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogFormLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbakun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nama_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gelombang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(simpan)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("FORM BIAYA PMB");

        tableData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableData);

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getAccessibleContext().setAccessibleName("FORM KELATITS");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        mode="tambah";
        id.setText(null);
        cbjurusan.setSelectedItem(null);
        cbakun.setSelectedItem(null);
        cbangkatan.setSelectedItem(null);
        nama_biaya.setText(null);
        gelombang.setText(null);
        jumlah.setText(null);
        id.setEnabled(true);
        dialogForm.setTitle("Form Biaya PMB - Tambah");
        dialogForm.pack();
        dialogForm.setLocationRelativeTo(null);
        dialogForm.setVisible(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        int baris_index = tableData.getSelectedRow();
        if(baris_index >= 0) {
            mode="ubah";
            String id_pilih = (tableData.getModel().getValueAt(baris_index, 1).toString());
            try {
                String sql="select * from biaya_pmb where id='"+id_pilih+"'";
                rs = kon.perintah.executeQuery(sql);
                if (rs.next()) {
                    String txtId =rs.getString("id");
                    String txtAkunId =rs.getString("akun_id");
                    String txtNamaBiaya =rs.getString("nama_biaya");
                    String txtJumlah =rs.getString("jumlah");
                    String txtGelombang =rs.getString("gelombang");
                    String txtTahunAngkatan =rs.getString("tahun_angkatan");
                    cbjurusan.setSelectedItem(rs.getString("jurusan"));
                    cbakun.setSelectedItem(txtAkunId);
                    cbangkatan.setSelectedItem(txtTahunAngkatan);
                    id.setText(txtId);
                    nama_biaya.setText(txtNamaBiaya);
                    gelombang.setText(txtGelombang);
                    jumlah.setText(txtJumlah);
                    
                    
                    cbjurusan.setEnabled(true);
                    id.setEnabled(false);
                    dialogForm.setTitle("Form Biaya PMB - Ubah");
                    dialogForm.pack();
                    dialogForm.setLocationRelativeTo(null);
                    dialogForm.setVisible(true);
                }
            } catch (Exception salahe) {
                System.err.println("Gagal Tampil data: "+salahe.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int baris_index = tableData.getSelectedRow();
        if (baris_index >= 0) {
            int jwb = JOptionPane.showConfirmDialog(this, "Yakin mau hapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(jwb == JOptionPane.YES_OPTION) {
                String id_pilih = (tableData.getModel().getValueAt(baris_index, 1).toString());
                try {
                    String sql="delete from biaya_pmb where id='"+id_pilih+"'";
                    kon.perintah.execute(sql);
                    tampilData("");
                } catch (Exception salahe) {
                    System.err.println("Gagal Tampil data: "+salahe.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Belum ada data yang dipilih");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        String txtCari = cari.getText();
        tampilData(txtCari);
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String txtId = id.getText();
        String txtAkunId = String.valueOf(cbakun.getSelectedItem());
        String txtNamaBiaya = nama_biaya.getText();
        String txtJumlah = jumlah.getText();
        String txtGelombang = gelombang.getText();
        String txtTahunAngkatan = String.valueOf(cbangkatan.getSelectedItem());
        String txtJurusan = String.valueOf(cbjurusan.getSelectedItem());
        String sql = "";
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String waktu_sekarang = now.format(format);
        
        if (mode == "tambah") {
            sql = "insert into biaya_pmb values ("
                + "'" + txtId +"',"
                + "'" + txtAkunId +"',"
                + "'" + txtNamaBiaya +"',"
                + "'" + txtJumlah +"',"
                + "'" + txtTahunAngkatan +"',"
                + "'" + txtGelombang +"',"
                + "'" + txtJurusan +"',"
                + "'" + waktu_sekarang +"',"
                + "'" + waktu_sekarang +"',"
                + "null"
                + ")";
        } else {
            sql = "update biaya_pmb set akun_id='"+txtAkunId+"',"
                + "nama_biaya='"+txtNamaBiaya+"',"
                + "jumlah='"+txtJumlah+"',"
                + "jurusan='"+txtJurusan+"',"
                + "gelombang='"+txtGelombang+"',"
                + "tahun_angkatan='"+txtTahunAngkatan+"',"
                + "updatedAt='"+waktu_sekarang+"'"
                + "where id='"+txtId+"'";
        }
        
        try {
            kon.perintah.execute(sql);
            dialogForm.setVisible(false);
            tampilData("");
        } catch (Exception salahe) {
            System.err.println("Gagal Tampil data: "+salahe.getMessage());
            JOptionPane.showConfirmDialog(this, "Gagal Simpan");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void cbakunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbakunMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbakunMouseClicked

    private void cbangkatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbangkatanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbangkatanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbakun;
    private javax.swing.JComboBox<String> cbangkatan;
    private javax.swing.JComboBox<String> cbjurusan;
    private javax.swing.JDialog dialogForm;
    private javax.swing.JTextField gelombang;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField nama_biaya;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tableData;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
