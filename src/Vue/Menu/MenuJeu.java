package Vue.Menu;

import Controlleur.ControlleurPartie;
import Vue.Pong;
import Vue.Toile;

import javax.swing.*;
import java.awt.*;

public class MenuJeu implements Menu {
    Pong pong;
    ControlleurPartie controlleurPartie;
    JPanel jPanel;

    public MenuJeu(Pong pong){
        this.pong = pong;
        this.controlleurPartie = new ControlleurPartie(pong);

    }

    @Override
    public void deployer(JPanel jPanel) {
        this.jPanel = jPanel;
        jPanel.setLayout(new GridLayout(1,1));

        init();
    }

    public void init(){
        jPanel.add(this.controlleurPartie.toile);
    }
}
