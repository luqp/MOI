/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.utils;

import java.nio.file.Path;

public class Params {
    private Path filePath;
    private String version;
    private String lenguage;

    public Params(Path filePath, String version, String lenguage) {
        this.filePath = filePath;
        this.version = version;
        this.lenguage = lenguage;
    }

    public Path getFilePath() {
        return filePath;
    }

    public String getVersion() {
        return version;
    }

    public String getLenguage() {
        return lenguage;
    }
}
