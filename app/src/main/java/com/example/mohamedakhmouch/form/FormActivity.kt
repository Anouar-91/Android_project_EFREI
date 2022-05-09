package com.example.anouarberrouane.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import com.example.anouarberrouane.R
import com.example.anouarberrouane.databinding.ActivityFormBinding
import com.example.anouarberrouane.tasklist.Task
import java.util.*

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater )
        setContentView(binding.root)

        val task = intent?.getSerializableExtra("task") as Task?
        binding.titleEditText.setText(task?.title)
        binding.descriptionEditText.setText(task?.description)

        binding.button.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val newTask = Task(id = task?.id ?: UUID.randomUUID().toString(), title = title, description = description)
            intent.putExtra("task", newTask)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}