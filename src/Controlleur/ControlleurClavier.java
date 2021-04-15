package Controlleur;

import Modele.Raquette;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlleurClavier implements KeyListener {
    Raquette raquette;
    int haut;
    int bas;

    public ControlleurClavier(Raquette raquette, int haut, int bas) {
        this.raquette = raquette;
        this.haut = haut;
        this.bas = bas;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == haut) {
            raquette.vitesse.y = -10;
        }
        if (e.getKeyCode() == bas) {
            raquette.vitesse.y = 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == haut || e.getKeyCode() == bas) {
            raquette.vitesse.y = 0;
        }
    }
}
