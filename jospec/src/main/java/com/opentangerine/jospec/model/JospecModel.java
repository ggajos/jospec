package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;

import java.util.*;

public class JospecModel implements Jospec {
    private Jospec.Level level;
    private String name;
    private String purpose;
    private Collection<String> notes = new ArrayList<>();
    private Collection<Jospec> specs = new ArrayList<>();
    private Collection<String> tags = new ArrayList<>();
    private Collection<Constraint> constraints = new ArrayList<>();
    private Map<String, Object> properties = new HashMap<>();
    private Object done;

    public JospecModel(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public Object getDone() {
        return done;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Collection<Jospec> getSpecs() {
        return specs;
    }

    public Collection<String> getNotes() {
        return notes;
    }

    @Override
    public Jospec level(Jospec.Level level) {
        this.level = level;
        return this;
    }

    @Override
    public Jospec.Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    private String actor;

    public Collection<String> getTags() {
        return tags;
    }

    @Override
    public Jospec actor(String actor) {
        this.actor = actor;
        return this;
    }

    @Override
    public Jospec note(String input) {
        notes.add(input);
        return this;
    }

    @Override
    public Jospec tag(String tag) {
        tags.add(tag);
        return this;
    }

    @Override
    public Jospec purpose(String reason) {
        purpose = reason;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public Jospec done(Class<?> clazz) {
        done = clazz;
        return this;
    }

    @Override
    public Jospec done(String description) {
        done = description;
        return this;
    }

    @Override
    public Jospec done() {
        done = true;
        return this;
    }

    @Override
    public boolean isDone() {
        return getDone() != null;
    }

    @Override
    public Jospec property(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    @Override
    public <T> T getProperty(String key) {
        return (T) properties.get(key);
    }

    @Override
    public Jospec contains(Jospec... inFeatures) {
        for (Jospec it : inFeatures) {
            specs.add(it);
        }
        return this;
    }

    public Jospec merge(J annotation) {
        name = annotation.name();
        level = annotation.level();
        purpose = annotation.purpose();
        notes = Arrays.asList(annotation.notes());
        tags = Arrays.asList(annotation.tags());
        constraints = Arrays.asList(annotation.constraints());
        done = annotation.done();
        return this;
    }
}
