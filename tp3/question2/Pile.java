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
    
     public void copy(PileI pa, PileI pi){
        while(!pa.estVide()){
            try{
                pi.empiler(pa.depiler());
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
       
        Pile p1 = new Pile(this.taille());        
        Pile p2 = new Pile(p.taille());
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
                copy(p1, this);
                copy(p2, p);
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
    
    public int hashCode(){ return toString().hashCode();}

}