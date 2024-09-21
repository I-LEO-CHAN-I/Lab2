package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputFieldN = findViewById<EditText>(R.id.editTextNumber);
        val inputFieldA = findViewById<EditText>(R.id.editTextNumberDecimal);

        val button = findViewById<Button>(R.id.button);
        val resultText = findViewById<TextView>(R.id.textView);

        button.setOnClickListener() {
            try {
                val n = inputFieldN.text.toString().toInt();
                val a = inputFieldA.text.toString().toFloat();

                var sum = 0f
                for (i in 0..n) {
                    var term = 1f;
                    for (j in 0..i) {
                        term *= (a + j)
                    }
                    sum += (1f/term)
                    println(sum)
                }

                resultText.text = sum.toString()
            } catch (e : Exception) {
                resultText.text = "Ошибка ввода"
            }
        }
    }
}