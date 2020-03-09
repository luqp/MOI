/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model;

import java.nio.file.Path;

/**
 * Contains information from client about what language,
 * version and files location will be used to compile.
 */
public class Params {
    private Path filesPath;
    private Language language;

    /**
     * @param filesPath contains files location on the local host.
     * @param language is a enum that contains the language in which files will be compiled.
     */
    public Params(Path filesPath, Language language) {
        this.filesPath = filesPath;
        this.language = language;
    }

    public Path getFilesPath() {
        return filesPath;
    }

    public Language getLanguage() {
        return language;
    }
}
