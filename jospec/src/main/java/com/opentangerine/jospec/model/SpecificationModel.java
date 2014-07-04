package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpecificationModel implements Jospec.Specification {
    private static SpecificationModel instance = new SpecificationModel();
    private Jospec.Project project;
    private Map<String, Jospec.Module> mods = new HashMap<>();

    public static SpecificationModel getInstance() {
        return instance;
    }

    public static Jospec.Project project(String name) {
        if(getInstance().project != null) {
            if(getInstance().project.getName().equalsIgnoreCase(name)) {
                throw new IllegalArgumentException("Found another project in codebase scope " + name + ", previous: " + getInstance().project.getName() + ". Multiple projects are not supported.");
            }
            return getInstance().project;
        }
        getInstance().project = new ProjectModel(name);
        return null;
    }

    @Override
    public Collection<Jospec.Module> getModules() {
        return mods.values();
    }

    public static Jospec.Module module(String name) {
        Jospec.Module module = getInstance().mods.get(name);
        if(module == null) {
            module = new ModuleModel(name);
            getInstance().mods.put(name, module);
        }
        return module;
    }

    public static Jospec.Feature feature(String input) {
        return new FeatureModel(input);
    }

    public static Jospec.Attribute attribute(String name) {
        return new AttributeModel(name);
    }
}
