package com.lsh.checkversion_java;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author lsh
 * @version 1.0.1 2018-11-08. Java
 * <p>
 * Getting a version of application (Market / Application Package).
 */
public class CheckModule {
    private String market_version;
    private String app_version;
    private Context context;

    public CheckModule(Context context) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.context = context;
        this.market_version = getMarketVersion(context.getPackageName());
        this.app_version = getCurrAppVersion();
    }

    /**
     * Getting a market version of application.
     *
     * @param packageName current package name.
     * @return application's market version.
     */
    private String getMarketVersion(String packageName) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Document document = Jsoup.connect(
                    "https://play.google.com/store/apps/details?id=" + packageName).get();
            Elements Version = document.select(".htlgb");
            return Version.get(5).text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Getting a application package version.
     *
     * @return application package version.
     */
    private String getCurrAppVersion() {
        String device_version = null;

        try {
            device_version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return device_version;
    }

    /**
     * User can use this method to get a market version.
     *
     * @return market ver.
     */
    public String getMarketVer() {
        return this.market_version;
    }

    /**
     * User can use this method to get a current package version.
     *
     * @return current package ver.
     */
    public String getApplicationVer() {
        return this.app_version;
    }

    /**
     * User can use this method for compare both versions.
     *
     * @return campare market & current version .
     */
    public boolean isVersionSame() {
        return this.app_version == this.market_version;
    }
}

