package model.bangun_datar;

public abstract class BangunDatar {
    private String nama;
    
    public BangunDatar(String nama) {
        this.nama = nama;
    }
    
    public abstract double hitungLuas();
    public abstract double hitungKeliling();
    public abstract String getRumusLuas();
    public abstract String getRumusKeliling();
    
    public String getNama() {
        return nama;
    }
    
    public String getDetailPerhitungan() {
        return String.format("%s: Luas = %.2f, Keliling = %.2f", 
            nama, hitungLuas(), hitungKeliling());
    }
}