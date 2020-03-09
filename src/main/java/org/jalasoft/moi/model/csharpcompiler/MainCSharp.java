/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.csharpcompiler;

import org.jalasoft.moi.model.Csharp;
import org.jalasoft.moi.model.Language;
import org.jalasoft.moi.model.Params;

import java.nio.file.Paths;

public class MainCSharp {

    public static void main(String[] args) {

        Params params = new Params(Paths.get("C:/Users/Admin/Desktop/csharp/hiworld.cs"), "4.0", Language.CSHARP);
        Csharp compliler = new Csharp();
        System.out.println(compliler.commandBuilder(params));

    }
}
