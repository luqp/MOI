package org.jalasoft.moi.model.core;

public interface ICacheProvider {
    Process getProcessById(long pid);
    void add(long pid, Process process);
    void deleteProcess(long pid);
}
