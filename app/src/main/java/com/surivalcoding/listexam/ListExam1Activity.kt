package com.surivalcoding.listexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 1. 홀수 번째는 배경이 파란색, 짝수 번째는 빨간색이 표시되는 리스트를 만든다
class ListExam1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_exam1)
    }
}