package dev.carbon.pocketlauncher.ui.dialogs.gameversionselect;

import dev.carbon.pocketlauncher.core.versions.GameVersion;

import java.util.ArrayList;
import java.util.List;

public class VersionGroup {
    public String versionCode;
    public List<GameVersion> versions = new ArrayList<>();

    public VersionGroup(String code) {
        this.versionCode = code;
    }
}