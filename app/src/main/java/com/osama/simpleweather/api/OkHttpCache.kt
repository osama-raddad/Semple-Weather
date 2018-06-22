package com.osama.simpleweather.api

import android.content.Context
import okhttp3.Cache
import java.io.File

class OkHttpCache //10MB Cache
private constructor(context: Context) {
     val cache: Cache = Cache(File(context.cacheDir, "okhttp_cache"), (10 * 1000 * 1000).toLong())
    companion object {
        private var okHttpCache: OkHttpCache? = null
        fun getInstance(context: Context): OkHttpCache {
            if (okHttpCache == null) okHttpCache = OkHttpCache(context)
            return okHttpCache as OkHttpCache
        }
    }
}
