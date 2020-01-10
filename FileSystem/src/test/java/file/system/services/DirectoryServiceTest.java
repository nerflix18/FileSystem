/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.services;

import file.system.domain.Command;
import file.system.domain.Operation;
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
public class DirectoryServiceTest {

    private final String ROOT_TEST = "rootTest/";

    private DirectoryService srv;

    public DirectoryServiceTest() {
        srv = new DirectoryService();
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
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir() {
        System.out.println("testCreateDir");
        String path_to_dir = ROOT_TEST + "dir_test";
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory created", true);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }
    
    /**
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir_in_subfolders() {
        System.out.println("testCreateDir_in_subfolders");
        String path_to_dir = ROOT_TEST + "dir_test_sub";
        srv.createDir(path_to_dir);
        path_to_dir = ROOT_TEST + "dir_test_sub/" + "dir_test_sub_sub";
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory created", true);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        srv.delete(ROOT_TEST + "dir_test_sub");
        assertEquals(expResult.getResult(), result.getResult());
    }
    
    /**
     * Test of createDir method, of class DirectoryService.
     */
    @Test
    public void testCreateDir_when_dir_exists() {
        System.out.println("testCreateDir_when_dir_exists");
        String path_to_dir = ROOT_TEST + "dir_test_ext";
        srv.createDir(path_to_dir);
        Operation expResult = new Operation(new Command("mkdir", "Create Directory"), "Directory already exists", false);
        Operation result = srv.createDir(path_to_dir);
        srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete() {
        System.out.println("testDelete");
        String path_to_dir = ROOT_TEST + "dir_test_rm";
        srv.createDir(path_to_dir);
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory deleted", true);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }
    
    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete_non_exist_dir() {
        System.out.println("testDelete_non_exist_dir");
        String path_to_dir = ROOT_TEST + "dir_test_rm";
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory doesn't exists", true);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

    /**
     * Test of delete method, of class DirectoryService.
     */
    @Test
    public void testDelete_non_empty_dir() {
        System.out.println("testDelete_non_empty_dir");
        String path_to_dir = ROOT_TEST + "sys";
        Operation expResult = new Operation(new Command("rmdir", "Delete Directory"), "Directory isnt' empty", true);
        Operation result = srv.delete(path_to_dir);
        assertEquals(expResult.getResult(), result.getResult());
    }

}
