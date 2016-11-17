package ru.innopolis.studentproject.server.entity;

/**
 * Created by innopolis on 16.11.16.
 */
public class Version {
    private long version;

    @javax.persistence.Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
