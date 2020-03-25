/**
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

import org.jalasoft.moi.model.core.Handler;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class defines the file controller.
 *
 * @author Carlos Meneses
 *         Mauricio Oroza
 * @version 1.2
 */
@RestController
@RequestMapping("/file")
@Api(value = "file", description = "Operations pertaining to manage files")
public class FileController {

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
        return fileService.getFileById(id);
    }

    /**
     * Inserts a new file in to data base and creates a file inside the project path.
     *
     * @param name inserts the new file name
     * @param code inserts the new file code
     * @param projectId assigns a user the new project
     * @return contains the inserted project information
     */
    @PostMapping(path = "/project/{projectId}")
    public FileCode addNewFile(@RequestParam(value = "File Name") String name,
                               @RequestParam(value = "Code") String code,
                               @PathVariable Long projectId) throws IOException {
        System.out.println(projectId);
        fileService.saveFileB64(name, code, projectId);
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
                                   @RequestParam(value = "Code") String code) {
        return fileService.updateFileInfo(id, name, code);
    }

    /**
     * Deletes a file by the parameter id.
     *
     * @param id to search for the file to delete.
     */
    @DeleteMapping(path = "/{id}")
    public void deleteFileById(@PathVariable Long id) {
        fileService.deleteFile(id);
    }

    /**
     * Returns a String that shows the output of the program.
     *
     * @return the output from the execution
     */
    @PostMapping(path = "/execute")
    public String executeCode(@RequestParam(value = "Project Id") Long projectID) {
        Handler handler = new Handler(cache);
        Parameters codeParams = fileService.setParams(projectID);
        return handler.runProgram(codeParams).wrappedResult();
    }
}
