package com.example.wangm9557.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText editName;
    EditText editAddress;
    EditText editAge;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataBaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editAddress = (EditText) findViewById(R.id.editText_address);
        editAge = (EditText) findViewById(R.id.editText_age);
    }

    public void addData(View v){
        boolean isInserted = myDb.insertData(editName.getText().toString(), editAddress.getText().toString(), editAge.getText().toString() );
        int duration = Toast.LENGTH_SHORT;
        Toast toastSuccessful = Toast.makeText(this, "Inserted Correctly", duration);
        Toast toastNotSuccessful = Toast.makeText(this, "Inserted Incorrectly", duration);
        if(isInserted){
            Log.d("MyContact", "Data Insertion Successful");
            // create toast message to user indicating data inserted correctly
            toastSuccessful.show();
        }

        else {
            Log.d("MyContact", "Data Insertion inuccessful");
            // create toast message to user indicating data inserted incorrectly
            toastNotSuccessful.show();
        }
    }

}