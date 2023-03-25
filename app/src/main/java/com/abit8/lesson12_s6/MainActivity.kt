package com.abit8.lesson12_s6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abit8.lesson12_s6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras!!.getString("dataKey2")
        binding.tvText.text = data

        binding.apply {
            btnNext.setOnClickListener {
                if (binding.etText.text.isNotEmpty()) {
                    val secondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                    secondActivity.putExtra("dataKey", binding.etText.text.toString())
                    startActivity(secondActivity)
                } else if (binding.etText.text.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Поле не должно быть пустой!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                /* activityResult.launch(binding.etText.text.toString())*/
            }
        }
    }


    /*val activityResult = registerForActivityResult(MySecondActivityContract()) {}*/
    /* class MySecondActivityContract : ActivityResultContract<String, String?>() {

         override fun createIntent(context: Context, input: String): Intent {
             return Intent(context, SecondActivity::class.java)
                 .putExtra("my_input_key", input)
         }

         override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
             resultCode != Activity.RESULT_OK -> null
             else -> intent?.getStringExtra("my_result_key")
         }
     }*/
}