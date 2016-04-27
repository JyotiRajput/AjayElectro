package com.example.experthp.ajayelectro;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.experthp.ajayelectro.DataBase.ContactDetails;

public class Login extends AppCompatActivity {
    ContactDetails db=new ContactDetails(this);
    Button Btn1;
    TextView txt1,Txt1SignUp;
    EditText Edt1;
    EditText Edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Btn1 = (Button) findViewById(R.id.Button1);
        Btn1.setEnabled(false);
        txt1 = (TextView) findViewById(R.id.textView2);
        Edt1 = (EditText) findViewById(R.id.EditText1);
        Edt2 = (EditText) findViewById(R.id.EditText2);

        TextWatcher watcher = new LocalTextWatcher();
        Edt1.addTextChangedListener(watcher);
        Edt2.addTextChangedListener(watcher);

        //updateButtonState();





        Btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // txt1.setText(Edt1.getText().toString());
                // txt1.append(" Has been Login Successfully");
                // txt1.setVisibility(View.VISIBLE);


                Log.d("btn1", Edt1.getText().length() + "Bt1 is clicked");
                String k=Edt1.getText().toString();

                db.open();
                Cursor c=db.matchPassword(k);
                if(c.getCount()>0){
                    if (c.moveToFirst()) {
                        //DBGetRecord(c);
                        String pass;
                        pass = c.getString(0);
                        Log.d("name and email test", pass + "is");
                        //Email = c.getString(2);
                        if (Edt2.getText().toString().equals(pass)) {
                            //Toast.makeText(MainActivity1.this, "Login Succesfully", Toast.LENGTH_LONG).show();
                            Intent int_menu= new Intent(Login.this,Expandable_Slideview.class);
                            startActivity(int_menu);

                        } else
                            Log.d("login ", "unsucessfull");
                    }}
                else
                    Toast.makeText(Login.this, "Email not exist", Toast.LENGTH_LONG).show();
                db.close();
                Edt1.setText("");
                Edt2.setText("");


            }

        });

        //public void SignUp(View v) {
        Txt1SignUp = (TextView) findViewById(R.id.textView1);
        Txt1SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, SignUP.class);
                startActivity(intent1);
            }
        });

        /*try{
            String path="C:\\Users\\expert HP\\AndroidStudioProjects\\HelloWorldPRG1\\app\\src\\main\\java\\com\\example\\experthp\\helloworldprg1" +"/databases/jojo";
            File file =new File(path);
            if (!file.exists()){
                    CopyDB(getBaseContext().getAssets().open("Mydb"),new FileOutputStream(path));
            }
        }
        catch (FileNotFoundException e){
                e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }*/


    }
    void updateButtonState() {
        if(checkEditText(Edt1) || checkEditText(Edt2)) Btn1.setEnabled(false);
        else Btn1.setEnabled(true);

    }


    private boolean checkEditText(EditText edit) {
        //return Integer.getInteger(edit.getText().toString()) != null;
        return edit.getText().length() == 0;
    }

    private class LocalTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable s) {
            updateButtonState();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }







}
