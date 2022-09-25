package com.tmdirectmessenger.tmdirectmessenger;

import android.accessibilityservice.AccessibilityService;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

public class FileUtils {

    public static boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isAccessibilitySettingsOn(Context context) {
        int accessibilityEnabled = 0;
        final String service = context.getPackageName() + "/" + AccessibilityService.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    context.getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {

        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    context.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();

                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        } else {
        }
        if (accessibilityEnabled == 0) {
            return false;
        } else {
            return true;
        }
    }
}
