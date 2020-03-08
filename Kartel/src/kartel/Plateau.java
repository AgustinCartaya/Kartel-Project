/**
 * Classe qui modélise le plateau
 * le plateau contient les Jetons, la prison et le détective
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
public class Plateau {
    
    //Liste des Jetons 
    private ArrayList <Jeton> jetons;
    
    //Détective
    private Detective detective;
    
    //Prison
    private Prison prison;
    
    
    // Constructeur
    /**
     * 
     * @param nomsGangs 
     */
    public Plateau(String []nomsGangs, int maxPrisonniers){
        String []abb = extraireIni(nomsGangs);
        
        jetons = new ArrayList <Jeton>();
        //Remplissage de la liste des jetons avec tous les jetons des différents gangs 
        
	//Pas sure qu'on puisse faire ca, on a pas vu cette méthode en cours
        for (int i = 0; i < nomsGangs.length; i++) 
            jetons.addAll(Arrays.asList(  (new Gang( nomsGangs[i], abb[i])).getGang() ));
        
        //Mélange de la liste des jetons
        melanger(jetons);
        
        //Création du detective
        detective =  new Detective (jetons.size()-1);
        
        //Création de la prison
        prison = new Prison(maxPrisonniers);
    }

    
    //fonctions internes
    
    /**
     * Méthode qui fait avancer le détéctive en fonction du nombe de pas saisi,
     * supprime et renvoie le jeton de la position où le détective s'est arrêté,
     * s'il est un boss, il entre en prison
     * @param pas
     * @return 
     */
    public Jeton next( int pas ){
        if(pas == 0)
            return null;
        //On fait avancer le détéctive :
        this.detective.avancer(pas);
        int pos = detective.getPosition()-1;
        
	//Si le jeton qui se situe à cette position est un boss: on le met en prison
        if(this.jetons.get(pos).getType().equals("boss"))
            this.prison.addBoss((Boss)this.jetons.get(pos));
  
	
        if(detective.getPosition()>0)
         this.detective.avancer(-1);
        
         this.detective.setMax(jetons.size()-1);
        return jetons.remove(pos);
    }

    /**
     * méthode qui mélange les jetons
     * @param list 
     */
	
	//Pas vu ca non plus en cours, on devrais peut etre utilise melanger2
    public void melanger(List<Jeton> list) {
	final long seed = System.nanoTime();
	Collections.shuffle(list, new Random(seed));
    }
    
    //non utilisé
    public static Object[] melanger2( Object [] objects  ) {
        Object [] obj = new Object[objects.length];
        int rdm;
        for(int i=0; i<objects.length; i++){
            do{
               rdm = (int)(Math.random() * objects.length);
            }while(obj[rdm] != null);
            obj[rdm] = objects[i];
            
        } 
        return obj;
    }
    
    //non utilisé
    public String[] extraireIni(String []noms){
        String []abb = new String [noms.length];
        
        for (int i = 0; i < noms.length; i++) {
            int trouve = 0;
            for (int j = 0; j < i; j++) 
                if(abb[j].contains(( noms[i].charAt(0) +"")))
                    trouve++;
              abb[i] = (trouve == 0)?noms[i].charAt(0)+"":noms[i].charAt(0)+""+trouve;
        }
        return abb;      
    }
    
    
    // Getters et Setters
    
    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public Detective getDetective() {
        return detective;
    }

    public Prison getPrison() {
        return prison;
    }
    
    
    //Override méthodes 
    
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < this.jetons.size(); i++) {
            
            if(i==this.detective.getPosition())
                s+="<> - ";
            s+= this.jetons.get(i).toString()+" - ";
            
        }
        s += '\n' + this.prison.toString();
        return s;
    }
    
        

    
}
