package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private  lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.button)

        getSharedPreferences("shared_preferences", Context.MODE_PRIVATE)
            .getString("saved_data", null).let {
                textView.text = it
            }

        button.setOnClickListener {
            getSharedPreferences("shared_preferences", Context.MODE_PRIVATE).edit().apply {
                putString("saved_data", editText.text.toString())
                apply()
            }
        }


    }
}