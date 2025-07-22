import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Spieler{
    private String farbe;
    private ArrayList<Figur> figuren;
    
    public static String waehleFarbe(ArrayList<String> farben, Set<String> bereitsVergeben) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Verfügbare Farben:");
            for (int i = 0; i < farben.size(); i++) {
                String status = bereitsVergeben.contains(farben.get(i)) ? " (bereits vergeben)" : "";
                System.out.println((i + 1) + " = " + farben.get(i) + status);
            }
            System.out.print("Wähle eine Farbe (Nummer eingeben): ");
            if (scanner.hasNextInt()) {
                int wahl = scanner.nextInt();
                if (wahl >= 1 && wahl <= farben.size() && !bereitsVergeben.contains(farben.get(wahl - 1))) {
                    return farben.get(wahl - 1);
                }
            } else {
                scanner.next(); // ungültige Eingabe verwerfen
            }
            System.out.println("Ungültige Eingabe oder Farbe schon vergeben. Bitte nochmal versuchen.");
        }
    }
    
    public static int wuerfeln() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // gibt eine Zahl von 1 bis 6 zurück
    }
    
    public Spieler(String gewaehlteFarbe){
        
        this.farbe = gewaehlteFarbe;
        
        this.figuren = new ArrayList<>();
        for(int i = 1 ; i<=4 ; i++){
            figuren.add(new Figur(this,i));
        }        
        
    }
    
    
    public String getFarbe(){
        return this.farbe;  
    }
    
    public Figur getFigur(int nr){
        return figuren.get(nr);
    }
    
    public void zieheFigur(int figurNummer,int felder){
        Figur figur = getFigur(figurNummer);
        if(figur != null){
            figur.ziehe(felder);
        }
    }
    
}
