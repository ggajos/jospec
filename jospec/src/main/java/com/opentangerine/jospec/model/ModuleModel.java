package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;

import java.util.ArrayList;
import java.util.Collection;

public class ModuleModel implements Jospec.Module {
    private String name;
    private String description;
    private Collection<Jospec.Feature> features = new ArrayList<>();

    public ModuleModel(String name) {
        this.name = name;
    }

    public ModuleModel(J.Module module) {
        name = module.name();
    }

    @Override
    public Jospec.Module description(String input) {
        description = input;
        return this;
    }

    @Override
    public Jospec.Module contains(Jospec.Feature... inFeatures) {
        for (Jospec.Feature inFeature : inFeatures) {
            features.add(inFeature);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Jospec.Feature> getFeatures() {
        return features;
    }
}
