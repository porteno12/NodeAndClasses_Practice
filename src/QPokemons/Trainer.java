package QPokemons;

public class Trainer {
    private String name;
    private int victories;
    private Pokemon[] pocaBall;

    //q1.a- solution
    public Trainer(String name){
        this.name = name;
        this.victories = 0;
        this.pocaBall = new Pokemon[150];   // p, null, null...
    }

    //q1.b - solution
    public boolean addPokemon (Pokemon p){
        if(p==null)
            return false;
        for (int i = 0; i <this.pocaBall.length ; i++) {
            if(this.pocaBall[i]==null){
                this.pocaBall[i] = p;
                return true;
            }
        }
        return false;
    }

    public void addVictory(){
        this.victories++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVictories() {
        return victories;
    }

    public Pokemon[] getPocaBall() {
        return pocaBall;
    }
}
