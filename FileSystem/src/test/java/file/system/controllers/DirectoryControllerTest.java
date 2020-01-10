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

    private DirectoryController ctrl;

    public DirectoryControllerTest() {
        ctrl = new DirectoryController();
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
        String expResult = "Directory created";
        String result = ctrl.createDir(path_to_dir, path_working_dir);
        ctrl.deleteDir(path_to_dir, path_working_dir);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteDir method, of class DirectoryController.
     */
    @Test
    public void testDeleteDir() {
        System.out.println("deleteDir");
        String path_to_dir = "dir_test_ctrl";
        String path_working_dir = ROOT_TEST;
        String expResult = "Directory deleted";
        ctrl.createDir(path_to_dir, path_working_dir);
        String result = ctrl.deleteDir(path_to_dir, path_working_dir);
        assertEquals(expResult, result);
    }

    /**
     * Test of createFile method, of class DirectoryController.
     */
    @Test
    public void testCreateFile() {
        System.out.println("createFile");
        String path_to_file = "file_test_ctrl";
        String path_working_dir = ROOT_TEST;
        String expResult = "Create file";
        String result = ctrl.createFile(path_to_file, path_working_dir);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteFile method, of class DirectoryController.
     */
    @Test
    public void testDeleteFile() {
        System.out.println("testDeleteFile");
        String path_to_file = "file_test_ctrl";
        String path_working_dir = ROOT_TEST;
        String expResult = "File deleted";
        ctrl.createFile(path_to_file, path_working_dir);
        String result = ctrl.deleteFile(path_to_file, path_working_dir);
        assertEquals(expResult, result);
    }

}
