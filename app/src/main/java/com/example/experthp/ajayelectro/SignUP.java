package com.example.experthp.ajayelectro;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.experthp.ajayelectro.DataBase.ContactDetails;

import java.util.regex.Pattern;

public class SignUP extends AppCompatActivity{
    ContactDetails db=new ContactDetails(this);
    EditText name,email,ph,pass,Confrm_Pass;
    Button addBtn,viewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        ph = (EditText) findViewById(R.id.PhNo);
        pass = (EditText) findViewById(R.id.PassWd1);
        Confrm_Pass = (EditText) findViewById(R.id.PassWd2);
        addBtn = (Button) findViewById(R.id.submit);
        addBtn.setEnabled(false);
        viewBtn = (Button) findViewById(R.id.View);
        viewBtn.setEnabled(false);

        //empty editview validation
        TextWatcher watcher = new LocalTextWatcher();
        name.addTextChangedListener(watcher);
        email.addTextChangedListener(watcher);
        ph.addTextChangedListener(watcher);
        pass.addTextChangedListener(watcher);
        Confrm_Pass.addTextChangedListener(watcher);

    }
    public void addDetails(View v){
        Log.d("test", "Adding");
        if (pass.getText().toString().equals(Confrm_Pass.getText().toString())==false)
            Toast.makeText(this, "Confirm password is not matching with password", Toast.LENGTH_LONG).show();
        else if (check==false)
            Toast.makeText(this,"Email is not valid",Toast.LENGTH_LONG).show();
        else
        {
            db.open();
            db.insertRecord(name.getText().toString(), email.getText().toString(), ph.getText().toString(),pass.getText().toString());
            db.close();
            name.setText("");
            email.setText("");
            ph.setText("");
            pass.setText("");
            Confrm_Pass.setText("");
            Toast.makeText(SignUP.this,"Contact Details added Successfully",Toast.LENGTH_LONG).show();

        }}

    public void viewDetails(View v){
        Log.d("Records","Viewing");
        db.open();
        Cursor c=db.getRecord("erjyoti@gmail.com");
        if(c.moveToFirst()) {
            //DBGetRecord(c);
            name = (EditText) findViewById(R.id.Name);
            email = (EditText) findViewById(R.id.Email);
            ph = (EditText) findViewById(R.id.PhNo);
            name.setText(c.getString(1));
            email.setText(c.getString(2));
            ph.setText(c.getString(3));
            pass.setText(c.getString(4));
        }
        else
            Toast.makeText(this,"fail to view records",Toast.LENGTH_LONG).show();
        db.close();
    }


    //public void DBGetRecord(Cursor c){
    //     Toast.makeText(this,"id"+c.getString(0)+
    //           "Name"+c.getString(1),Toast.LENGTH_LONG).show();
    //}

    void updateButtonState() {
        if (checkEditText(name) || checkEditText(email) || checkEditText(ph) || checkEditText(pass) || checkEditText(Confrm_Pass)) {
            addBtn.setEnabled(false);
            //Toast.makeText(this,"Please fill all fields",Toast.LENGTH_LONG).show();
            //viewBtn.setEnabled(false);
        } else {
            addBtn.setEnabled(true);

        }
    }

    boolean check;
    void isValidEmail(EditText email1) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        check =   pattern.matcher(email1.getText().toString()).matches();
        if (check==false)

            email1.setError("invalid email");


    }



    private boolean checkEditText(EditText edit) {
        //return Integer.getInteger(edit.getText().toString()) != null;
        return edit.getText().length() == 0;
    }

    private class LocalTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable s) {
            updateButtonState();
            isValidEmail(email);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }
}
