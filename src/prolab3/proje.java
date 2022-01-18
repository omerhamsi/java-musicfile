/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA
 */
public class proje extends javax.swing.JFrame {
baglanti baglanti;
kullanici user;
int sanatci_kontrol=0;
int guncelleme_sayfa_kontrol=0;
private int kontrol_button=0;
int a;
    ArrayList<sarkılar> genel_en_dinlenen=new ArrayList<>();
    ArrayList<Integer> genel_en_dinlenen_id=new ArrayList<>();
    ArrayList<JButton> premium_button=new ArrayList<>();
    ArrayList<Integer> premium_user_id=new ArrayList<>();
    ArrayList<Integer> takip_ettiklerim=new ArrayList<>();
    ArrayList<Integer> premium_pop_button=new ArrayList<>();
    ArrayList<JButton> premium_pop_click=new ArrayList<>();
    ArrayList<JLabel> pop_label_id=new ArrayList<>();
    ArrayList<JLabel> en_cok_dinlenen_label=new ArrayList<>();
    ArrayList<Integer> pop_10_id=new ArrayList<>();
     ArrayList<JLabel> jaz_label_id=new ArrayList<>();
     ArrayList<JLabel> klasik_label_id=new ArrayList<>();
     ArrayList<JButton> pop_10_button=new ArrayList<>();
     ArrayList<JButton> klasik_10_button=new ArrayList<>();
     ArrayList<Integer> klasik_10_id=new ArrayList<>();
     ArrayList<JButton> jaz_10_button=new ArrayList<>();
     ArrayList<Integer> jaz_10_id=new ArrayList<>();
     ArrayList<JButton> premium_klasik_button=new ArrayList<>();
     ArrayList<Integer> premium_klasik_id=new ArrayList<>();
     ArrayList<JButton> premium_jaz_button=new ArrayList<>();
     ArrayList<Integer> premium_jaz_id=new ArrayList<>();
     ArrayList<Integer> gozat_button_id=new ArrayList<>();
     ArrayList<JButton> gozat_buttons=new ArrayList<>();
     ArrayList<String> album_isimleri=new ArrayList<>();
     ArrayList<JButton> album_sil=new ArrayList<>();
     ArrayList<JButton> sanatci_sil_button=new ArrayList<>();
     ArrayList<Integer> sanatci_button_id=new ArrayList<>();
     JButton albumsilbutton;
          int button_tutucu=0;
private Statement statement=null;
private Connection con=null;
    DefaultTableModel modelim=new DefaultTableModel();
    DefaultTableModel sanatci_modelim=new DefaultTableModel();
    DefaultTableModel premium_takip_modelim=new DefaultTableModel();
    DefaultTableModel pop_modelim=new DefaultTableModel();
    DefaultTableModel kullanıcılar_modelim=new DefaultTableModel();
     DefaultTableModel klasik_modelim=new DefaultTableModel();
     DefaultTableModel jaz_modelim=new DefaultTableModel();
     DefaultTableModel album_modelim=new DefaultTableModel();
          DefaultTableModel album_content_modelim=new DefaultTableModel();
    Object[] satirlar=new Object[8];
    Object[] sanatci_satirlar=new Object[3];
    Object[] premium_takip_satir=new Object[3];
    Object[] pop_satir=new Object[3];
    Object[] jaz_satir=new Object[3];
    Object[] album_satir=new Object[3];
    Object[] klasik_satir=new Object[3];
    Object[] album_content_satir=new Object[4];
    Object[] kullanıcılar_satir=new Object[5];
    Object[] kolonlar={"sarkıid","sarkiadi","tarih","sanatci","album","tur","sure","dinlenmesayisi"};
    Object[] sanatçı_kolonlari={"sanatcid","sanatciadi","ulke"};
    Object[] premium_takip_kolonlari={"idpremium_takip","premium_takip_user","premium_takip_id"};
    Object[] pop_kolonlari={"idpop","useridpop","sarkiid"};
    Object[] klasik_kolonlari={"idklasik","useridklasik","sarkiid"};
    Object[] jaz_kolonlari={"idjaz","useridjaz","sarkiid"};
    Object[] album_kolonlari={"albumid","albumadı","albumturu"};
    Object[] album_content_kolonlari={"idalbum_content","album_id","şarkı","sanatçı"};
    Object[] kullanıcılar_kolonları={"kullanıcııd","kullanıcıadı","email","sifre","abonelikturu"};
    String id;
    JButton[] btnarray;
    JButton b1 ;
    JButton button;
    JPanel jPanelliste;
    JLabel jLabelmuziksmi ;
    JLabel jLabeldinlenme;
    JButton  jButtonekleme;
    JPanel premium_panel;
    JLabel premium_user_ismi;
    JButton takip_et;
    JPanel premium_pop_panel;
    JLabel premium_sarki_ismi;
    JButton premium_ekle;
    JLabel premium_dinlenme;
    JLabel premium_tur;
    JLabel jlabeltur;
    JPanel album_list;
    JLabel album_name;
    JLabel album_type;
    JButton gozat;
    JLabel album_sanatci;
    //JButton[] jButtonsayisi=new JButton[10] ;
    ArrayList<JButton> jbuttonsayisi=new ArrayList<>();
    /**
     * Creates new form proje
     */
    public proje() {
        initComponents();
        jPanel2.setVisible(false);
        jPanel5.setVisible(false);
        guncelle.setVisible(false);
        jScrollPane2.setVisible(false);
        kullanıcı_paneli.setVisible(false);
        sarkici_ekleme_paneli.setVisible(false);
        normal.setVisible(false);
        premium.setVisible(false);
        baglanti=new baglanti();
        premium_listesi.setVisible(false);
        premium_listeleri.setVisible(false);
        user_pop_list.setVisible(false);
        jScrollPane5.setVisible(false);
        jScrollPane7.setVisible(false);
        kayıt_ekranı.setVisible(false);
        album_ekle.setVisible(false);
        album_listesi.setVisible(false);
        album_detay.setVisible(false);
        sanatci_goruntuleme.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        //jScrollPane1.setViewportView(jTable1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        kullanıcı_girisi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        guncelleme = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        albumleri_goster = new javax.swing.JButton();
        sanatcılar = new javax.swing.JButton();
        sarkici_ekleme_paneli = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sarki_tarihi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sanatci_ismi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sarki_adi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        albumismi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        turismi = new javax.swing.JTextField();
        sure = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        geri = new javax.swing.JButton();
        listele = new javax.swing.JPanel();
        kullanıcı_paneli = new javax.swing.JPanel();
        kullanıcı_adı = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sifre = new javax.swing.JPasswordField();
        kullanıcı_butonu = new javax.swing.JButton();
        sonuc = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        premium = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        guncelle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        premium_listesi = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        premium_listeleri = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        tumunu_ekle = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jaz_tumunu_ekle = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        klasik_tumunu_ekle = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        user_pop_list = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        normal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pop_listesi = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        pop_10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        kayıt_ekranı = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        kayıt_kullanıcı_adi = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        kayıt_kullanıcı_sifre = new javax.swing.JPasswordField();
        jLabel31 = new javax.swing.JLabel();
        kayıt_kullanıcı_turu = new javax.swing.JComboBox<>();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        kayıt_kullanıcı_mail = new javax.swing.JTextField();
        album_ekle = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        album_adı = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        album_turu = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        album_listesi = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        album_detay = new javax.swing.JPanel();
        album_sarkıları = new javax.swing.JLabel();
        album_detay_sarkıları = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        albume_sarkı_ekleme_paneli = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        album_add_isim = new javax.swing.JTextField();
        album_add_sanatci = new javax.swing.JTextField();
        album_add_tur = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        sanatci_goruntuleme = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        sanatci_ismi_text = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        sanatci_ulke_text = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 750));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(null);

        jButton1.setText("ADMİN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(175, 136, 120, 32);

        kullanıcı_girisi.setText("kullanıcı girişi");
        kullanıcı_girisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanıcı_girisiActionPerformed(evt);
            }
        });
        jPanel1.add(kullanıcı_girisi);
        kullanıcı_girisi.setBounds(330, 140, 140, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1368, 760);

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(null);

        jPanel3.setLayout(null);

        jButton2.setText("ŞARKI EKLE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sarkiciekle(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(0, 20, 154, 42);

        guncelleme.setText("GUNCELLE");
        guncelleme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guncellemeMouseClicked(evt);
            }
        });
        guncelleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncellemeActionPerformed(evt);
            }
        });
        jPanel3.add(guncelleme);
        guncelleme.setBounds(10, 90, 150, 70);

        jButton17.setText("ALBUM EKLE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);
        jButton17.setBounds(10, 190, 140, 40);

        albumleri_goster.setText("ALBUMLERİ GÖSTER");
        albumleri_goster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumleri_gosterActionPerformed(evt);
            }
        });
        jPanel3.add(albumleri_goster);
        albumleri_goster.setBounds(0, 250, 154, 32);

        sanatcılar.setText("SANATÇILAR");
        sanatcılar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sanatcılarActionPerformed(evt);
            }
        });
        jPanel3.add(sanatcılar);
        sanatcılar.setBounds(10, 300, 130, 32);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 30, 170, 340);

        sarkici_ekleme_paneli.setLayout(null);

        jLabel1.setText("TARİH:");
        sarkici_ekleme_paneli.add(jLabel1);
        jLabel1.setBounds(47, 72, 101, 33);

        sarki_tarihi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sarkici_ekleme_paneli.add(sarki_tarihi);
        sarki_tarihi.setBounds(110, 80, 181, 24);

        jLabel2.setText("ŞARKİ ADİ:");
        sarkici_ekleme_paneli.add(jLabel2);
        jLabel2.setBounds(52, 42, 101, 33);
        sarkici_ekleme_paneli.add(sanatci_ismi);
        sanatci_ismi.setBounds(120, 120, 181, 24);

        jLabel3.setText("ALBÜM:");
        sarkici_ekleme_paneli.add(jLabel3);
        jLabel3.setBounds(55, 161, 101, 33);
        sarkici_ekleme_paneli.add(sarki_adi);
        sarki_adi.setBounds(130, 50, 181, 24);

        jLabel4.setText("SANATÇI:");
        sarkici_ekleme_paneli.add(jLabel4);
        jLabel4.setBounds(57, 121, 101, 33);
        sarkici_ekleme_paneli.add(albumismi);
        albumismi.setBounds(110, 170, 181, 24);

        jLabel5.setText("SÜRE:");
        sarkici_ekleme_paneli.add(jLabel5);
        jLabel5.setBounds(55, 250, 101, 33);

        jLabel7.setText("TÜR:");
        sarkici_ekleme_paneli.add(jLabel7);
        jLabel7.setBounds(55, 206, 101, 33);

        turismi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turismiActionPerformed(evt);
            }
        });
        sarkici_ekleme_paneli.add(turismi);
        turismi.setBounds(130, 210, 181, 24);
        sarkici_ekleme_paneli.add(sure);
        sure.setBounds(110, 250, 181, 24);

        jButton5.setText("EKLE");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        sarkici_ekleme_paneli.add(jButton5);
        jButton5.setBounds(140, 290, 90, 32);

        jPanel2.add(sarkici_ekleme_paneli);
        sarkici_ekleme_paneli.setBounds(190, 10, 360, 410);

        jButton23.setText("ANA SAYFA");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton23);
        jButton23.setBounds(320, 430, 220, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 10, 1368, 760);

        jPanel5.setLayout(null);

        geri.setText("GERİ");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });
        jPanel5.add(geri);
        geri.setBounds(380, 370, 100, 32);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        listele.setLayout(flowLayout1);
        jPanel5.add(listele);
        listele.setBounds(90, 20, 700, 310);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 860, 500);

        kullanıcı_paneli.setLayout(null);
        kullanıcı_paneli.add(kullanıcı_adı);
        kullanıcı_adı.setBounds(140, 60, 170, 24);

        jLabel14.setText("kullanıcı adı:");
        kullanıcı_paneli.add(jLabel14);
        jLabel14.setBounds(20, 60, 110, 30);

        jLabel15.setText("şifre");
        kullanıcı_paneli.add(jLabel15);
        jLabel15.setBounds(30, 120, 100, 30);
        kullanıcı_paneli.add(sifre);
        sifre.setBounds(140, 120, 170, 22);

        kullanıcı_butonu.setText("GİRİŞ");
        kullanıcı_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanıcı_butonuActionPerformed(evt);
            }
        });
        kullanıcı_paneli.add(kullanıcı_butonu);
        kullanıcı_butonu.setBounds(120, 180, 170, 32);
        kullanıcı_paneli.add(sonuc);
        sonuc.setBounds(100, 230, 200, 30);

        jButton14.setText("KAYIT OL");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        kullanıcı_paneli.add(jButton14);
        jButton14.setBounds(340, 180, 160, 32);

        jButton25.setText("ANA EKRAN");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        kullanıcı_paneli.add(jButton25);
        jButton25.setBounds(260, 250, 140, 32);

        getContentPane().add(kullanıcı_paneli);
        kullanıcı_paneli.setBounds(140, 30, 1368, 760);

        premium.setLayout(null);

        jButton6.setText("premium");
        premium.add(jButton6);
        jButton6.setBounds(260, 170, 160, 32);

        getContentPane().add(premium);
        premium.setBounds(0, 0, 860, 500);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 0));

        guncelle.setMaximumSize(new java.awt.Dimension(0, 0));
        guncelle.setPreferredSize(new java.awt.Dimension(1368, 5000));
        guncelle.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        guncelle.add(jScrollPane1);
        jScrollPane1.setBounds(60, 40, 410, 340);
        guncelle.add(jTextField1);
        jTextField1.setBounds(630, 40, 170, 24);
        guncelle.add(jTextField2);
        jTextField2.setBounds(640, 80, 170, 24);
        guncelle.add(jTextField3);
        jTextField3.setBounds(640, 120, 170, 24);
        guncelle.add(jTextField4);
        jTextField4.setBounds(640, 160, 170, 24);
        guncelle.add(jTextField5);
        jTextField5.setBounds(640, 200, 170, 24);
        guncelle.add(jTextField6);
        jTextField6.setBounds(640, 240, 170, 24);
        guncelle.add(jTextField7);
        jTextField7.setBounds(650, 280, 160, 24);

        jLabel6.setText("dinlenme sayısı:");
        guncelle.add(jLabel6);
        jLabel6.setBounds(510, 280, 100, 30);

        jLabel8.setText("şarkı adi:");
        guncelle.add(jLabel8);
        jLabel8.setBounds(510, 40, 100, 30);

        jLabel9.setText("tarih:");
        guncelle.add(jLabel9);
        jLabel9.setBounds(510, 80, 100, 30);

        jLabel10.setText("sanatçı");
        guncelle.add(jLabel10);
        jLabel10.setBounds(510, 120, 100, 30);

        jLabel11.setText("albüm:");
        guncelle.add(jLabel11);
        jLabel11.setBounds(510, 160, 100, 30);

        jLabel12.setText("tur:");
        guncelle.add(jLabel12);
        jLabel12.setBounds(510, 200, 100, 30);

        jLabel13.setText("süre:");
        guncelle.add(jLabel13);
        jLabel13.setBounds(510, 240, 100, 30);

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        guncelle.add(update);
        update.setBounds(610, 340, 100, 32);

        jButton4.setText("listele");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        guncelle.add(jButton4);
        jButton4.setBounds(740, 340, 130, 32);

        jButton7.setText("ANA SAYFA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        guncelle.add(jButton7);
        jButton7.setBounds(570, 400, 170, 50);

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        guncelle.add(delete);
        delete.setBounds(890, 340, 90, 32);

        jLabel41.setText("ŞARKILAR");
        guncelle.add(jLabel41);
        jLabel41.setBounds(110, 10, 220, 20);

        jLabel42.setText("SANATÇILAR");
        guncelle.add(jLabel42);
        jLabel42.setBounds(250, 500, 180, 30);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(jTable3);

        guncelle.add(jScrollPane9);
        jScrollPane9.setBounds(170, 550, 340, 230);

        jLabel43.setText("PREMİUM_TAKİP");
        guncelle.add(jLabel43);
        jLabel43.setBounds(220, 810, 250, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTable2);

        guncelle.add(jScrollPane8);
        jScrollPane8.setBounds(160, 860, 350, 270);

        jLabel44.setText("POP");
        guncelle.add(jLabel44);
        jLabel44.setBounds(790, 480, 240, 20);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(jTable4);

        guncelle.add(jScrollPane10);
        jScrollPane10.setBounds(730, 530, 370, 270);

        jLabel45.setText("KULLANICILAR");
        guncelle.add(jLabel45);
        jLabel45.setBounds(780, 826, 250, 30);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(jTable5);

        guncelle.add(jScrollPane11);
        jScrollPane11.setBounds(760, 860, 330, 260);

        jLabel46.setText("KLASİK");
        guncelle.add(jLabel46);
        jLabel46.setBounds(170, 1160, 260, 30);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(jTable6);

        guncelle.add(jScrollPane12);
        jScrollPane12.setBounds(160, 1200, 350, 220);

        jLabel47.setText("JAZ");
        guncelle.add(jLabel47);
        jLabel47.setBounds(790, 1146, 270, 40);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(jTable7);

        guncelle.add(jScrollPane13);
        jScrollPane13.setBounds(760, 1200, 350, 220);

        jLabel48.setText("ALBUMLER");
        guncelle.add(jLabel48);
        jLabel48.setBounds(170, 1450, 230, 30);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(jTable8);

        guncelle.add(jScrollPane14);
        jScrollPane14.setBounds(160, 1490, 350, 210);

        jLabel49.setText("ALBUM_CONTENT");
        guncelle.add(jLabel49);
        jLabel49.setBounds(780, 1436, 280, 30);

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane15.setViewportView(jTable9);

        guncelle.add(jScrollPane15);
        jScrollPane15.setBounds(760, 1480, 350, 230);

        jScrollPane2.setViewportView(guncelle);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 1368, 760);

        premium_listesi.setLayout(null);

        jPanel6.setPreferredSize(new java.awt.Dimension(1360, 1500));
        jPanel6.setLayout(null);

        jLabel17.setText("PREMİUM KULLANICILAR");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(90, 40, 240, 60);

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));
        jPanel6.add(jPanel7);
        jPanel7.setBounds(60, 100, 320, 260);

        jButton12.setText("GERİ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton12);
        jButton12.setBounds(330, 400, 59, 32);

        jScrollPane3.setViewportView(jPanel6);

        premium_listesi.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 1360, 640);

        getContentPane().add(premium_listesi);
        premium_listesi.setBounds(0, 0, 1368, 760);

        premium_listeleri.setLayout(null);

        jPanel8.setPreferredSize(new java.awt.Dimension(1360, 1500));
        jPanel8.setLayout(null);

        jLabel18.setText("POP LİSTESİ");
        jPanel8.add(jLabel18);
        jLabel18.setBounds(110, 26, 170, 40);

        jPanel9.setLayout(new java.awt.GridLayout(0, 1));
        jPanel8.add(jPanel9);
        jPanel9.setBounds(30, 70, 360, 250);

        tumunu_ekle.setText("TÜMÜNÜ EKLE");
        tumunu_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tumunu_ekleActionPerformed(evt);
            }
        });
        jPanel8.add(tumunu_ekle);
        tumunu_ekle.setBounds(120, 330, 120, 32);

        jLabel25.setText("JAZ LİSTESİ");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(500, 20, 170, 50);

        jPanel16.setLayout(new java.awt.GridLayout(0, 1));
        jPanel8.add(jPanel16);
        jPanel16.setBounds(460, 70, 370, 260);

        jaz_tumunu_ekle.setText("TÜMÜNÜ EKLE");
        jPanel8.add(jaz_tumunu_ekle);
        jaz_tumunu_ekle.setBounds(525, 360, 130, 32);

        jLabel26.setText("KLASİK LİSTESİ");
        jPanel8.add(jLabel26);
        jLabel26.setBounds(910, 20, 160, 40);

        jPanel17.setLayout(new java.awt.GridLayout(0, 1));
        jPanel8.add(jPanel17);
        jPanel17.setBounds(870, 70, 370, 280);

        klasik_tumunu_ekle.setText("TÜMÜNÜ EKLE");
        jPanel8.add(klasik_tumunu_ekle);
        klasik_tumunu_ekle.setBounds(1000, 370, 130, 32);

        jButton13.setText("ANA SAYFA");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13);
        jButton13.setBounds(300, 472, 310, 70);

        jScrollPane4.setViewportView(jPanel8);

        premium_listeleri.add(jScrollPane4);
        jScrollPane4.setBounds(0, 0, 1368, 680);

        getContentPane().add(premium_listeleri);
        premium_listeleri.setBounds(0, 0, 1368, 680);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(1368, 2554));

        user_pop_list.setMinimumSize(new java.awt.Dimension(1360, 5000));
        user_pop_list.setPreferredSize(new java.awt.Dimension(1368, 2554));
        user_pop_list.setLayout(null);

        jLabel19.setText("POP ŞARKILARI");
        user_pop_list.add(jLabel19);
        jLabel19.setBounds(110, 16, 210, 50);

        jButton9.setText("GERİ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        user_pop_list.add(jButton9);
        jButton9.setBounds(420, 910, 180, 50);

        jLabel20.setText("JAZ LİSTESİ");
        user_pop_list.add(jLabel20);
        jLabel20.setBounds(770, 10, 260, 60);

        jPanel10.setLayout(new java.awt.GridLayout(0, 1));
        user_pop_list.add(jPanel10);
        jPanel10.setBounds(710, 90, 460, 300);

        jLabel21.setText("KLASİK LİSTEM");
        user_pop_list.add(jLabel21);
        jLabel21.setBounds(160, 560, 290, 40);

        jPanel12.setLayout(new java.awt.GridLayout(0, 1));
        user_pop_list.add(jPanel12);
        jPanel12.setBounds(150, 640, 490, 260);

        jPanel13.setLayout(null);

        jPanel11.setPreferredSize(new java.awt.Dimension(430, 1000));
        jPanel11.setLayout(new java.awt.GridLayout(0, 1, -5, -5));
        jScrollPane6.setViewportView(jPanel11);

        jPanel13.add(jScrollPane6);
        jScrollPane6.setBounds(0, 0, 430, 320);

        user_pop_list.add(jPanel13);
        jPanel13.setBounds(80, 70, 430, 320);

        jScrollPane5.setViewportView(user_pop_list);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(0, 0, 1360, 760);

        normal.setPreferredSize(new java.awt.Dimension(1368, 5000));
        normal.setLayout(null);

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new java.awt.GridLayout(10, 0));
        normal.add(jPanel4);
        jPanel4.setBounds(230, 80, 330, 380);

        jLabel16.setText("EN ÇOK DİNLENEN 10 ŞARKI");
        normal.add(jLabel16);
        jLabel16.setBounds(270, 20, 230, 40);

        pop_listesi.setText("ÇALMA LİSTELERİM");
        pop_listesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_listesiActionPerformed(evt);
            }
        });
        normal.add(pop_listesi);
        pop_listesi.setBounds(20, 140, 160, 32);

        jButton8.setText("PREMİUM KULLANICILAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        normal.add(jButton8);
        jButton8.setBounds(10, 240, 170, 32);

        jButton10.setText("ÇIKIŞ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        normal.add(jButton10);
        jButton10.setBounds(760, 10, 62, 32);

        jLabel22.setText("TOP 10 POP LİSTESİ");
        normal.add(jLabel22);
        jLabel22.setBounds(730, 70, 230, 40);

        pop_10.setLayout(new java.awt.GridLayout(0, 1));
        normal.add(pop_10);
        pop_10.setBounds(720, 110, 340, 360);

        jLabel23.setText("TOP 10 KLASİK");
        normal.add(jLabel23);
        jLabel23.setBounds(100, 506, 250, 40);

        jPanel14.setLayout(new java.awt.GridLayout(0, 1));
        normal.add(jPanel14);
        jPanel14.setBounds(80, 580, 330, 530);

        jLabel24.setText("TOP 10 JAZ");
        normal.add(jLabel24);
        jLabel24.setBounds(650, 506, 220, 40);

        jPanel15.setLayout(new java.awt.GridLayout(0, 1));
        normal.add(jPanel15);
        jPanel15.setBounds(640, 570, 330, 460);

        jButton11.setText("TAKİP ETTİKLERİM");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        normal.add(jButton11);
        jButton11.setBounds(20, 310, 150, 32);

        jButton26.setText("TABLOLAR");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        normal.add(jButton26);
        jButton26.setBounds(20, 360, 150, 32);

        jScrollPane7.setViewportView(normal);

        getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(0, 0, 1368, 760);

        kayıt_ekranı.setLayout(null);

        jLabel27.setText("KULLANICI ADI:");
        kayıt_ekranı.add(jLabel27);
        jLabel27.setBounds(60, 90, 100, 30);
        kayıt_ekranı.add(kayıt_kullanıcı_adi);
        kayıt_kullanıcı_adi.setBounds(160, 90, 190, 24);

        jLabel28.setText("EMAİL:");
        kayıt_ekranı.add(jLabel28);
        jLabel28.setBounds(60, 150, 100, 30);

        jLabel30.setText("ŞİFRE:");
        kayıt_ekranı.add(jLabel30);
        jLabel30.setBounds(60, 210, 90, 30);
        kayıt_ekranı.add(kayıt_kullanıcı_sifre);
        kayıt_kullanıcı_sifre.setBounds(160, 210, 190, 30);

        jLabel31.setText("KULLANICI TURU:");
        kayıt_ekranı.add(jLabel31);
        jLabel31.setBounds(40, 266, 120, 30);

        kayıt_kullanıcı_turu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "normal", "premium" }));
        kayıt_ekranı.add(kayıt_kullanıcı_turu);
        kayıt_kullanıcı_turu.setBounds(160, 270, 190, 26);

        jButton15.setText("KAYIT");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        kayıt_ekranı.add(jButton15);
        jButton15.setBounds(140, 330, 130, 32);

        jButton16.setText("KULLANICI GİRİŞİ");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        kayıt_ekranı.add(jButton16);
        jButton16.setBounds(320, 330, 140, 32);
        kayıt_ekranı.add(kayıt_kullanıcı_mail);
        kayıt_kullanıcı_mail.setBounds(160, 150, 190, 24);

        getContentPane().add(kayıt_ekranı);
        kayıt_ekranı.setBounds(0, 0, 1368, 760);

        album_ekle.setLayout(null);

        jLabel29.setText("ALBUM ADI:");
        album_ekle.add(jLabel29);
        jLabel29.setBounds(60, 110, 150, 40);
        album_ekle.add(album_adı);
        album_adı.setBounds(210, 114, 170, 30);

        jLabel32.setText("ALBUM TÜRÜ:");
        album_ekle.add(jLabel32);
        jLabel32.setBounds(60, 180, 130, 40);
        album_ekle.add(album_turu);
        album_turu.setBounds(200, 174, 200, 40);

        jButton18.setText("EKLE");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        album_ekle.add(jButton18);
        jButton18.setBounds(152, 260, 80, 32);

        jButton19.setText("GERİ");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        album_ekle.add(jButton19);
        jButton19.setBounds(320, 260, 85, 32);

        getContentPane().add(album_ekle);
        album_ekle.setBounds(-10, -30, 1368, 760);

        album_listesi.setMaximumSize(new java.awt.Dimension(0, 0));
        album_listesi.setMinimumSize(new java.awt.Dimension(0, 0));
        album_listesi.setLayout(null);

        jLabel33.setText("ALBUMLER");
        album_listesi.add(jLabel33);
        jLabel33.setBounds(90, 40, 200, 40);

        jPanel18.setLayout(new java.awt.GridLayout(0, 1));
        album_listesi.add(jPanel18);
        jPanel18.setBounds(90, 110, 690, 320);

        jButton20.setText("GERİ GEL");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        album_listesi.add(jButton20);
        jButton20.setBounds(360, 470, 160, 32);

        getContentPane().add(album_listesi);
        album_listesi.setBounds(-10, -30, 1368, 760);

        album_detay.setMaximumSize(new java.awt.Dimension(0, 0));
        album_detay.setMinimumSize(new java.awt.Dimension(0, 0));
        album_detay.setLayout(null);
        album_detay.add(album_sarkıları);
        album_sarkıları.setBounds(110, 70, 210, 40);

        album_detay_sarkıları.setLayout(new java.awt.GridLayout(0, 1));
        album_detay.add(album_detay_sarkıları);
        album_detay_sarkıları.setBounds(90, 130, 290, 350);

        jButton21.setText("ŞARKI EKLE");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        album_detay.add(jButton21);
        jButton21.setBounds(650, 470, 140, 32);

        albume_sarkı_ekleme_paneli.setLayout(null);

        jLabel34.setText("ŞARKI İSMİ:");
        albume_sarkı_ekleme_paneli.add(jLabel34);
        jLabel34.setBounds(10, 60, 130, 40);

        jLabel35.setText("SANATÇI:");
        albume_sarkı_ekleme_paneli.add(jLabel35);
        jLabel35.setBounds(10, 136, 120, 50);

        jLabel36.setText("TÜR:");
        albume_sarkı_ekleme_paneli.add(jLabel36);
        jLabel36.setBounds(10, 220, 120, 40);
        albume_sarkı_ekleme_paneli.add(album_add_isim);
        album_add_isim.setBounds(140, 64, 200, 30);
        albume_sarkı_ekleme_paneli.add(album_add_sanatci);
        album_add_sanatci.setBounds(150, 150, 190, 24);
        albume_sarkı_ekleme_paneli.add(album_add_tur);
        album_add_tur.setBounds(150, 224, 190, 30);

        album_detay.add(albume_sarkı_ekleme_paneli);
        albume_sarkı_ekleme_paneli.setBounds(490, 100, 370, 350);

        jButton22.setText("GERİ");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        album_detay.add(jButton22);
        jButton22.setBounds(370, 550, 150, 32);

        getContentPane().add(album_detay);
        album_detay.setBounds(0, 0, 1368, 760);

        sanatci_goruntuleme.setLayout(null);

        jLabel37.setText("SANATÇILAR");
        sanatci_goruntuleme.add(jLabel37);
        jLabel37.setBounds(70, 30, 200, 50);

        jPanel19.setLayout(new java.awt.GridLayout(0, 1));
        sanatci_goruntuleme.add(jPanel19);
        jPanel19.setBounds(60, 100, 400, 310);

        jLabel38.setText("SANATÇI EKLE");
        sanatci_goruntuleme.add(jLabel38);
        jLabel38.setBounds(640, 50, 220, 50);

        jLabel39.setText("SANATÇI  İSMİ:");
        sanatci_goruntuleme.add(jLabel39);
        jLabel39.setBounds(540, 130, 130, 50);
        sanatci_goruntuleme.add(sanatci_ismi_text);
        sanatci_ismi_text.setBounds(690, 140, 170, 24);

        jLabel40.setText("ÜLKE:");
        sanatci_goruntuleme.add(jLabel40);
        jLabel40.setBounds(540, 206, 130, 40);
        sanatci_goruntuleme.add(sanatci_ulke_text);
        sanatci_ulke_text.setBounds(690, 210, 180, 24);

        jButton3.setText("SANATÇI EKLE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        sanatci_goruntuleme.add(jButton3);
        jButton3.setBounds(640, 290, 170, 32);

        jButton24.setText("GERİ");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        sanatci_goruntuleme.add(jButton24);
        jButton24.setBounds(390, 490, 180, 32);

        getContentPane().add(sanatci_goruntuleme);
        sanatci_goruntuleme.setBounds(-10, -30, 1368, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        sarkici_ekleme_paneli.setVisible(false);
        //jScrollPane1.setViewportView(jTable1);
        //sarkilari_goster.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
 
  
    private void sarkiciekle(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarkiciekle
        sarkici_ekleme_paneli.setVisible(true);
        
    }//GEN-LAST:event_sarkiciekle

    private void turismiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turismiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_turismiActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        boolean sonuc=baglanti.sarkici_ekle(sarki_adi.getText(),sarki_tarihi.getText(),sanatci_ismi.getText(),albumismi.getText(),turismi.getText(),250);
        if(sonuc){
            JOptionPane.showMessageDialog(null,"kayıt başarılı bir şekilde eklendi");
        }else{
            JOptionPane.showMessageDialog(null,"kayıt zaten sistemde ekli");
        }
        
        sarkici_ekleme_paneli.setVisible(false);
        sarki_adi.setText("");
        sarki_tarihi.setText("");
        sanatci_ismi.setText("");
        albumismi.setText("");
        turismi.setText("");
        sure.setText("");
        
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void guncellemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guncellemeMouseClicked
        jPanel2.setVisible(false);
        sarkici_ekleme_paneli.setVisible(false);
        guncelle.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane9.setVisible(true);
        sanatci_modelim.setColumnIdentifiers(sanatçı_kolonlari);
        modelim.setColumnIdentifiers(kolonlar);
        pop_modelim.setColumnIdentifiers(pop_kolonlari);
        premium_takip_modelim.setColumnIdentifiers(premium_takip_kolonlari);
        kullanıcılar_modelim.setColumnIdentifiers(kullanıcılar_kolonları);
        klasik_modelim.setColumnIdentifiers(klasik_kolonlari);
        jaz_modelim.setColumnIdentifiers(jaz_kolonlari);
        album_modelim.setColumnIdentifiers(album_kolonlari);
        album_content_modelim.setColumnIdentifiers(album_content_kolonlari);
        ResultSet klasik_result=baglanti.klasik_table();
        ResultSet result=baglanti.tumsarkilarigoster();
        ResultSet sanatci_result=baglanti.sanatcilari_goster();
        ResultSet premium_takip_result=baglanti.premium_takip_table();
        ResultSet pop_result=baglanti.pop_table();
        ResultSet jaz_result=baglanti.jaz_table();
        ResultSet album_result=baglanti.album_table();
        ResultSet album_content_result=baglanti.album_content_table();
        ResultSet kullanıcılar_result=baglanti.kullanıcılar_table();
        
        //dasd
       try {
        while(album_result.next()){
            album_satir[0]=album_result.getInt("albumid");
            album_satir[1]=album_result.getString("albumadı");
            album_satir[2]=album_result.getString("albumturu");
            album_modelim.addRow(album_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable8.setModel(album_modelim);
       try {
        while(album_content_result.next()){
            album_content_satir[0]=album_content_result.getInt("idalbum_content");
            album_content_satir[1]=album_content_result.getInt("album_id");
            album_content_satir[2]=album_content_result.getString("şarkı");
            album_content_satir[3]=album_content_result.getString("sanatçı");
            album_content_modelim.addRow(album_content_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }jTable9.setModel(album_content_modelim);
       try {
        while(jaz_result.next()){
            jaz_satir[0]=jaz_result.getInt("idjaz");
            jaz_satir[1]=jaz_result.getInt("useridjaz");
            jaz_satir[2]=jaz_result.getInt("sarkiid");
            jaz_modelim.addRow(jaz_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable7.setModel(jaz_modelim);
       try {
        while(klasik_result.next()){
            klasik_satir[0]=klasik_result.getInt("idklasik");
            klasik_satir[1]=klasik_result.getInt("useridklasik");
            klasik_satir[2]=klasik_result.getInt("sarkiid");
            klasik_modelim.addRow(klasik_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable6.setModel(klasik_modelim);
     try {
        while(kullanıcılar_result.next()){
            kullanıcılar_satir[0]=kullanıcılar_result.getInt("kullanıcııd");
            kullanıcılar_satir[1]=kullanıcılar_result.getString("kullanıcıadı");
            kullanıcılar_satir[2]=kullanıcılar_result.getString("email");
            kullanıcılar_satir[3]=kullanıcılar_result.getString("sifre");
            kullanıcılar_satir[4]=kullanıcılar_result.getString("abonelikturu");
            kullanıcılar_modelim.addRow(kullanıcılar_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
     jTable5.setModel(kullanıcılar_modelim);
    try {
        while(result.next()){
            satirlar[0]=result.getInt("sarkıid");
            satirlar[1]=result.getString("sarkiadi");
            satirlar[2]=result.getString("tarih");
            satirlar[3]=result.getString("sanatci");
            satirlar[4]=result.getString("album");
            satirlar[5]=result.getString("tur");
            satirlar[6]=result.getString("sure");
            satirlar[7]=result.getInt("dinlenmesayisi");
            modelim.addRow(satirlar);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable1.setModel(modelim);
    try {
        while(sanatci_result.next()){
            sanatci_satirlar[0]=sanatci_result.getInt("sanatcid");
            sanatci_satirlar[1]=sanatci_result.getString("sanatciadi");
            sanatci_satirlar[2]=sanatci_result.getString("ulke");
            sanatci_modelim.addRow(sanatci_satirlar);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable3.setModel(sanatci_modelim);
    try {
        while(premium_takip_result.next()){
            premium_takip_satir[0]=premium_takip_result.getInt("idpremium_takip");
            premium_takip_satir[1]=premium_takip_result.getInt("premium_takip_user");
            premium_takip_satir[2]=premium_takip_result.getInt("premium_takip_id");
            premium_takip_modelim.addRow(premium_takip_satir);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable2.setModel(premium_takip_modelim);
    try {
        while(pop_result.next()){
            pop_satir[0]=pop_result.getInt("idpop");
            pop_satir[1]=pop_result.getInt("useridpop");
            pop_satir[2]=pop_result.getInt("sarkiid");
            pop_modelim.addRow(pop_satir);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable4.setModel(pop_modelim);
    }//GEN-LAST:event_guncellemeMouseClicked

    private void guncellemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncellemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guncellemeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         id=modelim.getValueAt(jTable1.getSelectedRow(),0).toString();
        jTextField1.setText(modelim.getValueAt(jTable1.getSelectedRow(),1).toString());
        jTextField2.setText((String)modelim.getValueAt(jTable1.getSelectedRow(),2));
        jTextField3.setText((String)modelim.getValueAt(jTable1.getSelectedRow(),3));
        jTextField4.setText((String)modelim.getValueAt(jTable1.getSelectedRow(),4));
        jTextField5.setText((String)modelim.getValueAt(jTable1.getSelectedRow(),5));
        jTextField6.setText((String)modelim.getValueAt(jTable1.getSelectedRow(),6));
        jTextField7.setText(modelim.getValueAt(jTable1.getSelectedRow(),7).toString());

        
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        baglanti.update(id,jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),Integer.parseInt(jTextField6.getText()),Integer.parseInt(jTextField7.getText()));
         
    }//GEN-LAST:event_updateActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        jPanel5.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_geriActionPerformed

    public void panel_item(){
        jPanelliste = new javax.swing.JPanel();
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jlabeltur = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            en_cok_dinlenen_label.add(jLabeldinlenme);
           
            //pop_10_button.add(jButtonekleme);
          
            jPanelliste.setLayout(null);
            jPanelliste.add(jLabelmuziksmi);
            jLabelmuziksmi.setBounds(11, 10, 100, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(120, 10, 90, 30);
            jPanelliste.add(jlabeltur);
            jlabeltur.setBounds(180,10 ,50,40);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(220, 10, 100, 50);
            //jButtnekleme.setSize(200,300);
            jButtonekleme.setText("EKLE");
            //jButtonekleme.setText(""+sarkiid);
            
    }
    private void kullanıcı_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanıcı_butonuActionPerformed
        
        boolean giris_sonucu=baglanti.kullanici_girisi(kullanıcı_adı.getText(),sifre.getText());
        if(giris_sonucu){
            sonuc.setVisible(true);
            sonuc.setText("giriş başarılı");
            guncelleme_sayfa_kontrol=1;
            user=baglanti.kullanici_bilgileri(kullanıcı_adı.getText(),sifre.getText());
            kullanıcı_paneli.setVisible(false);
            String abonelik_turu=baglanti.abonelik(kullanıcı_adı.getText(),sifre.getText());
            if(abonelik_turu.equals("normal")|| abonelik_turu.equals("premium")){
                normal.setVisible(true);
                jScrollPane7.setVisible(true);
                 ResultSet result=baglanti.calisanlarigoster();
                 ResultSet pop_10_list=baglanti.pop_10_list("pop");
                 ResultSet klasik_10_list=baglanti.pop_10_list("klasik");
                 ResultSet jaz_10_list=baglanti.pop_10_list("jaz");
         //jPanelliste.removeAll();
    try {
        //sarkilari_goster.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //JButton button=new JButton();
        int i=0;
        while(result.next()){
            b1 = new  JButton ();
            jPanelliste = new javax.swing.JPanel();
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jlabeltur = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            en_cok_dinlenen_label.add(jLabeldinlenme);
            jButtonekleme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //jButtoneklemeMouseClicked(evt);
            }
          });
            
            String name=result.getString("sarkiadi");
            int dinlenme_sayisi=result.getInt("dinlenmesayisi");
            String sanatci=result.getString("sanatci");
            String album=result.getString("album");
            String tur=result.getString("tur");
            int sure=result.getInt("sure");
            
            int sarkiid=result.getInt("sarkıid");
            genel_en_dinlenen_id.add(sarkiid);
            sarkılar sarkı=new sarkılar(sarkiid,name,sanatci, album, tur, sure,dinlenme_sayisi);
            genel_en_dinlenen.add(sarkı);
            jPanelliste.setLayout(null);
            jPanelliste.add(jLabelmuziksmi);
            jLabelmuziksmi.setBounds(11, 10, 100, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(120, 10, 90, 30);
            jPanelliste.add(jlabeltur);
            jlabeltur.setBounds(180,10 ,50,40);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(220, 10, 100, 50);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            //jButtonekleme.setSize(200,300);
            
            jButtonekleme.setText("EKLE");
            //jButtonekleme.setText(""+sarkiid);
            jlabeltur.setText(tur);
            jbuttonsayisi.add(jButtonekleme);
            //b1.setText(name);
           // b1.setText("\n");
           
            //b1.setText(name+"\n"+dinlenme_sayisi.toString());
            //b1.setSize(500,500);
            //b1.setAlignmentX(350);
            
            jPanel4.add(jPanelliste);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try {
        //sarkilari_goster.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //JButton button=new JButton();
        int i=0;
        while(pop_10_list.next()){
            b1 = new  JButton ();
            jPanelliste = new javax.swing.JPanel();
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jlabeltur = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            en_cok_dinlenen_label.add(jLabeldinlenme);
           
            
            String name=pop_10_list.getString("sarkiadi");
            int dinlenme_sayisi=pop_10_list.getInt("dinlenmesayisi");
            String sanatci=pop_10_list.getString("sanatci");
            String album=pop_10_list.getString("album");
            String tur=pop_10_list.getString("tur");
            int sure=pop_10_list.getInt("sure");
            
            int sarkiid=pop_10_list.getInt("sarkıid");
            pop_10_id.add(sarkiid);
            pop_10_button.add(jButtonekleme);
            //genel_en_dinlenen_id.add(sarkiid);
            sarkılar sarkı=new sarkılar(sarkiid,name,sanatci, album, tur, sure,dinlenme_sayisi);
            genel_en_dinlenen.add(sarkı);
            jPanelliste.setLayout(null);
            jPanelliste.add(jLabelmuziksmi);
            jLabelmuziksmi.setBounds(11, 10, 100, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(120, 10, 90, 30);
            jPanelliste.add(jlabeltur);
            jlabeltur.setBounds(180,10 ,50,40);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(220, 10, 100, 50);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            //jButtonekleme.setSize(200,300);
            
            jButtonekleme.setText("EKLE");
            //jButtonekleme.setText(""+sarkiid);
            jlabeltur.setText(tur);
            //jbuttonsayisi.add(jButtonekleme);
            //b1.setText(name);
           // b1.setText("\n");
           
            //b1.setText(name+"\n"+dinlenme_sayisi.toString());
            //b1.setSize(500,500);
            //b1.setAlignmentX(350);
            
            pop_10.add(jPanelliste);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        //sarkilari_goster.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //JButton button=new JButton();
        int i=0;
        while(klasik_10_list.next()){
            
             panel_item();
            
            String name=klasik_10_list.getString("sarkiadi");
            int dinlenme_sayisi=klasik_10_list.getInt("dinlenmesayisi");
            String sanatci=klasik_10_list.getString("sanatci");
            String album=klasik_10_list.getString("album");
            String tur=klasik_10_list.getString("tur");
            int sure=klasik_10_list.getInt("sure");
            
            int sarkiid=klasik_10_list.getInt("sarkıid");
            klasik_10_id.add(sarkiid);
            klasik_10_button.add(jButtonekleme);
            //pop_10_id.add(sarkiid);
            //pop_10_button.add(jButtonekleme);
            //genel_en_dinlenen_id.add(sarkiid);
            sarkılar sarkı=new sarkılar(sarkiid,name,sanatci, album, tur, sure,dinlenme_sayisi);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            //jButtonekleme.setSize(200,300);
            //jButtonekleme.setText(""+sarkiid);
            jlabeltur.setText(tur);
            //jbuttonsayisi.add(jButtonekleme);
            //b1.setText(name);
           // b1.setText("\n");
           
            //b1.setText(name+"\n"+dinlenme_sayisi.toString());
            //b1.setSize(500,500);
            //b1.setAlignmentX(350);
            
            jPanel14.add(jPanelliste);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        //sarkilari_goster.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //JButton button=new JButton();
        int i=0;
        while(jaz_10_list.next()){
            
             panel_item();
            
            String name=jaz_10_list.getString("sarkiadi");
            int dinlenme_sayisi=jaz_10_list.getInt("dinlenmesayisi");
            String sanatci=jaz_10_list.getString("sanatci");
            String album=jaz_10_list.getString("album");
            String tur=jaz_10_list.getString("tur");
            int sure=jaz_10_list.getInt("sure");
            
            int sarkiid=jaz_10_list.getInt("sarkıid");
            jaz_10_id.add(sarkiid);
            jaz_10_button.add(jButtonekleme);
            //pop_10_id.add(sarkiid);
            //pop_10_button.add(jButtonekleme);
            //genel_en_dinlenen_id.add(sarkiid);
            sarkılar sarkı=new sarkılar(sarkiid,name,sanatci, album, tur, sure,dinlenme_sayisi);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            //jButtonekleme.setSize(200,300);
            //jButtonekleme.setText(""+sarkiid);
            jlabeltur.setText(tur);
            //jbuttonsayisi.add(jButtonekleme);
            //b1.setText(name);
           // b1.setText("\n");
           
            //b1.setText(name+"\n"+dinlenme_sayisi.toString());
            //b1.setSize(500,500);
            //b1.setAlignmentX(350);
            
            jPanel15.add(jPanelliste);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    for(int i=0;i<jbuttonsayisi.size();i++){
        int sayi=genel_en_dinlenen_id.get(i);//Integer.parseInt(jbuttonsayisi.get(i).getText());
        int kontrol=i;
        jbuttonsayisi.get(i).addActionListener(  
      new ActionListener() {  
     
   //Handle event
   public void actionPerformed(ActionEvent event) {  
       if(genel_en_dinlenen.get(kontrol).getTur().equals("pop")){
         boolean sonuc=baglanti.pop_calma_listesine_ekle(sayi,user.getKullanici_id(),genel_en_dinlenen.get(kontrol).getTur());    
         if(sonuc){
             JOptionPane.showMessageDialog(null, "pop listenize eklendi.");
         }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
         }
       }else if(genel_en_dinlenen.get(kontrol).getTur().equals("jaz")){
           boolean sonuc=baglanti.jaz_calma_listesine_ekle(sayi,user.getKullanici_id(),genel_en_dinlenen.get(kontrol).getTur());
         if(sonuc){
             JOptionPane.showMessageDialog(null, "jaz listenize eklendi.");
         }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
         }
       }else if(genel_en_dinlenen.get(kontrol).getTur().equals("klasik")){
           boolean sonuc=baglanti.klasik_calma_listesine_ekle(sayi,user.getKullanici_id(),genel_en_dinlenen.get(kontrol).getTur());
        if(sonuc){
             JOptionPane.showMessageDialog(null, "klasik listenize eklendi.");
         }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
         }
       }
       
   }  
  }  
  );
    }for(int i=0;i<pop_10_button.size();i++){
           int sayi=pop_10_id.get(i);
           pop_10_button.get(i).addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.out.println("dadasdsa");
                   boolean sonuc=baglanti.pop_calma_listesine_ekle(sayi,user.getKullanici_id(),"pop");
                   if(sonuc){
                    JOptionPane.showMessageDialog(null, "pop listenize eklendi.");
                }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
              }
               }
           });
       }
    for(int i=0;i<klasik_10_button.size();i++){
           int sayi=klasik_10_id.get(i);
           klasik_10_button.get(i).addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.out.println("dadasdsa");
                   boolean sonuc=baglanti.klasik_calma_listesine_ekle(sayi,user.getKullanici_id(),"klasik");
                   if(sonuc){
                    JOptionPane.showMessageDialog(null, "klasik listenize eklendi.");
                }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
              }
               }
           });
       }for(int i=0;i<jaz_10_button.size();i++){
           int sayi=jaz_10_id.get(i);
           jaz_10_button.get(i).addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.out.println("dadasdsa");
                   boolean sonuc=baglanti.jaz_calma_listesine_ekle(sayi,user.getKullanici_id(),"jaz");
                   if(sonuc){
                    JOptionPane.showMessageDialog(null, "jaz listenize eklendi.");
                }else{
             JOptionPane.showMessageDialog(null, "şarkı listenizde  ekli.");
              }
               }
           });
       }
            }else{
                premium.setVisible(true);
            }
        }else{
            sonuc.setVisible(true);
            sonuc.setText("giriş başarısız");
        }
        kullanıcı_adı.setText("");
        sifre.setText("");
        sonuc.setVisible(false);
    }//GEN-LAST:event_kullanıcı_butonuActionPerformed

    private void kullanıcı_girisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanıcı_girisiActionPerformed
        jPanel1.setVisible(false);
        kullanıcı_paneli.setVisible(true);
        sonuc.setVisible(false);
    }//GEN-LAST:event_kullanıcı_girisiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        modelim.setRowCount(0);
        modelim.setColumnIdentifiers(kolonlar);
        ResultSet result=baglanti.tumsarkilarigoster();
    try {
        while(result.next()){
            satirlar[0]=result.getInt("sarkıid");
            satirlar[1]=result.getString("sarkiadi");
            satirlar[2]=result.getString("tarih");
            satirlar[3]=result.getString("sanatci");
            satirlar[4]=result.getString("album");
            satirlar[5]=result.getString("tur");
            satirlar[6]=result.getString("sure");
            satirlar[7]=result.getInt("dinlenmesayisi");
            modelim.addRow(satirlar);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable1.setModel(modelim);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void pop_listesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_listesiActionPerformed
           ResultSet result=baglanti.pop_listeleme(user.getKullanici_id());
           ResultSet resultjaz=baglanti.jaz_listeleme(user.getKullanici_id());
           ResultSet resultklasik=baglanti.klasik_listeleme(user.getKullanici_id());
           user_pop_list.setVisible(true);
           jScrollPane5.setVisible(true);
           normal.setVisible(false);
           jPanelliste.removeAll();
           ArrayList<JButton> pop_buttons=new ArrayList<>();
           ArrayList<JButton> jaz_buttons=new ArrayList<>();
           ArrayList<JButton> klasik_buttons=new ArrayList<>();
           ArrayList<Integer> pop_buttons_id=new ArrayList<>();
           ArrayList<Integer> jaz_buttons_id=new ArrayList<>();
           ArrayList<Integer> klasik_buttons_id=new ArrayList<>();
           

    try {
        while(result.next()){
            String name=result.getString("sarkiadi");
            int id=result.getInt("sarkıid");
            pop_buttons_id.add(id);
            System.out.println(name);
            int dinlenme_sayisi=result.getInt("dinlenmesayisi");
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            jPanelliste=new javax.swing.JPanel();
            jPanelliste.setLayout(null);
            jPanelliste.add(jLabelmuziksmi);
            pop_buttons.add(jButtonekleme);
            pop_label_id.add(jLabeldinlenme);
            jLabelmuziksmi.setBounds(11, 10, 120, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(140, 10, 90, 30);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(240, 10, 30, 16);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            jButtonekleme.setSize(150,50);
            //jButtonekleme.setText("EKLE");
            jButtonekleme.setText("DİNLE");
            jPanel11.add(jPanelliste);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    //jPanelliste.removeAll();
    try {
        while(resultjaz.next()){
            String name=resultjaz.getString("sarkiadi");
            int dinlenme_sayisi=resultjaz.getInt("dinlenmesayisi");
             int id=resultjaz.getInt("sarkıid");
            jaz_buttons_id.add(id);
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            jPanelliste=new javax.swing.JPanel();
            jaz_buttons.add(jButtonekleme);
            jaz_label_id.add(jLabeldinlenme);
            jPanelliste.setLayout(null);
            jPanelliste.add(jLabelmuziksmi);
            jLabelmuziksmi.setBounds(11, 10, 120, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(140, 10, 90, 30);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(240, 10, 30, 16);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            jButtonekleme.setSize(150,50);
            //jButtonekleme.setText("EKLE");
            jButtonekleme.setText("DİNLE");
            jPanel10.add(jPanelliste);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    //jPanelliste.removeAll();
    try {
        while(resultklasik.next()){
            String name=resultklasik.getString("sarkiadi");
            int dinlenme_sayisi=resultklasik.getInt("dinlenmesayisi");
            int id=resultklasik.getInt("sarkıid");
            klasik_buttons_id.add(id);
            jLabelmuziksmi = new javax.swing.JLabel();
            jLabeldinlenme = new javax.swing.JLabel();
            jButtonekleme=new javax.swing.JButton();
            jPanelliste=new javax.swing.JPanel();
            jPanelliste.setLayout(null);
            klasik_buttons.add(jButtonekleme);
            klasik_label_id.add(jLabeldinlenme);
            jPanelliste.add(jLabelmuziksmi);
            jLabelmuziksmi.setBounds(11, 10, 120, 30);
            jPanelliste.add(jLabeldinlenme);
            jLabeldinlenme.setBounds(140, 10, 90, 30);
            jPanelliste.add(jButtonekleme);
            jButtonekleme.setBounds(240, 10, 30, 16);
            jLabelmuziksmi.setText(name);
            jLabeldinlenme.setText(""+dinlenme_sayisi);
            jButtonekleme.setSize(150,50);
            //jButtonekleme.setText("EKLE");
            jButtonekleme.setText("DİNLE");
            jPanel12.add(jPanelliste);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    for(int i=0;i<pop_buttons.size();i++){
        int sayi=pop_buttons_id.get(i);
        int kontrol=i;
        pop_buttons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Şarkı dinleniyor");
                int dinlenme=baglanti.dinlenme_sayisi_kontrolu(sayi);
                System.out.println(dinlenme);
                pop_label_id.get(kontrol).setText(""+dinlenme);
            }
        });
  }
    for(int i=0;i<jaz_buttons.size();i++){
        int sayi=jaz_buttons_id.get(i);
        int kontrol=i;
        jaz_buttons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Şarkı dinleniyor");
                int dinlenme=baglanti.dinlenme_sayisi_kontrolu(sayi);
                System.out.println(dinlenme);
                jaz_label_id.get(kontrol).setText(""+dinlenme);
            }
        });
  }for(int i=0;i<klasik_buttons.size();i++){
        int sayi=klasik_buttons_id.get(i);
        int kontrol=i;
        klasik_buttons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Şarkı dinleniyor");
                int dinlenme=baglanti.dinlenme_sayisi_kontrolu(sayi);
                System.out.println(dinlenme);
                klasik_label_id.get(kontrol).setText(""+dinlenme);
            }
        });
  }
    }//GEN-LAST:event_pop_listesiActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        normal.setVisible(false);
        premium_listesi.setVisible(true);
        ResultSet result=baglanti.premium_user_al();
        ResultSet result_takip=baglanti.takip_ettiklerim(user.getKullanici_id());
    try {
        while(result_takip.next()){
            takip_ettiklerim.add(result_takip.getInt("kullanıcııd"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        while(result.next()){
            String isim=result.getString("kullanıcıadı");
            int premium_id=result.getInt("kullanıcııd");
            
            int kontrol=0;
            
            if(user.getKullanici_id()==premium_id){
                kontrol=1;
                System.out.println("dassad");
            }
            if(takip_ettiklerim.size()==0 && kontrol==0){
                premium_panel = new javax.swing.JPanel();
            premium_user_ismi = new javax.swing.JLabel();
            takip_et = new javax.swing.JButton();

            premium_button.add(takip_et);
            premium_user_id.add(premium_id);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            premium_panel.setLayout(null);

            premium_panel.add(premium_user_ismi);
            premium_user_ismi.setBounds(0, 10, 160, 40);

            takip_et.setText("TAKİP ET");
            premium_panel.add(takip_et);
            takip_et.setBounds(170, 0, 130, 50);

           getContentPane().add(premium_panel);
           premium_panel.setBounds(120, 100, 150, 30);
           premium_user_ismi.setText(isim);
           premium_user_ismi.setBackground(Color.red);
           jPanel7.add(premium_panel);
            }
            
            for(int i=0;i<takip_ettiklerim.size();i++){
                if(premium_id==takip_ettiklerim.get(i)){
                    kontrol=1;
                    break;
                }
            }
             if(kontrol==0 && takip_ettiklerim.size()!=0){
             premium_panel = new javax.swing.JPanel();
            premium_user_ismi = new javax.swing.JLabel();
            takip_et = new javax.swing.JButton();

            premium_button.add(takip_et);
            premium_user_id.add(premium_id);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            premium_panel.setLayout(null);

            premium_panel.add(premium_user_ismi);
            premium_user_ismi.setBounds(0, 10, 160, 40);

            takip_et.setText("TAKİP ET");
            premium_panel.add(takip_et);
            takip_et.setBounds(170, 0, 130, 50);

           getContentPane().add(premium_panel);
           premium_panel.setBounds(120, 100, 150, 30);
           premium_user_ismi.setText(isim);
           premium_user_ismi.setBackground(Color.red);
           jPanel7.add(premium_panel);
             }
           //buraya kadar
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    for(int i=0;i<premium_button.size();i++){
        int sayi=premium_user_id.get(i);
        int kontrol=i;
        premium_button.get(i).addActionListener(  
      new ActionListener() {  
     
   //Handle event
   public void actionPerformed(ActionEvent event) {
       //takip_ettiklerim.add(sayi);
       int sarki_id;
         
           //premium_button.clear();
           baglanti.takip_ettiklerime_ekle(user.getKullanici_id(),sayi);
           premium_listesi.setVisible(false);
           premium_listeleri.setVisible(true);
           System.out.println("sayi:"+sayi);
           ResultSet result=baglanti.pop_listeleme(sayi);
           ResultSet resultjaz=baglanti.jaz_listeleme(sayi);
           ResultSet resultklasik=baglanti.klasik_listeleme(sayi);
       
       try {
           while(result.next()){
               String isim=result.getString("sarkiadi");
               int dinlenme=result.getInt("dinlenmesayisi");
               String tur=result.getString("tur");
               sarki_id=result.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_pop_button.add(sarki_id);
        premium_pop_click.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel9.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           while(resultjaz.next()){
               String isim=resultjaz.getString("sarkiadi");
               int dinlenme=resultjaz.getInt("dinlenmesayisi");
               String tur=resultjaz.getString("tur");
               sarki_id=resultjaz.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_jaz_id.add(sarki_id);
        premium_jaz_button.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel16.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }try {
           while(resultklasik.next()){
               String isim=resultklasik.getString("sarkiadi");
               int dinlenme=resultklasik.getInt("dinlenmesayisi");
               String tur=resultklasik.getString("tur");
               sarki_id=resultklasik.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_klasik_id.add(sarki_id);
        premium_klasik_button.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel17.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }
       for(int i=0;i<premium_pop_click.size();i++){
        System.out.println("dasda");
        int sayi=premium_pop_button.get(i);
        int kontrol=i;
        premium_pop_click.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.pop_calma_listesine_ekle(sayi,user.getKullanici_id(),"pop");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "pop listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }for(int i=0;i<premium_jaz_button.size();i++){
        System.out.println("dasda");
        int sayi=premium_jaz_id.get(i);
        int kontrol=i;
        premium_jaz_button.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.jaz_calma_listesine_ekle(sayi,user.getKullanici_id(),"jaz");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "jaz listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }for(int i=0;i<premium_klasik_button.size();i++){
        System.out.println("dasda");
        int sayi=premium_klasik_id.get(i);
        int kontrol=i;
        premium_klasik_button.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.klasik_calma_listesine_ekle(sayi,user.getKullanici_id(),"klasik");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "klasik listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }
       tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_pop_button.size();i++){
                   baglanti.pop_calma_listesine_ekle(premium_pop_button.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar pop listene eklendi");
           }
       });
       jaz_tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_jaz_id.size();i++){
                   baglanti.jaz_calma_listesine_ekle(premium_jaz_id.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar jaz listene eklendi");
           }
       });
       klasik_tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_klasik_id.size();i++){
                   baglanti.klasik_calma_listesine_ekle(premium_klasik_id.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar klasik listene eklendi");
           }
       });
       
   }  
  }  
  );
    }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tumunu_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tumunu_ekleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tumunu_ekleActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jPanel11.removeAll();
        jPanel10.removeAll();
        jPanel12.removeAll();
        //jPanel14.removeAll();
        user_pop_list.setVisible(false);
        jScrollPane5.setVisible(false);
        normal.setVisible(true);
        jScrollPane7.setVisible(true);
        pop_label_id.clear();
        //kullanıcı_butonuActionPerformed(evt); 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jPanel4.removeAll();
        pop_10.removeAll();
        jPanel14.removeAll();
        normal.setVisible(false);
        jPanel4.removeAll();
        jPanel15.removeAll();
        kullanıcı_paneli.setVisible(true);
        jScrollPane7.setVisible(false);
        guncelleme_sayfa_kontrol=0;
     //genel_en_dinlenen.clear();

     
     premium_pop_click.clear();
     en_cok_dinlenen_label.clear();
     pop_10_id.clear();
     jaz_label_id.clear();
     klasik_label_id.clear();
     pop_10_button.clear();
     pop_label_id.clear();
     premium_pop_button.clear();
     premium_user_id.clear();
     takip_ettiklerim.clear();
     genel_en_dinlenen.clear();
     premium_button.clear();
     jbuttonsayisi.clear();
     genel_en_dinlenen_id.clear();
     //pop_10_button.clear();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
     normal.setVisible(false);
        premium_listesi.setVisible(true);
        //ResultSet result=baglanti.premium_user_al();
        ResultSet result_takip=baglanti.takip_ettiklerim(user.getKullanici_id());
    
    try {
        while(result_takip.next()){
            String isim=result_takip.getString("kullanıcıadı");
            int premium_id=result_takip.getInt("kullanıcııd");
     
                premium_panel = new javax.swing.JPanel();
            premium_user_ismi = new javax.swing.JLabel();
            takip_et = new javax.swing.JButton();

            premium_button.add(takip_et);
            premium_user_id.add(premium_id);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            premium_panel.setLayout(null);

            premium_panel.add(premium_user_ismi);
            premium_user_ismi.setBounds(0, 10, 160, 40);

            takip_et.setText("LİSTELERİNE BAK");
            premium_panel.add(takip_et);
            takip_et.setBounds(170, 0, 130, 50);

           getContentPane().add(premium_panel);
           premium_panel.setBounds(120, 100, 150, 30);
           premium_user_ismi.setText(isim);
           premium_user_ismi.setBackground(Color.red);
           jPanel7.add(premium_panel);
           
           //buraya kadar
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    for(int i=0;i<premium_button.size();i++){
        int sayi=premium_user_id.get(i);
        int kontrol=i;
        premium_button.get(i).addActionListener(  
      new ActionListener() {  
     
   //Handle event
   public void actionPerformed(ActionEvent event) {
       //takip_ettiklerim.add(sayi);
       int sarki_id;
         
           //premium_button.clear();
           //baglanti.takip_ettiklerime_ekle(user.getKullanici_id(),sayi);
           premium_listesi.setVisible(false);
           premium_listeleri.setVisible(true);
           System.out.println("sayi:"+sayi);
           ResultSet result=baglanti.pop_listeleme(sayi);
           ResultSet resultjaz=baglanti.jaz_listeleme(sayi);
           ResultSet resultklasik=baglanti.klasik_listeleme(sayi);
       
       try {
           while(result.next()){
               String isim=result.getString("sarkiadi");
               int dinlenme=result.getInt("dinlenmesayisi");
               String tur=result.getString("tur");
               sarki_id=result.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_pop_button.add(sarki_id);
        premium_pop_click.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel9.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           while(resultjaz.next()){
               String isim=resultjaz.getString("sarkiadi");
               int dinlenme=resultjaz.getInt("dinlenmesayisi");
               String tur=resultjaz.getString("tur");
               sarki_id=resultjaz.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_jaz_id.add(sarki_id);
        premium_jaz_button.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel16.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }try {
           while(resultklasik.next()){
               String isim=resultklasik.getString("sarkiadi");
               int dinlenme=resultklasik.getInt("dinlenmesayisi");
               String tur=resultklasik.getString("tur");
               sarki_id=resultklasik.getInt("sarkıid");
               premium_pop_panel = new javax.swing.JPanel();
               premium_sarki_ismi = new javax.swing.JLabel();
               premium_ekle = new javax.swing.JButton();
               premium_dinlenme = new javax.swing.JLabel();
               premium_tur = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        premium_klasik_id.add(sarki_id);
        premium_klasik_button.add(premium_ekle);
        //System.out.println(premium_button.get(0));
        premium_pop_panel.setLayout(null);
        premium_pop_panel.add(premium_sarki_ismi);
        premium_sarki_ismi.setBounds(0, 10, 80, 40);

        premium_ekle.setText("EKLE");
        premium_pop_panel.add(premium_ekle);
        premium_ekle.setBounds(230, 0, 130, 50);
        premium_pop_panel.add(premium_dinlenme);
        premium_dinlenme.setBounds(180, 10, 90, 40);
        

        getContentPane().add(premium_pop_panel);
        premium_pop_panel.add(premium_tur);
        premium_tur.setBounds(120, 10, 70, 40);
        premium_pop_panel.setBounds(120, 100, 420, 60);
        premium_sarki_ismi.setText(isim);
        //premium_dinlenme.setText(dinlenme.toString());
        premium_tur.setText(tur);
        jPanel17.add(premium_pop_panel);
           }
       } catch (SQLException ex) {
           Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
       }
       for(int i=0;i<premium_pop_click.size();i++){
        System.out.println("dasda");
        int sayi=premium_pop_button.get(i);
        int kontrol=i;
        premium_pop_click.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.pop_calma_listesine_ekle(sayi,user.getKullanici_id(),"pop");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "pop listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }for(int i=0;i<premium_jaz_button.size();i++){
        System.out.println("dasda");
        int sayi=premium_jaz_id.get(i);
        int kontrol=i;
        premium_jaz_button.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.jaz_calma_listesine_ekle(sayi,user.getKullanici_id(),"jaz");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "jaz listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }for(int i=0;i<premium_klasik_button.size();i++){
        System.out.println("dasda");
        int sayi=premium_klasik_id.get(i);
        int kontrol=i;
        premium_klasik_button.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean sonuc=baglanti.klasik_calma_listesine_ekle(sayi,user.getKullanici_id(),"klasik");
               if(sonuc){
                   JOptionPane.showMessageDialog(null, "klasik listene eklendi");
               }else{
                   JOptionPane.showMessageDialog(null, "şarkı zaten listende ekli");
               }
                //System.out.println("girdi");
            }
        });
    }
       tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_pop_button.size();i++){
                   baglanti.pop_calma_listesine_ekle(premium_pop_button.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar pop listene eklendi");
           }
       });
       jaz_tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_jaz_id.size();i++){
                   baglanti.jaz_calma_listesine_ekle(premium_jaz_id.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar jaz listene eklendi");
           }
       });
       klasik_tumunu_ekle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(int i=0;i<premium_klasik_id.size();i++){
                   baglanti.klasik_calma_listesine_ekle(premium_klasik_id.get(i),user.getKullanici_id(),"pop");
               }
               JOptionPane.showMessageDialog(null, "tüm şarkılar klasik listene eklendi");
           }
       });
       
   }  
  }  
  );
    }       
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jPanel7.removeAll();
        premium_listesi.setVisible(false);
        normal.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jPanel9.removeAll();
        jPanel16.removeAll();
        jPanel17.removeAll();
        jPanel7.removeAll();
        premium_listeleri.setVisible(false);
        normal.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        kullanıcı_paneli.setVisible(false);
        kayıt_ekranı.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        boolean sonuc=baglanti.kullanıcı_ekle(kayıt_kullanıcı_adi.getText(),kayıt_kullanıcı_mail.getText(),kayıt_kullanıcı_sifre.getText(),kayıt_kullanıcı_turu.getSelectedItem().toString());
        if(sonuc){
             JOptionPane.showMessageDialog(null, "kayıt Başarılı bir şekilde eklendi");
         }else{
             JOptionPane.showMessageDialog(null, "Kullanıcı zaten ekli..");
             kayıt_kullanıcı_adi.setText("");
             kayıt_kullanıcı_mail.setText("");
             kayıt_kullanıcı_sifre.setText("");
         }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        kayıt_ekranı.setVisible(false);
        kullanıcı_paneli.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
       boolean sonuc=baglanti.album_ekle(album_adı.getText(),album_turu.getText());
       if(sonuc){
           JOptionPane.showMessageDialog(null, "album eklendi");
       }else{
           JOptionPane.showMessageDialog(null, "album zaten mevcut");
       }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jPanel2.setVisible(false);
        album_ekle.setVisible(true);
        sarkici_ekleme_paneli.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        album_ekle.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void albumleri_gosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumleri_gosterActionPerformed
    try {
        jPanel2.setVisible(false);
        sarkici_ekleme_paneli.setVisible(false);
        album_listesi.setVisible(true);
        ResultSet result=baglanti.albumleri_goster();
        while(result.next()){
         int albumid=result.getInt("albumid");
            String album_ad=result.getString("albumadı");
            String albumturu=result.getString("albumturu");
            album_list = new javax.swing.JPanel();
        album_name = new javax.swing.JLabel();
        album_type = new javax.swing.JLabel();
        gozat = new javax.swing.JButton();
        albumsilbutton=new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        album_sil.add(albumsilbutton);
        album_isimleri.add(album_ad);
        gozat_button_id.add(albumid);
        gozat_buttons.add(gozat);
        album_list.setLayout(null);
        album_list.add(album_name);
        album_name.setBounds(11, 6, 140, 40);
        album_list.add(album_type);
        album_type.setBounds(170, 6, 110, 40);

        gozat.setText("GÖZAT");
        album_list.add(gozat);
        gozat.setBounds(290, 10, 160, 32);
        albumsilbutton.setText("SİL");
        album_list.add(albumsilbutton);
        albumsilbutton.setBounds(450, 10, 160, 32);
        getContentPane().add(album_list);
        album_list.setBounds(130, 100, 300, 50);
        album_name.setText(album_ad);
        album_type.setText(albumturu);
        jPanel18.add(album_list);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    for(int i=0;i<gozat_buttons.size();i++){
        System.out.println("gozat butonunaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        int sayi=gozat_button_id.get(i);
        int kontrol=i;
        
        gozat_buttons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album_listesi.setVisible(false);
                album_detay.setVisible(true);
                ResultSet result=baglanti.album_icerigini_goster(sayi);
                album_sarkıları.setText(album_isimleri.get(kontrol));
                button_tutucu=gozat_button_id.get(kontrol);
                try {
                    while(result.next()){
                        String sanatci=result.getString("sanatçı");
                        String şarkı=result.getString("şarkı");
                        String tur=result.getString("albumturu");
                        album_list = new javax.swing.JPanel();
                           album_name = new javax.swing.JLabel();
                           album_sanatci = new javax.swing.JLabel();
                         album_type = new javax.swing.JLabel();
                           //gozat = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

                      //gozat_button_id.add(albumid);
                     //gozat_buttons.add(gozat);
                     album_list.setLayout(null);
                     album_list.add(album_name);
                     album_name.setBounds(11, 6, 120, 40);
                     album_list.add(album_sanatci);
                     album_sanatci.setBounds(120, 6, 90, 40);
                     album_list.add(album_type);
                     album_type.setBounds(200, 6, 110, 40);

                   // gozat.setText("GÖZAT");
                    //album_list.add(gozat);
                    //gozat.setBounds(290, 10, 160, 32);
                    getContentPane().add(album_list);
                    album_list.setBounds(130, 100, 300, 50);
                    album_name.setText(şarkı);
                    album_type.setText(tur);
                    album_sanatci.setText(sanatci);
                    album_detay_sarkıları.add(album_list);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        /*
        album_sil.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
        });*/
            
        }
    for(int i=0;i<album_sil.size();i++){
        int sayi=gozat_button_id.get(i);
        int kontrol=i;
        
        album_sil.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
       
        boolean sonuc=baglanti.album_sil(sayi);
        if(sonuc){
           jPanel18.removeAll();  
           album_sil.clear();
           album_isimleri.clear();
           gozat_buttons.clear();
           gozat_button_id.clear();
            albumleri_gosterActionPerformed(e);
            JOptionPane.showMessageDialog(null,"ALBÜM SİLİNDİ");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
        });
    }
        System.out.println("test yapıyorum");
    
    }//GEN-LAST:event_albumleri_gosterActionPerformed

   
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        album_listesi.setVisible(false);
        album_detay.setVisible(false);
        jPanel2.setVisible(true);
        jPanel18.removeAll();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        boolean sonuc=baglanti.albume_sarki_ekle(button_tutucu,album_add_isim.getText(),album_add_sanatci.getText(),album_add_tur.getText());
        System.out.println(button_tutucu);
        album_add_isim.setText("");
        album_add_sanatci.setText("");
        album_add_tur.setText("");
        if(sonuc){
            JOptionPane.showMessageDialog(null, "BAŞARILI BİR ŞEKİLDE EKLENDİ");
            album_detay_sarkıları.removeAll();
            ResultSet result=baglanti.album_icerigini_goster(button_tutucu);
                try {
                    while(result.next()){
                        String sanatci=result.getString("sanatçı");
                        String şarkı=result.getString("şarkı");
                        album_list = new javax.swing.JPanel();
                         album_name = new javax.swing.JLabel();
                         album_type = new javax.swing.JLabel();
                           //gozat = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

                      //gozat_button_id.add(albumid);
                     //gozat_buttons.add(gozat);
                     album_list.setLayout(null);
                     album_list.add(album_name);
                     album_name.setBounds(11, 6, 140, 40);
                     album_list.add(album_type);
                     album_type.setBounds(170, 6, 110, 40);

                   // gozat.setText("GÖZAT");
                    //album_list.add(gozat);
                    //gozat.setBounds(290, 10, 160, 32);
                    getContentPane().add(album_list);
                    album_list.setBounds(130, 100, 300, 50);
                    album_name.setText(şarkı);
                    album_type.setText(sanatci);
                    album_detay_sarkıları.add(album_list);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else{
           JOptionPane.showMessageDialog(null, "BU TÜRDE BİR ŞARKI ALBÜME EKLENEMEZ");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
       album_detay_sarkıları.removeAll();
       album_detay.setVisible(false);
       album_listesi.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(guncelleme_sayfa_kontrol==0){
            jPanel2.setVisible(true);
            sanatci_modelim.setRowCount(0);
            modelim.setRowCount(0);
            premium_takip_modelim.setRowCount(0);
            pop_modelim.setRowCount(0);
            kullanıcılar_modelim.setRowCount(0);
            klasik_modelim.setRowCount(0);
            jaz_modelim.setRowCount(0);
            album_modelim.setRowCount(0);
            album_content_modelim.setRowCount(0);

            jScrollPane2.setVisible(false);
            jScrollPane1.setVisible(false);
            guncelle.setVisible(false);
        }else{
            jScrollPane2.setVisible(false);
            guncelle.setVisible(false);
            normal.setVisible(true);
            jScrollPane7.setVisible(true);
            sanatci_modelim.setRowCount(0);
            modelim.setRowCount(0);
            premium_takip_modelim.setRowCount(0);
            pop_modelim.setRowCount(0);
            kullanıcılar_modelim.setRowCount(0);
            klasik_modelim.setRowCount(0);
            jaz_modelim.setRowCount(0);
            album_modelim.setRowCount(0);
            album_content_modelim.setRowCount(0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        boolean sonuc=baglanti.delete(Integer.parseInt(id));
        if(sonuc){
            JOptionPane.showMessageDialog(null,"kayıt başarıyla silindi");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void sanatcılarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sanatcılarActionPerformed
        sanatci_goruntuleme.setVisible(true);
        ResultSet result=baglanti.sanatcilari_goster();
        //album_sil.clear();
        try {
        jPanel2.setVisible(false);
        sarkici_ekleme_paneli.setVisible(false);
        while(result.next()){
            int sanatci_id=result.getInt("sanatcid");
            String sanatci_adi=result.getString("sanatciadi");
            String sanatci_ulke=result.getString("ulke");
            album_list = new javax.swing.JPanel();
        album_name = new javax.swing.JLabel();
        album_type = new javax.swing.JLabel();
        albumsilbutton=new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

       
        sanatci_sil_button.add(albumsilbutton);
        //album_isimleri.add(sanatci_adi);
        sanatci_button_id.add(sanatci_id);
        album_list.setLayout(null);
        album_list.add(album_name);
        album_name.setBounds(11, 6, 140, 40);
        album_list.add(album_type);
        album_type.setBounds(170, 6, 110, 40);
        albumsilbutton.setText("SİL");
        album_list.add(albumsilbutton);
        albumsilbutton.setBounds(245, 10, 160, 32);
        getContentPane().add(album_list);
        album_list.setBounds(130, 100, 300, 50);
        album_name.setText(sanatci_adi);
        album_type.setText(sanatci_ulke);
        jPanel19.add(album_list);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
        for(int i=0;i<sanatci_sil_button.size();i++){
            int sayi=sanatci_button_id.get(i);
            int kontrol=i;
            sanatci_sil_button.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean sonuc=baglanti.sanatci_sil(sayi);
                    if(sonuc){
                        JOptionPane.showMessageDialog(null,"SANATCİ SİLİNDİ");
                        jPanel19.removeAll();
                        //album_isimleri.clear();
                        sanatci_button_id.clear();
                        sanatci_sil_button.clear();
                        sanatcılarActionPerformed(e);
                    }else{
                        
                    }
                }
            });
        }
    }//GEN-LAST:event_sanatcılarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean sonuc=baglanti.sanatci_ekle(sanatci_ismi_text.getText(),sanatci_ulke_text.getText());
        if(sonuc){
            JOptionPane.showMessageDialog(null,"sanatçı eklendi");
            jPanel19.removeAll();
            //album_isimleri.clear();
            sanatci_button_id.clear();
            sanatci_sil_button.clear();
            sanatci_ismi_text.setText("");
            sanatci_ulke_text.setText("");
            sanatcılarActionPerformed(evt);
            
            //album_isimleri.clear();
        }else{
            JOptionPane.showMessageDialog(null,"sanatçı zaten mevcut");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        sanatci_goruntuleme.setVisible(false);
        if(sanatci_kontrol==0){
            sanatci_sil_button.clear();
            sanatci_button_id.clear();
            //album_isimleri.clear();
        }
        jPanel2.setVisible(true);
        jPanel19.removeAll();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        kullanıcı_paneli.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
       jScrollPane7.setVisible(false);
       normal.setVisible(false);
       guncelle.setVisible(true);
        jScrollPane2.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane9.setVisible(true);
        sanatci_modelim.setColumnIdentifiers(sanatçı_kolonlari);
        modelim.setColumnIdentifiers(kolonlar);
        pop_modelim.setColumnIdentifiers(pop_kolonlari);
        premium_takip_modelim.setColumnIdentifiers(premium_takip_kolonlari);
        kullanıcılar_modelim.setColumnIdentifiers(kullanıcılar_kolonları);
        klasik_modelim.setColumnIdentifiers(klasik_kolonlari);
        jaz_modelim.setColumnIdentifiers(jaz_kolonlari);
        album_modelim.setColumnIdentifiers(album_kolonlari);
        album_content_modelim.setColumnIdentifiers(album_content_kolonlari);
        ResultSet klasik_result=baglanti.klasik_table();
        ResultSet result=baglanti.tumsarkilarigoster();
        ResultSet sanatci_result=baglanti.sanatcilari_goster();
        ResultSet premium_takip_result=baglanti.premium_takip_table();
        ResultSet pop_result=baglanti.pop_table();
        ResultSet jaz_result=baglanti.jaz_table();
        ResultSet album_result=baglanti.album_table();
        ResultSet album_content_result=baglanti.album_content_table();
        ResultSet kullanıcılar_result=baglanti.kullanıcılar_table();
        
        //dasd
       try {
        while(album_result.next()){
            album_satir[0]=album_result.getInt("albumid");
            album_satir[1]=album_result.getString("albumadı");
            album_satir[2]=album_result.getString("albumturu");
            album_modelim.addRow(album_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable8.setModel(album_modelim);
       try {
        while(album_content_result.next()){
            album_content_satir[0]=album_content_result.getInt("idalbum_content");
            album_content_satir[1]=album_content_result.getInt("album_id");
            album_content_satir[2]=album_content_result.getString("şarkı");
            album_content_satir[3]=album_content_result.getString("sanatçı");
            album_content_modelim.addRow(album_content_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }jTable9.setModel(album_content_modelim);
       try {
        while(jaz_result.next()){
            jaz_satir[0]=jaz_result.getInt("idjaz");
            jaz_satir[1]=jaz_result.getInt("useridjaz");
            jaz_satir[2]=jaz_result.getInt("sarkiid");
            jaz_modelim.addRow(jaz_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable7.setModel(jaz_modelim);
       try {
        while(klasik_result.next()){
            klasik_satir[0]=klasik_result.getInt("idklasik");
            klasik_satir[1]=klasik_result.getInt("useridklasik");
            klasik_satir[2]=klasik_result.getInt("sarkiid");
            klasik_modelim.addRow(klasik_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
       jTable6.setModel(klasik_modelim);
     try {
        while(kullanıcılar_result.next()){
            kullanıcılar_satir[0]=kullanıcılar_result.getInt("kullanıcııd");
            kullanıcılar_satir[1]=kullanıcılar_result.getString("kullanıcıadı");
            kullanıcılar_satir[2]=kullanıcılar_result.getString("email");
            kullanıcılar_satir[3]=kullanıcılar_result.getString("sifre");
            kullanıcılar_satir[4]=kullanıcılar_result.getString("abonelikturu");
            kullanıcılar_modelim.addRow(kullanıcılar_satir);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
     jTable5.setModel(kullanıcılar_modelim);
    try {
        while(result.next()){
            satirlar[0]=result.getInt("sarkıid");
            satirlar[1]=result.getString("sarkiadi");
            satirlar[2]=result.getString("tarih");
            satirlar[3]=result.getString("sanatci");
            satirlar[4]=result.getString("album");
            satirlar[5]=result.getString("tur");
            satirlar[6]=result.getString("sure");
            satirlar[7]=result.getInt("dinlenmesayisi");
            modelim.addRow(satirlar);

        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable1.setModel(modelim);
    try {
        while(sanatci_result.next()){
            sanatci_satirlar[0]=sanatci_result.getInt("sanatcid");
            sanatci_satirlar[1]=sanatci_result.getString("sanatciadi");
            sanatci_satirlar[2]=sanatci_result.getString("ulke");
            sanatci_modelim.addRow(sanatci_satirlar);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable3.setModel(sanatci_modelim);
    try {
        while(premium_takip_result.next()){
            premium_takip_satir[0]=premium_takip_result.getInt("idpremium_takip");
            premium_takip_satir[1]=premium_takip_result.getInt("premium_takip_user");
            premium_takip_satir[2]=premium_takip_result.getInt("premium_takip_id");
            premium_takip_modelim.addRow(premium_takip_satir);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable2.setModel(premium_takip_modelim);
    try {
        while(pop_result.next()){
            pop_satir[0]=pop_result.getInt("idpop");
            pop_satir[1]=pop_result.getInt("useridpop");
            pop_satir[2]=pop_result.getInt("sarkiid");
            pop_modelim.addRow(pop_satir);
        }
    } catch (SQLException ex) {
        Logger.getLogger(proje.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable4.setModel(pop_modelim);
       guncelleme_sayfa_kontrol=1;
    }//GEN-LAST:event_jButton26ActionPerformed
  public void deneme(){
     
      for(int i=0;i<premium_pop_click.size();i++){
        System.out.println("dasda");
        int sayi=premium_pop_button.get(i);
        int kontrol=i;
        premium_pop_click.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //baglanti.pop_calma_listesine_ekle(sayi,user.getKullanici_id(),"pop");
                System.out.println("girdi");
            }
        });
    }
  }
    private void b1MouseClicked(java.awt.event.MouseEvent evt){
        System.out.println("hello");
    }
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
            java.util.logging.Logger.getLogger(proje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField album_add_isim;
    private javax.swing.JTextField album_add_sanatci;
    private javax.swing.JTextField album_add_tur;
    private javax.swing.JTextField album_adı;
    private javax.swing.JPanel album_detay;
    private javax.swing.JPanel album_detay_sarkıları;
    private javax.swing.JPanel album_ekle;
    private javax.swing.JPanel album_listesi;
    private javax.swing.JLabel album_sarkıları;
    private javax.swing.JTextField album_turu;
    private javax.swing.JPanel albume_sarkı_ekleme_paneli;
    private javax.swing.JTextField albumismi;
    private javax.swing.JButton albumleri_goster;
    private javax.swing.JButton delete;
    private javax.swing.JButton geri;
    private javax.swing.JPanel guncelle;
    private javax.swing.JButton guncelleme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton jaz_tumunu_ekle;
    private javax.swing.JPanel kayıt_ekranı;
    private javax.swing.JTextField kayıt_kullanıcı_adi;
    private javax.swing.JTextField kayıt_kullanıcı_mail;
    private javax.swing.JPasswordField kayıt_kullanıcı_sifre;
    private javax.swing.JComboBox<String> kayıt_kullanıcı_turu;
    private javax.swing.JButton klasik_tumunu_ekle;
    private javax.swing.JTextField kullanıcı_adı;
    private javax.swing.JButton kullanıcı_butonu;
    private javax.swing.JButton kullanıcı_girisi;
    private javax.swing.JPanel kullanıcı_paneli;
    private javax.swing.JPanel listele;
    private javax.swing.JPanel normal;
    private javax.swing.JPanel pop_10;
    private javax.swing.JButton pop_listesi;
    private javax.swing.JPanel premium;
    private javax.swing.JPanel premium_listeleri;
    private javax.swing.JPanel premium_listesi;
    private javax.swing.JPanel sanatci_goruntuleme;
    private javax.swing.JTextField sanatci_ismi;
    private javax.swing.JTextField sanatci_ismi_text;
    private javax.swing.JTextField sanatci_ulke_text;
    private javax.swing.JButton sanatcılar;
    private javax.swing.JTextField sarki_adi;
    private javax.swing.JTextField sarki_tarihi;
    private javax.swing.JPanel sarkici_ekleme_paneli;
    private javax.swing.JPasswordField sifre;
    private javax.swing.JLabel sonuc;
    private javax.swing.JTextField sure;
    private javax.swing.JButton tumunu_ekle;
    private javax.swing.JTextField turismi;
    private javax.swing.JButton update;
    private javax.swing.JPanel user_pop_list;
    // End of variables declaration//GEN-END:variables
}
