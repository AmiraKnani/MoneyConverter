package com.example.miniappconvmonnaie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entree;
    RadioGroup groupConversion;
    Button convertir;
    TextView sortie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entree=(EditText)findViewById(R.id.idMonnaie);
        groupConversion=(RadioGroup)findViewById(R.id.groupbtn);
        convertir=(Button)findViewById(R.id.btnConvert);
        sortie=(TextView)findViewById(R.id.result);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(entree.getText().toString().equals(""))
                {
                    AlertDialog.Builder alertDialog;
                    alertDialog= new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Champ manquant");
                    alertDialog.setMessage("Vous devez saisir une valeur");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }
                else { float valeurInit=0.0F, res;

                    valeurInit=Float.valueOf(entree.getText().toString());
                    if(groupConversion.getCheckedRadioButtonId()==R.id.EurDin)
                    {
                        res=euroToDinar(valeurInit);
                    }
                    else
                        res=dinarToEuro(valeurInit);
                    sortie.setText(String.valueOf(String.format("%.02f",res)));

                }
            }
        });

    }

    public float euroToDinar(float vEuro)
    {
        return(float) (vEuro*3.112);
    }

    public float dinarToEuro(float vDinar)
    {
        return(float) (vDinar*0.316);
    }
}