/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 *
 */

package org.jalasoft.moi.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute {
    String command;
    String salida;

     /**
     * The contructor recieves the string command
     */
    public Execute(String comm){
        command=comm;
        salida = null;
    }

     /**
     * @return  The output of the console in one string in te form: String1 + \n + String1 + \n + ....
     *
     * The code recieves the command and executes it on cmd
     */
    public String run(){
        StringBuilder builder=new StringBuilder();
        try
        {
            Process proceso = Runtime.getRuntime().exec(command);
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
            if((salida=stdInput.readLine()) != null){
                System.out.println("Comando ejecutado Correctamente");
                while ((salida=stdInput.readLine()) != null){
                    builder.append(salida).append("\n");
                }
            }else{
                System.out.println("No se a producido ninguna salida");
            }
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy! U r Doing Something Wrong ");
            e.printStackTrace();
        }
        salida=builder.toString();
        return salida;
    }
}
