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
 * Params class contains information from client about what language and root are need
 */
public class Params {

    private Path filesPath;
    private String version;
    private Language language;

    /**
     * @param filesPath contains the root files in the local host.
     * @param version contains the language version.
     * @param language of the code used for the client.
     */
    public Params(Path filesPath, String version, Language language) {
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

    public Language getLanguage() {
        return language;
    }
}
