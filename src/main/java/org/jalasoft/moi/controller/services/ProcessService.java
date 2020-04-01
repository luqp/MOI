/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.controller.repository.ProjectRepository;
import org.jalasoft.moi.domain.Project;
import org.jalasoft.moi.model.core.ICacheProvider;
import org.jalasoft.moi.model.core.parameters.Parameters;
import org.jalasoft.moi.model.core.parameters.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

/**
 * Contains all processes created by the model.
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
@Service
public class ProcessService implements ICacheProvider {

    @Autowired
    private ProjectRepository projectRepository;
    private HashMap<Long, Process> processMap;

    public ProcessService() {
        this.processMap = new HashMap<>();
    }

    /**
     * Helps to identify a specific process.
     *
     * @param pid process id
     * @return a specific process
     */
    @Override
    public Process getProcessById(long pid) {
        return processMap.get(pid);
    }

    /**
     * Adds process to cache.
     *
     * @param pid     process id
     * @param process specific process to add
     */
    @Override
    public void add(long pid, Process process) {
        processMap.put(pid, process);
    }

    /**
     * Deletes a process from cache.
     *
     * @param pid process id
     */
    @Override
    public void deleteProcess(long pid) {
        Process process = processMap.remove(pid);
        process.destroy();
    }

    /**
     * Create a new file with name and code to set the file properties in a new params object.
     *
     * @param projectId gets the project path by project id
     * @return the parameters setted object
     */
    public Parameters setParams(Long projectId){
        Project projInfo = projectRepository.findById(projectId).get();
        Parameters codeParams = new Params();
        File codeFile = new File(projInfo.getPath());
        codeParams.setFilesPath(codeFile.toPath());
        codeParams.setLanguage(projInfo.getLanguage());
        return codeParams;
    }
}
