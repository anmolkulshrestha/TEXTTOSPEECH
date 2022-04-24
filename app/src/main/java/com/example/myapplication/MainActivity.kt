package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.SeekBar
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var tts:TextToSpeech
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.speed.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
         binding.listen.setOnClickListener {
             tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                 if (it == TextToSpeech.SUCCESS) {
                     tts.setLanguage(Locale.US)
tts.setSpeechRate(binding.speed.progress.toFloat())
                     tts.speak(binding.entertext.text.toString(), TextToSpeech.QUEUE_ADD, null)
                 }
             })
         }
    }
}