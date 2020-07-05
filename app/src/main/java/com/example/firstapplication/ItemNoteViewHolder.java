package com.example.firstapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class ItemNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView header;
    private TextView context;
    private TextView date;
    private RecyclerNotesAdapter.RecyclerViewClickListener listener;


    public ItemNoteViewHolder(@NonNull View itemView) {
        super(itemView);

        header = itemView.findViewById(R.id.header);
        context = itemView.findViewById(R.id.context);
        date = itemView.findViewById(R.id.date);

        itemView.setOnClickListener(this);

    }

    public void findItem(Notes noteData){

        header.setText(noteData.getHeader());
        context.setText(noteData.getContext());
        date.setText(noteData.getDate());

    }

    @Override
    public void onClick(View view) {

        listener.onClick(view, getAdapterPosition());

    }
}
