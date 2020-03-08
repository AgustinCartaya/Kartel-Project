/**
 * Classe qui modelisse les Pots De Vin
 * 
 * classe parent: Recompense
 */
package kartel;

/**
 *
 * @author agust
 */
public class PotDeVin extends Recompense {
    

    //valeur de la recompense
    private int recompense;

    // Constructeur
    /**
     * 
     * @param gang 
     */
    public PotDeVin(Gang gang){
        super (gang, "pot de vin", 3);
    }
    
    //Override méthodes 
    
    @Override
    public String toString() {
        return  '$' + getGang().getAbb();
    }

    
}
