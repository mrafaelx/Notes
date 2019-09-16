package ru.fa.notes.app;

import android.app.Application;

public class NotesApp extends Application {
    public static Application instance;

    public NotesApp() {
        instance = this;
    }
}
