/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

/**
 *
 * @author Geoffrey
 */
public class AlgoAvTd3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Dico<Integer, String> instance = new ABR<>();
                
        instance.ajouter(5 ,"papier" );
        instance.ajouter(6 ,"papier" );
        instance.ajouter(2 ,"papier" );
        instance.ajouter(1 ,"papier" );
        instance.ajouter(3 ,"papier" );
        instance.ajouter(9 ,"papier" );
        instance.ajouter(7 ,"papier" );

        System.out.println(instance.toSTring());
        
        
        System.out.println("/n ------------------------ /n");
    }
    
}
