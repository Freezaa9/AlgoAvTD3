/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antoine
 */
public class ABRTest {
    
    public ABRTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class ABR.
     */
    @Test
    public void testAjouterExist() {
        System.out.println("ajoutet et exist");
        Integer cle = 1;
        String valeur = "pizza";
        Dico<Integer, String> instance = new ABR<>();
        instance.ajouter(cle, valeur);
        assertEquals(instance.exist(cle), true);
    }

        /**
     * Test of rechercher method, of class ABR.
     */
    @Test
    public void testAjouterRechercher() {
        System.out.println("ajouter et rechercher");
        Integer cle = 1;
        String valeur = "pizza";
        Dico<Integer, String> instance = new ABR<>();
        instance.ajouter(cle, valeur);
        assertEquals(instance.rechercher(cle), valeur);
    }
    
    /**
     * Test of nbElem method, of class ABR.
     */
    @Test
    public void testNbElem() {
        System.out.println("nbElem");
        Dico<Integer, Integer> a = new ABR<>();
        int expResult = 0;
        int result = a.nbElem();
        assertEquals(expResult, result);
        
        a.ajouter(1, 1);
        a.ajouter(0,0);
        a.ajouter(2,2);
       
        expResult = 3;
        result = a.nbElem();
        assertEquals(expResult, result);
    }

    /**
     * Test of vider method, of class ABR.
     */
    @Test
    public void testVider() {
        System.out.println("nbElem");
        Dico<Integer, Integer> a = new ABR<>();
        int expResult = 0;
        int result = a.nbElem();
        assertEquals(expResult, result);
        
        a.ajouter(1, 1);
        a.ajouter(0,0);
        a.ajouter(2,2);
       
        expResult = 3;
        result = a.nbElem();
        assertEquals(expResult, result);
        
        a.vider();
        expResult = 0;
        result = a.nbElem();
        assertEquals(expResult, result);
    }

    /**
     * Test of supprimer method, of class ABR.
     */
    @Test
    public void testAjouterSupprimer() {
        System.out.println("ajouter et supprimer");
        Integer cle = 1;
        String valeur = "pizza";
        Dico<Integer, String> instance = new ABR<>();
        instance.ajouter(cle,valeur);
        assertEquals(instance.supprimer(cle), "pizza");
        assertEquals(instance.supprimer(cle),null);
    }

    /**
     * Test of estVide method, of class ABR.
     */
    @Test
    public void testEstVide() {
        System.out.println("nbElem");
        Dico<Integer, Integer> a = new ABR<>();
        
        a.ajouter(1, 1);
        a.ajouter(0,0);
        a.ajouter(2,2);
       
        
        assertFalse(a.estVide());
        
        a.vider();
        
        assertTrue(a.estVide());

    }

    /**
     * Test of hauteur method, of class ABR.
     */
    @Test
    public void testHauteur() {
        System.out.println("nbElem");
        Dico<Integer, Integer> a = new ABR<>();
        
        int expResult = 0;
        assertEquals(a.hauteur(), expResult);
        
        a.ajouter(1, 1);
        a.ajouter(0,0);
        a.ajouter(2,2);
        
        expResult = 2;
        assertEquals(a.hauteur(), expResult);
        
        a.ajouter(3,2);
        
        expResult = 3;
        assertEquals(a.hauteur(), expResult);
        
    }

    /**
     * Test of estEquilibre method, of class ABR.
     */
    @Test
    public void testEstEquilibre() {
        System.out.println("estEquilibre");
        ABR instance = new ABR();
        boolean expResult = false;
        boolean result = instance.estEquilibre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equilibrer method, of class ABR.
     */
    @Test
    public void testEquilibrer() {
        System.out.println("equilibrer");
        //création d'un arbre
        Integer cle = 1;
        String valeur = "pizza";
        Dico<Integer, String> instance = new ABR<>();
        instance.ajouter(cle, valeur);
        
        
        instance.ajouter(2 ,"papier" );
        instance.ajouter(3 ,"papier" );
        instance.ajouter(4 ,"papier" );
        instance.ajouter(5 ,"papier" );
        instance.ajouter(6 ,"papier" );
        instance.ajouter(7 ,"papier" );
        instance.ajouter(8 ,"papier" );
        instance.ajouter(9 ,"papier" );
        
        System.out.println("hauteur avant : " + instance.hauteur());
        
        instance.equilibrer();
        
        System.out.println("hauteur après : " + instance.hauteur());
        //assertEquals(instance.exist(cle), true);
        
    }
    
}
