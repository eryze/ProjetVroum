import javax.swing.JPanel;
import java.awt.Graphics;

public class Classement extends JPanel {
    private Voiture[] voitures;

    public Classement(Voiture[] voitures) {
        this.voitures = voitures;
    }

    public void updateClassement(Voiture[] nouvellesVoitures) {
        this.voitures = nouvellesVoitures;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Voiture[] copie = voitures.clone();
        java.util.Arrays.sort(copie, (a, b) -> b.tours - a.tours);

        g.drawString("Classement:", 10, 15);
        int y = 35;
        for (Voiture v : copie) {
            g.setColor(v.getCouleur());
            g.drawString("V" + v.getId() + " : " + v.getTours() + " tours", 10, y);
            y += 20;
        }
    }
}
