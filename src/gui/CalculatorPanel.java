package gui;

import model.bangun_ruang.*;
import model.bangun_datar.*;
import database.HistoryManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorPanel extends JPanel {
    private MainFrame mainFrame;
    private HistoryManager historyManager;
    
    private JComboBox<String> kategoriComboBox;
    private JComboBox<String> bangunComboBox;
    private JPanel inputPanel;
    private JButton hitungButton;
    private JTextArea hasilArea;
    
    private JTextField fieldPanjang, fieldLebar, fieldTinggi;
    private JTextField fieldJariJari, fieldSisi;
    private JTextField fieldAlasAtas, fieldAlasBawah;
    private JTextField fieldSisi1, fieldSisi2;
    
    public CalculatorPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.historyManager = new HistoryManager();
        initComponents();
        setupLayout();
    }
    
    private void initComponents() {
        String[] kategoriList = {"Pilih Kategori", "Bangun Ruang", "Bangun Datar"};
        kategoriComboBox = new JComboBox<>(kategoriList);
        kategoriComboBox.addActionListener(this::onKategoriSelected);
        
        bangunComboBox = new JComboBox<>(new String[]{"Pilih Bangun"});
        bangunComboBox.addActionListener(this::onBangunSelected);
        
        inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        fieldPanjang = new JTextField();
        fieldLebar = new JTextField();
        fieldTinggi = new JTextField();
        fieldJariJari = new JTextField();
        fieldSisi = new JTextField();
        fieldAlasAtas = new JTextField();
        fieldAlasBawah = new JTextField();
        fieldSisi1 = new JTextField();
        fieldSisi2 = new JTextField();
        
        hitungButton = new JButton("Hitung");
        hitungButton.addActionListener(this::hitung);
        hitungButton.setEnabled(false);
        
        hasilArea = new JTextArea(10, 35);
        hasilArea.setEditable(false);
        hasilArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.add(new JLabel("Pilih Kategori:"));
        topPanel.add(kategoriComboBox);
        topPanel.add(new JLabel("Pilih Bangun:"));
        topPanel.add(bangunComboBox);
        
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(new JLabel("Input Dimensi:"), BorderLayout.NORTH);
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.add(hitungButton, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(hasilArea), BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void onKategoriSelected(ActionEvent e) {
        String kategori = (String) kategoriComboBox.getSelectedItem();
        bangunComboBox.removeAllItems();
        
        if ("Bangun Ruang".equals(kategori)) {
            bangunComboBox.addItem("Pilih Bangun Ruang");
            bangunComboBox.addItem("Balok");
            bangunComboBox.addItem("Kubus");
            bangunComboBox.addItem("Bola");
            bangunComboBox.addItem("Tabung");
            bangunComboBox.addItem("Kerucut");
        } else if ("Bangun Datar".equals(kategori)) {
            bangunComboBox.addItem("Pilih Bangun Datar");
            bangunComboBox.addItem("Persegi Panjang");
            bangunComboBox.addItem("Trapesium");
            bangunComboBox.addItem("Segitiga");
            bangunComboBox.addItem("Lingkaran");
        } else {
            bangunComboBox.addItem("Pilih Bangun");
        }
        
        inputPanel.removeAll();
        inputPanel.revalidate();
        inputPanel.repaint();
        hitungButton.setEnabled(false);
    }
    
    private void onBangunSelected(ActionEvent e) {
        inputPanel.removeAll();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String selected = (String) bangunComboBox.getSelectedItem();
        
        boolean enabled = !selected.startsWith("Pilih");
        hitungButton.setEnabled(enabled);
        
        if ("Bangun Ruang".equals(kategori)) {
            switch (selected) {
                case "Balok":
                    addInputField("Panjang:", fieldPanjang);
                    addInputField("Lebar:", fieldLebar);
                    addInputField("Tinggi:", fieldTinggi);
                    break;
                case "Kubus":
                    addInputField("Sisi:", fieldSisi);
                    break;
                case "Bola":
                    addInputField("Jari-jari:", fieldJariJari);
                    break;
                case "Tabung":
                    addInputField("Jari-jari:", fieldJariJari);
                    addInputField("Tinggi:", fieldTinggi);
                    break;
                case "Kerucut":
                    addInputField("Jari-jari:", fieldJariJari);
                    addInputField("Tinggi:", fieldTinggi);
                    break;
            }
        } else if ("Bangun Datar".equals(kategori)) {
            switch (selected) {
                case "Persegi Panjang":
                    addInputField("Panjang:", fieldPanjang);
                    addInputField("Lebar:", fieldLebar);
                    break;
                case "Trapesium":
                    addInputField("Alas Atas:", fieldAlasAtas);
                    addInputField("Alas Bawah:", fieldAlasBawah);
                    addInputField("Tinggi:", fieldTinggi);
                    addInputField("Sisi Miring 1:", fieldSisi1);
                    addInputField("Sisi Miring 2:", fieldSisi2);
                    break;
                case "Segitiga":
                    addInputField("Alas:", fieldAlasAtas);
                    addInputField("Tinggi:", fieldTinggi);
                    addInputField("Sisi 1:", fieldSisi1);
                    addInputField("Sisi 2:", fieldSisi2);
                    break;
                case "Lingkaran":
                    addInputField("Jari-jari:", fieldJariJari);
                    break;
            }
        }
        
        inputPanel.revalidate();
        inputPanel.repaint();
    }
    
    private void addInputField(String label, JTextField field) {
        inputPanel.add(new JLabel(label));
        inputPanel.add(field);
    }
    
    private void hitung(ActionEvent e) {
        try {
            String kategori = (String) kategoriComboBox.getSelectedItem();
            String selected = (String) bangunComboBox.getSelectedItem();
            Object bangun = null;
            String hasil = "";
            
            if ("Bangun Ruang".equals(kategori)) {
                bangun = createBangunRuang(selected);
                if (bangun != null) {
                    BangunRuang br = (BangunRuang) bangun;
                    double volume = br.hitungVolume();
                    hasil = String.format(
                        "=== HASIL PERHITUNGAN BANGUN RUANG ===\n" +
                        "Bangun Ruang: %s\n" +
                        "Rumus Volume: %s\n" +
                        "Volume: %.2f\n",
                        br.getNama(), br.getRumus(), volume
                    );
                    
                    if (bangun instanceof Tabung) {
                        Tabung tabung = (Tabung) bangun;
                        hasil += String.format(
                            "Rumus Luas Permukaan: %s\n" +
                            "Luas Permukaan: %.2f\n",
                            tabung.getRumusLuasPermukaan(), tabung.hitungLuasPermukaan()
                        );
                    }
                    hasil += "===================================";
                }
            } else if ("Bangun Datar".equals(kategori)) {
                bangun = createBangunDatar(selected);
                if (bangun != null) {
                    BangunDatar bd = (BangunDatar) bangun;
                    double luas = bd.hitungLuas();
                    double keliling = bd.hitungKeliling();
                    hasil = String.format(
                        "=== HASIL PERHITUNGAN BANGUN DATAR ===\n" +
                        "Bangun Datar: %s\n" +
                        "Rumus Luas: %s\n" +
                        "Luas: %.2f\n" +
                        "Rumus Keliling: %s\n" +
                        "Keliling: %.2f\n" +
                        "===================================",
                        bd.getNama(), bd.getRumusLuas(), luas, 
                        bd.getRumusKeliling(), keliling
                    );
                }
            }
            
            if (bangun != null) {
                hasilArea.setText(hasil);
                historyManager.simpanHistory(bangun);
                clearFields();
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Masukkan angka yang valid!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Terjadi kesalahan: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private BangunRuang createBangunRuang(String selected) {
        switch (selected) {
            case "Balok":
                return new Balok(
                    Double.parseDouble(fieldPanjang.getText()),
                    Double.parseDouble(fieldLebar.getText()),
                    Double.parseDouble(fieldTinggi.getText())
                );
            case "Kubus":
                return new Kubus(Double.parseDouble(fieldSisi.getText()));
            case "Bola":
                return new Bola(Double.parseDouble(fieldJariJari.getText()));
            case "Tabung":
                return new Tabung(
                    Double.parseDouble(fieldJariJari.getText()),
                    Double.parseDouble(fieldTinggi.getText())
                );
            case "Kerucut":
                return new Kerucut(
                    Double.parseDouble(fieldJariJari.getText()),
                    Double.parseDouble(fieldTinggi.getText())
                );
            default:
                return null;
        }
    }
    
    private BangunDatar createBangunDatar(String selected) {
        switch (selected) {
            case "Persegi Panjang":
                return new PersegiPanjang(
                    Double.parseDouble(fieldPanjang.getText()),
                    Double.parseDouble(fieldLebar.getText())
                );
            case "Trapesium":
                return new Trapesium(
                    Double.parseDouble(fieldAlasAtas.getText()),
                    Double.parseDouble(fieldAlasBawah.getText()),
                    Double.parseDouble(fieldTinggi.getText()),
                    Double.parseDouble(fieldSisi1.getText()),
                    Double.parseDouble(fieldSisi2.getText())
                );
            case "Segitiga":
                return new Segitiga(
                    Double.parseDouble(fieldAlasAtas.getText()),
                    Double.parseDouble(fieldTinggi.getText()),
                    Double.parseDouble(fieldSisi1.getText()),
                    Double.parseDouble(fieldSisi2.getText())
                );
            case "Lingkaran":
                return new Lingkaran(Double.parseDouble(fieldJariJari.getText()));
            default:
                return null;
        }
    }
    
    private void clearFields() {
        fieldPanjang.setText("");
        fieldLebar.setText("");
        fieldTinggi.setText("");
        fieldJariJari.setText("");
        fieldSisi.setText("");
        fieldAlasAtas.setText("");
        fieldAlasBawah.setText("");
        fieldSisi1.setText("");
        fieldSisi2.setText("");
    }
}