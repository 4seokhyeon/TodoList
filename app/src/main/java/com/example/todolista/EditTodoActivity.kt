package com.example.todolista

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.todolista.databinding.ActivityEditTodoBinding

class EditTodoActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditTodoBinding
    private var todo: Todo?=null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("type")

        if (type.equals("ADD")) {
            binding.btnSave.text = "추가하기"
        } else {
            todo = intent.getSerializableExtra("item") as Todo?
            binding.etTodoTitle.setText(todo!!.title)
            binding.etTodoContent.setText(todo!!.content)
            binding.btnSave.text = "수정하기"
        }

        binding.btnSave.setOnClickListener {
            val title = binding.etTodoTitle.text.toString()
            val content = binding.etTodoContent.text.toString()
            val ageString = binding.age.text.toString()
            val age = if (ageString.isNotEmpty()) ageString.toInt() else 0
            val currentDate = SimpleDateFormat("yyyy-MM-dd HH:mm").format(System.currentTimeMillis())

            if (type.equals("ADD")) {
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    val todo = Todo(0, title, content,age, currentDate, false)
                    val intent = Intent().apply {
                        putExtra("todo", todo)
                        putExtra("flag", 0)
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                }
            } else {
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    val todo = Todo(todo!!.id, title, content, age, currentDate, todo!!.isChecked)

                    val intent = Intent().apply {
                        putExtra("todo", todo)
                        putExtra("flag", 1)
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        }
    }

}