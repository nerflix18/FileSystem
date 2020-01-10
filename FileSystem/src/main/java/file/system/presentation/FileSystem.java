/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.presentation;

import file.system.controllers.ConsultCommandsController;
import file.system.controllers.DirectoryController;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class FileSystem {

    //Root simulation folder
    public final String ROOT = "root";

    //Path to working directory
    public String location;

    //Read User Input
    public Scanner scanner = new Scanner(System.in);

    public FileSystem() {
        this.location = "/";
    }

    public void doShow() {
        boolean exit = false;
        String result = "";
        do {
            System.out.print("$:" + this.location + ">");
            String command = scanner.nextLine();
            switch (command.split(" ")[0]) {
                case "?":
                    result = new ConsultCommandsController().consultCommands();
                    break;
                case "mkdir":
                    result = new DirectoryController().createDir(command.split(" ")[1], ROOT + this.location);
                    break;
                case "ext":
                    exit = true;
                    result = "";
                    break;
                default:
                    result = command.split(" ")[0] + " is not recognized as a command. Check '?' to see all available commands!";
            }
            System.out.println(result);
        } while (!exit);
    }

}
