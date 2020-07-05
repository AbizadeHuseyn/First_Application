package com.example.firstapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemNoteViewHolder extends RecyclerView.ViewHolder {

    private View root;
    private TextView header;
    private TextView context;
    private TextView date;
    private RecyclerViewClickListener listener;

    public ItemNoteViewHolder(@NonNull View itemView, final RecyclerViewClickListener listener) {
        super(itemView);

        this.listener = listener;

        root = itemView;
        header = itemView.findViewById(R.id.header);
        context = itemView.findViewById(R.id.context);
        date = itemView.findViewById(R.id.date);
    }

    public void bindItem(Notes noteData) {
        header.setText(noteData.getHeader());
        context.setText(noteData.getContext());
        date.setText(noteData.getDate());

        configureClickListener();
    }

    private void configureClickListener() {
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition());
            }
        });
    }

}
