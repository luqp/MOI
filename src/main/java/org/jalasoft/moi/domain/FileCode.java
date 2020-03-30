/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.domain;

import javax.persistence.*;

/**
 * Defines the file that will be used for write and compile code.
 *
 * @author Carlos Meneses
 * @version 1.1
 */
@Entity
@Table(name = "FileCode")
public class FileCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    @ManyToOne
    private Project project;
    private String name;
    private String code;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
