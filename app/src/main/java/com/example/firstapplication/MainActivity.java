package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private FakeDatabase database;
    private EditText searchBar;
    private RecyclerNotesAdapter adapter;
    private RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        initializeDatabase();
        configureRecyclerViewNotes();
        configureSearchLogic();
    }

    private void initializeUI() {
        recyclerViewNotes = findViewById(R.id.recycler_view);
        searchBar = findViewById(R.id.search_bar);
    }

    private void configureSearchLogic() {
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                Runnable runnable = new Runnable() { //THIS IS MULTI THREADING
                    @Override
                    public void run() {
                        List<Notes> filteredList = database.filter(editable.toString());
                        updateListOfNotes(filteredList);
                    }
                };
                runnable.run(); //execute defined asynchronous process
            }
        });
    }

    private void displayMessage() {
        Toast.makeText(MainActivity.this, "enetered information is not found in any notes", LENGTH_SHORT).show();
    }

    private void configureRecyclerViewNotes() {
        configureClickListeners();
        recyclerViewNotes.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new RecyclerNotesAdapter(listener);
        recyclerViewNotes.setAdapter(adapter);
        updateListOfNotes(database.getListOfNotes());
    }

    private void updateListOfNotes(List<Notes> listOfNotes) {
        if (listOfNotes.isEmpty()) {
            displayMessage();
            return;
        }
        adapter.submitList(listOfNotes);
    }

    private void configureClickListeners() {
        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ActivityNoteDetails.class);
                intent.putExtra("Header", database.getListOfNotes().get(position).getHeader());
                intent.putExtra("Context", database.getListOfNotes().get(position).getContext());
                intent.putExtra("Date", database.getListOfNotes().get(position).getDate());
                startActivity(intent);
            }
        };
    }

    private void initializeDatabase() {
        database = new FakeDatabase();
    }

}