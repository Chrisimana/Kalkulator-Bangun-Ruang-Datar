package model.bangun_ruang;

public abstract class BangunRuang {
    private String nama;
    
    public BangunRuang(String nama) {
        this.nama = nama;
    }
    
    public abstract double hitungVolume();
    public abstract String getRumus();
    
    public String getNama() {
        return nama;
    }
    
    public String getDetailPerhitungan() {
        return String.format("%s: Volume = %.2f", nama, hitungVolume());
    }
}