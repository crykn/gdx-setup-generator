package com.github.payne.logic.modules.android.files;

import com.github.payne.generator.input.GeneratorConfigs;
import com.github.payne.generator.input.model.VersionedLanguage;
import com.github.payne.generator.input.model.enums.Language;
import com.github.payne.logic.root.BuildGradleFile;
import java.util.LinkedHashSet;
import java.util.Set;

public class AndroidBuildGradleFile extends BuildGradleFile {

    private final Set<String> srcFolders = new LinkedHashSet<>();

    public AndroidBuildGradleFile(final GeneratorConfigs input) {
        super("generator/dynamic/modules/android/build-gradle.txt", input);
    }

    @Override
    protected void assignOtherKeys() {
        srcFolders();
        kotlinPlugin();

        // todo: "dependencies", "nativeDependencies"
//        assignKey("dependencies", joinDependencies(dependencies, "api"));
    }

    private void srcFolders() {
        for (VersionedLanguage language : input.getLanguages()) {
            srcFolders.add("'src/main/" + language.getLanguage() + "'");
        }
        assignKey("srcFolders", String.join(", ", srcFolders));
    }

    private void kotlinPlugin() {
        final String kotlinPluginReplacement = input.contains(Language.KOTLIN)
                ? "apply plugin: 'kotlin-android'\n"
                : "";
        assignKey("kotlinPlugin", kotlinPluginReplacement);
    }
}
