package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpecificationModel implements Jospec.Specification {
    private static SpecificationModel instance = new SpecificationModel();
    private Map<String, Jospec> specs = new HashMap<>();

    public static SpecificationModel getInstance() {
        return instance;
    }

    @Override
    public Collection<Jospec> getSpecs() {
        return specs.values();
    }

    public static Jospec module(String name) {
        Jospec module = getInstance().specs.get(name);
        if(module == null) {
            module = new JospecModel(name);
            getInstance().specs.put(name, module);
        }
        return module;
    }

    public static Jospec feature(String name) {
        return new JospecModel(name).level(Jospec.Level.FEATURE);
    }

    public static Jospec attribute(String name) {
        return new JospecModel(name).level(Jospec.Level.ATTRIBUTE);
    }
}
