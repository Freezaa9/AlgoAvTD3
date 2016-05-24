/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

/**
 * @author Antoine
 * @param <K>
 * @param <V>
 */
public class ABR<K extends Comparable, V > implements Dico<K, V>{
    
    private Noeud racine;
    
    public ABR(){
    }

    /**
     * Ajouter un élément une combinaison clé, valeur dans le Dico.
     * @param cle La clé a laquelle la valeur doit être inserer.
     * @param valeur la valeur à inserer.
     * @return La valeur remplacé si elle existe, null sinon
     */
    @Override
    public V ajouter(K cle, V valeur) {
        if(estVide()){
            racine = new Noeud(cle, valeur);
            return null;
        }
        if(cle.compareTo(racine.cle) == 0 ){
            V tmpValeur = (V) racine.valeur;
            racine.valeur = valeur;
            return tmpValeur;
        }
        if(cle.compareTo(racine.cle) <= 0 ){
            return (V) racine.fg.ajouter(cle, valeur);
        }
        
        return (V) racine.fd.ajouter(cle, valeur);
    }
    

    @Override
    public int nbElem() {
        if(this.estVide())
            return 0;
        return racine.fg.nbElem() + racine.fd.nbElem() + 1;
    }

    @Override
    public void vider() {
        racine = null;
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
            return racine.valeur;
        }
        if (cle.compareTo(racine.cle)<0) {
            return racine.fg.rechercher(cle);
        }
        else{
            return racine.fd.rechercher(cle);
        }
    }

    @Override
    public boolean exist(K cle) {    
        if (estVide())
            return false;
        
        if (cle.compareTo(racine.cle) == 0)
            return true;  
        
        if (cle.compareTo(racine.cle) < 0)
            return racine.fg.exist(cle);
        else
            return racine.fd.exist(cle);              
    }

    @Override
    public V supprimer(K cle) {
        if(estVide()){
            return null;
        }
        
        if (cle.compareTo(racine.cle)==0) {
            V valCourante = racine.valeur; 
            if(!racine.fd.estVide()){
                Noeud plusPetitNoeud = racine.fd.supprimerPlusPetitNoeud();
                racine.cle = plusPetitNoeud.cle;
                racine.valeur = plusPetitNoeud.valeur;
            }
            else {
                racine = racine.fg.racine;
            }
            return valCourante;
            
        }
        if (cle.compareTo(racine.cle)<0) {
            return racine.fg.supprimer(cle);
        }
        else{
            return racine.fd.supprimer(cle);
        }
    }
    
    private Noeud supprimerPlusPetitNoeud() {
        if (racine.fg.estVide()) {
            Noeud n = racine;
            racine = null;
            return n;
        }
        else {
            return racine.fg.supprimerPlusPetitNoeud();
        }
    }
    
    @Override
    public boolean estVide() {
        return racine == null;
    }

    @Override
    public int hauteur() {
        if (racine == null)
            return 0;
        return 1 + Math.max(racine.fg.hauteur(),racine.fd.hauteur());
    }

    @Override
    public boolean estEquilibre() {
        if (Math.abs(racine.fg.hauteur() - racine.fd.hauteur()) > 1){
            return false;
        }
        return racine.fg.estEquilibre() && racine.fd.estEquilibre();
    }

    @Override
    public void equilibrer() {
        // Mettre dans un tableau
        // Utiliser la valeur du milieu comme racine
        // Ajouter le tableau de gauche dans le sous arbre gauche
        // Ajouter le tableau de droite dans le sous arbre de droite
        // Use Récursivité
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Noeud {
        K cle;
        V valeur;
        ABR<K, V> fg; // ne doit jamais être null (et pas testé == null) !!
                       // L'arbre peut etre vide mais jamais null
        ABR<K, V> fd; // ne doit jamais être null (et pas testé == null) !!
                        // Ne pas confondre vide et n'existe pas
                        // un arbre vide existe mais à une racine == null

        public Noeud(K cle, V valeur) {
            this.fg = new ABR<>();
            this.fd = new ABR<>();
            this.cle = cle;
            this.valeur = valeur;
        }               
    }
}
