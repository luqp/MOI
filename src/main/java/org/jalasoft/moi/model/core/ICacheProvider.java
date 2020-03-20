package org.jalasoft.moi.model.core;

/**
 * Provides a cache format
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
public interface ICacheProvider {

    Process getProcessById(long pid);

    void add(long pid, Process process);

    void deleteProcess(long pid);
}
