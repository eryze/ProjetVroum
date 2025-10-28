import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class TabBord extends JPanel {
    private Voiture voiture;

    public TabBord(Voiture voiture) {
        this.voiture = voiture;
        
    }

    public void setVoiture(Voiture voiture){ 
        this.voiture = voiture; 
    }
    public Voiture getVoiture(){ 
        return voiture; 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(voiture.getCouleur());
        g.fillRect(10, 10, 20, 20);
        g.setColor(Color.BLACK);
        g.drawString("Carburant : " + voiture.getCarburant(), 40, 25);
        g.drawString("Tours : " + voiture.getTours(), 40, 45);
    }
}
