package io.cro.android.extensions

import android.content.Context
import android.content.pm.ApplicationInfo

val Context.isDebuggable: Boolean
    get() = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
