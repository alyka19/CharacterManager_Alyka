package com.unpri.charactermanager.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;                      // container utama
    private ArrayList<Character> characterList;    // data dari Main.java (Model)
    private double avgLevel;                       // rata-rata level

    // Konstruktor diperbarui menerima 2 parameter sesuai pemanggilan di Main.java
    public MainWindow(ArrayList<Character> characterList, double avgLevel) {
        super("Character Manager v0.4");           // versi naik: sprint #4
        this.characterList = characterList;
        this.avgLevel = avgLevel;

        initComponents();                          // 1. susun semua komponen dulu

        pack();                                    // 2. ukuran jendela mengikuti isi
        setMinimumSize(new Dimension(450, 300));   // 3. cegah jendela terlalu kecil
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);               // 4. pusatkan SETELAH pack()
    }

    private void initComponents() {
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        mainPanel.setBackground(AppTheme.BG_MAIN);                           
        mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); 

        mainPanel.add(createTitleLabel());          // judul di atas

        for (Character c : characterList) {          
            mainPanel.add(createCharacterLabel(c));
        }

        add(mainPanel);                             
    }

    /** Membuat judul layar dengan informasi jumlah karakter dan rata-rata level. */
    private JLabel createTitleLabel() {
        String titleText = String.format("Daftar Karakter (%d) | Rata-rata Lv: %.1f", 
                                         characterList.size(), avgLevel);
        JLabel lbl = new JLabel(titleText, SwingConstants.CENTER);   
        lbl.setFont(AppTheme.FONT_TITLE);                 
        lbl.setForeground(AppTheme.TEXT_MAIN);            
        return lbl;
    }

    /** Membuat satu kartu karakter (JLabel berwarna sesuai role). */
    private JLabel createCharacterLabel(Character c) {
        String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();     

        JLabel lbl = new JLabel(info);
        lbl.setFont(AppTheme.FONT_BODY);                          
        lbl.setForeground(AppTheme.TEXT_LIGHT);                   
        lbl.setBackground(AppTheme.colorFor(c.getType()));        
        lbl.setOpaque(true);                                      
        lbl.setBorder(AppTheme.CARD_BORDER);                      
        lbl.setToolTipText(AppTheme.describe(c.getType()));       
        lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        return lbl;
    }
}