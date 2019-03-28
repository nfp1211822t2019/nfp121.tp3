package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
     public Pile2(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(T o) throws PilePleineException {
        if(estPleine())throw new PilePleineException();
        stk.push(o);
        
    }

    public T depiler() throws PileVideException {
        if(estVide())throw new PileVideException();
        T i=(T)stk.pop();
        return i;
    }

    public T sommet() throws PileVideException {
        if(estVide())throw new PileVideException();
        T o1=(T)stk.peek();
        return o1;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        
        return stk.size()==capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = stk.size() - 1; i >= 0; i--) {
            sb.append(stk.get(i).toString());
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java