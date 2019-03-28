package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine())throw new PilePleineException();
        stk.push(o);
        
    }

    public Object depiler() throws PileVideException {
        if(estVide())throw new PileVideException();
        Object i=(Object)stk.pop();
        return i;
    }

    public Object sommet() throws PileVideException {
        if(estVide())throw new PileVideException();
        Object o1=(Object)stk.peek();
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