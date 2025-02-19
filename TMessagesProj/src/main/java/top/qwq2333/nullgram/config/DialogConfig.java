package top.qwq2333.nullgram.config;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;

import top.qwq2333.nullgram.helpers.TranslateHelper;

public class DialogConfig {
    private static final SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("dialogconfig", Context.MODE_PRIVATE);

    public static boolean isAutoTranslateEnable(long dialog_id, int topicId) {
        return preferences.getBoolean("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""), TranslateHelper.getAutoTranslate());
    }

    public static boolean hasAutoTranslateConfig(long dialog_id, int topicId) {
        return preferences.contains("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""));
    }

    public static void setAutoTranslateEnable(long dialog_id, int topicId, boolean enable) {
        preferences.edit().putBoolean("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""), enable).apply();
    }

    public static void removeAutoTranslateConfig(long dialog_id, int topicId) {
        preferences.edit().remove("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : "")).apply();
    }

}
