package org.opentangerine.jospec.github;

import com.google.common.base.Strings;
import com.opentangerine.jospec.Jospec;

public class GitHubMarkup {

    public static void render(Jospec.Specification model) {
        System.out.println();
        System.out.println("# " + model.project().getName());
        System.out.println();
        for (Jospec.Module module : model.getModules()) {
            System.out.println();
            System.out.println("## " + module.getName());
            if(!Strings.isNullOrEmpty(module.getDescription())) {
                System.out.println(module.getDescription());
            }
            System.out.println("#### Features");
            for (Jospec.Feature feature : module.getFeatures()) {
                System.out.print(" - " + (!feature.isDone() ? "`comming soon` " : "") + feature.getName());
                for (String s : feature.getTags()) {
                    System.out.print("`" + s + "`");
                }
                System.out.println("");
            }
        }
    }

}
