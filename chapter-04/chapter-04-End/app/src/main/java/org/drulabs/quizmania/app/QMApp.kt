package org.drulabs.quizmania.app

import android.app.Application
import org.drulabs.quizmania.ui.settings.UserSettingsFragment
import org.drulabs.quizmania.ui.settings.setAppMode

class QMApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setAppMode(this)
    }
}