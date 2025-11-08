package model.bangun_datar;

public class Lingkaran extends BangunDatar {
    private final double jariJari;

    public Lingkaran(double jariJari) {
        super("Lingkaran");
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * Math.pow(jariJari, 2);
    }

    @Override
    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }

    @Override
    public String getRumusLuas() {
        return String.format("π × r² = 3.14 × %.2f²", jariJari);
    }

    @Override
    public String getRumusKeliling() {
        return String.format("2 × π × r = 2 × 3.14 × %.2f", jariJari);
    }
    
    public double getJariJari() { return jariJari; }
}