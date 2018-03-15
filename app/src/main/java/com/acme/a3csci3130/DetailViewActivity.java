package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;


public class DetailViewActivity extends Activity {

    private EditText businessNumberFiled, nameField, primaryBussinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = ((MyApplicationData) getApplicationContext());
        businessNumberFiled = (EditText) findViewById(R.id.business_number);
        nameField = (EditText) findViewById(R.id.name);
        primaryBussinessField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){

            businessNumberFiled.setText(receivedPersonInfo.business_number);
            nameField.setText(receivedPersonInfo.name);
            primaryBussinessField.setText(receivedPersonInfo.primary_business);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);

        }
    }

    public void updateContact(View v){
        String uid = receivedPersonInfo.uid;

        String business_number = businessNumberFiled.getText().toString();
        String name = nameField.getText().toString();
        String primary_business = primaryBussinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(uid, business_number, name, primary_business, address, province);
        appState.firebaseReference.child(uid).setValue(person);
        finish();

        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);

    }

    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }
}
