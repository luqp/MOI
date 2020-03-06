/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class defines the controller for the data sent from the endpoint.
 */
@RestController("/")
public class CodeController {

    private ILanguage language;

    /**
     * This method is used for communication between the model and the client.
     * @param language that the user sends as programming language to use
     * @param version of the programming language
     * @param fileName provided by user to its file to be created
     * @param code sent form user as input to be compiled and executed
     * @return the output from the execution
     */
    @RequestMapping(path = "/api/v1/onlineCompiler", method = RequestMethod.PUT, consumes = "application/json")
    public String makeParams(@RequestBody String language, String version, String fileName, String code) {
        File codeFile = new File("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
        try {
            FileWriter codeWriter = new FileWriter("C:\\Users\\Admin\\Documents\\temp\\" + fileName);
            codeWriter.write(code);
            codeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return language.construct(codeFile.getAbsolutePath(), language, version);
    }
}
