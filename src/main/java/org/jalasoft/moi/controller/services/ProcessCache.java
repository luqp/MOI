/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.services;

import org.jalasoft.moi.model.core.ICacheProvider;

import java.util.HashMap;

public class ProcessCache implements ICacheProvider {
    HashMap<Long, Process> processMap;

    public ProcessCache() {
        this.processMap = new HashMap<>();
    }

    @Override
    public Process getProcessById(long pid) {
        return processMap.get(pid);
    }

    @Override
    public void add(long pid, Process process) {
        processMap.put(pid, process);
    }

    @Override
    public void deleteProcess(long pid) {
        Process process = processMap.remove(pid);
        process.destroy();
    }
}
