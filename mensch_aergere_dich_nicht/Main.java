public class Main{
    public static void main (String[] args){
        Spieler spieler1 = new Spieler();
        if(spieler1.waehleFarbe("rot")){
            System.out.println("Spieler 1 hat die Farbe gewählt: "+ spieler1.getName());
        }
        
        Spieler spieler2 = new Spieler();
        if(!spieler2.waehleFarbe("rot")){
            System.out.println("Farbe 'rot' ist bereits vergeben!");
        }
        
        if( spieler2.waehleFrbe("blau")){
            system.out.println("Spieler2 hat die Farbe gewählt:"+ spieler2.getName());
        }
        System.out.println("Noch verfügbare 
    }
}