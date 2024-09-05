package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderForm extends AppCompatActivity {
    Button btnSenderNext;
    EditText etSEmail, etSName, etSContactInformation, etSCountry, etSAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnSenderNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etSEmail.getText().toString().trim();
                String name = etSName.getText().toString().trim();
                String contactInfo = etSContactInformation.getText().toString().trim();
                String country = etSCountry.getText().toString().trim();
                String address = etSAddress.getText().toString().trim();

                if(!email.isEmpty() && !name.isEmpty() && !contactInfo.isEmpty() && !country.isEmpty() && !address.isEmpty())
                {
                    Intent i = new Intent(SenderForm.this, RecieverForm.class);
                    i.putExtra("prop_sEmail", email);
                    i.putExtra("prop_sName", name);
                    i.putExtra("prop_sContactInfo", contactInfo);
                    i.putExtra("prop_sCountry", country);
                    i.putExtra("prop_sAddress", address);
                    if(email.contains("@"))
                    {
                        startActivity(i);
                        finish();
                    }
                    else {
                        Toast.makeText(SenderForm.this, "Email must contain @ symbol",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SenderForm.this, "All fields must be filled",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init()
    {
        btnSenderNext = findViewById(R.id.btnSenderNext);
        etSEmail = findViewById(R.id.etSEmail);
        etSName = findViewById(R.id.etSName);
        etSContactInformation = findViewById(R.id.etSContactInformation);
        etSCountry = findViewById(R.id.etSCountry);
        etSAddress = findViewById(R.id.etSAddress);
    }
}