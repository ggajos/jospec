package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FeatureModel implements Jospec.Feature {
    private String name;
    private String purpose;
    private Collection<String> notes = new ArrayList<>();
    private Collection<Jospec.Attribute> attributes = new ArrayList<>();
    private Collection<Jospec.Feature> features = new ArrayList<>();
    private Collection<String> tags = new ArrayList<>();
    private Map<String, Object> properties = new HashMap<>();
    private Object done;

    public String getActor() {
        return actor;
    }

    public Object getDone() {
        return done;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public Collection<Jospec.Feature> getFeatures() {
        return features;
    }

    public Collection<Jospec.Attribute> getAttributes() {
        return attributes;
    }

    public Collection<String> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    private String actor;

    public FeatureModel(String name) {
        this.name = name;
    }

    @Override
    public Jospec.Feature actor(String actor) {
        this.actor = actor;
        return this;
    }

    @Override
    public Jospec.Feature note(String input) {
        notes.add(input);
        return this;
    }

    @Override
    public Jospec.Feature tag(String tag) {
        tags.add(tag);
        return this;
    }

    @Override
    public Jospec.Feature purpose(String reason) {
        purpose = reason;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public Jospec.Feature done(Class<?> clazz) {
        done = clazz;
        return this;
    }

    @Override
    public Jospec.Feature done(String description) {
        done = description;
        return this;
    }

    @Override
    public Jospec.Feature done() {
        done = true;
        return this;
    }

    @Override
    public boolean isDone() {
        return getDone() != null;
    }

    @Override
    public Jospec.Feature property(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    @Override
    public <T> T getProperty(String key) {
        return (T) properties.get(key);
    }

    @Override
    public Jospec.Feature contains(Jospec.Feature... inFeatures) {
        for (Jospec.Feature it : inFeatures) {
            features.add(it);
        }
        return this;
    }

    @Override
    public Jospec.Feature contains(Jospec.Attribute... inAttributes) {
        for (Jospec.Attribute it : inAttributes) {
            attributes.add(it);
        }
        return this;
    }
}
