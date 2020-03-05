/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi;

import org.jalasoft.moi.model.CsharpCompliler;

public class Main {

    public static void main(String[] args) {

        CsharpCompliler file = new CsharpCompliler();
        file.executeCommand();
        //System.out.println("Hello World!!!");
    }
}
