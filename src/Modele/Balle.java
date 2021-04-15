package Modele;

import java.awt.*;

public class Balle {
    public Point position;
    public Point vitesse;
    public int rayon;

    public Balle(int x,int y, int rayon){
        this.position = new Point(x,y);
        this.vitesse = new Point(5,5);
        this.rayon = rayon;
    }


}
