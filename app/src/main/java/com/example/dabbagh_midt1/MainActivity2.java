package com.example.dabbagh_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    String firstName;
    String title;
    String date2;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn1 = (Button) findViewById(R.id.buttonActivity2toActivity1);
        Button btn3 = (Button) findViewById(R.id.buttonActivity2toActivity3);
        Button submit =(Button) findViewById(R.id.submitBttn);
        EditText name =(EditText) findViewById(R.id.inputName);
        EditText year =(EditText) findViewById(R.id.inputYear);
        final RadioButton female = (RadioButton) findViewById(R.id.radioButtonFEMALE);
        final RadioButton male = (RadioButton) findViewById(R.id.radioButtonMALE);
        final RadioButton instructor = (RadioButton) findViewById(R.id.radioButtonINSTRUCTOR);
        final RadioButton student = (RadioButton) findViewById(R.id.radioButtonSTUDENT);
        TextView output = (TextView) findViewById(R.id.output);

        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity2.this, d, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = (name.getText().toString());
                age = 2021 - (Integer.parseInt(year.getText().toString()));
                if (male.isChecked()) {
                    title="Mr. ";
                }
                else if (female.isChecked()) {
                    title="Mrs. ";
                }
                else{
                    title="N/A ";
                }
                output.setText("Hi " + title + firstName + " you are " + age + " years old");
                if(instructor.isChecked()){
                    Toast.makeText(MainActivity2.this, "Hi, Prof. "+firstName, Toast.LENGTH_LONG).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }

    Calendar c = Calendar.getInstance();
    DateFormat fmtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }};
}