/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

/**
 *
 * @author Antoine
 */
public class ABR<K, V> {
    
    private Noeud racine;
    
    public ABR(){
        racine = new Noeud();
    }

    private class Noeud<K, V> {
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
