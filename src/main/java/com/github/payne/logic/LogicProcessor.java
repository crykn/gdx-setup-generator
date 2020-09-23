package com.github.payne.logic;

import com.github.payne.generator.annotations.NotImplemented;
import com.github.payne.generator.annotations.NotTested;
import com.github.payne.generator.input.GeneratorConfigs;
import com.github.payne.generator.input.model.enums.AddOn;
import com.github.payne.generator.input.model.enums.Platform;
import com.github.payne.generator.output.GeneratedProject;
import com.github.payne.generator.output.vfs.AppendableTree;
import com.github.payne.generator.output.vfs.FileNode;
import com.github.payne.logic.files.GradlePropertiesFile;
import com.github.payne.logic.files.ReadMeFile;
import com.github.payne.logic.files.RootBuildGradleFile;
import com.github.payne.logic.files.SettingsGradleFile;
import com.github.payne.logic.files.abstracts.DynamicFile;
import com.github.payne.logic.modules.GdxModule;
import java.util.Arrays;

@NotTested
@NotImplemented
public class LogicProcessor {

    private final GeneratorConfigs input;
    private final GeneratedProject project; // used to inject Error Messages, if any
    private final AppendableTree vfs;
    private final FileNode root;

    public LogicProcessor(GeneratorConfigs input, GeneratedProject project) {
        this.input = input;
        this.project = project;
        this.vfs = project.getVirtualFileSystem();
        this.root = vfs.getRoot();
    }

    public void applyInputs() {
        addRootFiles();
        addRootFolders();

        applyTemplate();
    }

    public void addRootFiles() {
        addGitIgnore();
        addRootBuildGradle();
        addReadmeFile();
        addGradleProperties();
        addSettingsGradle();
    }

    public void addRootFolders() {
        addAssets();
        addGradleWrapper();
        addPlatforms();
    }

    public void addPlatforms() {
        for (Platform platform : input.getPlatforms()) {
            GdxModule module = platform.getModuleGenerator();
            module.generate(input, vfs);
        }
    }

    public void addGitIgnore() {
        vfs.copyFileToRoot("generator/static/gitignore", ".gitignore");
    }

    public void addRootBuildGradle() {
        DynamicFile rootBuildGradle = new RootBuildGradleFile(input);
        vfs.addToParent(root, rootBuildGradle.createFile());
    }

    public void addGradleProperties() {
        DynamicFile gradleProperties = new GradlePropertiesFile(input);
        vfs.addToParent(root, gradleProperties.createFile());
    }

    public void addAssets() {
        final String DEST_FOLDER = input.getAssetsFolderName();
        vfs.addToParent(root, new FileNode(DEST_FOLDER));
        if (input.contains(AddOn.GUI_ASSETS)) {
            vfs.copyFolder("generator/static/assets", Arrays.asList(DEST_FOLDER), false);
        }
    }

    private void addGradleWrapper() {
        if (input.contains(AddOn.GRADLE_WRAPPER)) {
            vfs.copyFolderToRoot("generator/static/gradle", true);
        }
    }

    public void applyTemplate() {
        // todo
    }

    public void addReadmeFile() {
        if (input.contains(AddOn.README)) {
            DynamicFile readme = new ReadMeFile(input);
            vfs.addToParent(root, readme.createFile());
        }
    }

    private void addSettingsGradle() {
        DynamicFile modules = new SettingsGradleFile(input);
        vfs.addToParent(root, modules.createFile());
    }
}
