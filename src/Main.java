import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // 1. Siapkan DATA terlebih dahulu (layer Model) - Total minimal 5 Karakter sesuai ketentuan TP8
        CharacterManager manager = new CharacterManager();
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));
        manager.addCharacter(new Character("Raphael", CharacterType.HEALER, 6));
        manager.addCharacter(new Character("Lancelot", CharacterType.WARRIOR, 7));

        // 2. Ambil kalkulasi statistik dari Model (Menerapkan prinsip MVC)
        double avgLevel = manager.getAverageLevel();

        // 3. Jalankan GUI dengan AMAN di Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager.getAllCharacters(), avgLevel);
            window.setVisible(true);    
        });
    }
}