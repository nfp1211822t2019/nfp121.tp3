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

    // if (!(o instanceof PileI))return false;
   
     // Pile4 p = (Pile4) o; 
      // if(this.capacite()!=p.capacite())return false;
       // if(this.taille()!=p.taille())return false;
     
          // Maillon m1=this.stk;
          // Maillon m2=p.stk;
        
          // while(m1!=null && m2!=null){
            // if(!m1.equals(m2))return false;
               // else {
                  // m1=m1.suivant();
                  // m2=m2.suivant();
                    // }       
        // }
    // return true;
// }

 public void copy(PileI p1, PileI p2){
        while(!p1.estVide()){
            try{
                p2.empiler(p1.depiler());
            } catch (PileVideException e){}
            catch (PilePleineException p){}
        }
    }
    
    public boolean equals(Object o) {
		
        if(!(o instanceof PileI)) return false;
        
        PileI p = (PileI)o;   
        if(super.equals(o))
            return true;   
              
        if(this.capacite() != p.capacite()) return false;            
        if(this.taille() != p.taille()) return false;        
       
        Pile4 p1 = new Pile4(this.taille());        
        Pile4 p2 = new Pile4(p.taille());
        boolean b;
        
        while (!p.estVide()){
            try{
                b = false;
             if(this.sommet().equals(p.sommet()))  b = true;
            
             if(b==true){
                p1.empiler(this.depiler());                    
                p2.empiler(p.depiler());
                }
                
                else{
              
                copy(p2, p);
                  copy(p1, this);
                return false;
                }
            } 
            catch(PilePleineException e){}            
            catch(PileVideException ee){}
        }
              
        copy(p2, p);   
          copy(p1, this);
        return true;
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