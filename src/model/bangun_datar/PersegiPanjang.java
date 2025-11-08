package model.bangun_datar;

public class PersegiPanjang extends BangunDatar {
    private final double panjang;
    private final double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        super("Persegi Panjang");
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }

    @Override
    public String getRumusLuas() {
        return String.format("p × l = %.2f × %.2f", panjang, lebar);
    }

    @Override
    public String getRumusKeliling() {
        return String.format("2 × (p + l) = 2 × (%.2f + %.2f)", panjang, lebar);
    }
    
    public double getPanjang() { return panjang; }
    public double getLebar() { return lebar; }
}