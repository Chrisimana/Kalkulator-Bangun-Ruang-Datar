package model.bangun_ruang;

public class Kubus extends BangunRuang {
    private final double sisi;

    public Kubus(double sisi) {
        super("Kubus");
        this.sisi = sisi;
    }

    @Override
    public double hitungVolume() {
        return Math.pow(sisi, 3);
    }

    @Override
    public String getRumus() {
        return String.format("s³ = %.2f³", sisi);
    }
    
    public double getSisi() { return sisi; }
}