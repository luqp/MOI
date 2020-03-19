package org.jalasoft.moi.model.interaction;

import org.jalasoft.moi.model.core.Executer;
import org.jalasoft.moi.model.core.ICacheProvider;
import org.jalasoft.moi.model.core.ICommandBuilder;
import org.jalasoft.moi.model.core.parameters.InputParameters;
import org.jalasoft.moi.model.core.parameters.Params;
import org.jalasoft.moi.model.core.parameters.ProcessResult;
import org.jalasoft.moi.model.core.parameters.Result;

import java.io.IOException;

public class Builder {

    private ICacheProvider processCache;

    public Builder(ICacheProvider processCache) {

        this.processCache = processCache;
    }

    public Result createExecution(Params params) {
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
