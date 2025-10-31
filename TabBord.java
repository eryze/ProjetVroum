import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class TabBord extends JPanel implements VoitureObserver {
    private Voiture voiture;

    public TabBord(Voiture voiture) {
        this.voiture = voiture;
        voiture.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(voiture.getCouleur());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawString("Carburant : " + voiture.getCarburant(), 40, 25);
        g.drawString("Tours : " + voiture.getTours(), 40, 45);
    }
}
