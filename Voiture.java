import java.awt.Color;

public class Voiture {
    int id;
    Color couleur;
    int carburant = 60;
    int tours = 0;
    int position;

    public Voiture(int id, Color couleur, int carburant, int tours) {
        this.id = id;
        this.couleur = couleur;
        this.carburant = carburant;
        this.tours = tours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getCarburant() {
        return carburant;
    }
    public int getTours() {
        return tours;
    }

    public void consommerCarburant() {
        if (carburant > 0) {
            carburant -= 2;
        }
    }

    public void toMove() {
        int avancer = (int) (Math.random() * 6) + 1;
        if (carburant > 1) {
            position += avancer;
            System.out.println("La voiture " + id + " avance !");
            consommerCarburant();
        } 
        if (position >= 100) {
            tours += 1;
            position = 0;
            System.out.println("La voiture " + id + " a fait un tour !");

        }
        if (carburant == 1 || carburant == 0) {
            System.out.println("La voiture " + id + " n'a plus de carburant et ne peut plus avancer !");

        }
        if (tours==3) {
            System.out.println("La voiture " + id + " a gagné la course !");
            carburant = 0;
        }

    }

}