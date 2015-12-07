package com.plurlasight.notetaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditNoteActivity extends AppCompatActivity {

    private boolean isInEditMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        final Button saveButton = (Button) findViewById(R.id.saveButton);
        final Button cancelButton = (Button) findViewById(R.id.cancelButton);
        final EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
        final EditText noteEditText = (EditText) findViewById(R.id.noteEditText);
        final TextView dateTextView = (TextView) findViewById(R.id.dateTextView);

        Serializable extra = getIntent().getSerializableExtra("Note");

        if (extra != null) {
            Note note = (Note) extra;
            titleEditText.setText(note.getTitle());
            noteEditText.setText(note.getNote());

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String date = dateFormat.format(note.getDate());

            dateTextView.setText(date);

            isInEditMode = false;
            titleEditText.setEnabled(false);
            noteEditText.setEnabled(false);
            saveButton.setText("Edit");
        }

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, new Intent());
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInEditMode) {
                    Intent returnIntent = new Intent();
                    Note note;
                    note = new Note(titleEditText.getText().toString(), noteEditText.getText().toString(), Calendar.getInstance().getTime());
                    returnIntent.putExtra("Note", note);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                } else {
                    isInEditMode = true;
                    saveButton.setText("Save");
                    titleEditText.setEnabled(true);
                    noteEditText.setEnabled(true);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
