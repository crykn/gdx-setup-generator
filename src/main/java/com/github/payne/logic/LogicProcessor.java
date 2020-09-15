package com.github.payne.logic;

import com.github.payne.generator.annotations.NotImplemented;
import com.github.payne.generator.annotations.NotTested;
import com.github.payne.generator.input.GeneratorConfigs;
import com.github.payne.generator.output.GeneratedProject;
import com.github.payne.generator.output.vfs.VirtualFileSystem;

@NotTested
@NotImplemented
public class LogicProcessor {

    private GeneratorConfigs input;
    private final GeneratedProject project;
    private final VirtualFileSystem vfs;

    public LogicProcessor(GeneratedProject project) {
        this.project = project;
        this.vfs = project.getVirtualFileSystem();
    }

    public void applyInputs(GeneratorConfigs input) {
        /*
            fun generate() {
                addBasicFiles()
                addJvmLanguagesSupport()
                addExtensions()
                template.apply(this)
                addPlatforms()

                addSkinAssets()
                addReadmeFile()
                saveProperties()
                saveFiles()
            }
        */

    }
}