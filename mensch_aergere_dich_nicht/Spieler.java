import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spieler{
    private String name;
    private ArrayList<Figur> figuren;
    
    private static List<String> verfuegbareFarben = new ArrayList<>(Arrays.asList("rot", "blau", "gelb", "gruen"));
    
    public Spieler(){
        this.figuren = new ArrayList<>();
    }
    
    /**
     *@param farbe gewünschte Farbe (klein geschrieben, z.B. "rot")
     * @return true wenn erfolgreich, false wenn Farbe bereits vergeben 
     */    
    public boolean waehleFarbe(String farbe){
        if(verfuegbareFarben.contains(farbe)){
            this.name = farbe;
            verfuegbareFarben.remove(farbe);
            for(int i = 1;i<=4;i++){
                figuren.add(new Figur(this,i));
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getName(){
        return name;  
    }
    
    public ArrayList<Figur>getFiguren(){
        return figuren;
    }
    
    public void zieheFigur(int figurNummer,int felder){
        Figur figur = getFigur(figurNummer);
        if(figur != null){
            figur.ziehe(felder);
        }
    }
    
    public static List<String>getVerfuegbareFarben(){
        return verfuegbareFarben;
    }
}