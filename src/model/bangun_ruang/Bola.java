package model.bangun_ruang;

public class Bola extends BangunRuang {
    private final double jariJari;

    public Bola(double jariJari) {
        super("Bola");
        this.jariJari = jariJari;
    }

    @Override
    public double hitungVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(jariJari, 3);
    }

    @Override
    public String getRumus() {
        return String.format("4/3 × π × r³ = 4/3 × 3.14 × %.2f³", jariJari);
    }
    
    public double getJariJari() { return jariJari; }
}