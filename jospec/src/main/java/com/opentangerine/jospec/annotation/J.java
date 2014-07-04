package com.opentangerine.jospec.annotation;

import com.opentangerine.jospec.Jospec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@J(name = "use annotations to describe your specification")
public @interface J {
    Jospec.Level level() default Jospec.Level.FEATURE;
    Jospec.Constraint[] constraints() default {};
    String name();
    String purpose() default "";
    String[] notes() default {};
    String[] tags() default {};
    boolean done() default true;

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Provider {
    }
}