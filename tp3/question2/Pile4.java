package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
            
            nombre++;
            Maillon ancienStk = stk;
            stk = new Maillon(o, ancienStk);
    
        // à compléter
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
        Object o = stk.element();
                this.stk = this.stk.suivant();
                nombre--;
        return o;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
       return this.stk.element; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
		return stk == null;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.capacite == this.taille(); // � compl�ter

    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        Maillon m =stk;
	while(m != null){
	    
		s = s + m.element().toString();
		m = m.suivant();
		if(m != null) s = s + ", ";}
        // à compléter
        return s + "]";
    }

   
       // public boolean equals(Object o) {
	     // if (o instanceof Pile4) {
	          // Pile4 p = (Pile4) o;
	  // if(this.capacite()!=p.capacite())return false;
        // else if(this.taille()!=p.taille())return false;
        // else if (this.toString().equals(p.toString())) return true;
       // else return false;
    // }
         // return false;
    // }
    public boolean equals(Object o) { 
    if (o instanceof PileI) { 
      PileI p = (PileI) o; 
      return this.capacite() == p.capacite() 
          && this.hashCode() == p.hashCode(); 
    } else 
      return false; 
  }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}