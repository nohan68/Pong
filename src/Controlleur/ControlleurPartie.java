package Controlleur;

import Modele.Balle;
import Modele.Raquette;
import Modele.Partie;
import Vue.Pong;
import Vue.Toile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ControlleurPartie implements ActionListener {
    public Toile toile;
    public Pong pong;

    Timer actualisation;

    Partie partie;
    Raquette[] raquette;
    Balle balle;

    public ControlleurPartie(Pong pong){
        this.pong = pong;

        this.actualisation = new Timer(1000/120,this);
        this.actualisation.start();

        this.raquette = new Raquette[2];
        this.raquette[0] = new Raquette(Math.round(Pong.LARGEUR/4),Math.round(Pong.HAUTEUR/2),200);
        this.raquette[1] = new Raquette(Pong.LARGEUR-Math.round(Pong.LARGEUR/4),Math.round(Pong.HAUTEUR/2),200);

        toile = new Toile(this);
        pong.setFocusable(true);
        pong.setFocusTraversalKeysEnabled(false);

        pong.addKeyListener(new ControlleurClavier(raquette[0],90,83));
        pong.addKeyListener(new ControlleurClavier(raquette[1], 38,40));


        this.balle = new Balle(Math.round(Pong.LARGEUR/2),Math.round(Pong.HAUTEUR/2),20);
        this.partie = new Partie(raquette[0],raquette[1],balle);
    }

    public Partie getPartie() {
        return partie;
    }

    public void instantSuivant(){
        for(Raquette raquette : partie.raquettes){
            raquette.position.x += raquette.vitesse.x;
            raquette.position.y += raquette.vitesse.y;
        }

        //Collision balle
        for(Balle balle : partie.balles){
            //avec murs
            if(balle.position.x < balle.rayon){
                balle.vitesse.x *= -1;
                this.raquette[1].score++;
            }
            if(balle.position.x > Pong.LARGEUR-balle.rayon){
                balle.vitesse.x *= -1;
                this.raquette[0].score++;
            }


            if(balle.position.y < balle.rayon || balle.position.y > Pong.HAUTEUR- balle.rayon){
                balle.vitesse.y *= -1;
            }


            balle.position.x += balle.vitesse.x;
            balle.position.y += balle.vitesse.y;
            // avec raquettes
            for(Raquette raquette : partie.raquettes){
                // sur x
                if(balle.position.x + balle.rayon > raquette.position.x && balle.position.x - balle.rayon < raquette.position.x + Raquette.epaisseur){
                    // et sur y
                    if(balle.position.y + balle.rayon > raquette.position.y && balle.position.y - balle.rayon < raquette.position.y + raquette.taille) {
                        if(balle.position.x + balle.rayon < raquette.position.x + 10){
                            balle.vitesse.x = -Math.abs(balle.vitesse.x);
                            continue;
                        }
                        if(balle.position.y + balle.rayon < raquette.position.y + 10){
                            balle.vitesse.y = -Math.abs(balle.vitesse.y);
                            continue;
                        }
                        if(balle.position.x - balle.rayon > raquette.position.x - 10){
                            balle.vitesse.x = Math.abs(balle.vitesse.x);
                            continue;
                        }
                        if(balle.position.y - balle.rayon > raquette.position.y - 10){
                            balle.vitesse.y = Math.abs(balle.vitesse.y);
                            continue;
                        }

                    }
                }
            }


        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == toile.actualisation){
            toile.repaint();
        }

        if(e.getSource() == actualisation){
            instantSuivant();
        }

    }
}
