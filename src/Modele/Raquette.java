package Modele;

import java.awt.*;

public class Raquette {
    public static final int epaisseur = 20;
    public int score;
    public Point position;
    public Point vitesse;
    public int taille;

    public Raquette(int x,int y,int taille){
        this.score = 0;
        this.position = new Point(x,y);
        this.taille = taille;
        this.vitesse = new Point(0,0);
    }

}
