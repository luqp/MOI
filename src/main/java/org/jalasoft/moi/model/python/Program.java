/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.python;

import java.nio.file.Paths;

public class Program {

    public static void main(String[] args) {
        PythonExecutor python = new PythonExecutor(Paths.get("H:/hello.py"));
        python.compile();
        python.run();
    }
}
