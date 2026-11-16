package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola koleksi Character: tambah, cari, hapus, dan statistik dasar.
 * Menerapkan Composition: CharacterManager "has-a" ArrayList<Character>.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();   
    }

    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {   
            System.out.println("❌ Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        characterList.add(character);
        System.out.println("✅ Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    public Character findByName(String name) {
        for (Character c : characterList) {         
            if (c.getName().equals(name)) {          
                return c;                             
            }
        }
        return null;                                  
    }

    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target == null) {
            System.out.println("❌ Gagal hapus: karakter '" + name + "' tidak ditemukan.");
            return false;
        }
        characterList.remove(target);                 
        System.out.println("🗑️ Karakter '" + name + "' berhasil dihapus.");
        return true;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);        
    }

    /**
     * Menghitung rata-rata level seluruh karakter di dalam manager.
     * Ditempatkan di Model agar sesuai dengan prinsip MVC.
     */
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }
        int totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        return (double) totalLevel / characterList.size();
    }
}