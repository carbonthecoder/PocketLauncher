package dev.carbon.pocketlauncher.core.discord;

final class DiscordPresenceNative {
    private DiscordPresenceNative() {}

    static native long create(long applicationId);
    static native void update(long handle, String details, String state, long startedAt, String largeImage);
    static native void tick(long handle);
    static native void destroy(long handle);
}
