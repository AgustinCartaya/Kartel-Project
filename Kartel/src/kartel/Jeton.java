/**
 * Classe qui modélise
 * les pièces qui peuvent être sur le plateau, sauf le detective
 * 
 * sous-classes:
 * Boss, Recompense
 */
package kartel;

/**
 *
 * @author 
 */
public abstract class Jeton {
    //type de pièces sur le plateau
    /**
     * ----- à discuter ------
     * Une pièce ne doit pas pouvoir changer de type,
     * ça impliquerait de changer sa classe ce qui n'est pas possible
     */
    private final String type;
    
    //Famille/gang à laquelle il appartient
    private Gang gang;
    
    // Constructeur
    /**
     * @param type 
     */
    public Jeton (Gang gang, String type){
        this.gang = gang;
        this.type = type;
    }
    
    // Getters et Setters 
    public Gang getGang() {
        return this.gang;
    }
        
    public String getType() {
        return type;
    }

   
    
}
