package com.skn.ham;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

public class AppManager {

    private static SharedPreferences sharedPreferences;
    private static final String ACCESS_TIME = "accessTime";
    private static final String APP_VERSION = "appVersion";
    private static AppManager ourInstance;
    private static Context mContext;

    public enum VersionCheckResult {
        LATEST,
        MAJOR_UPDATE,
        MINOR_UPDATE,
        INVALID
    }

    public AppManager() {

    }

    public static AppManager getInstance(Context context){

        if(ourInstance == null){
            ourInstance = new AppManager();
            mContext = context;
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        }

        return ourInstance;
    }

    public String getAccessTime() {
        return sharedPreferences.getString(ACCESS_TIME, "");
    }

    public void setAccessTime(String accessTime) {
        sharedPreferences.edit().putString(ACCESS_TIME, accessTime).apply();
    }

    public String getNewVersion() {
        return sharedPreferences.getString(APP_VERSION, "");
    }

    public void setNewVersion(String newVersion) {

        sharedPreferences.edit().putString(APP_VERSION, newVersion).apply();
    }

    private String getCurrentVersion() {

        try {
            PackageInfo pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public VersionCheckResult checkAppVersion() {

        String currentVersion = getCurrentVersion();
        String newVersion = getNewVersion();

        if (currentVersion != null && newVersion != null) {

            if (currentVersion.compareTo(newVersion) == 0) {

                return VersionCheckResult.LATEST;
            } else {

                String[] currentVersionCodes = currentVersion.split("\\.");
                String[] newVersionCodes = newVersion.split("\\.");

                if (currentVersionCodes.length != newVersionCodes.length) {
                    return VersionCheckResult.INVALID;
                } else {

                    if (currentVersionCodes.length > 0) {

                        int curMajorCode = Integer.parseInt(currentVersionCodes[0]);
                        int newMajorCode = Integer.parseInt(newVersionCodes[0]);

                        if (newMajorCode > curMajorCode) {

                            return VersionCheckResult.MAJOR_UPDATE;
                        } else {

                            return VersionCheckResult.MINOR_UPDATE;
                        }
                    } else {
                        return VersionCheckResult.INVALID;
                    }
                }
            }
        } else {

            return VersionCheckResult.INVALID;
        }
    }

}
