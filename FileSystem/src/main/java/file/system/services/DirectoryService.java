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

    /**
     * Create Directory
     *
     * @param path_to_dir string with path to where new directory will be
     * created
     * @return operation with directory success/falied creation
     */
    public Operation createDir(String path_to_dir) {
        boolean result = new File(path_to_dir).mkdirs();
        if (result) {
            return new Operation(new Command("mkdir", "Create Directory"), "Directory created", result);
        } else {
            return new Operation(new Command("mkdir", "Create Directory"), "Directory already exists", result);
        }
    }

    /**
     * Delete Directory
     *
     * @param path_to_dir string with path to where new directory will be
     * deleted
     * @return operation with directory success/falied elimination
     */
    public Operation delete(String path_to_dir) {
        File dir = new File(path_to_dir);
        if (dir.exists() && dir.isDirectory()) {
            if (isEmpty(dir)) {
                dir.delete();
                return new Operation(new Command("rmdir", "Delete Directory"), "Directory deleted", true);
            } else {
                return new Operation(new Command("rmdir", "Delete Directory"), "Directory isnt' empty", false);
            }
        } else {
            return new Operation(new Command("rmdir", "Delete Directory"), "Directory doesn't exists", false);
        }
    }

    /**
     * Check file is empty
     *
     * @param dir file to check
     * @return true if file is empty and false otherwise
     */
    private boolean isEmpty(File dir) {
        return dir.list().length == 0;
    }

}
