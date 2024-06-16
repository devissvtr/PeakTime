package com.devissvtr.peaktime.ui.customviews

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class CustomEmail : AppCompatEditText, View.OnTouchListener {
    private fun init() {
        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                error = if (Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    null
                } else {
                    "Email format wrong"
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        )
    }

    constructor(context: Context): super(context) {
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr) {
        init()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return false
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }
}