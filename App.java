import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class App {
    static boolean pause = false;

    public static void main(String[] args) {
        Voiture v1 = new Voiture(1, Color.RED, 60, 0);
        Voiture v2 = new Voiture(2, Color.BLUE, 60, 0);
        Voiture v3 = new Voiture(3, Color.ORANGE, 60, 0);
        Voiture[] voitures = { v1, v2, v3 };

        TabBord tab1 = new TabBord(v1);
        TabBord tab2 = new TabBord(v2);
        TabBord tab3 = new TabBord(v3);
        TabBord[] tabs = { tab1, tab2, tab3 };

        Classement classement = new Classement(voitures);

        JFrame frame = new JFrame("Course de Voitures");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.GridLayout(0, 1));
        for (TabBord t : tabs) {
            frame.add(t);
        }
        frame.add(classement);
        frame.setVisible(true);
    }

}
