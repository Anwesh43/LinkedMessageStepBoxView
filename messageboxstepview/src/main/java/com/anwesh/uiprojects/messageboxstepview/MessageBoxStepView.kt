package com.anwesh.uiprojects.messageboxstepview

/**
 * Created by anweshmishra on 26/09/18.
 */

import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Color
import android.view.MotionEvent
import android.view.View

val nodes : Int = 5

class MessageBoxStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}