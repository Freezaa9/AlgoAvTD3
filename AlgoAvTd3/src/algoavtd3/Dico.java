/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

/**
 *
 * @author Antoine
 * @param <K> Type de la clé
 * @param <V> Type de la valeur
 */
public interface Dico<K, V> {

    /*
     * Si la clé existe deja la valeur est remplacé et l'ancienne est retournée.
     */
    public V ajouter(K cle, V valeur);

    /*
     * Permet de rechercher une valeur associé à la clé passé en paramètre.
     */
    public V rechercher(K cle);

    /*
     * retourne vrais si la clé existe dans le Dico
     * Interet : permet au dico de gerer des données ou null est utilisé.
     */
    public boolean exist(K cle);

    /*
     * Supprimer un couple clé valeur
     * si le noeud supprimé na pas de fils on met sa racine à vide
     * si le noeud supprimé à un fils on le "remonte" d'un cran (gauche ou droit)
     * si le noeud supprimé à deux fils deux possibilitées :
     *   on remonte le plus a droite des petits fils de gauche
     *   on remonte le plus à gauche des petits fils de droite
     * @return la valeur supprimée.
     */
    public V supprimer(K cle);

    /*
     * Méthode récursive qui calcule le nombre d'elements dans le Dico
     */
    public int nbElem();

    /*
     * Vide le dico.
     */
    public void vider();

    /*
     * Retourne si le dico est vide ou pas
     */
    public boolean estVide();

    /*il est possible de rajouter des méthodes pour la partie test : hauteur équilibrer etc ...
     * dans la suite du tp c'est necessaire
     * remarque(antoine) : ces méthodes n'ont à mon avis pas leur place dans l'interface
     *notes: un arbre équilibré est un arbre dons la hauteur des sous arbre varie au plus de 1
     * et dont les sous arbres sont déséquilibrés.
     */
    /*
     *Retourne la hauteur de l'arbre
     *
     */
    public int hauteur();

    /*
     * Indique si larbre est équilibré ou non
     */
    public boolean estEquilibre();

    /*
     * Equilibre l'arbre
     */
    public void equilibrer();
    
    public String toSTring();
}
