package com.emajidev.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operation: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneBtn.setOnClickListener{numberPress("1")}
        twoBtn.setOnClickListener{numberPress("2")}
        threeBtn.setOnClickListener{numberPress("3")}
        forBtn.setOnClickListener{numberPress("4")}
        fiveBtn.setOnClickListener{numberPress("5")}
        sixBtn.setOnClickListener{numberPress("6")}
        sevenBtn.setOnClickListener{numberPress("7")}
        eightBtn.setOnClickListener{numberPress("8")}
        nineBtn.setOnClickListener{numberPress("9")}
        zeroBtn.setOnClickListener{numberPress("10")}

        sumBtn.setOnClickListener{operationPress(SUM)}
        restBtn.setOnClickListener{operationPress(REST)}
        mulBtn.setOnClickListener{operationPress(MUL)}
        divBtn.setOnClickListener{operationPress(DIV)}
        clrBtn.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultTextView.text ="0"
            operation = NO_OPERATION

        }
        equalBtn.setOnClickListener{
            var result = when(operation){
                SUM -> num1 + num2
                REST -> num1 - num2
                MUL -> num1 * num2
                DIV -> num1 / num2
                else -> 0
            }
            resultTextView.text = result.toString()
        }
    }
    private fun numberPress(digit:String){
        resultTextView.text = "${resultTextView.text}$digit"
        if(operation == NO_OPERATION){
            num1 = resultTextView.text.toString().toDouble()
        }else {
            num2 = resultTextView.text.toString().toDouble()
        }
    }
    private fun operationPress(operation:Int){
        this.operation = operation
        resultTextView.text = "0"
    }
    companion object{
        const val NO_OPERATION = 0
        const val SUM  = 1
        const val REST = 2
        const val MUL  = 3
        const val DIV  = 4
    }

}
