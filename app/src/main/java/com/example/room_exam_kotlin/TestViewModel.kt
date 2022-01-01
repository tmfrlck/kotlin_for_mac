package com.example.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
}

class TestAndroidViewModel(application: Application): AndroidViewModel(application) {}