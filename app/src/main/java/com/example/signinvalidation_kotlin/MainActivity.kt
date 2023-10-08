package com.example.signinvalidation_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner= findViewById<Spinner>(R.id.spnPrograms)
        val display= findViewById<TextView>(R.id.tvDisplay)
        val submit= findViewById<Button>(R.id.btnSubmit)
        val password= findViewById<EditText>(R.id.etPassword)
        val confirm= findViewById<EditText>(R.id.etPassword2)
        val name= findViewById<EditText>(R.id.etUName)
        val spinError= findViewById<TextView>(R.id.tvSpinError)
        val majors= arrayOf("Please select a major","Information Science", "Computer Science", "Math and CS", "Data Science", "Other")

        spinner.adapter= MajorsAdapter(this, majors)

        submit.setOnClickListener {
            if (name.text.isEmpty())
            {
                name.setError("Please enter your name")
            }
            else if (password.text.isEmpty())
            {
                password.setError("Please enter a password")
            }
            else if (password.text.toString() != confirm.text.toString())
            {
                confirm.setError("Make sure your passwords match")
            }
            else if (spinner.selectedItem.toString() == majors[0])
            {
                spinError.text = "Please choose a major from the dropdown list above"
            }
            else
            {
                display.text= "Welcome to the app, ${name.text.toString()}"
            }
        }//end submit.setOnClickListener

    }
}//end MainActivity

class MajorsAdapter(_context: Context, _majors: Array<String>): BaseAdapter()
{
    private val context= _context
    private val major= _majors
    override fun getCount(): Int {
        return major.size
    }

    override fun getItem(p0: Int): Any {
        return major[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView= TextView(context)
        textView.text= major[p0]
        textView.textSize= 20f
        return textView
    }
}//end MajorsAdpater