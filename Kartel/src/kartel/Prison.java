/**
 * Classe qui modelisse la prison
 * 
 */
package kartel;

/**
 *
 * @author
 */
public class Prison {
    
    //liste des boss en prison
    private Boss [] bosses;
    
    //quantité de boss en prison
    private int nbBosses;
    
    //nombre maximum de prisonniers
    private int maxPrisoniers;


    // Constructeur
    /**
     * 
     * @param maxPrisoniers 
     */
    public Prison(int maxPrisoniers){
        this.maxPrisoniers = maxPrisoniers;
        this.bosses = new Boss[ this.maxPrisoniers ];
        this.nbBosses = 0;
    }
    
    
    // Getters et Setters
    
    public int getMaxPrisoniers() {
        return maxPrisoniers;
    }

    public void setMaxPrisoniers(int maxPrisoniers) {
        this.maxPrisoniers = maxPrisoniers;
    }
    
    public boolean isPrisonComplete(){
        return nbBosses >= this.maxPrisoniers;
    }
    
    public boolean addBoss(Boss boss){
        if(nbBosses == maxPrisoniers)
           return false;
        
        this.bosses[nbBosses] = boss;
        boss.getGang().bossInPrision();
        nbBosses++;
        return true;
    }

    public int getNbBosses() {
        return nbBosses;
    }
    
    public Boss getBoss(int index){
        if(index >=0 && index<nbBosses)
            return this.bosses[index];
        return null;
    }

    public Boss[] getBosses() {
        Boss []bosses = new Boss[nbBosses];
        for (int i = 0; i < nbBosses; i++)
            bosses[i] = this.bosses[i];
        
        return bosses;
    }
    
    
    //Override méthodes 

    @Override
    public String toString() {
        String s = "Prison:";
        for (int i = 0; i < nbBosses; i++) {
            s+= getBoss(i) + " - ";
        }
        return  s;
    }

    
}
