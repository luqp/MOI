package org.jalasoft.moi.model.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PythonExecutor {
    private Path path;

    public PythonExecutor(Path path) {
        this.path = path;
    }

    public void compile() {
        try {
            Process process = Runtime.getRuntime().exec("python -m compileall " + path.toString());
            System.out.println(process.waitFor());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String fileName = path.getFileName().toString().replace(".py", "");
        try {
            Path pathRun = Paths.get(path.getRoot() + "__pycache__/" + fileName + ".cpython-37.pyc");
            Process process = Runtime.getRuntime().exec("python " + pathRun);
            InputStream inputStream = process.getInputStream();
            InputStreamReader input = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(input);
            String line = null;
            System.out.println("<OUTPUT>");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            System.out.println("</OUTPUT>");
            System.out.println(process.waitFor());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
