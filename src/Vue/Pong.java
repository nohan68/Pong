package Vue;

import Vue.Menu.Menu;
import Vue.Menu.MenuPrincipal;

import javax.swing.*;
import java.awt.*;

public class Pong extends JFrame {
    public static final int HAUTEUR = 600;
    public static final int LARGEUR = 800;

    JPanel panneauGeneral;

    public Pong(){
        super("Pong");
        setSize(LARGEUR,HAUTEUR);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initAttr();
        initWigets();
    }

    public void initAttr(){
        panneauGeneral = new JPanel();
    }

    public void initWigets(){
        setContentPane(panneauGeneral);
    }


    public void setMenu(Menu menu){
        initAttr();
        initWigets();
        menu.deployer(panneauGeneral);
        panneauGeneral.revalidate();
        revalidate();
    }
}
