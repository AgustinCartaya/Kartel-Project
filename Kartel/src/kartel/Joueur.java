/**
 * Classe qui modélise les joueurs
 * 
 * interfaces implémentées:
 * Comparable
 */
package kartel;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author
 */
public class Joueur implements Comparable{

    //nom du joueur
    private String nom;
    
    //récompenses du joueur
    private ArrayList<Recompense> recompenses;
    
    
    // Constructeur
    /**
     * 
     * @param nom 
     */
    public Joueur(String nom) {
        this.nom = nom;
        recompenses = new ArrayList<Recompense>();
    }
    
    // Getters et Setters
    
    public void addRecompense( Recompense recompense){
        recompenses.add(recompense);
    }
        
    public int getScore(){
        int c=0;
        for(Recompense r:recompenses )
            c+=r.getRecompense();
        return c;
    }

    public ArrayList<Recompense> getRecompenses() {
        return recompenses;
    }

    public String getNom() {
        return nom;
    }
    
    public String getListRecompensesString(){
        String s="";
        for(Recompense r: this.recompenses)
            s+=r.toString() +" - ";
        return s;
    }

    
    //Override méthodes 
    
    @Override
    public String toString() {
        return nom + "("+getScore()+") : "+ getListRecompensesString();
    }

    @Override
    public int compareTo(Object o) {
        Joueur j2 = (Joueur) o;
        return j2.getScore() - this.getScore();
    }
 
    
}
