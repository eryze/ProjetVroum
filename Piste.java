import javax.swing.*;
import java.awt.*;

public class Piste extends JPanel implements VoitureObserver {
    private static final int cols = 20, rows = 10, cell = 20;
    private int[][] grille = new int[rows][cols];
    private Voiture[] voitures;

    public Piste(Voiture[] voitures) {
        setPreferredSize(new Dimension(cols * cell, rows * cell));
        this.voitures = voitures;
        construireGrille();
        for (Voiture v : voitures) v.addObserver(this);
    }
    
    private void construireGrille() {
        for (int y = 0; y < rows; ++y)
            for (int x = 0; x < cols; ++x)
                grille[y][x] = 0;
        // horizontale 5 bas -> A
        for (int x = 1; x <= 17; x++)
            grille[8][x] = 1;
        // verticale A -> 5 haut
        for (int y = 1; y < 8; y++)
            grille[y][18] = 1;
        // horizontale 5 -> 2
        for (int x = 15; x < 18; x++)
            grille[1][x] = 1;
        // verticale 2 -> 2
        for (int y = 1; y < 6; y++)
            grille[y][15] = 1;
        // horizontal 2 -> 2
        for (int x = 12; x < 16; x++)
            grille[5][x] = 1;
        // verticale 2 -> 2
        for (int y = 2; y < 6; y++)
            grille[y][12] = 1;
        // horizontale 2-> 3
        for (int x = 1; x < 13; x++)
            grille[2][x] = 1;
        // verticale 3 -> 5
        for (int y = 2; y < 8; y++)
            grille[y][1] = 1;

        grille[2][1] = 2;
        grille[8][1] = 2;
        grille[1][18] = 2;
        grille[1][15] = 2;
        grille[2][12] = 2;

        grille[5][15] = 3;
        grille[5][12] = 3;

        grille[8][17] = 4;
        grille[8][18] = 5;

    }
    @Override
    public void update() {
    repaint();  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(0x228B22));
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < cols; ++x) {
                int X = x * cell, Y = y * cell;

                if (grille[y][x] == 1)
                    g.setColor(Color.LIGHT_GRAY);
                else if (grille[y][x] >= 2)
                    g.setColor(Color.YELLOW);
                else
                    g.setColor(new Color(0x228B22));
                g.fillRect(X, Y, cell, cell);

                g.setColor(Color.BLACK);
                Font fontGras = new Font("Dialog", Font.BOLD, 15);
                g.setFont(fontGras);

                if (y == 8 && x == 1 || y == 1 && x == 18)
                    g.drawString("5", X + 5, Y + 15);
                if (y == 2 && x == 1)
                    g.drawString("3", X + 5, Y + 15);
                if (y == 5 && x == 12 || y == 1 && x == 15 || y == 2 && x == 12 || y == 5 && x == 15)
                    g.drawString("2", X + 5, Y + 15);

                if (grille[y][x] == 4)
                    g.drawString("D", X + 5, Y + 15);
                if (grille[y][x] == 5)
                    g.drawString("A", X + 5, Y + 15);

                g.setColor(new Color(36, 51, 36));
                g.drawRect(X, Y, cell, cell);
            }
        }

        for (Voiture v : voitures) {
            Point p = v.getCoordGrille();
            g.setColor(v.getCouleur());
            g.fillRect(p.x * cell + 4, p.y * cell + 4, cell - 8, cell - 8);
            g.setColor(Color.BLACK);
            g.drawRect(p.x * cell + 4, p.y * cell + 4, cell - 8, cell - 8);
        }
    }

}
