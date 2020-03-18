package org.jalasoft.moi.model.interaction;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.Language;
import org.jalasoft.moi.model.core.ICacheProvider;
import org.jalasoft.moi.model.core.parameters.Answer;
import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.core.parameters.ProcessResult;
import org.jalasoft.moi.model.core.parameters.Result;
import org.jalasoft.moi.model.utils.Constant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleInteractionTest {

    private static ProcessCacheTest processCache;

    @BeforeAll
    static void initAll() {
        processCache = new ProcessCacheTest();
    }

    @ParameterizedTest
    @CsvSource({
            "1", "15", "999"
    })
    public void OneUserInputTest(String userInput) {
        String expected = "Insert number\r\n> ";
        Params params = new Params();
        params.setLanguage(Language.PYTHON_32);
        params.setFilesPath(Paths.get(Constant.ROOTPATH.getValue() + "\\thirdparty\\python\\local\\AskInputTest.py"));

        Result result = buildResult(params);
        assertEquals(expected, result.getValue());

        InputParameters input = new Answer();
        input.setProcessPid(result.getPid());
        input.setValue(userInput);
        expected = "your number is: " + input.getValue() + "\r\n";

        result = buildResultWithInput(input);
        assertEquals(expected, result.getValue());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "15, 4, 19",
            "999, 100, 1099"
    })
    public void SumTwoUserInputsTest(String number1, String number2, String sum) {
        ICacheProvider cache = processCache;
        Params params = new Params();
        params.setLanguage(Language.PYTHON_32);
        params.setFilesPath(Paths.get(Constant.ROOTPATH.getValue() + "\\thirdparty\\python\\local\\SumInputsTest.py"));
        String expected = "Insert number1\r\n> ";

        Result result = buildResult(params);
        assertEquals(expected, result.getValue());

        InputParameters input = new Answer();
        input.setProcessPid(result.getPid());
        input.setValue(number1);
        expected = "Insert number2\r\n> ";

        result = buildResultWithInput(input);
        assertEquals(expected, result.getValue());

        input = new Answer();
        input.setProcessPid(result.getPid());
        input.setValue(number2);
        expected = "Sum: " + sum + "\r\n";

        result = buildResultWithInput(input);
        assertEquals(expected, result.getValue());
    }

    public Result buildResult(Params params) {
        ICommandBuilder commandBuilder = params.getLanguage().getCommandBuilder();
        String command = commandBuilder.buildCommand(params.getFilesPath());
        Executer executer = new Executer(processCache);
        Result result;
        try {
            result = executer.execute(command);
        } catch (IOException e) {
            e.printStackTrace();
            result = new ProcessResult();
            result.setValue(e.getMessage());
            result.setPid(0);
        }
        return result;
    }

    public Result buildResultWithInput(InputParameters input) {
        Executer executer = new Executer(processCache);
        Result result;
        try {
            result = executer.processAnswer(input);
        } catch (IOException e) {
            e.printStackTrace();
            result = new ProcessResult();
            result.setValue(e.getMessage());
            result.setPid(0);
        }

        return result;
    }
}
