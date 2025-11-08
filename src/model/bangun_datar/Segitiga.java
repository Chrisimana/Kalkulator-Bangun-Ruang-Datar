package model.bangun_datar;

public class Segitiga extends BangunDatar {
    private final double alas;
    private final double tinggi;
    private final double sisi1;
    private final double sisi2;

    public Segitiga(double alas, double tinggi, double sisi1, double sisi2) {
        super("Segitiga");
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return alas + sisi1 + sisi2;
    }

    @Override
    public String getRumusLuas() {
        return String.format("½ × a × t = ½ × %.2f × %.2f", alas, tinggi);
    }

    @Override
    public String getRumusKeliling() {
        return String.format("a + b + c = %.2f + %.2f + %.2f", alas, sisi1, sisi2);
    }
}