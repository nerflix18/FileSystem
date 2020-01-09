/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.presentation;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class FileSystem {

    //Path to working directory
    public String location;

    //Read User Input
    public Scanner scanner = new Scanner(System.in);

    public FileSystem() {
        this.location = "\\";
    }

    public void doShow() {
        boolean exit = false;
        do {
            System.out.print("$:" + this.location + ">");
            String command = scanner.nextLine();
            switch (command.split(" ")[0]) {
                case "ext":
                    exit = true;
                    break;
                default:
                    System.out.println(command.split(" ")[0] + " is not recognized as a command. Check '?' to see all available commands!");
            }
        } while (!exit);
    }

}
