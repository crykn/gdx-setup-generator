package com.github.payne.generator.input.model.enums;

import com.github.payne.logic.modules.GdxModule;
import com.github.payne.logic.modules.android.AndroidModule;
import com.github.payne.logic.modules.core.CoreModule;
import com.github.payne.logic.modules.desktop.DesktopModule;
import com.github.payne.logic.modules.headless.HeadlessModule;
import com.github.payne.logic.modules.html.HtmlModule;
import com.github.payne.logic.modules.ios.IosModule;
import com.github.payne.logic.modules.lwjgl3.Lwjgl3Module;
import com.github.payne.logic.modules.server.ServerModule;
import com.github.payne.logic.modules.shared.SharedModule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Platform {
    ANDROID("android") {
        @Override
        public GdxModule getModuleGenerator() {
            return new AndroidModule(getValue());
        }
    },
    CORE("core") {
        @Override
        public GdxModule getModuleGenerator() {
            return new CoreModule(getValue());
        }
    },
    DESKTOP_LEGACY("desktop") {
        @Override
        public GdxModule getModuleGenerator() {
            return new DesktopModule(getValue());
        }
    },
    HEADLESS("headless") {
        @Override
        public GdxModule getModuleGenerator() {
            return new HeadlessModule(getValue());
        }
    },
    HTML("html") {
        @Override
        public GdxModule getModuleGenerator() {
            return new HtmlModule(getValue());
        }
    },
    IOS("ios") {
        @Override
        public GdxModule getModuleGenerator() {
            return new IosModule(getValue());
        }
    },
    LWJGL_3("lwjgl3") {
        @Override
        public GdxModule getModuleGenerator() {
            return new Lwjgl3Module(getValue());
        }
    },
    SERVER("server") {
        @Override
        public GdxModule getModuleGenerator() {
            return new ServerModule(getValue());
        }
    },
    SHARED("shared") {
        @Override
        public GdxModule getModuleGenerator() {
            return new SharedModule(getValue());
        }
    };

    private final String value;

    public abstract GdxModule getModuleGenerator();
}
