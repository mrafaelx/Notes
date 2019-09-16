package ru.fa.notes.mvp.common;

public class PrefNotes {

    public static String getNote(String nameKey) {
        return PrefUtils.getPrefs().getString(nameKey, "");
    }

    public static void setNote(String nameKey, String note) {
        PrefUtils.getEditor().putString(nameKey, note).commit();
    }
}
