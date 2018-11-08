package com.lsh.checkversion_kotlin

import android.content.Context
import android.content.pm.PackageManager
import android.os.StrictMode

import org.jsoup.Jsoup

import java.io.IOException

/**
 * @author lsh
 * @version 1.0.1 2018-11-08. Kotlin
 *
 * Getting a version of application (Market / Application Package).
 */
class CheckModule(private val context: Context) {
    /**
     * User can use this method to get a market version.
     *
     * @return market ver.
     */
    val marketVer: String?
    /**
     * User can use this method to get a current package version.
     *
     * @return current package ver.
     */
    val applicationVer: String?

    /**
     * Getting a application package version.
     *
     * @return application package version.
     */
    private val currAppVersion: String?
        get() {
            var device_version: String? = null

            try {
                device_version = context.packageManager.getPackageInfo(context.packageName, 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return device_version
        }

    /**
     * User can use this method for compare both versions.
     *
     * @return campare market & current version .
     */
    val isVersionSame: Boolean
        get() = this.applicationVer === this.marketVer

    init {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        this.marketVer = getMarketVersion(context.packageName)
        this.applicationVer = currAppVersion
    }

    /**
     * Getting a market version of application.
     *
     * @param packageName current package name.
     * @return application's market version.
     */
    private fun getMarketVersion(packageName: String): String? {
        try {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            val document = Jsoup.connect(
                    "https://play.google.com/store/apps/details?id=$packageName").get()
            val Version = document.select(".htlgb")
            return Version[5].text()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null
    }
}

