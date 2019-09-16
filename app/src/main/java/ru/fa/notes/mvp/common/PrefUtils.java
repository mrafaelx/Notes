package ru.fa.notes.mvp.common;

import android.content.Context;
import android.content.SharedPreferences;

import ru.fa.notes.app.NotesApp;

public class PrefUtils {
    private static final String PREF_NAME = "notes_fa";

    public static SharedPreferences getPrefs() {
        return NotesApp.instance.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }
}
