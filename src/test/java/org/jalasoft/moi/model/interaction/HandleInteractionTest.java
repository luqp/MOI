package org.jalasoft.moi.model.interaction;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.jalasoft.moi.model.core.*;
import org.jalasoft.moi.model.core.parameters.InputParams;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.utils.Constant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleInteractionTest {

    private static Cache<Long, Process> loaderProcess;

    @BeforeAll
    static void initAll() {
        loaderProcess = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(3, TimeUnit.MINUTES)
                .build();
    }

    @Test
    public void userInteractionTest() {

        Params params = new Params();
        params.setLanguage(Language.PYTHON_32);
        params.setFilesPath(Paths.get(Constant.ROOTPATH.getValue() + "\\thirdparty\\python\\local\\askInputTest.py"));

        Result result = inputTest(params);

        InputParams input = new InputParams();
        input.setProcessPid(result.getPid());
        input.setInput("2");

        secondInputTest(input);
    }

    public Result inputTest(Params params) {
        String expected = "Insert number\r\n> ";
        Result result;

        ICommandBuilder commandBuilder = params.getLanguage().getCommandBuilder();
        String command = commandBuilder.buildCommand(params.getFilesPath());
        Executer executer = new Executer(command);

        try {
            result = executer.run();
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result();
            result.setResult(e.getMessage());
            result.setPid(0);
        }

        assertEquals(expected, result.getResult());
        return result;
    }

    public void secondInputTest(InputParams input) {
        String expected = "Insert number\r\n> ";
        Executer executer = new Executer("");
        Result result;
        try {
             result = executer.setInput(input);
        } catch (IOException e) {
            e.printStackTrace();
            result = new Result();
            result.setResult(e.getMessage());
            result.setPid(0);
        }

        assertEquals(expected, result.getResult());
    }
}
