package com.example.user.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

enum class CurrentMode{
    None,Plus,Minus,Multy
}

class MainActivity : AppCompatActivity() {
    var labelString = ""
    var currentMode = CurrentMode.None
    var lastButtonWasMode = false
    var savedNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    }

    fun didPressClear(){

    }

    fun didPressNumber(num:Int){
        labelString = "$labelString$num"
        updateText()

    }

    fun changeMode(target:CurrentMode){

    }

    fun updateText(){
        textView.text = labelString
    }

}
