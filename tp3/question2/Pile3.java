package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
		this(0);
	}

	public Pile3(int taille) {
	    if (taille <= 0) taille = CAPACITE_PAR_DEFAUT;
	    
	    v = new Vector(taille);
		// traiter le cas <=0
		// à compléter
	}

	public void empiler(Object o) throws PilePleineException {
	    if(estPleine())throw new PilePleineException();
		
	    v.add(o);
		// à compléter
	}

	public Object depiler() throws PileVideException {
	    if(estVide())throw new PileVideException();	
	   
		// à compléter
		return v.remove(v.size()-1);
	}

	public Object sommet() throws PileVideException {
	    if(estVide())throw new PileVideException();
		return v.lastElement();
		// à compléter
		
	}

	public int taille() {
		// à compléter
		return v.size();
	}

	public int capacite() {
		// à compléter
		return v.capacity();
	}

	public boolean estVide() {
		// à compléter
		return v.size()==0;
	}

	public boolean estPleine() {
		// à compléter
		return v.size()==v.capacity();
	}

	public String toString() {
		// à compléter
		StringBuffer sb = new StringBuffer("[");
            for (int i = v.size() - 1; i >= 0; i--) {
                sb.append(v.get(i).toString());
                if (i > 0)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
	

	public boolean equals(Object o) { 
    if (o instanceof PileI) { 
      PileI p = (PileI) o; 
      return this.capacite() == p.capacite() 
          && this.hashCode() == p.hashCode(); 
    } else 
      return false; 
  }

	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}

}
