package org.jalasoft.moi.model.interaction;

import org.jalasoft.moi.model.core.ICacheProvider;

import java.util.HashMap;

public class ProcessCacheTest implements ICacheProvider {

    HashMap<Long, Process> processMap;

    public ProcessCacheTest() {
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
