package ru.fa.notes.mvp.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ru.fa.notes.mvp.common.BasePresenter;
import ru.fa.notes.mvp.common.PrefNotes;
import ru.fa.notes.mvp.common.PrefUtils;
import ru.fa.notes.mvp.model.Note;
import ru.fa.notes.mvp.view.NotesListView;

public class NoteListPresenter extends BasePresenter<NotesListView> {
    public List<Note> getNotes() {
        Log.e("PREFS", "Hello!");
        Map<String, ?> notes = PrefUtils.getPrefs().getAll();
        List<Note> result = new ArrayList<>();
        for (Map.Entry<String, ?> entry : notes.entrySet()) {
            result.add(new Note(entry.getKey(), entry.getValue().toString()));
        }
        return result;
    }

    public void addNote(String title, String note) {
        PrefNotes.setNote(title, note);
    }
}
