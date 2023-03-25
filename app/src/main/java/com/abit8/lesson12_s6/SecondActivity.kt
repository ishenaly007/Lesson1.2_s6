package com.abit8.lesson12_s6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abit8.lesson12_s6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras!!.getString("dataKey")
        binding.etText2.setText(data)

        binding.btnNext2.setOnClickListener {
            if (binding.etText2.text.isNotEmpty()) {
                val mainActivity = Intent(this@SecondActivity, MainActivity::class.java)
                mainActivity.putExtra("dataKey2", binding.etText2.text.toString())
                startActivity(mainActivity)
            } else if (binding.etText2.text.isEmpty()) {
                Toast.makeText(
                    this@SecondActivity,
                    "Поле не должно быть пустой!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        /* val etData = registerForActivityResult(MainActivity.MySecondActivityContract()) {

         }*/
    }
}