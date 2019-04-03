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
            for (int i = this.taille()- 1; i >= 0; i--) {
                sb.append(v.get(i).toString());
                if (i > 0)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    
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
                  
        
        Pile3 p1 = new Pile3(this.taille());        
        Pile3 p2 = new Pile3(p.taille());
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

  
   // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
