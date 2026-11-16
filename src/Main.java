import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");

        // Membuat object Character baru
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        Character wizard = new Character("Merlin", CharacterType.MAGE, 3);
        Character scout = new Character("Athena", CharacterType.ARCHER, 4);

        // Menampilkan ketiganya (sudah termasuk informasi mana)
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        System.out.println();
        System.out.println(">> " + hero.getName() + " level up!");
        hero.setLevel(hero.getLevel() + 1);
        System.out.println("After level up: " + hero);

        System.out.println();
        // Menguji method isAlive()
        System.out.println(">> Apakah " + hero.getName() + " masih hidup? " + hero.isAlive());

        // Menguji setter mana dan validasinya
        wizard.setMana(120);
        System.out.println(">> Mana " + wizard.getName() + " diubah menjadi: " + wizard.getMana());
        
        // Contoh pengujian validasi error jika mana negatif (bisa di-uncomment untuk uji coba)
        // wizard.setMana(-10); 
    }
}