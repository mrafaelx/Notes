package ru.fa.notes.list;

import androidx.recyclerview.widget.DiffUtil;

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.fa.notes.mvp.model.Note;
import ru.fa.notes.utils.DiffCallback;

public class NotesAdapter extends ListDelegationAdapter<ArrayList<Note>> {

    public NotesAdapter(OnClickItem onClickItem) {
        items = new ArrayList<>();
        delegatesManager
                .addDelegate(new NoteDelegate(onClickItem));
    }

    public void setAdd(List<Note> list) {
        List<Note> oldData = items;

        items.clear();
        items.addAll(list);

        DiffUtil
                .calculateDiff(new DiffCallback<>(items, oldData), false)
                .dispatchUpdatesTo(this);
    }
}
