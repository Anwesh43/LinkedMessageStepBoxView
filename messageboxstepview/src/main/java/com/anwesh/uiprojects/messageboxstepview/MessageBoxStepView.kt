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

fun Canvas.drawMBSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val boxSize : Float = gap/3
    val tipSize = gap / 10
    val sc1 : Float = Math.min(0.5f, scale) * 2
    val sc2 : Float = Math.min(0.5f, Math.max(scale - 0.5f, 0f)) * 2
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.parseColor("#283593")
    paint.style = Paint.Style.STROKE
    save()
    translate(w/2, gap + i * gap)
    val path : Path = Path()
    path.moveTo(-boxSize/2, -boxSize * sc1)
    path.lineTo(boxSize/2, -boxSize * sc1)
    path.lineTo(boxSize/2, 0f)
    path.lineTo(tipSize, 0f)
    path.lineTo(0f, tipSize * sc2)
    path.lineTo(-tipSize, 0f)
    path.lineTo(-boxSize/2, 0f)
    drawPath(path, paint)
    restore()
}

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

    data class State(var scale : Float = 0f, var prevScale : Float = 0f, var dir : Float = 0f) {

        fun update(cb : (Float) -> Unit) {
            scale += 0.05f * this.dir
            if (Math.abs(scale - prevScale) > 1) {
                scale = prevScale + dir
                dir = 0f
                prevScale = scale
                cb(prevScale)
            }
        }

        fun startUpdating(cb : () -> Unit) {
            if (dir == 0f) {
                dir = 1f - 2 * prevScale
                cb()
            }
        }
    }

    data class Animator(var view : View, var animated : Boolean = false) {
        fun animate(cb : () -> Unit) {
            if (animated) {
                cb()
                try {
                    Thread.sleep(50)
                    view.invalidate()
                } catch(ex : Exception) {

                }
            }
        }

        fun start() {
            if (!animated) {
                animated = true
                view.postInvalidate()
            }
        }

        fun stop() {
            if (animated) {
                animated = false
            }
        }
    }
}