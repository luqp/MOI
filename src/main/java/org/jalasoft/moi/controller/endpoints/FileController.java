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
import org.jalasoft.moi.domain.FileCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class defines the file controller.
 *
 * @author Carlos Meneses
 *         Lucero Quiroga Perez
 * @version 1.1
 */
@Controller
@RequestMapping("/file")
@Api(value = "file", description = "Operations pertaining to manage files")
public class FileController {

    /**
     * This method get a list of all files.
     *
     * @return a list of all saved files
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAllFiles(){
        return "//TO DO";
    }

    /**
     * This method get a file by a id parameter.
     *
     * @param id is the parameter to search a specific file
     * @return a file find by id
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public String getFileById(@PathVariable Long id){
        return "//TO DO";
    }

    /**
     * This method update a File code and File name.
     *
     * @param updateFile is a file to be updated by a put method
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String updateFile(FileCode updateFile){
        return "//TO DO";
    }

    /**
     * This method delete a File by the parameter id.
     *
     * @param id is the parameter to be used to delete a File
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public String deleteFileById(@PathVariable Long id){
        return "//TO DO";
    }
}
