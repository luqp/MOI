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
import org.jalasoft.moi.domain.Project;
import org.jalasoft.moi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class defines the project controller.
 *
 * @author Carlos Meneses.
 * @version 1.1
 */
@Controller
@RequestMapping("/project")
@Api(value = "project", description = "Operations pertaining to manage project")
public class ProjectController {

     /**
     * This method get a list of all projects.
     *
     * @return a list of registered projects.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAllProjects(){
        return "//TO DO";
    }

    /**
     * This method get a projects by a id parameter.
     *
     * @param id is the parameter to search a specific projects.
     * @return a projects find by id.
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public String getProjectById(@PathVariable Long id){
        return "//TO DO";
    }

    /**
     * This method insert a new projects in to data base.
     *
     * @param newProject is a project to be added by a post method.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addNewProject(@RequestBody Project newProject){
        return "//TO DO";
    }

    /**
     * This method update a project in to data base.
     *
     * @param updateProject is a project to be updated by a put method.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String updateProject(Project updateProject){
        return "//TO DO";
    }

    /**
     * This method delete a project by the parameter id.
     *
     * @param id is the parameter to be used to delete a project.
     */
    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public String deleteProjectById(@PathVariable Long id){
        return "//TO DO";
    }

}
