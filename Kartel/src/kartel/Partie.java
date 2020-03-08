/**
 * classe qui crée le jeu/Parti
 * un jeu/Parti doit contenir des joueurs un plateau et un dé
 */
package kartel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author
 */
public class Partie {
    
    //le plateau
    private Plateau plateau;
    
    //les joueurs
    private LesJoueurs lesJoueurs;
    
    //le de
    private De de;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Partie();
    }
    
    
    // Constructeur
    public Partie(){
        
        this.lesJoueurs = new LesJoueurs();
        initAutomatique();
        jouer();
    }
    
    
    //fonctions internes
    
    /**
     * ajoute un joueur avec le nom passé par paramètre
     * @param s 
     */
    private void ajouterJoueur(String s){
        this.lesJoueurs.addJoueur( new Joueur (s));  
    }
    
    /**
     * crée le tableau avec la liste des gangs passée par paramètre
     * et un dé avec les faces passés par paramètre
     * @param gansters 
     */
    private void initPlateau(String [] nomsGangs, int maxPrisoniers){
        this.plateau = new Plateau(nomsGangs, maxPrisoniers); 
    }
           
    /**
     * crée le tableau avec la liste des gangs passée par paramètre
     * et un dé par défaut
     * @param gansters 
     */
    private void initPlateau(String [] gansters){
        this.plateau = new Plateau(gansters,5);
    }
    
    /**
     * initialisation du dé avec les faces passées par paramètre
     * @param faces 
     */
    private void initDe( int []faces){
        this.de = new De(faces);
    }
    
    /**
     * initialisation du dé par défaut
     */
    private void initDe(){
        this.de = new De();
    }
    
    /**
     * initialisation automatique pour les tests
     */
    private void initAutomatique(){
        System.out.println("Init...");
        
        for (int i = 0; i < 3; i++) 
            ajouterJoueur("Joueur"+i);
        
        initPlateau(new String[]{"Verts","Blue","Rouge","Cian","Noire","Gris","Magenta"});    
        initDe();
    }
    
    /**
     * méthode en charge de démarrer le jeu
     * explication détaillée plus tard ...
     */
    private void jouer(){
        if(this.plateau == null || this.lesJoueurs.getNbJoueurs() == 0 || this.de == null)
            return;//on peut mettre une exception
        
        //int opc = 0;
        int resDe, valeurChoisie;
        Joueur jAct;
        Jeton jetAct;
        while( !this.plateau.getPrison().isPrisonComplete() ){
            
            jAct = this.lesJoueurs.getJoueurActuel(); 
            System.out.println(this.plateau);
            System.out.println(this.lesJoueurs.toString());
            System.out.println("C'est à "  + jAct.getNom() +" de jouer" );
            
            resDe = this.de.lancer();
            System.out.println("Le resulta du De est: " + resDe + " que jouez-vous ? : ");
            try {valeurChoisie = Lire.i();}
            catch(NumberFormatException e) {valeurChoisie =  resDe+1;}

            while(valeurChoisie < 0 || valeurChoisie > resDe){
                System.out.println("La valeur doit etre entre 0 et " + resDe + " insertez une valeur correpte svp");   
                try {valeurChoisie = Lire.i();}
                catch(NumberFormatException e) {valeurChoisie =  resDe+1;}
            }
            
            jetAct = this.plateau.next( valeurChoisie );
            if(jetAct != null){
                
            
            if(!jetAct.getType().equals("boss"))
                jAct.addRecompense((Recompense)jetAct);
            }
            this.lesJoueurs.nextJoueur();
            //System.out.println("Continuar? 0 = si : ");
            //opc = Lire.i();
            
            
        }
        System.out.println("***** Fin du jeu *****");
        System.out.println("Plateau:");
        System.out.println(this.plateau);
        System.out.println("Resultats:");
        System.out.println(this.lesJoueurs.imprimerPositions(-1));
        
        
    }
    
    
    
 
}
