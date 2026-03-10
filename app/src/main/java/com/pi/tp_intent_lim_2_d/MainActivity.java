package com.pi.tp_intent_lim_2_d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnApropos,btnPassParam;
    EditText edtParam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnApropos = findViewById(R.id.btnApropos);
        btnPassParam = findViewById(R.id.btnPassParam);
        edtParam = findViewById(R.id.edtParam);

        btnPassParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //récupérer le texte saisi par l'utilisateur
                String sParam = edtParam.getText().toString();
                Intent i2 = new Intent(getApplicationContext(), PassParamActivity.class);
                i2.putExtra("param", sParam );
                startActivity(i2);
            }
        });

        btnApropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AproposActivity.class);
                startActivity(i);
            }
        });


    }
}