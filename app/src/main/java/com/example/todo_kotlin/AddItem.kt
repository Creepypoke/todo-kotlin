package com.example.todo_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
    }

    fun addItem (view: View) {
        val elementTitle = findViewById<EditText>(R.id.etTitle)
        val elementDescription = findViewById<EditText>(R.id.etDescription)
        val title = elementTitle.text.toString()
        val description = elementDescription.text.toString()
        if (title.isNotEmpty()) {
            listNotes.add(Note(++lastID, title, description))
            elementTitle.setText("")
            Toast.makeText(this, "New item \"$title\" is added", Toast.LENGTH_SHORT).show() // TODO: Use value @string for i18n
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Toast.makeText(this, "Please, add title for item", Toast.LENGTH_SHORT).show() // TODO: Use value @string for i18n
    }
}
