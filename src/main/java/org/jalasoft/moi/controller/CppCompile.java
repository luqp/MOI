/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import java.io.*;
import java.util.Scanner;

public class CppCompile {

    // Constants
    private static String CPPCOMPILERPATH = "C:\\MinGW\\bin\\";
    private static String FILENAME = "test";
    private static String FILEPATH = "C:\\AWT5\\IDEOnline\\MOI\\resources\\files\\";
    private static String CPPCOMPILECOMMAND = "c++.exe ";
    private static String RESULTOUTPUTFILE = "test.txt";

    /**
     * C++ Main Method
     * @param args
     */
    public static void main(String[] args) {
        try {
            String actualPath = System.getProperty("user.dir");
            String compileCommands = "cmd /c " +
                                    "cd " + CPPCOMPILERPATH +
                                    " && " + CPPCOMPILECOMMAND + FILEPATH + FILENAME + ".cpp" +
                                    " -o " + FILEPATH + FILENAME + ".exe" +
                                    " && cd " + actualPath +
                                    " && "  + FILEPATH + FILENAME + ".exe > " + FILEPATH + RESULTOUTPUTFILE;
            System.out.println(compileCommands);
            Process process = Runtime.getRuntime().exec(compileCommands);
            System.out.println(process);
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method read and print a file
     */
    private static void readFile(){
        try {
            File myObj = new File(FILEPATH + RESULTOUTPUTFILE);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
