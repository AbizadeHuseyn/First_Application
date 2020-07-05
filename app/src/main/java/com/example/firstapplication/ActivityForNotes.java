package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityForNotes extends AppCompatActivity {

    private EditText header;
    private EditText context;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_notes);

        header = findViewById(R.id.note_header);
        context = findViewById(R.id.note_context);
        date = findViewById(R.id.note_date);


        String header1 = "Header is not written";
        String context1 = "Context is not written";
        String date1 = "Date is not written";

        Bundle extras  = getIntent().getExtras();

        if(extras != null ){

            header1 = extras.getString("Header");
            context1 = extras.getString("Context");
            date1 = extras.getString("Date");


        }

        header.setText(header1);
        context.setText(context1);
        date.setText(date1);


    }


}