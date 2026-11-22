package dev.carbon.pocketlauncher.core.minecraft

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dev.carbon.pocketlauncher.core.crash.CrashReporter
import dev.carbon.pocketlauncher.core.discord.DiscordPresence
import dev.carbon.pocketlauncher.core.packages.PackageService
import dev.carbon.pocketlauncher.core.news.NewsNotificationHelper
import dev.carbon.pocketlauncher.settings.FeatureSettings
import dev.carbon.pocketlauncher.ui.dialogs.LogcatOverlayManager

class LauncherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        FeatureSettings.init(applicationContext)
        CrashReporter.init(this)
        val processName = Application.getProcessName()
        if (processName.endsWith(":crash")) return

        PackageService.init(this)
        NewsNotificationHelper.initialize(this)
        LogcatOverlayManager.init(this)

        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        DiscordPresence.initialize(this)
    }

    companion object {
        @JvmStatic
        lateinit var context: Context
            private set

        @JvmStatic
        lateinit var preferences: SharedPreferences
            private set
    }
}
