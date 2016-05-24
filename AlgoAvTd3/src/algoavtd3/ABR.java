/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

import java.util.ArrayList;
import java.util.List;

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
        return true && racine.fg.estEquilibre() && racine.fd.estEquilibre();
    }

    @Override
    public void equilibrer() {
        // Mettre dans un tableau
        List<tuple> l = new ArrayList<>();
        parcourArbre(l);        
        // Utiliser la valeur du milieu comme racine
        racine = null;
        construireArbre(l, this, 0, l.size()-1);
    }
    
    private void construireArbre(List<tuple> l,ABR arbre,int debut, int fin){
        
        if(fin == debut){
            arbre.ajouter(l.get(debut).cle, l.get(debut).valeur);
        }
        else if(fin == debut+1){
            arbre.ajouter(l.get(debut).cle,l.get(debut).valeur);
            arbre.ajouter(l.get(fin).cle,l.get(fin).valeur);
        }
        else if(fin > debut+1){
            arbre.ajouter(l.get(fin - (fin-debut)/2).cle, l.get(fin - (fin-debut)/2).valeur);
            construireArbre(l, arbre, debut, fin - (fin-debut)/2-1);
            construireArbre(l,arbre, fin - (fin-debut)/2+1, fin);    
        }
    }
    
    private void parcourArbre(List<tuple> l){        
        if (!estVide()) {
            racine.fg.parcourArbre(l);
            l.add(new tuple(racine.cle,racine.valeur));
            racine.fd.parcourArbre(l);
        }
        
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
    
        private class tuple {
        K cle;
        V valeur;
        


        public tuple(K cle, V valeur) {
            this.cle = cle;
            this.valeur = valeur;
        }               
    }
}
