/**
 * Classe qui modelisse le detective
 */
package kartel;

/**
 *
 * @author
 */

public class Detective {
    
    //position courante du détective sur le plateau
    private int position;
    
    //position maximale à laquelle le détective peut atteindre
    private int max;
    
    
    // Constructeur
    /**
     * 
     * @param max 
     */
    public Detective(int max){
        this.max = max;
        this.position =0;
    }
    

    //fonctions internes
    
    /**
     * avance le détective selon les pas passé par paramètre,
     * revenant au début si le maximum est passe
     * @param deplacement 
     */
    public void avancer(int deplacement) {
        
        this.position += deplacement;
        if(this.position > this.max)
            this.position = this.position - this.max ;
    }
    
    
    // Getters et Setters 
    
    public int getPosition() {
        return position;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    
}
