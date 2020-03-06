/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
*/

package org.jalasoft.moi.model;

public class main {
    public static void main(String[] arg){
        System.out.println("Estoy en al main 1");
        try
        {
            // We are running "cd", "complile" and "run" commands on cmd
            // /K : Carries out command specified by string
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd C:/Users/MauricioOroza/com && javac *.java && java MainClass\"");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
}