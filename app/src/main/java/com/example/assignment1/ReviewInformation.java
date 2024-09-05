package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewInformation extends AppCompatActivity {
    TextView tvSenderName, tvSenderCountry, tvSenderAddress, tvSenderContact;
    TextView tvName, tvCountry, tvAddress, tvContact;
    ImageView btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent props = getIntent();
        if(props != null)
        {
            tvSenderName.setText(props.getStringExtra("prop_sName"));
            tvSenderCountry.setText(props.getStringExtra("prop_sCountry"));
            tvSenderAddress.setText(props.getStringExtra("prop_sAddress"));
            tvSenderContact.setText(props.getStringExtra("prop_sContactInfo"));

            tvName.setText(props.getStringExtra("prop_name"));
            tvCountry.setText(props.getStringExtra("prop_country"));
            tvAddress.setText(props.getStringExtra("prop_address"));
            tvContact.setText(props.getStringExtra("prop_contactInfo"));
        }

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReviewInformation.this, SenderForm.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void init()
    {
        tvSenderName = findViewById(R.id.tvSenderName);
        tvSenderCountry = findViewById(R.id.tvSenderCountry);
        tvSenderAddress = findViewById(R.id.tvSenderAddress);
        tvSenderContact = findViewById(R.id.tvSenderContact);

        tvName = findViewById(R.id.tvRecieverName);
        tvCountry = findViewById(R.id.tvRecieverCountry);
        tvAddress = findViewById(R.id.tvRecieverAddress);
        tvContact = findViewById(R.id.tvRecieverContact);
        btnClear = findViewById(R.id.btnClear);
    }
}