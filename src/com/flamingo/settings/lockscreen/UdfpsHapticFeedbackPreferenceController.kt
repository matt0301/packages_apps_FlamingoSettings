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

package com.flamingo.settings.lockscreen

import android.content.Context

import com.android.settings.core.BasePreferenceController
import com.flamingo.settings.Utils

class UdfpsHapticFeedbackPreferenceController(
    context: Context,
    key: String,
) : BasePreferenceController(context, key) {

    override fun getAvailabilityStatus(): Int =
        if (Utils.hasUDFPS(mContext)) {
            AVAILABLE
        } else {
            UNSUPPORTED_ON_DEVICE
        }
}