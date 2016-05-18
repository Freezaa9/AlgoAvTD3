/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

/**
 *
 * @author Antoine
 * @param <K>
 * @param <V>
 */
public class ABR<K extends Comparable, V > implements Dico<K, V>{
    
    private Noeud racine;
    
    public ABR(){
        //TODO
        racine = new Noeud();
    }

    /**
     * Ajouter un élément une combinaison clé, valeur dans le Dico.
     * @param pCle La clé a laquelle la valeur doit être inserer.
     * @param pValeur la valeur à inserer.
     * @return La valeur remplacé si elle existe, null sinon
     */
    @Override
    public V ajouter(K pCle, V pValeur) {
        if(estVide()){
            racine = new Noeud(pCle, pValeur);
            return null;
        }
        if(pCle.compareTo(racine.cle) == 0 ){
            V tmpValeur = (V) racine.valeur;
            racine.valeur = pValeur;
            return tmpValeur;
        }
        if(pCle.compareTo(racine.cle) <= 0 ){
            return (V) racine.fg.ajouter(pCle, pValeur);
        }
        
        return (V) racine.fd.ajouter(pCle, pValeur);
    }
    

    @Override
    public int nbElem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vider() {
        racine = new Noeud();
    }

    /**
     *
     * @param cle
     * @return
     */
    @Override
    public V rechercher(K cle) {
            if(estVide()){
            return null;
        }
        if (cle.compareTo(racine.cle)==0) {
            return (V)racine.valeur;
        }
        if (cle.compareTo(racine.cle)<0) {
            return (V)racine.fg.rechercher(cle);
        }
        else{
            return (V)racine.fd.rechercher(cle);
        }
    }

    @Override
    public boolean exist(K cle) {    
        if (racine == null)
            return false;
        
        if (cle.compareTo(racine.cle) == 0)
            return true;  
        
        return racine.fg.exist(cle) || racine.fd.exist(cle);              
    }

    @Override
    public V supprimer(K cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean estVide() {
        return racine.cle != null;
    }

    private class Noeud<K extends Comparable, V> {
        K cle;
        V valeur;
        ABR<K, V> fg; // ne doit jamais être null (et pas testé == null) !!
                       // L'arbre peut etre vide mais jamais null
        ABR<K, V> fd; // ne doit jamais être null (et pas testé == null) !!
                        // Ne pas confondre vide et n'existe pas
                        // un arbre vide existe mais à une racine == null

        public Noeud(K cle, V valeur) {
            this();
            this.cle = cle;
            this.valeur = valeur;
        }
        
        public Noeud() {
            fg = new ABR();
            fd = new ABR();
        }
        
    }
}
