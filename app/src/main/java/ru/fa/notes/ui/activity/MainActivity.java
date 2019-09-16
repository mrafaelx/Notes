package ru.fa.notes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ru.fa.notes.R;
import ru.fa.notes.list.NotesAdapter;
import ru.fa.notes.list.OnClickItem;
import ru.fa.notes.mvp.common.PrefNotes;
import ru.fa.notes.mvp.common.PrefUtils;
import ru.fa.notes.mvp.model.Note;
import ru.fa.notes.mvp.presenter.NoteListPresenter;
import ru.fa.notes.mvp.view.NotesListView;

public class MainActivity extends AppCompatActivity implements NotesListView {

    public static final String NOTE_TITLE = "note_title";
    public static final String NOTE_BODY = "note_body";

    private NotesAdapter notesAdapter = new NotesAdapter(new OnClickItem() {
        @Override
        public void onClick(Note item) {
            Intent data = new Intent(MainActivity.this, AddNoteActivity.class);
            data.putExtra(NOTE_TITLE, item.getTitle());
            data.putExtra(NOTE_BODY, item.getBody());
            startActivity(data);
        }

        @Override
        public void onLongClick() {
            // TODO
        }
    });

    private NoteListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvNoteList = findViewById(R.id.rvNotesList);
        rvNoteList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvNoteList.setAdapter(notesAdapter);

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
        });

        presenter = new NoteListPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotes(presenter.getNotes());
    }

    private void showNotes(List<Note> notes) {
        notesAdapter.notifyDataSetChanged();
        notesAdapter.setAdd(notes);
    }

}
