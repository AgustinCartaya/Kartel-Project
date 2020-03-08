/**
 * Classe qui modélise un ensemble de joueurs
 */
package kartel;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author
 */
public class LesJoueurs {
    
    //liste des joueurs
    private ArrayList<Joueur> joueurs;
    
    //joueur à son tour
    private int joueurActuel;
    
    
    // Constructeur
    public LesJoueurs() {
        this.joueurs = new ArrayList<Joueur>();

    }
    
    
    //fonctions internes
    
    /**
     * passe au joueur suivant, revien au premier si le précédent était le dernier
     */
    public void nextJoueur(){
        
        this.joueurActuel++;
        
        if(this.joueurActuel >= getNbJoueurs())
            this.joueurActuel = 0;
    }
    
    /**
     * Imprimez les positions des joueurs.
     * le nombre de positions est indiqué
     * @param ctt
     * @return 
     */
    public String imprimerPositions(int ctt){
        ArrayList<Joueur> resultats =  getListResultats();
        String s="1er lieu:";
        int pos = 1, i = 0;
        if(ctt == -1)
            ctt = resultats.size();
        
        while (i < resultats.size() && pos<=ctt) {

                if(i>0 && resultats.get(i).getScore() != resultats.get(i-1).getScore()){
                    
                    pos++;
                    if(pos>ctt)//j'ai pas truve une autre solution
                        break;
                    
                    s += "\n"+pos +"ème lieu";
                }
                
                //s+="\n\t"+resultats.get(i).getNom() + "\tScore: " + resultats.get(i).getScore();
                s+= "\n\t"+ resultats.get(i).toString();

                i++;
        }
 
         
         return s;
    } 
    
    
    // Getters et Setters
    
    public void addJoueur( Joueur j){
        this.joueurs.add(j);
    }   
    
    public int getNbJoueurs(){
        return this.joueurs.size();
    }
    
    public Joueur getJoueur(int index){
        if(index>=0 && index<getNbJoueurs())
            return this.joueurs.get(index);
        
        return null;
    }
    
    public int getIndexJoueurActuel(){
        return this.joueurActuel;
    }
    
    public Joueur getJoueurActuel(){
        return getJoueur(this.joueurActuel);
    }
    
    //non utilisé
    public ArrayList<Joueur> getGagnant(){
        int posGagnant = 0;
        ArrayList<Joueur> gagnant = new ArrayList<Joueur> ();
        gagnant.add(this.joueurs.get(0));
        for (int i = 1; i < this.joueurs.size(); i++) 
            if(this.joueurs.get(i).getScore() == gagnant.get(0).getScore())
                gagnant.add(this.joueurs.get(i));
            else if(this.joueurs.get(i).getScore() > gagnant.get(0).getScore()){
                gagnant.clear();
                gagnant.add(this.joueurs.get(i));
            }
        return gagnant;
        
    }
    
    public ArrayList<Joueur> getListResultats(){
          ArrayList<Joueur> resultats = this.joueurs;
          Collections.sort(resultats);
          return resultats;
      }
    
    
    //Override méthodes 
    
    @Override
    public String toString(){
        String s="";
       /* for(Joueur j: this.joueurs)
            s+= j.toString()+'\n';*/
       //cette ligne remplace une boucle for/foreach c'est interessant ça!
        s = this.joueurs.stream().map((j) -> j.toString() +'\n').reduce(s, String::concat);
        return s;
    }
    
    
}
