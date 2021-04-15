package Vue.Menu;

import Controlleur.Menu.ControlleurMenuPrincipal;
import Vue.Pong;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal implements Menu{
    Pong pong;

    JLabel lTitre;
    public JButton bDuo;
    public JButton bLigne;
    public JButton bOptions;

    public MenuPrincipal(Pong pong){
        this.pong = pong;
    }

    JPanel jPanel;
    @Override
    public void deployer(JPanel jPanel) {
        this.jPanel = jPanel;
        jPanel.setLayout(new GridLayout(5,1));
        init();
    }

    private void init(){
        lTitre = new JLabel("Pong", SwingConstants.CENTER);
        lTitre.setForeground(Color.ORANGE);
        lTitre.setFont(new Font("Serif sans", Font.BOLD, 75));
        bDuo = new JButton("Duo");
        bDuo.setFont(new Font("Serif sans", Font.PLAIN, 50));
        bDuo.addActionListener(new ControlleurMenuPrincipal(this.pong,this));
        bLigne = new JButton("En ligne");
        bLigne.setFont(new Font("Serif sans", Font.PLAIN, 50));
        bLigne.addActionListener(new ControlleurMenuPrincipal(this.pong,this));
        bOptions = new JButton("Options");
        bOptions.setFont(new Font("Serif sans", Font.PLAIN, 50));
        bOptions.addActionListener(new ControlleurMenuPrincipal(this.pong,this));

        jPanel.add(lTitre);
        jPanel.add(bDuo);
        jPanel.add(bLigne);
        jPanel.add(bOptions);
    }


}
