package com.example.firstapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerNotesAdapter extends RecyclerView.Adapter<ItemNoteViewHolder> {

    private RecyclerViewClickListener listener;

    private List<Notes> givenListOfNotes = new ArrayList<>();

    public RecyclerNotesAdapter(RecyclerViewClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.item_note, parent, false);
        return new ItemNoteViewHolder(rootView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNoteViewHolder holder, int position) {
        holder.bindItem(givenListOfNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return givenListOfNotes.size();
    }

    public void submitList(List<Notes> notes) {
        this.givenListOfNotes = notes;
        notifyDataSetChanged();
    }

}
