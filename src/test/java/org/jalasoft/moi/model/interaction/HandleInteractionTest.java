package org.jalasoft.moi.model.interaction;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleInteractionTest {

    @Test
    public void userInteractionTest() {
        inputTest();
        secondInputTest();
    }

    public void inputTest() {
        String expected = "Insert number\r\n> ";
        String result;

        ICommandBuilder commandBuilder = Language.PYTHON_32.getCommandBuilder();
        String command = commandBuilder.buildCommand(Paths.get("H:\\MOI\\thirdparty\\python\\local\\askInputTest.py"));
        Executer executer = new Executer(command);

        try {
            result = executer.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            result = e.getMessage();
        }

        assertEquals(expected, result);
    }

    public void secondInputTest() {

    }
}
