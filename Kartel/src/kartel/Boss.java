/**
 * Classe qui modelisse les boss
 * 
 * classe parent: Jeton
 */
package kartel;

/**
 *
 * @author
 */
public class Boss extends Jeton{
    

    
    //true si le boss est prisoner
    private boolean prisonnier; 

    // Constructeur
    /**
     * 
     * @param gang 
     */
    public Boss(Gang gang){
        super(gang, "boss");
        this.prisonnier = false;
    }

    // Getters et Setters 

    public boolean isPrisonnier() {
        return prisonnier;
    }
    
    public void setPrisonnier(boolean prisonnier) {
        this.prisonnier = prisonnier;
    }
    
    
    //Override méthodes 
    @Override
    public String toString() {
        return  '[' + getGang().getAbb()+ ']';
    }

}
