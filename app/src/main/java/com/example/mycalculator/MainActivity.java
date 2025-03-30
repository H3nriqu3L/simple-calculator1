package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
    }


    public void calculation(View view) {

        EditText valor1 = findViewById(R.id.numvalor1);
        EditText valor2 = findViewById(R.id.numvalor2);
        TextView resultado = findViewById(R.id.resultado);


        String str1 = valor1.getText().toString().trim();
        String str2 = valor2.getText().toString().trim();


        if (str1.isEmpty() || str2.isEmpty()) {
            resultado.setText("Por favor, preencha ambos os campos.");
            return;
        }


        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        String tag = (String) view.getTag();
        int result = 0;

        if ("sum".equals(tag)) {
            result = num1 + num2;
        } else if ("minus".equals(tag)) {
            result = num1 - num2;
        } else if ("mult".equals(tag)){
            result = num1 * num2;
        } else if ("div".equals(tag)) {
            result = num1/num2;
        }


        resultado.setText("Resultado: " + result);
    }

}