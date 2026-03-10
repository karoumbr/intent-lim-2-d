package com.pi.tp_intent_lim_2_d;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnApropos,btnPassParam,btnResult;
    EditText edtParam;
    TextView txtResult;
    Button button4,button5,button6,button7,button8;
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
        btnResult = findViewById(R.id.btnResult);
        txtResult = findViewById(R.id.txtResult);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ichrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=woB4E3innbE&list=PL6bOvrvJX9SSGE2vAk5eHnNpA5uP78KyD"));
                startActivity(ichrome);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGoogleMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:36.800204,10.1862744"));
                startActivity(iGoogleMap);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iTelephone = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:21699888777"));
                startActivity(iTelephone);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(iCamera);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] TO = {"karoumbr@yahoo.fr"};
                String[] CC= {""};
                Intent iGmail = new Intent(Intent.ACTION_SEND);
                iGmail.setData(Uri.parse("mailto:"));
                iGmail.setType("text/plain");
                iGmail.putExtra(Intent.EXTRA_EMAIL,TO);
                iGmail.putExtra(Intent.EXTRA_CC, CC);
                iGmail.putExtra(Intent.EXTRA_SUBJECT, "Sujet Email");
                iGmail.putExtra(Intent.EXTRA_TEXT, "N'oubliez pas de vous inscrire sur la chaîne Youtube \"BEN TECH PRO TV\" et appuyer sur le bouton de notification.\n Karim Ben Romdhane. ");
                try {
                    startActivity(Intent.createChooser(iGmail,"Envoi de email..."));
                    finish();;
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(),"Installez un client email.", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(), ResultActivity.class);
                startActivityForResult(i3,4);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 4){
            String message = data.getStringExtra("MESSAGE");
            txtResult.setText("Résultat: " + message );
        }
    }
}