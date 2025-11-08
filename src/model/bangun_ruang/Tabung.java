package model.bangun_ruang;

public class Tabung extends BangunRuang {
    private final double jariJari;
    private final double tinggi;

    public Tabung(double jariJari, double tinggi) {
        super("Tabung");
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return Math.PI * Math.pow(jariJari, 2) * tinggi;
    }
    
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    @Override
    public String getRumus() {
        return String.format("π × r² × t = 3.14 × %.2f² × %.2f", jariJari, tinggi);
    }
    
    public String getRumusLuasPermukaan() {
        return String.format("2 × π × r × (r + t) = 2 × 3.14 × %.2f × (%.2f + %.2f)", 
            jariJari, jariJari, tinggi);
    }
    
    @Override
    public String getDetailPerhitungan() {
        return String.format("%s: Volume = %.2f, Luas Permukaan = %.2f", 
            getNama(), hitungVolume(), hitungLuasPermukaan());
    }
    
    public double getJariJari() { return jariJari; }
    public double getTinggi() { return tinggi; }
}