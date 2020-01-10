/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.services;

import file.system.domain.Command;
import file.system.domain.Operation;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    /**
     * Create Empty File
     *
     * @param path_to_file string with path to where new file will be created
     * @return operation with file success/falied creation
     */
    public Operation createFile(String path_to_file) {
        try {
            boolean result = new File(path_to_file).createNewFile();
            if (result) {
                return new Operation(new Command("nano", "Create File"), "Create file", result);
            } else {
                return new Operation(new Command("nano", "Create File"), "File already exists", result);
            }
        } catch (IOException ex) {
            return new Operation(new Command("nano", "Create File"), "Failed to locate file", false);
        }
    }

    /**
     * Delete File
     *
     * @param path_to_file string with path to where file will be deleted
     * @return operation with file success/falied elimination
     */
    public Operation deleteFile(String path_to_file) {
        File file = new File(path_to_file);
        if (file.exists() && file.isFile()) {
            file.delete();
            return new Operation(new Command("rmdir", "Delete File"), "File deleted", true);
        } else {
            return new Operation(new Command("rmdir", "Delete File"), "File doesn't exists", false);
        }
    }

    public Operation moveFile(String path_to_file_source, String path_to_file_dest) {
        File file_source = new File(path_to_file_source);
        if (file_source.isFile() && file_source.exists()) {
            if (file_source.renameTo(new File(path_to_file_dest))) {
                file_source.delete();
                return new Operation(new Command("mv", "Move File"), "File moved", true);
            } else {
                return new Operation(new Command("mv", "Move File"), "Failed to move file", false);
            }
        } else {
            return new Operation(new Command("mv", "Move File"), "Failed to move, because is a directory", false);
        }
    }

}
