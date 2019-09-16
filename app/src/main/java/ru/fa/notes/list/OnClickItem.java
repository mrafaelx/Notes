package ru.fa.notes.list;

import ru.fa.notes.mvp.model.Note;

public interface OnClickItem {
    void onClick(Note item);
    void onLongClick();
}
