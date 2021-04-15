import Vue.Menu.MenuPrincipal;
import Vue.Pong;

public class Main {
    public static void main(String[] args){
        Pong vue = new Pong();
        vue.setMenu(new MenuPrincipal(vue));
        vue.setVisible(true);
    }
}
