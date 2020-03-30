/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import java.io.File;

import org.jalasoft.moi.controller.repository.ProjectRepository;
import org.jalasoft.moi.controller.repository.UserRepository;
import org.jalasoft.moi.domain.Project;
import org.jalasoft.moi.model.core.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Provides to project controller the CRUD basic operations.
 *
 * @author Carlos Meneses
 * @version 1.2
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment environment;

    /**
     * Gets a list of all projects.
     *
     * @return a list of projects
     */
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Gets a project by a id parameter.
     *
     * @param id to search a specific project
     * @return contains a user found by id
     */
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).get();
    }

    /**
     * Inserts a new project in to data base.
     *
     * @param name inserts the new project name
     * @param desc inserts the new project description
     * @param lang inserts the new project language
     * @return contains the inserted project information
     */
    public Project addNewProject(String name, String desc, String lang, Long userId) {
        Project newProject = new Project();
        newProject.setProjectName(name);
        newProject.setDescription(desc);
        newProject.setLanguage(setProjectLang(lang));
        newProject.setPath(pathBuilder(userId, lang, name));
        newProject.setUser(userRepository.findById(userId).get());
        return projectRepository.save(newProject);
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
        Project projectToUpdate = projectRepository.findById(id).get();
        projectToUpdate.setProjectName(name);
        projectToUpdate.setDescription(desc);
        projectToUpdate.setPath(updateProjectFolder(id,name));
        return projectRepository.save(projectToUpdate);
    }

    /**
     * Deletes a project by the parameter id.
     *
     * @param id to search for the project to delete.
     */
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    /**
     * Builds a project path using user id, language and project name.
     *
     * @param userId to build a folder name whit user id
     * @param lang to build a folder with a language
     * @param projectName to build a folder with project name
     * @return a string with the built path
     */
    private String pathBuilder(Long userId, String lang, String projectName){
        String basePath = environment.getProperty("file.path");
        String user = "user_"+userId+"_projects";
        String projectPath = basePath+"/"+user+"/"+lang+"/"+projectName;
        File path = new File(projectPath);
        path.mkdirs();
        return projectPath;
    }

    /**
     * Update the project folder path using projectId and the new project name.
     *
     * @param projectId to get the project path and update the project folder name
     * @param updateProjectName to build a folder with the new project name
     * @return a string with the updated built path
     */
    private String updateProjectFolder(Long projectId, String updateProjectName){
        Project project = projectRepository.findById(projectId).get();
        File projectFolder = new File(project.getPath());
        File updateFolder = new File(projectFolder.getParent()+"/"+ updateProjectName);
        projectFolder.renameTo(updateFolder);
        return updateFolder.getPath();
    }

    /**
     * Defines a specific language to be setted in the project.
     *
     * @param lang to sets the project language
     * @return a specific language
     */
    private Language setProjectLang(String lang){
        Language projectLang;
        switch (lang){
            case "java": projectLang = Language.JAVA;
                break;
            case "python": projectLang = Language.PYTHON_32;
                break;
            case "csharp": projectLang = Language.CSHARP;
                break;
            case "cplusplus": projectLang = Language.CPP;
                break;
            default: throw new IllegalArgumentException("Invalid Language: " + lang);
        }
        return projectLang;
    }
}
