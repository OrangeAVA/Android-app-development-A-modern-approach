package org.drulabs.quizmania.ui.settings

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import org.drulabs.quizmania.BuildConfig
import org.drulabs.quizmania.R

class AppVersionPreference(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int
) : Preference(context, attrs, defStyleAttr) {

    constructor(
        context: Context,
        attrs: AttributeSet
    ) : this(context, attrs, 0) {
        widgetLayoutResource = R.layout.item_version_preference
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        holder.itemView.isClickable = false
        holder.itemView.findViewById<TextView>(R.id.tvAppVersion).text =
            context.getString(
                R.string.app_version_settings,
                BuildConfig.VERSION_NAME
            )
    }
}
