package com.masashi.countappactions

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masashi.countappactions.databinding.ActivityMainBinding


/**
 * Created by Masashi Hamaguchi on 2021/09/06.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text = count.toString()

        binding.plusBtn.setOnClickListener {
            binding.textView.text = (++count).toString()
            checkColor()
        }

        binding.minusBtn.setOnClickListener {
            binding.textView.text = (--count).toString()
            checkColor()
        }

    }

    private fun checkColor() {
        if (count > 0) {
            binding.textView.setTextColor(Color.BLUE)
        } else if (count < 0) {
            binding.textView.setTextColor(Color.RED)
        } else {
            binding.textView.setTextColor(Color.BLACK)
        }
    }
}