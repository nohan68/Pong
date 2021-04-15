package Vue;

import Controlleur.ControlleurPartie;
import Modele.Balle;
import Modele.Raquette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Toile extends JPanel {
    public final int FPS = 60;
    public Timer actualisation;

    ControlleurPartie controlleurPartie;

    public Toile(ControlleurPartie controlleurPartie){
        super();
        this.controlleurPartie = controlleurPartie;
        actualisation = new Timer(1000/FPS,controlleurPartie);
        actualisation.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,Pong.LARGEUR, Pong.HAUTEUR);

        dessinerBalles(g);
        dessinerTemps(g);
        dessinerRaquette(g);

        Toolkit.getDefaultToolkit().sync();
    }

    void dessinerTemps(Graphics g) {
        g.setColor(new Color(184, 184, 184, 67));
        Font font = g.getFont().deriveFont( 100.0f );
        g.setFont( font );
        SimpleDateFormat formatter = new SimpleDateFormat("m:ss");
        g.drawString(formatter.format(new Date(new Date().getTime() - controlleurPartie.getPartie().debutPartie.getTime() )),Pong.LARGEUR/2-100,Pong.HAUTEUR-Pong.HAUTEUR/4);
    }

    void dessinerBalles(Graphics g){
        for(Balle balle : controlleurPartie.getPartie().balles){
            g.setColor(Color.white);
            g.fillOval(balle.position.x-balle.rayon, balle.position.y - balle.rayon, 2* balle.rayon, 2*balle.rayon);
        }
    }

    void dessinerRaquette(Graphics g){
        for(Raquette raquette : controlleurPartie.getPartie().raquettes){
            g.setColor(new Color(184, 184, 184, 67));
            Font font = g.getFont().deriveFont( 100.0f );
            g.setFont( font );
            g.drawString(Integer.toString(raquette.score),raquette.position.x - 25,100);

            g.setColor(Color.white);
            g.fillRect(raquette.position.x,raquette.position.y,Raquette.epaisseur,raquette.taille);

        }

    }


}
