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

public class RecieverForm extends AppCompatActivity {

    Button btnNext;
    EditText etEmail, etName, etContactInformation, etCountry, etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reciever_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String contactInfo = etContactInformation.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                Intent prop = getIntent();

                if(!email.isEmpty() && !name.isEmpty() && !contactInfo.isEmpty() && !country.isEmpty() && !address.isEmpty() && prop != null)
                {
                    Intent i = new Intent(RecieverForm.this, ReviewInformation.class);
                    i.putExtra("prop_sEmail", prop.getStringExtra("prop_sEmail"));
                    i.putExtra("prop_sName", prop.getStringExtra("prop_sName"));
                    i.putExtra("prop_sContactInfo", prop.getStringExtra("prop_sContactInfo"));
                    i.putExtra("prop_sCountry", prop.getStringExtra("prop_sCountry"));
                    i.putExtra("prop_sAddress", prop.getStringExtra("prop_sAddress"));
                    i.putExtra("prop_email", email);
                    i.putExtra("prop_name", name);
                    i.putExtra("prop_contactInfo", contactInfo);
                    i.putExtra("prop_country", country);
                    i.putExtra("prop_address", address);
                    if(email.contains("@"))
                {
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(RecieverForm.this, "Email must contain @ symbol",
                            Toast.LENGTH_SHORT).show();
                }
                }
                else {
                    Toast.makeText(RecieverForm.this, "All fields must be filled",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init()
    {
        btnNext = findViewById(R.id.btnRecieverNext);
        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etContactInformation = findViewById(R.id.etContactInformation);
        etCountry = findViewById(R.id.etCountry);
        etAddress = findViewById(R.id.etAddress);
    }
}