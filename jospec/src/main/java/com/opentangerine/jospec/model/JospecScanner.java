package com.opentangerine.jospec.model;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class JospecScanner {
    private Jospec.Specification s = new SpecificationModel();

    public Jospec.Specification scan() {
        Reflections reflections = new Reflections();
        Set<Class<?>> result = reflections.getTypesAnnotatedWith(J.Module.class);
        for (Class<?> aClass : result) {
            System.out.println(aClass.toString());
            String moduleName = aClass.getAnnotation(J.Module.class).name();
            for (Method method : ReflectionUtils.getAllMethods(aClass)) {
                for (Annotation annotation : method.getAnnotations()) {
                    if(annotation instanceof J.Feature) {
                        s.module(moduleName).contains(new FeatureModel((J.Feature)annotation).done());
                    }
                }

            }

            Set<Annotation> annots = ReflectionUtils.getAllAnnotations(aClass);
            for (Annotation annot : annots) {
//                System.out.println(annot);
            }

        }

        return s;
    }

}
