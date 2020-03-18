package org.jalasoft.moi.model.core.parameters;

public abstract class Result {
    private long pid;
    private String value;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
