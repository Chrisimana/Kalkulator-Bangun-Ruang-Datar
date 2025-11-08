package gui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CalculatorPanel calculatorPanel;
    private HistoryPanel historyPanel;
    
    public MainFrame() {
        initComponents();
        setupFrame();
    }
    
    private void initComponents() {
        setTitle("Kalkulator Bangun Ruang & Datar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 700));
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        calculatorPanel = new CalculatorPanel(this);
        historyPanel = new HistoryPanel(this);
        
        mainPanel.add(calculatorPanel, "CALCULATOR");
        mainPanel.add(historyPanel, "HISTORY");
        
        add(mainPanel);
        createMenuBar();
    }
    
    private void setupFrame() {
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuNavigasi = new JMenu("Navigasi");
        JMenuItem itemCalculator = new JMenuItem("Kalkulator");
        JMenuItem itemHistory = new JMenuItem("History");
        
        itemCalculator.addActionListener(e -> showCalculator());
        itemHistory.addActionListener(e -> showHistory());
        
        menuNavigasi.add(itemCalculator);
        menuNavigasi.add(itemHistory);
        menuBar.add(menuNavigasi);
        
        setJMenuBar(menuBar);
    }
    
    public void showCalculator() {
        cardLayout.show(mainPanel, "CALCULATOR");
    }
    
    public void showHistory() {
        historyPanel.refreshHistory();
        cardLayout.show(mainPanel, "HISTORY");
    }
}