package gui;

import database.HistoryManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HistoryPanel extends JPanel {
    private MainFrame mainFrame;
    private HistoryManager historyManager;
    private JTable historyTable;
    private DefaultTableModel tableModel;
    private JButton hapusButton, kembaliButton;
    
    public HistoryPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.historyManager = new HistoryManager();
        initComponents();
        setupLayout();
        refreshHistory();
    }
    
    private void initComponents() {
        String[] columnNames = {"ID", "Jenis", "Bangun", "Hasil", "Detail", "Waktu"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        historyTable = new JTable(tableModel);
        historyTable.setFillsViewportHeight(true);
        historyTable.setAutoCreateRowSorter(true);
        
        hapusButton = new JButton("Hapus Semua History");
        hapusButton.addActionListener(this::hapusHistory);
        
        kembaliButton = new JButton("Kembali ke Kalkulator");
        kembaliButton.addActionListener(e -> mainFrame.showCalculator());
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("History Perhitungan - Super Geometry Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(historyTable);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(hapusButton);
        buttonPanel.add(kembaliButton);
        
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void refreshHistory() {
        tableModel.setRowCount(0);
        var history = historyManager.getHistory();
        
        for (String[] row : history) {
            tableModel.addRow(row);
        }
    }
    
    private void hapusHistory(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin menghapus semua history?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            historyManager.hapusHistory();
            refreshHistory();
            JOption.showMessageDialog(this, "Semua history telah dihapus.");
        }
    }
}