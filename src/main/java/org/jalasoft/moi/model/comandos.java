/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
*/

package org.jalasoft.moi.model;
import java.io.*;
public class comandos {
    public static void main(String[] args) {

        String salida = null;
        //String inicioCmd = "cmd /c ";
        //String comando = "help dir";
        //String all = inicioCmd + comando;

        try{
            // Ejecucion Basica del Comando
            //Process proceso = Runtime.getRuntime().exec("cmd");
            Process proceso=Runtime.getRuntime().exec(new String[] {"cmd", "/c", "help", "dir"});

            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"help && dir\"");
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
            //Si el comando tiene una salida la mostramos
            if((salida=stdInput.readLine()) != null){
                System.out.println("Comando ejecutado Correctamente");
                while ((salida=stdInput.readLine()) != null){
                    System.out.println(salida);
                }
            }else{
                System.out.println("No se a producido ninguna salida");
            }
        }catch (IOException e) {
            System.out.println("Excepción: ");
            e.printStackTrace();
        }
    }
}