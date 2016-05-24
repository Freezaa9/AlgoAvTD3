/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

import java.util.ArrayList;
import java.util.List;

/*
 * <h1>{@code ABR} - Abstraction d'un arbre</h1>
 * <p>
 * Cette classe encapsule les propriétés et les comportements propres à la
 * classe {@code ABR}</p>
 *
 *
 *
 * @author Antoine DROUHIN, Aurélien GARRET & Geoffrey HARRAZI
 * @param <K>
 * @param <V>
 */
public class ABR<K extends Comparable, V> implements Dico<K, V> {

    /**
     * Noeud qui est la racine de cette arbre
     */
    private Noeud racine;

    /**
     * Ajouter un élément une combinaison clé, valeur dans le Dico.
     *
     * @param cle La clé a laquelle la valeur doit être inserer.
     * @param valeur la valeur à inserer.
     * @return La valeur remplacé si elle existe, null sinon
     */
    @Override
    public V ajouter(K cle, V valeur) {
        if (estVide()) {
            racine = new Noeud(cle, valeur);
            return null;
        }
        if (cle.compareTo(racine.cle) == 0) {
            V tmpValeur = (V) racine.valeur;
            racine.valeur = valeur;
            return tmpValeur;
        }
        if (cle.compareTo(racine.cle) <= 0) {
            return (V) racine.fg.ajouter(cle, valeur);
        }

        return (V) racine.fd.ajouter(cle, valeur);
    }

    /**
     * Retourne le nombre d'élément de l'arbre
     *
     * @return le nombre d'élément de l'arbre
     */
    @Override
    public int nbElem() {
        if (this.estVide()) {
            return 0;
        }
        return racine.fg.nbElem() + racine.fd.nbElem() + 1;
    }

    /**
     * Vide l'arbre
     *
     */
    @Override
    public void vider() {
        racine = null;
    }

    /**
     * Recherche une valeur par rappord à sa clef
     *
     * @param cle
     * @return V valeur correspondant à la clef
     */
    @Override
    public V rechercher(K cle) {
        if (estVide()) {
            return null;
        }
        if (cle.compareTo(racine.cle) == 0) {
            return racine.valeur;
        }
        if (cle.compareTo(racine.cle) < 0) {
            return racine.fg.rechercher(cle);
        } else {
            return racine.fd.rechercher(cle);
        }
    }

    /**
     * indique si un noeud existe par rappord à sa clef
     *
     * @param cle
     * @return boolean existe ou non
     */
    @Override
    public boolean exist(K cle) {
        if (estVide()) {
            return false;
        }

        if (cle.compareTo(racine.cle) == 0) {
            return true;
        }

        if (cle.compareTo(racine.cle) < 0) {
            return racine.fg.exist(cle);
        } else {
            return racine.fd.exist(cle);
        }
    }

    /**
     * Supprime un noeud par rappord à sa clef
     *
     * @param cle
     * @return V la valeur de la clef supprimer
     */
    @Override
    public V supprimer(K cle) {
        if (estVide()) {
            return null;
        }

        if (cle.compareTo(racine.cle) == 0) {
            V valCourante = racine.valeur;
            if (!racine.fd.estVide()) {
                Noeud plusPetitNoeud = racine.fd.supprimerPlusPetitNoeud();
                racine.cle = plusPetitNoeud.cle;
                racine.valeur = plusPetitNoeud.valeur;
            } else {
                racine = racine.fg.racine;
            }
            return valCourante;

        }
        if (cle.compareTo(racine.cle) < 0) {
            return racine.fg.supprimer(cle);
        } else {
            return racine.fd.supprimer(cle);
        }
    }

    private Noeud supprimerPlusPetitNoeud() {
        if (racine.fg.estVide()) {
            Noeud n = racine;
            racine = null;
            return n;
        } else {
            return racine.fg.supprimerPlusPetitNoeud();
        }
    }

    /**
     * Indique si l'arbre est vide
     *
     * @return boolean : si l'arbre est vide ou non
     */
    @Override
    public boolean estVide() {
        return racine == null;
    }

    /**
     * Indique la hauteur de l'arbre
     *
     * @return int: retourne la hauteur de l'arbre
     */
    @Override
    public int hauteur() {
        if (racine == null) {
            return 0;
        }
        return 1 + Math.max(racine.fg.hauteur(), racine.fd.hauteur());
    }

    /**
     * Indique si l'arbre est equilibré
     *
     * @return boolean : si l'arbre est equilibé ou non
     */
    @Override
    public boolean estEquilibre() {
        if (estVide()) {
            return true;
        }
        if (Math.abs(racine.fg.hauteur() - racine.fd.hauteur()) > 1) {
            return false;
        }
        return racine.fg.estEquilibre() && racine.fd.estEquilibre();
    }

    /**
     * Cette fonction equilibre l'arbre
     */
    @Override
    public void equilibrer() {
        if (!estEquilibre()) {
            // Mettre dans un tableau
            List<tuple> l = new ArrayList<>(nbElem());
            parcourArbre(l);
            // Utiliser la valeur du milieu comme racine
            racine = null;
            construireArbre(l, this, 0, l.size() - 1);
        }
    }

    private void construireArbre(List<tuple> l, ABR arbre, int debut, int fin) {

        if (fin == debut) {
            arbre.ajouter(l.get(debut).cle, l.get(debut).valeur);
        } else if (fin == debut + 1) {
            arbre.ajouter(l.get(debut).cle, l.get(debut).valeur);
            arbre.ajouter(l.get(fin).cle, l.get(fin).valeur);
        } else if (fin > debut + 1) {
            arbre.ajouter(l.get(fin - (fin - debut) / 2).cle, l.get(fin - (fin - debut) / 2).valeur);
            construireArbre(l, arbre, debut, fin - (fin - debut) / 2 - 1);
            construireArbre(l, arbre, fin - (fin - debut) / 2 + 1, fin);
        }
    }

    private void parcourArbre(List<tuple> l) {
        if (!estVide()) {
            racine.fg.parcourArbre(l);
            l.add(new tuple(racine.cle, racine.valeur));
            racine.fd.parcourArbre(l);
        }

    }

//    private StringBuilder toStringWrapper(StringBuilder sB) {
//        if (!estVide()) {
//            racine.fg.toStringWrapper(sB);
//            sB.append(racine.cle + "=" + racine.valeur+"\n");
//            racine.fd.toStringWrapper(sB);
//        }
//        return sB;
//    }
    private StringBuilder toStringWrapper(ABR arbre, StringBuilder sB, int c) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < c; i++) {
            tab.append("	");
        }
        if (arbre.estVide()) {
            sB.append("Vide\n");

        } else {
            sB.append(arbre.racine.cle).append("=").append(arbre.racine.valeur).append("\n");
            c++;
            if (!(arbre.racine.fg.estVide() && arbre.racine.fd.estVide())) {
                sB.append(tab.toString());
                sB.append("|-");
                sB = toStringWrapper(arbre.racine.fg, sB, c);
                sB.append(tab.toString());
                sB.append("|+");
                sB = toStringWrapper(arbre.racine.fd, sB, c);
            }

        }
        return sB;
    }

    @Override
    public String toSTring() {
        StringBuilder sB = new StringBuilder();
        sB = toStringWrapper(this, sB, 0);
        return sB.toString();
    }

    /*
     * <h1>{@code Noeud} - Abstraction d'un Noeud</h1>
     * <p>
     * Cette classe encapsule les propriétés et les comportements propres à la
     * classe {@code Noeud}</p>
     *
     *
     *
     * @author Antoine DROUHIN, Aurélien GARRET & Geoffrey HARRAZI
     * @param <K>
     * @param <V>
     * @param ABR<K, V> fg
     * @param ABR<K, V> fd
     */
    private class Noeud {
        /*
         * K clef du noeud
         */

        K cle;
        /*
         * V valeur contenu par le noeud
         */
        V valeur;
        /*
         * Sous arbre gauche du noeud
         */
        ABR<K, V> fg; // ne doit jamais être null (et pas testé == null) !!
        // L'arbre peut etre vide mais jamais null

        /*
         * Sous arbre droit du noeud
         */
        ABR<K, V> fd; // ne doit jamais être null (et pas testé == null) !!
        // Ne pas confondre vide et n'existe pas
        // un arbre vide existe mais à une racine == null

        /*
         * Sous arbre droit du noeud
         *@param K cle 
         *@param V valeur
         */
        public Noeud(K cle, V valeur) {
            this.fg = new ABR<>();
            this.fd = new ABR<>();
            this.cle = cle;
            this.valeur = valeur;
        }
    }

    /*
     * <h1>{@code tuple} - Abstraction d'un tuple</h1>
     * <p>
     * Cette classe encapsule les propriétés et les comportements propres à la
     * classe {@code tuple}</p>
     *
     *
     *
     * @author Antoine DROUHIN, Aurélien GARRET & Geoffrey HARRAZI
     * @param <K>
     * @param <V>
     */
    private class tuple {
        /*
         * K clef contenu par le noeud
         */

        K cle;
        /*
         * V valeur contenu par le noeud
         */
        V valeur;

        public tuple(K cle, V valeur) {
            this.cle = cle;
            this.valeur = valeur;
        }
    }
}
