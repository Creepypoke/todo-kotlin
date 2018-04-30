package com.example.todo_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

var listNotes = ArrayList<Note>()
var lastID = 6

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listNotes.add(Note(1, "JavaSampleApproach", "Java technology, Spring Framework - approach to Java by Sample."))
        listNotes.add(Note(2, "Kotlin Android Tutorial", "Create tutorial for people to learn Kotlin Android. Kotlin is now an official language on Android. It's expressive, concise, and powerful. Best of all, it's interoperable with our existing Android languages and runtime."))
        listNotes.add(Note(3, "Android Studio", "Android Studio 3.0 provides helpful tools to help you start using Kotlin. Convert entire Java files or convert code snippets on the fly when you paste Java code into a Kotlin file."))
        listNotes.add(Note(4, "Java Android Tutorial", "Create tutorial for people to learn Java Android. Learn Java in a greatly improved learning environment with more lessons, real practice opportunity, and community support."))
        listNotes.add(Note(5, "Spring Boot Tutorial", "Spring Boot help build stand-alone, production Spring Applications easily, less configuration then rapidly start new projects."))

        viewManager = LinearLayoutManager(this)
        viewAdapter = NotesAdapter(listNotes)

        recyclerView = findViewById<RecyclerView>(R.id.rvNotes).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    fun openAddItemActivity (view: View) {
        val intent = Intent(this, AddItem::class.java)
        startActivity(intent)
    }

    fun openEditItemActivity (view: View) {

    }

    fun deleteItem (view: View) {

    }
}
