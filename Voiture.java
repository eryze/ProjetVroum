import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Voiture {
    int id;
    Color couleur;
    int carburant;
    int tours = 0;
    int position = 0;
    private static List<Point> parcours;
    private List<VoitureObserver> observers = new ArrayList<>();

    public Voiture(int id, Color couleur, int carburant, int tours) {
        this.id = id;
        this.couleur = couleur;
        this.carburant = carburant;
        this.tours = tours;
    }

    public int getPosition() {
        return position;
    }

    public static void setParcours(List<Point> parcours) {
        Voiture.parcours = parcours;
    }

    public static List<Point> getParcours() {
        return parcours;
    }

    public Point getCoordGrille() {
        return parcours.get(position);
    }

    void addObserver(VoitureObserver observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        for (VoitureObserver observer : observers) {
            observer.update();
        }
    }

    public int getCarburant() {
        return carburant;
    }

    public Color getCouleur() {
        return couleur;
    }

    public int getId() {
        return id;
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
            int temps = position;
            position = (position + avancer) % parcours.size();
            if (temps + avancer >= parcours.size()) {
                tours++;
            }
            consommerCarburant();
            notifyObservers();
        }
        if (carburant == 1 || carburant == 0)
            System.out.println("La voiture " + id + " n'a plus de carburant et ne peut plus avancer !");
        if (tours == 3) {
            System.out.println("La voiture " + id + " a gagné la course !");
        }

    }

}