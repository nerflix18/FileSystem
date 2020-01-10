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

    public String createDir(String path_to_dir, String path_working_dir) {
        return service.createDir(path_working_dir + path_to_dir).getResult();
    }

}
