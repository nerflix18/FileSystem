/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.services;

import file.system.domain.Command;
import file.system.domain.Operation;
import java.io.File;

/**
 *
 * @author Daniel
 */
public class DirectoryService {

    public Operation createDir(String path_to_dir) {
        boolean result = new File(path_to_dir).mkdirs();
        if (result) {
            return new Operation(new Command("mkdir", "Create Directory"), "Directory created", result);
        } else {
            return new Operation(new Command("mkdir", "Create Directory"), "Directory already exists", result);
        }
    }

}
