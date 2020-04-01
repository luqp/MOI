/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.jalasoft.moi.controller.repository.FileRepository;
import org.jalasoft.moi.controller.repository.ProjectRepository;
import org.jalasoft.moi.domain.FileCode;
import org.jalasoft.moi.domain.Project;
import org.jalasoft.moi.model.core.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages actions that each file will need as save file or show responses.
 *
 * @author Carlos Meneses
 * @version 1.2
 */
@Service
public class FileService {

    private static Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Gets a list of all files.
     *
     * @return a list of files
     */
    public Iterable<FileCode> getAllFiles() {
        return fileRepository.findAll();
    }

    /**
     * Gets a file by a id parameter.
     *
     * @param id to search a specific file
     * @return contains a file found by id
     */
    public FileCode getFileById(Long id) {
        return fileRepository.findById(id).get();
    }

    /**
     * Inserts a new file in to data base.
     *
     * @param name inserts the new project name
     * @param code inserts the new project description
     * @param projectID inserts the new project language
     * @return contains the inserted project information
     */
    public FileCode addNewFile(String name, String code, Long projectID) throws IOException {
        FileCode newFilecode = new FileCode();
        newFilecode.setName(name);
        newFilecode.setProject(projectRepository.findById(projectID).get());
        saveFileB64(name, code, projectID);
        LOGGER.info("Project id retrieved from URL: {}", projectID);
        return fileRepository.save(newFilecode);
    }

    /**
     * Updates a file information in the data base.
     *
     * @param id finds a file to be updated
     * @param name updates the file name field
     * @param code updates the code field
     * @return contains the updated project information
     */
    public FileCode updateFileInfo(Long id, String name, String code) throws IOException {
        FileCode fileToUpdate = fileRepository.findById(id).get();
        fileToUpdate.setName(name);
        updateFileB64(id, name, code);
        LOGGER.info("File id retrieved from URL: {}", id);
        return fileRepository.save(fileToUpdate);
    }

    /**
     * Deletes a file by the parameter id.
     *
     * @param id to search for the file to delete
     */
    public void deleteFileInfo(Long id) throws IOException {
        deleteFile(id);
        LOGGER.info("File id retrieved from URL: {}", id);
        fileRepository.deleteById(id);
    }

    /**
     * Creates a new file with name and code to set the file properties in base 64.
     *
     * @param name saves the file name in the project
     * @param codeB64 saves the code inside the file in base 64
     * @param projectId gets the project path by project id
     */
    private void saveFileB64(String name, String codeB64, Long projectId) throws IOException {
        byte[] byteArray = Base64.decodeBase64(codeB64.getBytes());
        String code = new String(byteArray);
        saveFileToProjectFolder(name, code, projectId);
        LOGGER.info("Project id retrieved from URL: {}", projectId);
    }

    /**
     * Create a new file with name and code to set the file properties in a new params object.
     *
     * @param name saves the file name in the project path
     * @param code saves the code inside the file
     * @param projectId gets the project path by project id
     */
    private void saveFileToProjectFolder(String name, String code, Long projectId) throws IOException {
        Project projInfo = projectRepository.findById(projectId).get();
        String filePath = projInfo.getPath()+"/"+ name + projInfo.getLanguage().getFileExtention();
        FileWriter codeWriter = new FileWriter(filePath);
        codeWriter.write(code);
        codeWriter.close();
        LOGGER.info("Project id retrieved from URL: {}", projectId);

    }

    /**
     * Updates a new file with name and code to set the file properties in base 64.
     *
     * @param fileId gets the file information by its id
     * @param name updates the file name in the project
     * @param codeB64 updates the code inside the file in base 64
     */
    private void updateFileB64(Long fileId, String name, String codeB64) throws IOException {
        byte[] byteArray = Base64.decodeBase64(codeB64.getBytes());
        String code = new String(byteArray);
        updateFileToProjectFolder(fileId, name, code);
        LOGGER.info("File id retrieved from URL: {}", fileId);
    }

    /**
     * Updates a new file with name and code to set the file properties in a new params object.
     *
     * @param fileId gets the file information by its id
     * @param name updates the file name in the project path
     * @param code updates the code inside the file
     */
    private void updateFileToProjectFolder(Long fileId, String name, String code) throws IOException {
        deleteFile(fileId);
        FileCode fileCode = fileRepository.findById(fileId).get();
        Project projInfo = fileCode.getProject();
        String filePath = projInfo.getPath()+"/"+ name + projInfo.getLanguage().getFileExtention();
        FileWriter codeWriter = new FileWriter(filePath);
        codeWriter.write(code);
        codeWriter.close();
        LOGGER.info("File id retrieved from URL: {}", fileId);
    }

    /**
     * Deletes a file from the project foler.
     *
     * @param fileId gets a file information by its id
     */
    private void deleteFile(Long fileId) {
        FileCode fileCode = fileRepository.findById(fileId).get();
        Project projInfo = fileCode.getProject();
        String name = fileCode.getName();
        String filePath = projInfo.getPath()+"/"+ name + projInfo.getLanguage().getFileExtention();
        File file = new File(filePath);
        file.delete();
    }
}
