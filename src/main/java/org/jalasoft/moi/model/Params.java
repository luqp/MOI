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
 * Parms class contains information from client about what language and root are need
 */
public class Params {
    private Path filesPath;
    private String version;
    private Enum<Laguage> language;

    public Params(Path filesPath, String version, Enum<Laguage> language) {
        this.filesPath = filesPath;
        this.version = version;
        this.language = language;
    }

    public Path getFilesPath() {
        return filesPath;
    }

    public String getVersion() {
        return version;
    }

    public Enum<Laguage> getLanguage() {
        return language;
    }
}
