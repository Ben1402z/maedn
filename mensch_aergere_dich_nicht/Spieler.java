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
        
        int nr = 0;
        
        if (this.farbe == "Blau") {
            nr = 1;
        } else if (this.farbe == "Rot") {
            nr = 5;
        } else if (this.farbe == "Gelb") {
            nr = 9;
        } else if (this.farbe == "Grün") {
            nr = 13;
        }
        
        for(int i = 0 ; i<4 ; i++){
            this.figuren.add(new Figur(this, nr+i, (-nr)-i));
        }
        for (int i = 0 ; i < this.figuren.size() ; i++) {
            System.out.println(this.figuren.get(i));
            System.out.println(this.figuren.get(i).getNummer());
        }
        
    }

    public Figur waehleFigur(int[] möglichkeiten){
        
        System.out.println("Bewegbare Figuren: ");
        System.out.println(Arrays.toString(möglichkeiten));
        
        Scanner scanner = new Scanner(System.in);
        int wahl;
        while (true) {
            System.out.print("Welche Figur möchtest du bewegen? Gib die Nummer ein: ");
            if (scanner.hasNextInt()) {
                wahl = scanner.nextInt();
                boolean enthalten = false;
                for (int m : möglichkeiten) {
                    if (m == wahl) {
                        enthalten = true;
                        break;
                    }
                }
                if (enthalten) {
                    break;
                } else {
                    System.out.println("Ungültige Wahl! Diese Figur kann nicht bewegt werden.");
                }
            } else {
                scanner.next(); // ungültige Eingabe verwerfen
                System.out.println("Bitte eine gültige Zahl eingeben.");
            }
        }
        
        for (int i = 0 ; i < this.figuren.size() ; i++) {
            if (this.figuren.get(i).getNummer() == wahl) {
                return this.figuren.get(i);
            }
        }
        
        return null;
    }
    
    public void updateFeld(int feld, int figurNr){
        
        for (int i = 0 ; i < this.figuren.size() ; i++) {
            if (this.figuren.get(i).getNummer() == figurNr) {
                System.out.println("Feld davor");
                System.out.println(this.figuren.get(i).getFeld());
                this.figuren.get(i).setFeld(feld);
                System.out.println("Feld danach");
                System.out.println(this.figuren.get(i).getFeld());
            }
        }
        
    }
    
    public String getFarbe(){
        return this.farbe;  
    }
    
    public Figur getFigur(int nr){
        return this.figuren.get(nr);
    }
    
    
}
