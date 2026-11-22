-keepattributes Signature,InnerClasses,EnclosingMethod,*Annotation*,SourceFile,LineNumberTable

-keep class com.discord.** { *; }
-keep class dev.carbon.pocketlauncher.core.discord.DiscordPresenceNative { *; }

-keep,includedescriptorclasses class org.levimc.** { *; }

-keepclasseswithmembers,includedescriptorclasses class * {
    native <methods>;
}

-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.minecraft.MinecraftActivity { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.util.NativeBridgeHelper { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.preloader.** { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.mods.Mod { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.mods.ModManager { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.mods.inbuilt.ExternalModBridge { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.mods.inbuilt.ExternalModBridge$* { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.mods.inbuilt.nativemod.** { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.content.nbt.NbtTag { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.content.nbt.NbtDocument { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.content.nbt.NativeNbt { *; }
-keep,includedescriptorclasses class dev.carbon.pocketlauncher.core.content.leveldb.WorldDatabase { *; }
-keep class dev.carbon.pocketlauncher.R$drawable { *; }
-keep class dev.carbon.pocketlauncher.** implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}

-keep class dev.carbon.pocketlauncher.settings.FeatureSettings {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.auth.MsftAccountStore$MsftAccount {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.versions.VersionProfileMetadata {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.util.InstanceBackupManager$BackupManifest {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.curseforge.models.** {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.modcatalog.ModCatalog {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.modcatalog.ModCatalog$* {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.news.NewsFeed {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.news.NewsItem {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.news.ChangelogManager$Changelog {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.news.ChangelogManager$Section {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.news.ChangelogManager$Item {
    !static !transient <fields>;
    <init>();
}

-dontwarn java.awt.**
-dontwarn javafx.**
-dontwarn javax.swing.**
-dontwarn com.sun.net.httpserver.**
-dontwarn java.net.http.**
-dontwarn reactor.**
-dontwarn org.reactivestreams.**
-dontwarn io.netty.**
-dontwarn net.lenni0451.commons.httpclient.executor.HttpClientExecutor
-dontwarn lombok.Generated

-keep class dev.carbon.pocketlauncher.core.play.PlayAccountStore$Account {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.play.GameRelease {
    !static !transient <fields>;
    <init>();
}

-keep class dev.carbon.pocketlauncher.core.play.GameDownloads$Downloaded {
    !static !transient <fields>;
    <init>();
}
