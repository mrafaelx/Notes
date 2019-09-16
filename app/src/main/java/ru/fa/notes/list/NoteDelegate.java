package ru.fa.notes.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;

import java.util.ArrayList;
import java.util.List;

import ru.fa.notes.R;
import ru.fa.notes.mvp.model.Note;

public class NoteDelegate extends AdapterDelegate<ArrayList<Note>> {

    private OnClickItem onClickItem;

    public NoteDelegate(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    @Override
    protected boolean isForViewType(@NonNull ArrayList<Note> items, int position) {
        return items.get(position).getClass().getSimpleName().equals(Note.class.getSimpleName());
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new NoteHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false),
                onClickItem
        );
    }

    @Override
    protected void onBindViewHolder(@NonNull ArrayList<Note> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        ((NoteHolder) holder).bind(items.get(position));
    }
}
