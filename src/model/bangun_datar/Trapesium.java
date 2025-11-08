package model.bangun_datar;

public class Trapesium extends BangunDatar {
    private final double alasAtas;
    private final double alasBawah;
    private final double tinggi;
    private final double sisiMiring1;
    private final double sisiMiring2;

    public Trapesium(double alasAtas, double alasBawah, double tinggi, double sisiMiring1, double sisiMiring2) {
        super("Trapesium");
        this.alasAtas = alasAtas;
        this.alasBawah = alasBawah;
        this.tinggi = tinggi;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * (alasAtas + alasBawah) * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return alasAtas + alasBawah + sisiMiring1 + sisiMiring2;
    }

    @Override
    public String getRumusLuas() {
        return String.format("½ × (a + b) × t = ½ × (%.2f + %.2f) × %.2f", 
            alasAtas, alasBawah, tinggi);
    }

    @Override
    public String getRumusKeliling() {
        return String.format("a + b + c + d = %.2f + %.2f + %.2f + %.2f", 
            alasAtas, alasBawah, sisiMiring1, sisiMiring2);
    }
    
    public double getAlasAtas() { return alasAtas; }
    public double getAlasBawah() { return alasBawah; }
    public double getTinggi() { return tinggi; }
}