package ar.edu.unrn.rankingservice.model;

import java.io.Serializable;

public enum PersonType implements Serializable {

    DIRECTOR("director"), ACTOR("Actor");

    private String description;

    PersonType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
