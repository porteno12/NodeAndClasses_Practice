package QPokemons;

import javax.swing.text.TabableView;

public class Program {

    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("balbasour", 1500, "grass");
        Pokemon p2 = new Pokemon("pikachu", 2500, "elctricty");
        Pokemon p3 = new Pokemon("psyduck", 2500, "mind");

        Pokemon p4 = new Pokemon("riaychu", 4000, "elctricty");
        Pokemon p5 = new Pokemon("miyatu", 5500, "mind");
        Pokemon p6 = new Pokemon("giglypuff", 20500, "mind");

        Trainer t1 = new Trainer("ash kutchem");
        t1.addPokemon(p6);

    }

    public static void pokemonDual(Trainer t1, Trainer t2) {
        String dualString = "";
        if (t1 == null && t2 == null) {
            dualString = "";
        } else if (t1 != null && t2 == null) {
            t1.addVictory();
            dualString = t1.getName();
        } else if (t1 == null && t2 != null) {
            t2.addVictory();
            dualString = t2.getName();
        } else {
            //there are 2 trainer
            Pokemon strong1 = strongestPokemon(t1);
            Pokemon strong2 = strongestPokemon(t2);
            if(strong1 == null && strong2==null)
                dualString = "";
            else if(strong1!=null && strong2==null){
                t1.addVictory();
                dualString = t1.getName();
            }
            else if(strong1==null && strong2!=null){
                t2.addVictory();
                dualString = t2.getName();
            }
            else{
                if(strong1.getPower()>strong2.getPower()){
                    t1.addVictory();
                    dualString = t1.getName();
                }else if(strong1.getPower()<strong2.getPower()){
                    t2.addVictory();
                    dualString = t2.getName();
                }
                else{
                    dualString = "";
                }
            }
        }
        System.out.println(dualString);
    }

    /**
     * helper method
     * @param t - a trainer
     * @return Pokemon - return the strongest pokemon of the trainer (null otherwise)
     */
    public static Pokemon strongestPokemon(Trainer t) {
        if (t == null) {
            return null;
        }
        Pokemon maxPokemon = getSomePokemon(t);
        if(maxPokemon != null) {

            for (int i = 0; i < t.getPocaBall().length; i++) {
                if(t.getPocaBall()[i]!=null){
                    Pokemon tmp = t.getPocaBall()[i];
                    if(tmp.getPower()> maxPokemon.getPower()){
                        maxPokemon = t.getPocaBall()[i];
                    }
                }
            }
            return maxPokemon;
        }
        return null;    //the trainer has no pokemons at all
    }

    /**
     * helper method
     * @param t - a trainer object
     * @return Pokemon - first pokemon in the array that is not null
     */
    public static Pokemon getSomePokemon(Trainer t) {
        if (t != null) {
            for (int i = 0; i < t.getPocaBall().length; i++) {
                if (t.getPocaBall()[i] != null) {
                    return t.getPocaBall()[i];
                }
            }
            return null;
        }
        return null;
    }
}
