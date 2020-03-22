/**
 * Copyright (c) 2020 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.controller.repository.ProjectRepository;
import org.jalasoft.moi.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides to project controller the CRUD basic operations.
 *
 * @author Carlos Meneses
 * @version 1.1
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    /**
     * Gets a list of all projects.
     *
     * @return a list of projects
     */
    public Iterable<Project> getAllProjects() {
        return repository.findAll();
    }

    /**
     * Gets a project by a id parameter.
     *
     * @param id to search a specific project
     * @return contains a user found by id
     */
    public Project getProjectById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Inserts a new project in to data base.
     *
     * @param name inserts the new project name
     * @param desc inserts the new project description
     * @param lang inserts the new project language
     * @return contains the inserted project information
     */
    public Project addNewProject(String name, String desc, String lang) {
        Project newProject = new Project();
        newProject.setProjectName(name);
        newProject.setDescription(desc);
        newProject.setLanguage(lang);
        return repository.save(newProject);
    }

    /**
     * Updates a user information in the data base.
     *
     * @param id finds a user to be updated
     * @param name updates the project name field
     * @param desc updates the description field
     * @return contains the updated project information
     */
    public Project updateProjectInfo(Long id, String name, String desc) {
        Project projectToUpdate = repository.findById(id).get();
        projectToUpdate.setProjectName(name);
        projectToUpdate.setDescription(desc);
        return repository.save(projectToUpdate);
    }

    /**
     * Deletes a project by the parameter id.
     *
     * @param id to search for the project to delete.
     */
    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}
