import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main{
    public static void main (String[] args){
        
        ArrayList<String> farben = new ArrayList<>(Arrays.asList("Blau", "Rot", "Gelb", "Grün"));
        Set<String> bereitsVergeben = new HashSet<>();
        int anzahlSpieler = 2;
        
        Spieler[] spieler = new Spieler[anzahlSpieler];
        
        for (int i = 0; i < anzahlSpieler; i++) {
            System.out.println("Spieler " + (i + 1) + ":");
            String gewaehlteFarbe = Spieler.waehleFarbe(farben, bereitsVergeben);
            bereitsVergeben.add(gewaehlteFarbe);
            spieler[i] = new Spieler(gewaehlteFarbe);
        }
        
        System.out.println(Spieler.wuerfeln());
        
        int[] zahlen = {1,2,4};
        Figur x = spieler[0].waehleFigur(zahlen);
        System.out.println(x.getNummer());
        
        spieler[0].updateFeld(45, 1);
    }
}
