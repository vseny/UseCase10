package com.vseny.usecase10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCheck).setOnClickListener {
            val text: String = findViewById<EditText>(R.id.inputText).text.toString()
            val maxChars = try {
                Integer.parseInt(findViewById<EditText>(R.id.inputSize).text.toString())
            } catch (e: NumberFormatException) {
                null
            }
            val isValid = ValidationUtil.validate(text, maxChars)
            val resultTextStringRes = if (isValid) R.string.result_true else R.string.result_false
            findViewById<TextView>(R.id.textResult).setText(resultTextStringRes)
        }
    }
}
