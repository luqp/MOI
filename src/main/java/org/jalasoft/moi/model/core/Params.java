/*
 *   Copyright (c) 2020 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *   ("Confidential Information"). You shall not disclose such Confidential
 *   Information and shall use it only in accordance with the terms of the
 *   license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.model.core;
import org.jalasoft.moi.model.core.Language;

import java.nio.file.Path;

/**
 * Contains information from client about what language,
 * version and files location will be used to compile.
 *
 * @version    1.0
 * @author     Lucero Quiroga Perez
 */
public class Params {
    private Path filesPath;
    private Language language;

    /**
     * Contains files location on the local host.
     *
     * @return Path
     */
    public Path getFilesPath() {
        return filesPath;
    }

    /**
     * Set files location on the local host.
     *
     * @param filesPath files location
     */
    public void setFilesPath(Path filesPath) {
        this.filesPath = filesPath;
    }

    /**
     * Contains the language in which files will be compiled.
     *
     * @return Language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Set the language in which files will be compiled.
     *
     * @param language type selected by the client
     */
    public void setLanguage(Language language) {
        this.language = language;
    }
}
