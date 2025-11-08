package model.bangun_ruang;

public class Balok extends BangunRuang {
    private final double panjang;
    private final double lebar;
    private final double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super("Balok");
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }

    @Override
    public String getRumus() {
        return String.format("p × l × t = %.2f × %.2f × %.2f", panjang, lebar, tinggi);
    }
    
    public double getPanjang() { return panjang; }
    public double getLebar() { return lebar; }
    public double getTinggi() { return tinggi; }
}