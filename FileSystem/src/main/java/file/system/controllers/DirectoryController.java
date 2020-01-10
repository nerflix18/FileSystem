/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.controllers;

import file.system.services.DirectoryService;

/**
 *
 * @author Daniel
 */
public class DirectoryController {

    private DirectoryService service = new DirectoryService();

    /**
     * Create Directory
     *
     * @param path_to_dir relative path to directory
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String createDir(String path_to_dir, String path_working_dir) {
        return service.createDir(path_working_dir + path_to_dir).getResult();
    }

    /**
     * Delete Directory
     *
     * @param path_to_dir relative path to directory
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String deleteDir(String path_to_dir, String path_working_dir) {
        return service.delete(path_working_dir + path_to_dir).getResult();
    }

    /**
     * Create File
     *
     * @param path_to_dir relative path to directory
     * @param path_working_dir absolute path to working directory
     * @return string with result of operation
     */
    public String createFile(String path_to_dir, String path_working_dir) {
        return service.createFile(path_working_dir + path_to_dir).getResult();
    }

}
