package com.algebra.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.regex.Pattern

/*
Validiraj da je uneseno neko ime
Validiraj da je uneseno neko prezime
Validiraj da je odabrana neka opcija za spol
Validiraj da je unesen mail i da je u ispravnom formatu

Korisniku pokažite odgovarajuću poruku (Toast)
 */

class MainActivity : AppCompatActivity( ) {

    private lateinit var etIme : EditText
    private lateinit var etPrezime : EditText
    private lateinit var etMail : EditText
    private lateinit var radioGrupa : RadioGroup
    private lateinit var radioM : RadioButton
    private lateinit var radioZ : RadioButton
    private lateinit var radioNZR : RadioButton
    private lateinit var bOdustani : Button
    private lateinit var bSpremi : Button



    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
        setupListeners( )
    }

    fun setupListeners( ) {
        bOdustani.setOnClickListener { }
        bSpremi.setOnClickListener {
            val korisnik = procitajPodatke( )
            if( korisnik.validiraj( ) )
                Toast.makeText( this, korisnik.toString( ), Toast.LENGTH_LONG ).show( )
            else
                Toast.makeText( this, "Pogreška...", Toast.LENGTH_LONG ).show( )


        }
    }

    fun procitajPodatke( ) : Korisnik {
        val unesenoIme = etIme.text.toString( );
        val unesenoPrezime = etPrezime.text.toString( );
        var spol = ""
        if( radioM.isChecked ) spol="M"
        else if( radioZ.isChecked ) spol = "Z"
        else if( radioNZR.isChecked ) spol = "/"
        var mail = etMail.text.toString( )
        return Korisnik( unesenoIme, unesenoPrezime, mail, spol )
    }

    fun initWidgets( ) {
        etIme      = findViewById( R.id.etIme )
        etPrezime  = findViewById( R.id.etPrezime )
        etMail     = findViewById( R.id.etMail )
        radioGrupa = findViewById( R.id.radiogrupa )
        radioM     = findViewById( R.id.rbM )
        radioZ     = findViewById( R.id.rbZ )
        radioNZR   = findViewById( R.id.rbNZR )
        bOdustani  = findViewById( R.id.bOdustani )
        bSpremi    = findViewById( R.id.bSpremi )
    }
}

class Korisnik( var ime:String, var prezime:String, var mail:String, var spol: String ) {

    fun isValidEmail( ): Boolean {
        val email_pattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
        val pattern = Pattern.compile(email_pattern)
        return pattern.matcher( mail ).matches()
    }

    fun validiraj( ) : Boolean {
        return  ( ime!=null && ime!="" ) &&
                ( prezime!=null && prezime!="" ) &&
                ( spol!=null && spol!="" ) &&
                isValidEmail( )
    }

    override fun toString(): String {
        return "IME: $ime\nPREZIME: $prezime\nE-MAIL: $mail\nSPOL: $spol"
    }
}