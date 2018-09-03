package com.example.user.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

enum class CurrentMode{
    None,Plus,Minus,Multy
}

class MainActivity : AppCompatActivity() {
    var labelString = "0"
    var currentMode = CurrentMode.None
    var lastButtonWasMode = false
    var savedNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCalculator()
    }

    fun setupCalculator(){
        val buttons = arrayOf(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)

        for (i in buttons.indices){
            buttons[i].setOnClickListener{
                didPressNumber(i)
            }
        }
        Plus.setOnClickListener{
            changeMode(CurrentMode.Plus)
        }
        Minus.setOnClickListener{
            changeMode(CurrentMode.Minus)
        }
        Multy.setOnClickListener{
            changeMode(CurrentMode.Multy)
        }
        Clear.setOnClickListener{
            changeMode(CurrentMode.None)
            didPressClear()
        }
        Equal.setOnClickListener{
            didPressEqual()
        }
    }

    fun didPressEqual(){
        var labelInt = this.labelString.toInt()
        when(currentMode) {
            CurrentMode.Plus -> labelInt += savedNumber
            CurrentMode.Minus -> labelInt = savedNumber - labelInt
            CurrentMode.Multy -> labelInt *= savedNumber
            CurrentMode.None -> return
        }
        labelString = labelInt.toString()
        updateText()
    }

    fun didPressClear(){
        labelString = "0"
        currentMode = CurrentMode.None
        lastButtonWasMode = false
        savedNumber = 0
        textView.setText("0")
    }

    fun didPressNumber(num:Int){

        if(lastButtonWasMode) {
            savedNumber = labelString.toInt()
            labelString = "$num"
            lastButtonWasMode = false
        }
        else  labelString = "$labelString$num"
        updateText()
    }

    fun changeMode(target:CurrentMode){
        lastButtonWasMode = true
        currentMode = target
    }

    fun updateText(){
        labelString = labelString.toInt().toString()
        textView.setText(labelString)

    }

}
