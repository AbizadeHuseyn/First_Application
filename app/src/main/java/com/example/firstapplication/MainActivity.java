package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerViewNotes;
    private FakeDatabase database;
    private EditText searchBar;
    RecyclerNotesAdapter adapter;
    private  RecyclerNotesAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        initializeDatabase();
        configureRecyclerViewNotes();
        searchLogic();
    }

    private void initializeUI(){

        recyclerViewNotes = findViewById(R.id.recycler_view);
        searchBar = findViewById(R.id.search_bar);

    }

    private void searchLogic(){
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());

            }
        });
    }

    private void filter(String text){
        ArrayList<Notes>  filteredList = new ArrayList<>();

        for(Notes note: database.getListOfNotes()){
            if(note.getContext().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(note);
            }

        }

        if(filteredList.size() == 0){
            displayMessage();
            adapter.submitList(database.getListOfNotes());
            return;

        }

        adapter.filterList(filteredList);
    }

    private void displayMessage (){
        Toast.makeText(MainActivity.this, "enetered information is not found in any notes", LENGTH_SHORT).show();
    }

    private void configureRecyclerViewNotes(){
        adapter =  new RecyclerNotesAdapter(listener);
        setOnClickListener();
        recyclerViewNotes.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        recyclerViewNotes.setAdapter(adapter);
        adapter.submitList(database.getListOfNotes());

    }

    private void setOnClickListener (){
        listener = new RecyclerNotesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ActivityForNotes.class);
                intent.putExtra("Header", database.getListOfNotes().get(position).getHeader());
                intent.putExtra("Context", database.getListOfNotes().get(position).getContext());
                intent.putExtra("Date", database.getListOfNotes().get(position).getDate());
                startActivity(intent);

            }
        };
    }

    private void initializeDatabase(){
        database = new FakeDatabase();
    }


}