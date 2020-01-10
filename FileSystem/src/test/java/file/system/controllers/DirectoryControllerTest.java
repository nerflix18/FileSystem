/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class DirectoryControllerTest {
    
    private final String ROOT_TEST = "rootTest/";
    
    public DirectoryControllerTest() {
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
     * Test of createDir method, of class DirectoryController.
     */
    @Test
    public void testCreateDir() {
        System.out.println("testCreateDir");
        String path_to_dir = "dir_test_ctrl";
        String path_working_dir = ROOT_TEST;
        DirectoryController instance = new DirectoryController();
        String expResult = "Directory created";
        String result = instance.createDir(path_to_dir, path_working_dir);
        assertEquals(expResult, result);
    }
    
}
