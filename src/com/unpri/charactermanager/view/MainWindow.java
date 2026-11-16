package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

/**
 * Jendela utama aplikasi Character Manager.
 * Menampilkan daftar karakter dan statistik ringkas yang diterima dari luar.
 */
public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;   
    private double averageLevel;                  // Menyimpan statistik dari Controller/Model

    public MainWindow(ArrayList<Character> characterList, double averageLevel) {
        super("Character Manager v0.3");    
        this.characterList = characterList;  
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();                 

        JLabel titleLabel = new JLabel("=== Daftar Karakter (" + characterList.size() + ") ===");
        mainPanel.add(titleLabel);                 

        // Loop setiap Character, buat JLabel baru untuk masing-masing
        for (Character c : characterList) {
            String info = c.getName() + " | " + c.getType() + 
                          " | Lv." + c.getLevel() + 
                          " | HP:" + c.getHitPoints() + 
                          " | ATK:" + c.getAttackPower();
            JLabel characterLabel = new JLabel(info);
            mainPanel.add(characterLabel); 
        }

        // ===== JLabel STATISTIK DI BAGIAN BAWAH =====
        JLabel statsLabel = new JLabel("--------------------------------------------------");
        JLabel averageLabel = new JLabel(String.format("📊 Rata-rata Level: %.1f", averageLevel));
        
        mainPanel.add(statsLabel);
        mainPanel.add(averageLabel);

        add(mainPanel);   
    }
}