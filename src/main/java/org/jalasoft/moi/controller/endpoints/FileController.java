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
import org.jalasoft.moi.domain.FileCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jalasoft.moi.model.core.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
     * @param projectId URL param that points to the project id where the new file will be created
     * @param name inserts the new file name
     * @param code inserts the new file code
     * @return contains the inserted project information
     */
    @PostMapping(path = "/new/project/{projectId}")
    public FileCode addNewFile(@RequestParam(value = "File Name") String name,
                               @RequestParam(value = "Code") String code,
                               @PathVariable Long projectId) throws IOException {
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
}
