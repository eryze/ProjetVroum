import javax.swing.JPanel;
import java.awt.Graphics;

public class Classement extends JPanel implements VoitureObserver {
    private Voiture[] voitures;

    public Classement(Voiture[] voitures) {
        this.voitures = voitures;
        for (Voiture v : voitures)
            v.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean[] place = new boolean[voitures.length];
        int y = 50;
        g.drawString("Classement :", 10, 25);
        for (int x = 1; x <= voitures.length; x++) {
            int best = -1;
            for (int i = 0; i < voitures.length; i++) {
                boolean change = place[i];
                if (!change) {
                    if (best == -1) {
                        best = i;
                    } else {
                        Voiture v1 = voitures[i], v2 = voitures[best];
                        if (v1.getTours() > v2.getTours())
                            best = i;
                        else if (v1.getTours() == v2.getTours() && v1.getPosition() > v2.getPosition())
                            best = i;
                    }
                }
            }
            place[best] = true;
            Voiture v = voitures[best];
            g.setColor(v.getCouleur());
            g.drawString(x + ". V" + v.getId() + " : " + v.getTours() + " tours, pos " + v.getPosition(), 10, y);
            y += 20;
        }
    }

}
