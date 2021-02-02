package app.doggy.count

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //カウントする変数の定義。
    var countNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナの設定。
        plusButton.setOnClickListener(ClickListener())
        minusButton.setOnClickListener(ClickListener())
        clearButton.setOnClickListener(ClickListener())
    }

    private inner class ClickListener: View.OnClickListener {
        override fun onClick(view: View) {

            //ボタンのidによる場合分け。
            when(view.id) {
                R.id.plusButton -> {
                    countNum += 1
                    numberTextView.text = countNum.toString()
                }

                R.id.minusButton -> {
                    countNum -= 1
                    numberTextView.text = countNum.toString()
                }

                R.id.clearButton -> {
                    countNum = 0
                    numberTextView.text = countNum.toString()
                }
            }

            //countNumの値が3の倍数の時、緑色にする。
            if (countNum%3 == 0 && countNum != 0) {
                numberTextView.setTextColor(ContextCompat.getColor(applicationContext, R.color.teal_700))
            } else {
                numberTextView.setTextColor(ContextCompat.getColor(applicationContext, R.color.text))
            }

        }
    }
}