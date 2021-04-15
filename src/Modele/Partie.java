package Modele;

import java.lang.reflect.Array;
import java.util.*;

public class Partie {
    public Date debutPartie;
    public Raquette[] raquettes;
    public ArrayList<Balle> balles;


    public Partie(Raquette r0, Raquette r1, Balle ... balles){
        this.debutPartie = new Date();
        raquettes = new Raquette[2];
        raquettes[0] = r0;
        raquettes[1] = r1;
        this.balles = new ArrayList<>();
        Collections.addAll(this.balles,balles);
    }

}
