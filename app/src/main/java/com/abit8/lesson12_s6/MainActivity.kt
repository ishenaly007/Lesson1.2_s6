package com.abit8.lesson12_s6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.abit8.lesson12_s6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val returnedData = data?.getStringExtra(KEY_DATA2)
                    binding.tvText.text = returnedData
                }
            }

        binding.btnNext.setOnClickListener {
            if (binding.etText.text.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(KEY_DATA, binding.etText.text.toString())
                resultLauncher.launch(intent)
                binding.etText.text.clear()
            } else {
                Toast.makeText(this@MainActivity, R.string.empty_text, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {
        const val KEY_DATA = "DATA_KEY"
        const val KEY_DATA2 = "DATA_KEY2"
    }
}