public class Course {
    boolean courseEnCours = true;
    Voiture[] voitures;
    Piste piste;
    TabBord[] tabBords;
    Classement classement;

    public Course(Voiture[] v, Piste p, TabBord[] tab, Classement cl) {
        voitures = v;
        piste = p;
        tabBords = tab;
        classement = cl;
    }
}
