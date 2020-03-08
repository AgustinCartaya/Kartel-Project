/**
 * Classe qui modelisse les familles/gangs
 * créer des jetons par défaut, (modifier cette fonctionnalité)
 */
package kartel;

/**
 *
 * @author agust
 */
public class Gang {
    
    //nom et surnom de gang
    private String nom,
                   abb;
    
    //creation de jetons par défaut
    private Boss boss;
    private Gangster[] gangsters;
    private PotDeVin potDeVin;
    
    
    // Constructeurs
    /**
     * 
     * @param nom
     * @param abb 
     */
    public Gang(String nom, String abb){

        this.nom = nom;
        this.abb = abb;

        boss = new Boss (this);
        gangsters = new Gangster[4];
        gangsters[0] =  new Gangster(this, 1);
        gangsters[1] =  new Gangster(this, 2);
        gangsters[2] =  new Gangster(this, 2);
        gangsters[3] =  new Gangster(this, 3);
        potDeVin = new PotDeVin(this);

    }
    
    /**
     * 
     * @param nom 
     */
    public Gang (String nom){
        this(nom, nom.charAt(0)+"");
    }
    
    //fonctions internes
    
    /**
     * envoi le boss en prison et change la valeur des récompenses
     */
    public void bossInPrision(){
        boss.setPrisonnier(true);
        for(Gangster g: gangsters)
            g.setRecompense( g.getRecompense() * -1);
        potDeVin.setRecompense(0);
    }
    
    
    // Getters et Setters 
    
    public String getNom() {
        return nom;
    }

    public String getAbb() {
        return abb;
    }
    
    public Jeton[] getGang(){
        return new Jeton[] {gangsters[0], gangsters[1], gangsters[2], gangsters[3], potDeVin, boss };
    } 
    
    
}
