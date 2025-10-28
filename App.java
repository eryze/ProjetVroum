import javax.swing.JFrame;
import java.awt.Color;

public class App {
    static boolean pause = false;

    public static void main(String[] args) {
        Voiture v1 = new Voiture(1, Color.RED, 60, 0);
        Voiture v2 = new Voiture(2, Color.BLUE, 60, 0);
        Voiture v3 = new Voiture(3, Color.ORANGE, 60, 0);
        Voiture[] voitures = { v1, v2, v3 };

        Classement classement = new Classement(voitures);

        JFrame frameC = new JFrame("classement");
        frameC.setSize(200, 200);
        frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameC.add(classement);
        frameC.setVisible(true);


        for (Voiture v : voitures) {
            JFrame framev = new JFrame("Voiture " + v.getId());
            framev.setSize(200, 200);
            framev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framev.add(new TabBord(v));
            framev.setVisible(true);
        }
    }

}
