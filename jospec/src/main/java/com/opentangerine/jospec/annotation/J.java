package com.opentangerine.jospec.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface J {
    static String NOT_SET = "";

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Provider {
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Module {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Feature {
        String name();
        String purpose() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Attribute {
        String name();
        String description();
        String[] notes() default NOT_SET;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Constraint {
        @Retention(RetentionPolicy.RUNTIME)
        @interface Required {
        }
        @Retention(RetentionPolicy.RUNTIME)
        @interface Unique {
            String value() default "";
        }
        String value();
    }

}