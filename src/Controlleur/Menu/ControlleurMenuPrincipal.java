package Controlleur.Menu;

import Controlleur.ControlleurPartie;
import Vue.Menu.MenuJeu;
import Vue.Menu.MenuPrincipal;
import Vue.Pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurMenuPrincipal implements ActionListener {
    Pong pong;
    MenuPrincipal vue;

    public ControlleurMenuPrincipal(Pong pong, MenuPrincipal vue){
        this.vue = vue;
        this.pong = pong;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vue.bDuo){
           lancerDuo();
        }

    }

    public void lancerDuo(){
        pong.setMenu(new MenuJeu(pong));


    }
}
