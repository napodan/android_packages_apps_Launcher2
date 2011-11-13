/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.android.launcher2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    private static Preferences _Current = null;

    public static Preferences getInstance() {
        if (_Current == null)
            _Current = new Preferences();
        return _Current;
    }

    private SharedPreferences mPreferences = null;

    public void setContext(Context context) {
        if (context == null && mPreferences != null) {
            mPreferences = null;
        } else if (context != null) {
            mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    static final String PREF_HOMESCREEN_ENDLESS_LOOP = "EndlessHomescreenLoop";
    static final String PREF_LAUNCHER_ORIENTATE = "LauncherOrientation";
    static final String PREF_WALLPAPER_SCROLLING = "WallpaperScrolling";
    static final String PREF_SCROLLABLE_WIDGETS = "ScrollableWidgets";
    static final String PREF_EXTENDED_HOTSEATS = "ExtendedHotseats";

    public boolean getEndlessScrolling() {
        return mPreferences.getBoolean(PREF_HOMESCREEN_ENDLESS_LOOP, true);
    }
    
    public boolean getOrientate() {
        return mPreferences.getBoolean(PREF_LAUNCHER_ORIENTATE, true);
    }

    public boolean getWallpaperScrolling() {
        return mPreferences.getBoolean(PREF_WALLPAPER_SCROLLING, true);
    }
    
    public boolean getScrollableWidgets() {
        return mPreferences.getBoolean(PREF_SCROLLABLE_WIDGETS, true);
    }
    
    public boolean getExtendedHotseats() {
        return mPreferences.getBoolean(PREF_EXTENDED_HOTSEATS, false);
    }
}
