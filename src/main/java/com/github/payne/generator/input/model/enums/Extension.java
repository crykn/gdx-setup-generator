package com.github.payne.generator.input.model.enums;

import com.github.payne.logic.files.GradlePropertiesFile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Extension {
    ASHLEY("ashley", "1.7.3"),
    BOX_2_D_LIGHTS("box2d-lights", "1.5"),
    AI("ai", "1.8.2"),
    BOX_2_D("box2d", GradlePropertiesFile.GDX_VERSION),
    BULLET("bullet", GradlePropertiesFile.GDX_VERSION),
    CONTROLLERS("controllers", GradlePropertiesFile.GDX_VERSION),
    FREETYPE("freetype", GradlePropertiesFile.GDX_VERSION),
    TOOLS("tools", GradlePropertiesFile.GDX_VERSION);

    private final String id;
    private final String propertyVersion;
}
