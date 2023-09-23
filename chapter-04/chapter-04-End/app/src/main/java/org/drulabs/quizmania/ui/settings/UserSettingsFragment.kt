package org.drulabs.quizmania.ui.settings

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import androidx.preference.SwitchPreference
import androidx.preference.SwitchPreferenceCompat
import org.drulabs.quizmania.R

class UserSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val uiModeList = findPreference<ListPreference>("key_app_mode")
        uiModeList?.setOnPreferenceChangeListener { _, newValue ->
            setAppMode(newValue as String)
            true
        }
    }
}

fun setAppMode(context: Context) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    sharedPreferences.getString("key_app_mode", "system")?.let {
        setAppMode(mode = it)
    }
}
fun setAppMode(mode: String) {
    when (mode) {
        "dark" -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        "light" -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        else -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}