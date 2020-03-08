/**
 * Classe qui modelisse les recompenses
 * Une récompense est un jeton qui donne une valeur x au score du joueur
 * 
 * classe parent: Jeton
 * sous-classes:
 * Boss, Recompense, detective? (à discuter)
 */
package kartel;

/**
 *
 * @author
 */
public abstract class Recompense extends Jeton{
    
    //valeur de la recompense
    private int recompense;

    // Constructeur
    /**
     * 
     * @param recompense
     * @param type 
     */
    public Recompense(Gang gang, String type, int recompense){
       super(gang, type);
        this.recompense = recompense;
    }
    
    
    // Getters et Setters 
    
    public int getRecompense() {
            return this.recompense;
        }
    
    public void setRecompense( int recompense) {
        this.recompense = recompense;
    }
}
