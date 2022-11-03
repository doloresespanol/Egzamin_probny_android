package com.example.obrazki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    private ArrayList<Integer> zdjecia;
    private int indeks;
    public Button dalejButton;
    public Button wsteczButton;
    public ImageView imageView;
    EditText editTekst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przygotujZdjecia();
        dalejButton = findViewById(R.id.button2);
        wsteczButton = findViewById(R.id.button1);
        imageView = findViewById(R.id.imageView);
        editTekst = findViewById(R.id.editNumber);
        aSwitch = findViewById(R.id.switch1);
        editTekst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    indeks = Integer.parseInt(editable.toString());
                    if(indeks>0 && indeks<zdjecia.size()) {
                        imageView.setImageResource(zdjecia.get(indeks));
                    }
                } catch (Exception ignore){

                }

            }
        });
        dalejButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        indeks++;
                        if(indeks>zdjecia.size()-1)
                            indeks =0 ;
                        wyswietlZdjecie(indeks);
                    }
                }
        );
        wsteczButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        indeks --;
                        if(indeks<0)
                            indeks = zdjecia.size()-1;
                        wyswietlZdjecie(indeks);
                    }
                }
        );
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                }
            }
        });
    }
    private void wyswietlZdjecie(int i){
        imageView.setImageResource(zdjecia.get(i));
    }
    private void przygotujZdjecia(){
        zdjecia = new ArrayList<>();
        zdjecia.add(R.drawable.breakingbad1);
        zdjecia.add(R.drawable.breakingbad2);
        zdjecia.add(R.drawable.breakingbad3);
        zdjecia.add(R.drawable.breakingbad4);
        zdjecia.add(R.drawable.breakingbad5);
        zdjecia.add(R.drawable.breakingbad6);
    }
}