package com.opentangerine.jospec.scanner;

import com.opentangerine.jospec.Jospec;
import com.opentangerine.jospec.annotation.J;
import com.opentangerine.jospec.model.SpecificationModel;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class Scanner {
    public static Jospec.Specification scan(String packagePrefix) {
        Reflections reflections = new Reflections(packagePrefix, null);
        Set<Class<?>> result = reflections.getTypesAnnotatedWith(J.class);
        for (Class<?> aClass : result) {
            System.out.println(aClass.toString());
            String moduleName = aClass.getAnnotation(J.class).name();
            for (Method method : ReflectionUtils.getAllMethods(aClass)) {
            }

            Set<Annotation> annots = ReflectionUtils.getAllAnnotations(aClass);
            for (Annotation annot : annots) {
//                System.out.println(annot);
            }

        }
        return SpecificationModel.getInstance();
    }

}
