package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    // https://developer.android.com/topic/libraries/architecture/viewmodel
    val testViewModel: TestViewModel by viewModels()
    val testAndroidViewModel by viewModels<TestAndroidViewModel>()
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(MainViewModel::class.java)
        viewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            // coroutines ?? lifecycleScope.launch(Dispatchers.IO) {// 코루틴으로 비동기 처리// https://0391kjy.tistory.com/49
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.insert(Todo(todo_edit.text.toString()))
            }
        }
    }
}