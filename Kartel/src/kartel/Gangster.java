/**
 * Classe qui modelisse les Gansters
 * 
 * classe parent: Recompense
 */
package kartel;

/**
 *
 * @author
 */
public class Gangster extends Recompense{
    
    
    //indique s'il s'agit d'un gangster de type 1,2 ou 3 (c'est également utilisé pour établir la récompense)
    private int niveau;

    // Constructeur
    /**
     * 
     * @param gang
     * @param niveau 
     */
    public Gangster(Gang gang, int niveau){
        super(gang, "ganster",-niveau);
        this.niveau = niveau;
    }
  
     
    //Override méthodes 
    
    @Override
    public String toString() {
        return  niveau + getGang().getAbb();
    }
    

    
}
