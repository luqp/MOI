package org.jalasoft.moi.model.core.parameters;

/**
 * Contains result values and a process id.
 *
 * @author Lucero Quiroga Perez
 * @version 1.1
 */
public abstract class Result {
    private long pid;
    private String value;

    /**
     * Contains the process id.
     *
     * @return process id
     */
    public long getPid() {
        return pid;
    }

    /**
     * Changes the process id.
     *
     * @param pid process id
     */
    public void setPid(long pid) {
        this.pid = pid;
    }

    /**
     * Contains the process result.
     *
     * @return result value
     */
    public String getValue() {
        return value;
    }

    /**
     * Changes the result value.
     *
     * @param value a string with the result value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Modifies the result output.
     *
     * @return String with pid + result
     */
    public String wrappedResult() {
        return this.getPid() + "\n" + this.getValue();
    }
}
