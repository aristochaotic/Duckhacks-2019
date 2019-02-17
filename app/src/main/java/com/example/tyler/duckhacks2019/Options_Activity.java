package com.example.tyler.duckhacks2019;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Options_Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    String op1;
    RadioGroup rGroup1 = null;
    EditText edit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_);

        RadioGroup rGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        edit = (EditText) findViewById(R.id.editText);
        edit.setEnabled(false);

        edit.setFocusable(true);

        rGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton11:
                        op1 = "call";
                        enableEdit(true);
                        break;
                     default:
                         enableEdit(false);
                         break;
                }
            }
        });
    }

    public void enableEdit(boolean state){
        edit.setEnabled(state);
        if(state){
            edit.requestFocus();
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
