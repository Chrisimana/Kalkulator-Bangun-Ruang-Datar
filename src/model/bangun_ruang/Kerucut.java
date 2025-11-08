package model.bangun_ruang;

public class Kerucut extends BangunRuang {
    private final double jariJari;
    private final double tinggi;

    public Kerucut(double jariJari, double tinggi) {
        super("Kerucut");
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return (1.0/3.0) * Math.PI * Math.pow(jariJari, 2) * tinggi;
    }

    @Override
    public String getRumus() {
        return String.format("1/3 × π × r² × t = 1/3 × 3.14 × %.2f² × %.2f", jariJari, tinggi);
    }
    
    public double getJariJari() { return jariJari; }
    public double getTinggi() { return tinggi; }
}