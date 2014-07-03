package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

import java.util.ArrayList;
import java.util.Collection;

public class AttributeModel implements Jospec.Attribute {
    private Collection<String> notes = new ArrayList<>();
    private String name;
    private String description;

    public AttributeModel(String name) {
        name = name;
    }

    @Override
    public Jospec.Attribute description(String description) {
        description = description;
        return this;
    }

    @Override
    public Jospec.Attribute note(String note) {
        notes.add(note);
        return this;
    }

    public Collection<String> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
