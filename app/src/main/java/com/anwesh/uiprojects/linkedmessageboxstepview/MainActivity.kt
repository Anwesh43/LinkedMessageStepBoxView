package com.anwesh.uiprojects.linkedmessageboxstepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.messageboxstepview.MessageBoxStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MessageBoxStepView.create(this)
    }
}
