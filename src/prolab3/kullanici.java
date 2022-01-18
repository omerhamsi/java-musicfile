/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

/**
 *
 * @author TOSHIBA
 */
public class kullanici {
    private int kullanici_id;
    private String kullanici_adi;
    private String email;
    private String abonelik_turu;

    public kullanici(int kullanici_id, String kullanici_adi, String email, String abonelik_turu) {
        this.kullanici_id = kullanici_id;
        this.kullanici_adi = kullanici_adi;
        this.email = email;
        this.abonelik_turu = abonelik_turu;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbonelik_turu() {
        return abonelik_turu;
    }

    public void setAbonelik_turu(String abonelik_turu) {
        this.abonelik_turu = abonelik_turu;
    }
    
}
