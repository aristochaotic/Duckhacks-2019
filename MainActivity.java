package com.example.plswork;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.plswork.Data.Concern;
import com.example.plswork.m_FireBase.FirebaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    EditText nameEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        //SET UP FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
            //    displayInputDialog();
            }
        //});
    //}

    //DISPLAY INPUT DIALOG
    private void displayInputDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Save To Firebase");
        //d.setContentView(R.layout.input_dialog);

        nameEditTxt= (EditText) d.findViewById(R.id.messageTxt);
        Button saveBtn= (Button) d.findViewById(R.id.sendBtn);

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String message=nameEditTxt.getText().toString();
                //String propellant=propTxt.getText().toString();
              //  String desc=descTxt.getText().toString();

                //SET DATA
                Concern s=new Concern();
                s.setMessage(message);
               // s.setPropellant(propellant);
               // s.setDescription(desc);

                //SAVE
                if(message != null && message.length()>0)
                {
                    if(helper.save(s))
                    {
                        nameEditTxt.setText("");
                      //  propTxt.setText("");
                       // descTxt.setText("");

                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        d.show();
    }

}

    /*/public void basicReadWrite() {
         //[START write_message]
         //Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
         //[END write_message]

         //[START read_message]
         //Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 This method is called once with the initial value and again
                 whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        }); /*/
        // [END read_message]

