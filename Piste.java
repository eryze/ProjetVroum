public class Piste {
    private Voiture[] voitures;
    private int[][] piste;

    public Piste(int longueur, int largeur, Voiture[] voitures){
        this.voitures = voitures;
        this.piste = new int[largeur][longueur];
    }
    public int[][] getPiste() {
        return piste;
    }
    public Voiture[] getVoitures() {
        return voitures;
    }
    public void setPiste(int[][] piste) {
        this.piste = piste;
    }
    public void setVoitures(Voiture[] voitures) {
        this.voitures = voitures;
    }
    
}
