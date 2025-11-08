package database;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import model.bangun_datar.BangunDatar;
import model.bangun_ruang.BangunRuang;

public class HistoryManager {
    private static final String FILE_NAME = "history.txt";
    private static final String SEPARATOR = "|||";
    
    public HistoryManager() {
        initHistoryFile();
    }
    
    private void initHistoryFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File history created: " + FILE_NAME);
            }
        } catch (Exception e) {
            System.err.println("Error initializing history file: " + e.getMessage());
        }
    }
    
    public void simpanHistory(Object bangun) {
        try {
            String historyLine = "";
            String timestamp = getCurrentTimestamp();
            
            if (bangun instanceof BangunRuang) {
                BangunRuang br = (BangunRuang) bangun;
                historyLine = String.format("BANGUN_RUANG%s%s%s%.2f%s%s%s%s",
                    SEPARATOR, br.getNama(), SEPARATOR, br.hitungVolume(),
                    SEPARATOR, br.getRumus(), SEPARATOR, timestamp);
                    
            } else if (bangun instanceof BangunDatar) {
                BangunDatar bd = (BangunDatar) bangun;
                historyLine = String.format("BANGUN_DATAR%s%s%s%.2f%s%.2f%s%s%s%s%s%s",
                    SEPARATOR, bd.getNama(), SEPARATOR, bd.hitungLuas(),
                    SEPARATOR, bd.hitungKeliling(), SEPARATOR,
                    bd.getRumusLuas(), SEPARATOR, bd.getRumusKeliling(),
                    SEPARATOR, timestamp);
            }
            
            // Tambahkan di awal file (stack behavior)
            List<String> history = bacaHistoryDariFile();
            history.add(0, historyLine);
            
            // Simpan hanya 50 record terakhir
            if (history.size() > 50) {
                history = history.subList(0, 50);
            }
            
            tulisHistoryKeFile(history);
            System.out.println("History saved: " + historyLine);
            
        } catch (Exception e) {
            System.err.println("Error saving history: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<String[]> getHistory() {
        List<String[]> history = new ArrayList<>();
        
        try {
            List<String> historyLines = bacaHistoryDariFile();
            SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            for (int i = 0; i < historyLines.size(); i++) {
                String line = historyLines.get(i);
                String[] parts = line.split("\\|\\|\\|");
                
                if (parts.length >= 3) {
                    String jenis = parts[0];
                    String namaBangun = parts[1];
                    String id = String.valueOf(i + 1);
                    String waktu = "";
                    
                    if (jenis.equals("BANGUN_RUANG") && parts.length >= 5) {
                        String volume = parts[2];
                        String rumus = parts[3];
                        waktu = formatTimestamp(parts[4]);
                        
                        String[] row = {
                            id, "Bangun Ruang", namaBangun, 
                            "Volume: " + volume, 
                            String.format("%s: %s", namaBangun, rumus),
                            waktu
                        };
                        history.add(row);
                        
                    } else if (jenis.equals("BANGUN_DATAR") && parts.length >= 7) {
                        String luas = parts[2];
                        String keliling = parts[3];
                        String rumusLuas = parts[4];
                        String rumusKeliling = parts[5];
                        waktu = formatTimestamp(parts[6]);
                        
                        String[] row = {
                            id, "Bangun Datar", namaBangun,
                            String.format("Luas: %s | Keliling: %s", luas, keliling),
                            String.format("%s: %s, %s", namaBangun, rumusLuas, rumusKeliling),
                            waktu
                        };
                        history.add(row);
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error reading history: " + e.getMessage());
            e.printStackTrace();
        }
        
        return history;
    }
    
    public void hapusHistory() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                file.delete();
                System.out.println("History file deleted");
            }
            initHistoryFile();
        } catch (Exception e) {
            System.err.println("Error clearing history: " + e.getMessage());
        }
    }
    
    private List<String> bacaHistoryDariFile() {
        List<String> history = new ArrayList<>();
        
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return history;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    history.add(line);
                }
            }
            reader.close();
            
        } catch (Exception e) {
            System.err.println("Error reading history file: " + e.getMessage());
        }
        
        return history;
    }
    
    private void tulisHistoryKeFile(List<String> history) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (String line : history) {
                writer.write(line + "\n");
            }
            writer.close();
            
        } catch (Exception e) {
            System.err.println("Error writing history file: " + e.getMessage());
        }
    }
    
    private String getCurrentTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }
    
    private String formatTimestamp(String timestamp) {
        try {
            long time = Long.parseLong(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.format(new Date(time));
        } catch (Exception e) {
            return "Unknown time";
        }
    }
    
    // Method untuk debugging
    public void printDebugInfo() {
        System.out.println("=== HISTORY MANAGER DEBUG INFO ===");
        System.out.println("History file: " + FILE_NAME);
        System.out.println("File exists: " + new File(FILE_NAME).exists());
        
        List<String> rawHistory = bacaHistoryDariFile();
        System.out.println("Total records: " + rawHistory.size());
        
        for (int i = 0; i < Math.min(rawHistory.size(), 3); i++) {
            System.out.println("Record " + i + ": " + rawHistory.get(i));
        }
        System.out.println("==================================");
    }
}