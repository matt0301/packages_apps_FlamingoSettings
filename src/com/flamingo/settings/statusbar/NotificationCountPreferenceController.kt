/*
 * Copyright (C) 2022 FlamingoOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flamingo.settings.statusbar

import android.content.Context
import android.os.UserHandle
import android.provider.Settings

import androidx.preference.Preference
import androidx.preference.SwitchPreference

import com.android.settings.core.BasePreferenceController
import com.flamingo.settings.Utils
import com.flamingo.support.preference.SystemSettingSwitchPreference

class NotificationCountPreferenceController(
    context: Context,
    key: String,
) : BasePreferenceController(context, key) {

    private val defaultEnabled = Utils.getBoolSysUIResource(context, CONFIG_RESOURCE_NAME)

    override fun getAvailabilityStatus(): Int = AVAILABLE

    override fun updateState(preference: Preference) {
        (preference as SwitchPreference).setChecked(
            Settings.System.getIntForUser(mContext.contentResolver,
                Settings.System.STATUS_BAR_NOTIF_COUNT,
                if (defaultEnabled) 1 else 0,
                UserHandle.USER_CURRENT,
            ) == 1
        )
    }

    companion object {
        private const val CONFIG_RESOURCE_NAME = "config_statusBarShowNumber"
    }
}