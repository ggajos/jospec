package com.opentangerine.jospec;

import com.opentangerine.jospec.annotation.J;

import java.util.Collection;

public interface Jospec {
    String NAME = "OSRSL";

    interface All extends Provider, Specification, Feature {}

    interface Provider {
        void spec(Specification spec);
    }

    interface Specification {
        Project project();
        Module module(String name);
        Collection<Module> getModules();
        Feature feature(String name);
        Attribute attribute(String name);
    }

    @J.Module(name = NAME)
    @J.Feature(name = "group features into modules")
    interface Module {
        String getName();
        Module description(String description);
        String getDescription();
        Module contains(Feature... features);
        Collection<Feature> getFeatures();
    }

    @J.Module(name = NAME)
    @J.Feature(name = "store project global informations")
    interface Project {
        Project name(String name);
        String getName();
    }

    @J.Module(name = NAME)
    @J.Feature(name="features")
    interface Feature {
        @J.Attribute(name="name", description="name of the feature")
        @J.Constraint.Required
        @J.Constraint.Unique("unique in specific module")
        String getName();

        @J.Attribute(name="actor", description="specify who is interested with this particular feature")
        Feature actor(String who);
        String getActor();

        @J.Attribute(name="notes", description="additional notes strictly related to this feature")
        Feature note(String input);
        Collection<String> getNotes();

        @J.Attribute(name="tags", description="tags to group or mark features")
        Feature tag(String tag);
        Collection<String> getTags();

        @J.Attribute(name="reason", description="explain purpose of this feature")
        Feature purpose(String what);
        String getPurpose();

        @J.Attribute(name="done", description = "mark if particular feature is fully implemented and optionally link it with related part of source code")
        Feature done();
        Feature done(Class<?> clazz);
        Feature done(String description);
        Object getDone();
        boolean isDone();

        @J.Attribute(name="properties", description="additional fully customized properties map")
        Feature property(String key, Object value);
        <T> T getProperty(String key);

        @J.Attribute(name="features", description="feature can contain nested features")
        Feature contains(Feature... features);
        Collection<Feature> getFeatures();

        @J.Attribute(name="attributes", description="feature can contain many attributes")
        Feature contains(Attribute... attributes);
        Collection<Attribute> getAttributes();
    }

    @J.Module(name = NAME)
    @J.Feature(name="attribute")
    interface Attribute {
        @J.Attribute(name="name", description="name of an attribute")
        @J.Constraint.Required
        @J.Constraint.Unique("unique in specific module")
        String getName();
        Attribute description(String description);
        String getDescription();
        Attribute note(String note);
        Collection<String> getNotes();
    }

}
