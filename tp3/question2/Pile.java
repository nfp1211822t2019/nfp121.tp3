package question2;

import question1.PilePleineException;
import question1.PileVideException;
import question2.PileI;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    public final static int TAILLE_PAR_DEFAUT = 6;

    private Object[] zone;
    private int ptr;

    /**
     * à compléter
     * 
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append((zone[i]));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Object sommet() throws PileVideException{
        if (taille()==0)return "la pile est vide";
        else return zone[taille()-1];}
    
    public int capacite(){return zone.length;}
    
    public int taille(){
        return ptr;
    }
    
     public boolean equals(Object o) { 
    if (o instanceof PileI) { 
      PileI p = (PileI) o; 
      return this.capacite() == p.capacite() 
          && this.hashCode() == p.hashCode(); 
    } else 
      return false; 
  }
    
    public int hashCode(){ return toString().hashCode();}

}