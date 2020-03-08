/**
 * Classe qui modelisse le De
 * 
 */

package kartel;

/**
 *
 * @author
 */
public class De {
    
    //faces du dé
    private int []faces;
    
    //faces currant du dé
    private int faceCourante;

    
    // Constructeurs
    /**
     * 
     * @param faces 
     */
    public De(int [] faces) {
        this.faces = faces;
        this.faceCourante = 0;
    }
    
    public De(){
        this(new int[]{2,2,3,3,4,4});
    }
    
    
    //fonctions internes
    
    /**
     * renvoie une face du dé choisie aléatoirement
     * @return int face
     */
    public int lancer(){
        this.faceCourante = (int) (Math.random() * faces.length);
        return this.faces[ this.faceCourante ];
    }

    
    // Getters et Setters 
    
    public int getFaceCourante() {
        return this.faceCourante;
    }


}
