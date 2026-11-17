package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {

    // ===== ATRIBUT (private — tidak bisa diakses langsung dari luar class) =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // ===== CONSTRUCTOR 1: untuk membuat karakter BARU =====
    public Character(String name, CharacterType type, int level) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        if (type == null) {
            throw new IllegalArgumentException("Role wajib dipilih");
        }
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException("Level harus 1-99");
        }
        // Mini-Challenge: Konsistensi antarfield (MAGE maks level 60)
        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException("Level MAGE maksimal adalah 60");
        }
        // Validasi Tambahan 1 (Model): HEALER minimal level 5
        if (type == CharacterType.HEALER && level < 5) {
            throw new IllegalArgumentException("Level HEALER minimal adalah 5");
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = calculateBaseMana();
    }

    // ===== CONSTRUCTOR 2: untuk MEMUAT karakter dari database =====
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower, int mana) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = mana;
    }

    // ===== HELPER PRIVATE =====
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    private int calculateBaseMana() {
        return 50 + (level * 5);
    }

    // ===== GETTER =====
    public int getId() { return id; }
    public String getName() { return name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public int getHitPoints() { return hitPoints; }
    public int getAttackPower() { return attackPower; }
    public int getMana() { return mana; }

    // ===== SETTER =====
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException("Level harus 1-99");
        }
        if (this.type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException("Level MAGE maksimal adalah 60");
        }
        if (this.type == CharacterType.HEALER && level < 5) {
            throw new IllegalArgumentException("Level HEALER minimal adalah 5");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = calculateBaseMana();
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif!");
        }
        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Character)) return false;
        Character other = (Character) obj;
        return this.name.equals(other.name);
    }
}