package com.github.payne.logic.root.files;

import com.github.payne.generator.input.GeneratorConfigs;
import com.github.payne.logic.root.DynamicFile;

public class LocalPropertiesFile extends DynamicFile {

    public LocalPropertiesFile(final GeneratorConfigs input) {
        super("settings.gradle", "generator/dynamic/local-properties.txt", input);
    }

    @Override
    protected void assignOtherKeys() {
        // nothing to do
    }
}
