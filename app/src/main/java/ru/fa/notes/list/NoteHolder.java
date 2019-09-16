package ru.fa.notes.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.fa.notes.R;
import ru.fa.notes.mvp.model.Note;

class NoteHolder extends RecyclerView.ViewHolder {

    private Note model;

    NoteHolder(@NonNull View itemView, OnClickItem onClickItem) {
        super(itemView);
        itemView.setOnClickListener(v ->
                onClickItem.onClick(model)
        );

        itemView.setOnLongClickListener(v -> {
            onClickItem.onLongClick();
            return false;
        });
    }

    void bind(Note model) {
        this.model = model;

        TextView txtNoteTitle = itemView.findViewById(R.id.txtNoteTitle);
        TextView txtNoteBody = itemView.findViewById(R.id.txtNoteBody);

        txtNoteTitle.setText(model.getTitle());
        txtNoteBody.setText(model.getBody());
    }
}
