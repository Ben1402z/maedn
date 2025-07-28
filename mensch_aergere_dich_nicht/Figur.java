public class Figur{
    private Spieler besitzer;
    private int nummer;
    private int feld; // position
    
    public Figur(Spieler besitzer, int nummer, int feld){
        this.besitzer = besitzer;
        this.nummer = nummer;
        this.feld = feld;
    }
    
    public Spieler getBesitzer(){
        return this.besitzer;
    }
    
    public int getNummer(){
        return this.nummer;
    }
    
    public void setFeld(int feld){
        this.feld = feld;
    }
    
    public int getFeld(){
        return this.feld;
    }
    
}
