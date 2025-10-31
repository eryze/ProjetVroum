import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class App {
    static boolean pause = false;

    public static void main(String[] args) {
        int carb = 60;
        Voiture v1 = new Voiture(1, Color.RED, carb, 0);
        Voiture v2 = new Voiture(2, Color.BLUE, carb, 0);
        Voiture v3 = new Voiture(3, Color.ORANGE, carb, 0);
        Voiture[] voitures = { v1, v2, v3 };

        Classement classement = new Classement(voitures);
        JFrame frameC = new JFrame("Classement");
        frameC.setSize(200, 200);
        frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameC.setLocation(0, 100);
        frameC.add(classement);
        frameC.setVisible(true);

        for (int i = 0; i < 450; i++) {
            for (Voiture v : voitures) {
                JFrame frameV = new JFrame("Voiture " + v.getId());
                frameV.setSize(200, 200);
                frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameV.setLocation(100 + i, 100);
                frameV.add(new TabBord(v));
                JButton pauseBtn = new JButton("Pause");
                pauseBtn.addActionListener(e -> {
                    pause = !pause;
                    pauseBtn.setText(pause ? "Reprendre" : "Pause");
                });
                frameV.add(pauseBtn, BorderLayout.SOUTH);
                frameV.setVisible(true);
                i += 150;
            }

        }
        JFrame frameP = new JFrame("Piste");
        frameP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameP.add(new Piste(voitures));
        frameP.setSize(425, 275);
        frameP.setLocation(400, 400);
        frameP.setVisible(true);

        List<Point> parcours = Arrays.asList(
                new Point(18, 8), // point de depart
                new Point(18, 7), new Point(18, 6), new Point(18, 5),
                new Point(18, 4), new Point(18, 3), new Point(18, 2), new Point(18, 1),
                new Point(17, 1), new Point(16, 1),
                new Point(15, 1), new Point(15, 2), new Point(15, 3), new Point(15, 4), new Point(15, 5),
                new Point(14, 5), new Point(13, 5), new Point(12, 5),
                new Point(12, 4), new Point(12, 3), new Point(12, 2),
                new Point(11, 2), new Point(10, 2), new Point(9, 2), new Point(8, 2), new Point(7, 2),
                new Point(6, 2), new Point(5, 2), new Point(4, 2), new Point(3, 2), new Point(2, 2),
                new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(1, 6), new Point(1, 7), new Point(1, 8),
                new Point(3, 8), new Point(4, 8), new Point(5, 8), new Point(6, 8), new Point(7, 8), new Point(8, 8),
                new Point(9, 8), new Point(10, 8), new Point(11, 8), new Point(12, 8), new Point(13, 8),
                new Point(14, 8), new Point(15, 8),
                new Point(16, 8),
                new Point(17, 8)

        );
        Voiture.setParcours(parcours);

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (!pause) {
                        for (Voiture v : voitures)
                            v.toMove();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

    }

}
