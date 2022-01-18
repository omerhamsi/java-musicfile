
package prolab3;

public class sarkılar {
    
    private int sarki_id;
    private String sarki_adi;
    private String sanatci;
    private String album;
    private String tur;
    private int sure;
    private int dinlenme_sayisi;

    public sarkılar(int sarki_id, String sarki_adi, String sanatci, String album, String tur, int sure, int dinlenme_sayisi) {
        this.sarki_id = sarki_id;
        this.sarki_adi = sarki_adi;
        this.sanatci = sanatci;
        this.album = album;
        this.tur = tur;
        this.sure = sure;
        this.dinlenme_sayisi = dinlenme_sayisi;
    }

    public int getSarki_id() {
        return sarki_id;
    }

    public String getSarki_adi() {
        return sarki_adi;
    }

    public String getSanatci() {
        return sanatci;
    }

    public String getAlbum() {
        return album;
    }

    public String getTur() {
        return tur;
    }

    public int getSure() {
        return sure;
    }

    public double getDinlenme_sayisi() {
        return dinlenme_sayisi;
    }
    
    
    
}
