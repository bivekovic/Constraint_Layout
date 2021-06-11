package com.algebra.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var bCancel: Button
    private lateinit var bSignup: Button
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbUnknown: RadioButton
    private lateinit var etEmail: EditText
    private lateinit var cbTermsAccepted: CheckBox

    // Samo da probam...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidgets()
        setupListeners()
    }


    private fun setupListeners() {
        bCancel.setOnClickListener { Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show() }
        bSignup.setOnClickListener {
            if (cbTermsAccepted.isChecked) {
                val text = "Welcome ${etFirstName.text} ${etLastName.text}"
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Terms must be accepted", Toast.LENGTH_LONG).show()
        }
    }

    private fun initWidgets() {
        bCancel = findViewById(R.id.bCancel)
        bSignup = findViewById(R.id.bSubmit)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
        rbUnknown = findViewById(R.id.rbUnknown)
        etEmail = findViewById(R.id.etMail)
        cbTermsAccepted = findViewById(R.id.cbRules)
    }

}
