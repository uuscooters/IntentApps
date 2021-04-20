package com.resmana.myintentapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity.setOnClickListener(this)
        btn_move_activity_data.setOnClickListener(this)
        btn_dial_number.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

           R.id.btn_move_activity -> {
               //  pindahan activity tanpa membawa data
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
           }

            R.id.btn_move_activity_data -> {
            //  pindah activity dengan membawa data
                val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,29)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "uus resmana")
                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial_number -> {
            // pindah activity secara implicit
                val number = "08998345930"
                val dialphone = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $number"))
                startActivity(dialphone)
            }
        }
    }
}