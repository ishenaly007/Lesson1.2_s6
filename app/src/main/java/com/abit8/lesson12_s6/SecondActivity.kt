package com.abit8.lesson12_s6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abit8.lesson12_s6.MainActivity.Companion.KEY_DATA
import com.abit8.lesson12_s6.MainActivity.Companion.KEY_DATA2
import com.abit8.lesson12_s6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent?.getStringExtra(KEY_DATA)
        binding.etText2.setText(data)

        binding.btnNext2.setOnClickListener {
            if (binding.etText2.text.isNotEmpty()) {
                val resultIntent = Intent()
                val data2 = binding.etText2.text.toString()
                resultIntent.putExtra(KEY_DATA2, data2)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(
                    this@SecondActivity,
                    R.string.empty_text,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}