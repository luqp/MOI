package org.jalasoft.moi.model.python;

import java.nio.file.Paths;

public class Program {

    public static void main(String[] args) {
        PythonExecutor python = new PythonExecutor(Paths.get("H:/hello.py"));
        python.compile();
        python.run();
    }
}
