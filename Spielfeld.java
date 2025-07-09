import java.util.Random;
public class Spielfeld{
    private Feld[][] Spielfeld;
    private int SpielerAnzahl;
    private Spieler[] meineSpieler;
    
    public Spielfeld(Spieler SpielerEins, Spieler SpielerZwei, Spieler SpielerDrei, Spieler SpielerVier){
        int i = 0;
        Spielfeld = new Feld[11][11];
        if(SpielerEins != null){
            SpielerAnzahl++;
            i++;
            if(SpielerZwei != null){
                SpielerAnzahl++;
                i++;
                if(SpielerDrei != null){
                    SpielerAnzahl++;
                    i++;
                    if(SpielerDrei != null){
                        SpielerAnzahl++;
                        i++;
                        }
                }
                }
        }
        if (i <= 2){
            meineSpieler = new Spieler[i];
        }
        else{
            System.out.println("Bitte Spieler Einfügen um Spiel zu beginnen");
            System.out.println();
            System.out.println("---------------------------------------------");
        }
    }
    public Feld FeldSpawn(int Art){
        // 1 = normal
        // 2 = Steh
        // 3 = Heim
        // 4 = 
        if(i=1){
            
        }
    }
    public void SpielfeldInitialisieren(){
        
    }
}
