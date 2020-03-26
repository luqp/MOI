/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.endpoints;

import io.swagger.annotations.Api;

import java.io.IOException;

import org.jalasoft.moi.controller.services.FileService;
import org.jalasoft.moi.controller.services.ProcessCache;
import org.jalasoft.moi.domain.FileCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.exceptions.CommandBuildException;
import org.jalasoft.moi.model.exceptions.ParametersException;
import org.jalasoft.moi.model.exceptions.ProcessIDException;
import org.jalasoft.moi.model.exceptions.ResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * This class defines the file controller.
 *
 * @author Carlos Meneses
 *         Diego Perez
 *         Mauricio Oroza
 * @version 1.2
 */
@RestController
@RequestMapping("/file")
@Api(value = "file", description = "Operations pertaining to manage files")
public class FileController {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Autowired
    private FileService fileService;
    @Autowired
    private ProcessCache cache;

    /**
     * Gets a list of all files.
     *
     * @return a list of files
     */
    @GetMapping
    public Iterable<FileCode> getAllFiles() {
        return fileService.getAllFiles();
    }

    /**
     * Gets a file by a id parameter.
     *
     * @param id to search a specific file
     * @return contains a file found by id
     */
    @GetMapping(path = "/{id}")
    public FileCode getFiletById(@PathVariable Long id) {
        LOGGER.info("File id retrieved from URL: {}", id);
        return fileService.getFileById(id);
    }

    /**
     * Inserts a new file in to data base and creates a file inside the project path.
     *
     * @param projectId URL param that points to the project id where the new file will be created
     * @param name inserts the new file name
     * @param code inserts the new file code
     * @return contains the inserted project information
     */
    @PostMapping(path = "/project/{projectId}")
    public FileCode addNewFile(@RequestParam(value = "File Name") String name,
                               @RequestParam(value = "Code") String code,
                               @PathVariable Long projectId) throws IOException {
        LOGGER.info("Project id retrieved from URL: {}", projectId);
        return fileService.addNewFile(name, code, projectId);
    }

    /**
     * Updates a file parameters in the data base and in the prject path.
     *
     * @param id finds a file to be updated
     * @param name updates the file name field
     * @param code updates the file code field
     * @return contains the updated file information
     */
    @PutMapping(path = "/info/{id}")
    public FileCode updateFileInfo(@PathVariable Long id,
                                     @RequestParam(value = "File name") String name,
                                     @RequestParam(value = "Code") String code) throws IOException {
        LOGGER.info("File id retrieved from URL: {}", id);
        return fileService.updateFileInfo(id, name, code);
    }

    /**
     * Deletes a file by the parameter id.
     *
     * @param id to search for the file to delete.
     */
    @DeleteMapping(path = "/{id}")
    public void deleteFileById(@PathVariable Long id) throws IOException {
        fileService.deleteFileInfo(id);
    }

    /**
     * Returns a String that shows the output of the program.
     *
     * @param projectId URL param that points to the project id that will be executed
     * @return the output from the execution
     */
    @PostMapping(path = "/execute/project/{projectId}")
    public String executeCode(@PathVariable Long projectId) throws IOException {
        Handler handler = new Handler(cache);
        Parameters codeParams = fileService.setParams(projectId);
        LOGGER.info("Project id retrieved from URL: {}", projectId);
        HttpServletResponse response = null;
        try {
            return handler.runProgram(codeParams).wrappedResult();
        } catch (ResultException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (CommandBuildException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (ParametersException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        } catch (ProcessIDException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return e.getMessage();
        }
    }
}
