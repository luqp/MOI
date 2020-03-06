/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package org.jalasoft.moi.model.csharpcompiler;

public class MainCSharp {

    public static void main(String[] args) {

        CsharpCompliler compliler = new CsharpCompliler("C:\\Users\\Admin\\IdeaProjects\\com\\csharp\\hiworld.cs");
        compliler.executeCommand();
    }
}
