package com.opentangerine.jospec;

import com.opentangerine.jospec.annotation.J;

import java.util.Collection;

import static com.opentangerine.jospec.Jospec.Level.ATTRIBUTE;
import static com.opentangerine.jospec.Jospec.Level.MODULE;

@J(level = MODULE, name = "Jospec")
public interface Jospec {
    enum Level {
        MODULE,
        FEATURE,
        ATTRIBUTE
    }

    enum Constraint {
        REQUIRED,
        UNIQUE
    }

    interface Specification {
        Collection<Jospec> getSpecs();
    }

    @J(level = ATTRIBUTE, name="level", purpose="describe how small element is described", constraints = {Constraint.REQUIRED, Constraint.UNIQUE})
    Level getLevel();
    Jospec level(Level level);

    @J(level = ATTRIBUTE, name="name", purpose="name of the FEATURE", constraints = {Constraint.REQUIRED, Constraint.UNIQUE})
    String getName();

    @J(level = ATTRIBUTE, name="actor", purpose="specify who is interested with this particular FEATURE")
    String getActor();
    Jospec actor(String actor);

    @J(level = ATTRIBUTE, name="notes", purpose="additional notes strictly related to this FEATURE")
    Collection<String> getNotes();
    Jospec note(String input);

    @J(level = ATTRIBUTE, name="tags", purpose="tags to group or mark Jospecs")
    Collection<String> getTags();
    Jospec tag(String tag);

    @J(level = ATTRIBUTE, name="purpose", purpose="explain purpose of this FEATURE")
    String getPurpose();
    Jospec purpose(String what);

    @J(level = ATTRIBUTE, name="done", purpose = "mark if particular FEATURE is fully implemented and optionally link it with related part of source code")
    Object getDone();
    boolean isDone();
    Jospec done();
    Jospec done(Class<?> clazz);
    Jospec done(String purpose);

    @J(level = ATTRIBUTE, name="properties", purpose="additional fully customized properties map")
    <T> T getProperty(String key);
    Jospec property(String key, Object value);

    @J(level = ATTRIBUTE, name="Jospecs", purpose="FEATURE can contain nested Jospecs")
    Collection<Jospec> getSpecs();
    Jospec contains(Jospec... Jospecs);

}
