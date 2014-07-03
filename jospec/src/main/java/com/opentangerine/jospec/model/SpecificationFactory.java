package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;

public class SpecificationFactory {

    public static Jospec.Feature feature(String input) {
        return new FeatureModel(input);
    }

    public static Jospec.Attribute attribute(String name) {
        return new AttributeModel(name);
    }

}
