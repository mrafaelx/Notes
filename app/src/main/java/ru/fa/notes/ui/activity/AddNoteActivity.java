package ru.fa.notes.ui.activity;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.fa.notes.R;
import ru.fa.notes.mvp.presenter.NoteListPresenter;
import ru.fa.notes.mvp.view.NotesListView;

public class AddNoteActivity extends AppCompatActivity implements NotesListView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText etNoteTitle = findViewById(R.id.etNoteTitle);
        EditText etNoteBody = findViewById(R.id.etNoteBody);
        FloatingActionButton btnSave = findViewById(R.id.btnSave);

        if (getIntent().getExtras() != null) {
            etNoteTitle.setText(getIntent().getStringExtra(MainActivity.NOTE_TITLE));
            etNoteBody.setText(getIntent().getStringExtra(MainActivity.NOTE_BODY));
        }

        NoteListPresenter presenter = new NoteListPresenter();
        presenter.attachView(this);

        btnSave.setOnClickListener(v -> {
            presenter.addNote(etNoteTitle.getText().toString(), etNoteBody.getText().toString());
            finish();
        });
    }
}
