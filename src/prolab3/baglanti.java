/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOSHIBA
 */
public class baglanti {
     private String kullanici_adi="root";
    private String parola="OmerHms61.";
    private String db_ismi="prolab";
    private String host="localhost";
    private int port=3306;
    private Statement statement=null;
   private Connection con=null;
    
   
   public ResultSet calisanlarigoster(){
      String sorgu=" SELECT * FROM şarkı ORDER BY dinlenmesayisi DESC LIMIT 10";
       ResultSet result = null;
       
        try {
            statement=con.createStatement();
            
          result=statement.executeQuery(sorgu);
            /*
            while(result.next()){
                
                String name=result.getString("sarkiadi");
                String surname=result.getString("sanatci");
                
                System.out.println("name:"+name);
                System.out.println("surname:"+surname);
            }
          */
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
       
   }
   public ResultSet tumsarkilarigoster(){
      String sorgu=" SELECT * FROM şarkı ";
       ResultSet result = null;
       
        try {
            statement=con.createStatement();
            
          result=statement.executeQuery(sorgu);
            /*
            while(result.next()){
                
                String name=result.getString("sarkiadi");
                String surname=result.getString("sanatci");
                
                System.out.println("name:"+name);
                System.out.println("surname:"+surname);
            }
          */
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
       
   }
   public boolean kullanici_girisi(String kullanıcı_adı,String sifre){
       String sorgu="Select * From kullanıcılar Where kullanıcıadı=? and sifre=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,kullanıcı_adı);
             preparedStatement.setString(2, sifre);
             ResultSet rs=preparedStatement.executeQuery();
             return rs.next();
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
   }
   public String abonelik(String kullanıcı_adı,String sifre){
       String sorgu="Select * From kullanıcılar Where kullanıcıadı=? and sifre=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,kullanıcı_adı);
             preparedStatement.setString(2, sifre);
             ResultSet rs=preparedStatement.executeQuery();
             while(rs.next()){
                 String abonelik_turu=rs.getString("abonelikturu");
                 return abonelik_turu;
             }
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return "";
   }
   public kullanici kullanici_bilgileri(String kullanıcı_adı,String sifre){
       String sorgu="Select * From kullanıcılar Where kullanıcıadı=? and sifre=?";
       PreparedStatement preparedStatement=null;
       kullanici user=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,kullanıcı_adı);
             preparedStatement.setString(2, sifre);
             ResultSet rs=preparedStatement.executeQuery();
             while(rs.next()){
                 int kullanici_id=rs.getInt("kullanıcııd");
                 String abonelik_turu=rs.getString("abonelikturu");
                 String email=rs.getString("email");
                 user=new kullanici(kullanici_id, kullanıcı_adı, email, abonelik_turu);
                 return user;
             }
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return user;
   }
   public boolean pop_calma_listesine_ekle(int id,int kullanici_id,String tur){
       
       String sorgu="Insert INTO pop (useridpop,sarkiid) VALUES(?,?)";
       String sorgu2="Select * from pop Where sarkiid=? AND useridpop=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu2);
             preparedStatement.setInt(1, id);
              preparedStatement.setInt(2, kullanici_id);
             ResultSet result=preparedStatement.executeQuery();
             if(!result.next()){
              preparedStatement=null;
              preparedStatement=con.prepareStatement(sorgu);
             //preparedStatement.setString(1,tur);
             preparedStatement.setInt(1,kullanici_id);
             preparedStatement.setInt(2,id);
             
             preparedStatement.executeUpdate(); 
             return true;
             }else{
                 System.out.println("zaten calma listenizde ekli....");
                 return false;
             }
             
             
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public boolean jaz_calma_listesine_ekle(int id,int kullanici_id,String tur){
       
       String sorgu="Insert INTO jaz (useridjaz,sarkiid) VALUES(?,?)";
       String sorgu2="Select * from jaz Where sarkiid=? AND useridjaz=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu2);
             preparedStatement.setInt(1, id);
             preparedStatement.setInt(2, kullanici_id);
             ResultSet result=preparedStatement.executeQuery();
             if(!result.next()){
              preparedStatement=null;
              preparedStatement=con.prepareStatement(sorgu);
             //preparedStatement.setString(1,tur);
             preparedStatement.setInt(1,kullanici_id);
             preparedStatement.setInt(2,id);
             
             preparedStatement.executeUpdate();   
             return true;
             }else{
                 System.out.println("zaten calma listenizde ekli....");
                 return false;
             }
             
             
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public boolean klasik_calma_listesine_ekle(int id,int kullanici_id,String tur){
       
       String sorgu="Insert INTO klasik (useridklasik,sarkiid) VALUES(?,?)";
       String sorgu2="Select * from klasik Where sarkiid=? AND useridklasik=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu2);
             preparedStatement.setInt(1, id);
             preparedStatement.setInt(2, kullanici_id);
             ResultSet result=preparedStatement.executeQuery();
             if(!result.next()){
              preparedStatement=null;
              preparedStatement=con.prepareStatement(sorgu);
             //preparedStatement.setString(1,tur);
             preparedStatement.setInt(1,kullanici_id);
             preparedStatement.setInt(2,id);
             
             preparedStatement.executeUpdate(); 
             return true;
             }else{
                 System.out.println("zaten calma listenizde ekli....");
                 return false;
             }
             
             
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   
   
   public void update(String id,String sarki_adi,String tarih,String sanatci,String album,String tur,int sure,int dinlenmesayisi){
       int sarkıid=Integer.parseInt(id);
       String sorgu="UPDATE şarkı SET sarkiadi=?,tarih=?,sanatci=?,album=?,tur=?,sure=?,dinlenmesayisi=? WHERE sarkıid=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1, sarki_adi);
             preparedStatement.setString(2, tarih);
             preparedStatement.setString(3, sanatci);
             preparedStatement.setString(4, album);
             preparedStatement.setString(5, tur);
             preparedStatement.setInt(6, sure);
             preparedStatement.setInt(7,dinlenmesayisi);
             preparedStatement.setInt(8,sarkıid);
             preparedStatement.executeUpdate();

         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   public void takip_ettiklerime_ekle(int kullanici_id,int premium_id){
      
       String sorgu="Insert INTO premium_takip (premium_takip_user,premium_takip_id) VALUES(?,?)";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1,kullanici_id);
             preparedStatement.setInt(2, premium_id);
             preparedStatement.executeUpdate();
             
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   public int dinlenme_sayisi_kontrolu(int sarkiid){
       String sorgu2="Select * from şarkı where sarkıid=?";
       String sorgu="UPDATE şarkı SET dinlenmesayisi=? WHERE sarkıid=?";
       int dinlenme=0;
       PreparedStatement preparedStatement=null;
       
         try {
             preparedStatement=con.prepareStatement(sorgu2);
             preparedStatement.setInt(1,sarkiid);
             ResultSet result=preparedStatement.executeQuery();
             while(result.next()){
                 dinlenme=result.getInt("dinlenmesayisi");
             }
             dinlenme+=1;
             System.out.println("dinlenme:"+dinlenme);
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1,dinlenme);
             preparedStatement.setInt(2,sarkiid);
             preparedStatement.executeUpdate();
             return dinlenme;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return dinlenme;
   }
   public ResultSet pop_10_list(String tur){
       String sorgu="Select * From şarkı Where tur=? ORDER BY dinlenmesayisi DESC LIMIT 10";
       ResultSet result=null;
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,tur);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }
   
   public ResultSet pop_listeleme(int id){
       
              // SELECT * FROM şarkı Ş INNER JOIN pop p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON ?=p.useridpop
       String sorgu="SELECT * FROM şarkı Ş INNER JOIN pop p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON p.useridpop=kullanıcııd where kullanıcııd=?";
       ResultSet result = null;
       PreparedStatement preparedStatement=null;
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
          result=preparedStatement.executeQuery();
            /*
            while(result.next()){
                
                String name=result.getString("sarkiadi");
                String surname=result.getString("sanatci");
                
                System.out.println("name:"+name);
                System.out.println("surname:"+surname);
            }
          */
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
       
   }
   public boolean kullanıcı_ekle(String kullanıcı_adı,String email,String sifre,String abonelik_turu){
       String sorgu1="Select * from kullanıcılar where kullanıcıadı=? AND sifre=?";
       String sorgu2="Insert INTO kullanıcılar (kullanıcıadı,email,sifre,abonelikturu) VALUES(?,?,?,?) ";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu1);
             preparedStatement.setString(1, kullanıcı_adı);
             preparedStatement.setString(2, sifre);
             ResultSet result=preparedStatement.executeQuery();
             while(!result.next()){
                 preparedStatement=null;
                 preparedStatement=con.prepareStatement(sorgu2);
                 preparedStatement.setString(1,kullanıcı_adı);
                 preparedStatement.setString(2,email);
                 preparedStatement.setString(3,sifre);
                 preparedStatement.setString(4,abonelik_turu);
                 preparedStatement.executeUpdate();
                 return true;

             }
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
       
   }
   public boolean album_ekle(String album_adı,String album_turu){
       String sorgu="Insert INTO albumler (albumadı,albumturu) VALUES(?,?)";
       String sorgu2="Select * from albumler where albumadı=? AND albumturu=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu2);
             preparedStatement.setString(1,album_adı);
             preparedStatement.setString(2,album_turu);
             ResultSet result=preparedStatement.executeQuery();
             while(!result.next()){
                 preparedStatement=null;
                 preparedStatement=con.prepareStatement(sorgu);
                 preparedStatement.setString(1,album_adı);
                 preparedStatement.setString(2,album_turu);
                 preparedStatement.executeUpdate();
                 return true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public ResultSet albumleri_goster(){
       String sorgu="Select * from albumler";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return result;
   }
   public ResultSet album_icerigini_goster(int id){
       String sorgu="SELECT * FROM albumler a INNER JOIN album_content c ON a.albumid= c.album_id Where albumid=?";
       ResultSet result=null;
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
       
   }
   public boolean albume_sarki_ekle(int id,String sarkı_ismi,String sanatci,String tur){
       String sorgu="Select * from albumler where  albumid=?";
       String sorgu2="Insert INTO album_content (album_id,şarkı,sanatçı) VALUES(?,?,?)";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
             ResultSet result=preparedStatement.executeQuery();
             while(result.next()){
                 String album_tur=result.getString("albumturu");
                 System.out.println(album_tur);
                 if(album_tur.equals(tur)){
                 preparedStatement=null;
                 preparedStatement=con.prepareStatement(sorgu2);
                 preparedStatement.setInt(1, id);
                 preparedStatement.setString(2, sarkı_ismi);
                 preparedStatement.setString(3, sanatci);
                 preparedStatement.executeUpdate();
                 return true;
             }
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public ResultSet jaz_listeleme(int id){
       
              // SELECT * FROM şarkı Ş INNER JOIN pop p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON ?=p.useridpop
       String sorgu="SELECT * FROM şarkı Ş INNER JOIN jaz p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON p.useridjaz=kullanıcııd where kullanıcııd=?";
       ResultSet result = null;
       PreparedStatement preparedStatement=null;
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
          result=preparedStatement.executeQuery();
            /*
            while(result.next()){
                
                String name=result.getString("sarkiadi");
                String surname=result.getString("sanatci");
                
                System.out.println("name:"+name);
                System.out.println("surname:"+surname);
            }
          */
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
       
   }
   public ResultSet klasik_listeleme(int id){
       
              // SELECT * FROM şarkı Ş INNER JOIN pop p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON ?=p.useridpop
       String sorgu="SELECT * FROM şarkı Ş INNER JOIN klasik p ON Ş.sarkıid= p.sarkiid INNER JOIN kullanıcılar user ON p.useridklasik=kullanıcııd where kullanıcııd=?";
       ResultSet result = null;
       PreparedStatement preparedStatement=null;
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
          result=preparedStatement.executeQuery();
            /*
            while(result.next()){
                
                String name=result.getString("sarkiadi");
                String surname=result.getString("sanatci");
                
                System.out.println("name:"+name);
                System.out.println("surname:"+surname);
            }
          */
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
       
   }
   
   public ResultSet takip_ettiklerim(int user_id){
       String sorgu="Select * from kullanıcılar where kullanıcııd IN (SELECT premium_takip_id FROM kullanıcılar k INNER JOIN premium_takip p ON p.premium_takip_user=k.kullanıcııd where premium_takip_user=?)";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1, user_id);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
   }
   public ResultSet premium_user_al(){
       String sorgu="Select * from kullanıcılar where abonelikturu=?";
       ResultSet result=null;
       PreparedStatement preparedStatement=null;
       
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,"premium");
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return result;
   }
   public void calisanekle(){
        try {
            statement=con.createStatement();
            String sorgu="Insert INTO calisanlar (name,surname,email) VALUES('batuhan','basoğlu','batu32@gmail.com')";
            statement.executeUpdate(sorgu);
           
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   }
   
   public void calisansil(){
        try {
            statement=con.createStatement();
            
            String sorgu="Delete from calisanlar where id>3";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   public boolean sarkici_ekle(String sarki_adi,String tarih,String sanatci,String album,String tur,int sure){
       int dinlenme_sayisi=0;
       String sorgu_kontrol="Select * from şarkı where sarkiadi=? AND sanatci=?";
       String sorgu="Insert INTO şarkı (sarkiadi,tarih,sanatci,album,tur,sure,dinlenmesayisi) VALUES(?,?,?,?,?,?,?)";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu_kontrol);
             preparedStatement.setString(1,sarki_adi);
             preparedStatement.setString(2,sanatci);
             ResultSet result=preparedStatement.executeQuery();
             if(!result.next()){
                 preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1, sarki_adi);
             preparedStatement.setString(2, tarih);
             preparedStatement.setString(3, sanatci);
             preparedStatement.setString(4, album);
             preparedStatement.setString(5, tur);
             preparedStatement.setInt(6, sure);
             preparedStatement.setInt(7,dinlenme_sayisi);
             preparedStatement.executeUpdate();
             return true;
             }
             else{
                 return false;
             }
             
            
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
   }
   public boolean delete(int id){
       	String sorgu="DELETE FROM şarkı WHERE sarkıid=?";
        PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
   }
   public ResultSet sanatcilari_goster(){
       String sorgu="Select * from sanatci";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
              result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
       
   }
   public boolean sanatci_sil(int id){
        String sorgu="Delete from sanatci where sanatcid=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1,id);
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public ResultSet premium_takip_table(){
       String sorgu="Select * from premium_takip";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   } public ResultSet pop_table(){
       String sorgu="Select * from pop";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }
   public ResultSet kullanıcılar_table(){
       String sorgu="Select * from kullanıcılar";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   } public ResultSet klasik_table(){
       String sorgu="Select * from klasik";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }
   public ResultSet jaz_table(){
       String sorgu="Select * from jaz";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }
   public ResultSet album_table(){
       String sorgu="Select * from albumler";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }public ResultSet album_content_table(){
       String sorgu="Select * from album_content";
       PreparedStatement preparedStatement=null;
       ResultSet result=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             result=preparedStatement.executeQuery();
             return result;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
   }
   public boolean sanatci_ekle(String name,String ulke){
        String sorgu_kontrol="Select * from sanatci where sanatciadi=? AND ulke=?";
       String sorgu="Insert INTO sanatci (sanatciadi,ulke) VALUES(?,?)";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu_kontrol);
             preparedStatement.setString(1,name);
             preparedStatement.setString(2,ulke);
             ResultSet result=preparedStatement.executeQuery();
             if(!result.next()){
                 preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, ulke);
             preparedStatement.executeUpdate();
             return true;
             }
             else{
                 return false;
             }
             
            
         } catch (SQLException ex) {
             
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
   }
   public boolean album_sil(int id){
       String sorgu="Delete from albumler where albumid=?";
       PreparedStatement preparedStatement=null;
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1,id);
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
       return false;
   }
   public void preparedcalisanlarigetir(int id){
       String sorgu="Select * From calisanlar where id>?";
       PreparedStatement preparedStatement=null;
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            
            ResultSet rs=preparedStatement.executeQuery();
            
            while (rs.next()) {
                String ad=rs.getString("name");
                String soyad=rs.getString("surname");
                System.out.println("name:"+ad);
                System.out.println("soyad:"+soyad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    public baglanti(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUnicode=true&characterEncoding=utf8";
        
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            con=DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("bağlanti basarili");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
          
    }
}
