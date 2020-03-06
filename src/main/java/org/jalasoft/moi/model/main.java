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
        String comm1="cmd.exe /c \"cd C:/Users/MauricioOroza/com && javac *.java && java MainClass\"";
        String comm2="help";
        String output;

        Execute buildedcomm=new Execute(comm1);
        output=buildedcomm.run();
        System.out.println(output);
    }
}