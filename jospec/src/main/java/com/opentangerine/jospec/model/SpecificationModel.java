package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpecificationModel implements Jospec.Specification {
    private Jospec.Project project = new ProjectModel();
    private Map<String, Jospec.Module> mods = new HashMap<>();
    private Collection<Jospec.Feature> features = new ArrayList<>();
    private String description;

    @Override
    public Jospec.Project project() {
        return project;
    }

    @Override
    public Jospec.Module module(String name) {
        Jospec.Module module = mods.get(name);
        if(module == null) {
            module = new ModuleModel(name);
            mods.put(name, module);
        }
        return module;
    }

    @Override
    public Collection<Jospec.Module> getModules() {
        return mods.values();
    }

    @Override
    public Jospec.Feature feature(String input) {
        return new FeatureModel(input);
    }

    @Override
    public Jospec.Attribute attribute(String name) {
        return new AttributeModel(name);
    }

}
