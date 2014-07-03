package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

public class ProjectModel implements Jospec.Project {
    private String name;

    @Override
    public Jospec.Project name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
