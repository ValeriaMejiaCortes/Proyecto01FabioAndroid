package com.example.proyecto01fabio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateNew extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";
    EditText EditTypeDocument;
    EditText EditDocument;
    EditText EditCode;
    EditText EditName;
    EditText EditLastName;
    EditText EditGender;
    EditText EditEmail;
    EditText EditPhone;
    Button btnSave;
    TextView txtStudent;
    TextView txtNameShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
         EditTypeDocument = (EditText) findViewById(R.id.EditTypeDocument);
         EditDocument =  (EditText)findViewById(R.id.EditDocument);
         EditCode =  (EditText)findViewById(R.id.EditCode);
         EditName =  (EditText)findViewById(R.id.EditName);
         EditLastName =  (EditText)findViewById(R.id.EditLastName);
         EditGender = (EditText) findViewById(R.id.EditGender);
         EditEmail =  (EditText) findViewById(R.id.EditEmail);
         EditPhone =  (EditText) findViewById(R.id.EditPhone);
         txtStudent = (TextView) findViewById(R.id.txtStudent);
         txtNameShow = (TextView) findViewById(R.id.txtNameShow);

         btnSave = (Button) findViewById(R.id.btnSave);

    }

    public void GetTextFromSQL(View v){
        try{

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();

            if (connect != null){
                if (Validations() == 8){
                    PreparedStatement pst = connect.prepareStatement("exec dbo.proc_InsertStudent?, ?, ?, ?, ?, ?, ?, ?;");
                    pst.setString(1, EditTypeDocument.getText().toString());
                    pst.setString(2, EditDocument.getText().toString());
                    pst.setString(3, EditCode.getText().toString());
                    pst.setString(4, EditName.getText().toString());
                    pst.setString(5, EditLastName.getText().toString());
                    pst.setString(6, EditGender.getText().toString());
                    pst.setString(7, EditEmail.getText().toString());
                    pst.setString(8, EditPhone.getText().toString());
                    pst.executeUpdate();

                    Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT).show();

                    Intent myIntent = new Intent( this, CreateNew.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"¡ERROR! Complete all fields", Toast.LENGTH_SHORT).show();
                }


            }else{
                ConnectionResult = "Check Connection";
            }
        }catch (Exception ex){
            Log.e("error", ex.getMessage());
        }
    }

    public int Validations(){
        int cont = 0;

        if(EditTypeDocument.getText().toString().isEmpty()){
            EditTypeDocument.setError("Campo Requerido");
        }else{
            EditTypeDocument.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditDocument.getText().toString().isEmpty()){
            EditDocument.setError("Campo Requerido");
        }else{
            EditDocument.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditCode.getText().toString().isEmpty()){
            EditCode.setError("Campo Requerido");
        }else{
            EditCode.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditName.getText().toString().isEmpty()){
            EditName.setError("Campo Requerido");
        }else{
            EditName.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditLastName.getText().toString().isEmpty()){
            EditLastName.setError("Campo Requerido");
        }else{
            EditLastName.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditGender.getText().toString().isEmpty()){
            EditGender.setError("Campo Requerido");
        }else{
            EditGender.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditEmail.getText().toString().isEmpty()){
            EditEmail.setError("Campo Requerido");
        }else{
            EditEmail.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        if(EditPhone.getText().toString().isEmpty()){
            EditPhone.setError("Campo Requerido");
        }else{
            EditPhone.setBackgroundColor(Color.parseColor("#4ff06d"));
            cont ++;
        }

        return cont;

    }



}