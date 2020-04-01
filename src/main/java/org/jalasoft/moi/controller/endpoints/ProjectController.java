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
import org.jalasoft.moi.controller.services.ProjectService;
import org.jalasoft.moi.domain.Project;
import org.jalasoft.moi.model.core.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * Handles the projects CRUD basic operations.
 *
 * @author Carlos Meneses
 *         Mauricio Oroza
 * @version 1.2
 */
@RestController
@RequestMapping(path = "/project")
@Api(value = "project", description = "Operations pertaining to manage projects")
public class ProjectController {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Autowired
    private ProjectService service;

    /**
     * Gets a list of all projects.
     *
     * @return a list of projects
     */
    @GetMapping
    public Iterable<Project> getAllProjects() {
        return service.getAllProjects();
    }

    /**
     * Gets a project by a id parameter.
     *
     * @param id to search a specific project
     * @return contains a project found by id
     */
    @GetMapping(path = "/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return service.getProjectById(id);
    }

    /**
     * Inserts a new project assigned to a user in to data base.
     *
     * @param userId URL param that assign a user the new project being created
     * @param name   inserts the new project name
     * @param desc   inserts the new project description
     * @param lang   inserts the new project language
     *
     * @return contains the inserted project information
     */
    @PostMapping(path = "/new/user/{userId}")
    public Project addNewProject(@PathVariable Long userId,
                                 @RequestParam(value = "Project Name") String name,
                                 @RequestParam(value = "Description", required = false) String desc,
                                 @RequestParam(value = "Language") String lang) {
        return service.addNewProject(name, desc, lang, userId);
    }

    /**
     * Updates a user information in the data base.
     *
     * @param id finds a user to be updated
     * @param name updates the project name field
     * @param desc updates the project description field
     * @return contains the updated user information
     */
    @PutMapping(path = "/info/{id}")
    public Project updateProjectInfo(@PathVariable Long id,
                                     @RequestParam(value = "Project name") String name,
                                     @RequestParam(value = "Description", required = false) String desc) {
        return service.updateProjectInfo(id, name, desc);
    }

    /**
     * Deletes a project by the parameter id.
     *
     * @param id to search for the project to delete.
     */
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProjectById(@PathVariable Long id) {
        service.deleteProject(id);
    }

}
