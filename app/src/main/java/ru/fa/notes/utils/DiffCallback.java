package ru.fa.notes.utils;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class DiffCallback<T> extends DiffUtil.Callback {

    private List<T> newData;
    private List<T> oldData;

    public DiffCallback(List<T> newData, List<T> oldData) {
        this.newData = newData;
        this.oldData = oldData;
    }

    @Override
    public int getOldListSize() {
        return oldData.size();
    }

    @Override
    public int getNewListSize() {
        return newData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldData.get(oldItemPosition) == newData.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldData.get(oldItemPosition) == newData.get(newItemPosition);
    }
}
