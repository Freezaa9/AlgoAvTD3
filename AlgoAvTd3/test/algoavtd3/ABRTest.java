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
        ABR instance = new ABR();
        int expResult = 0;
        int result = instance.nbElem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vider method, of class ABR.
     */
    @Test
    public void testVider() {
        System.out.println("vider");
        ABR instance = new ABR();
        instance.vider();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("estVide");
        ABR instance = new ABR();
        boolean expResult = false;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hauteur method, of class ABR.
     */
    @Test
    public void testHauteur() {
        System.out.println("hauteur");
        ABR instance = new ABR();
        int expResult = 0;
        int result = instance.hauteur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        ABR instance = new ABR();
        instance.equilibrer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
