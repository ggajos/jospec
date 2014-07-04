package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;

import java.util.ArrayList;
import java.util.Collection;

public class ModuleModel extends FeatureModel implements Jospec.Module {

    public ModuleModel(String name) {
        super(name);
    }

    public static ModuleModel from(J.Module module) {
        ModuleModel model = new ModuleModel(module.name());
        return model;
    }
}
