package com.example.catchme

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.animation.doOnPause
import androidx.core.view.isVisible
import com.example.catchme.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animator = AnimatorInflater.loadAnimator(this, R.animator.animator)
        animator.setTarget(binding.smurf)
        animator.start()
        binding.start.text="PAUSE"
        binding.start.setOnClickListener {
            when {
                binding.start.text.toString() == "PAUSE" -> {
                    animator.pause()
                    binding.start.text = "PLAY"
                }
                binding.start.text.toString() == "PLAY" -> {
                    animator.resume()
                    binding.start.text = "PAUSE"
                }
            }
            animator.doOnPause {
                if (animator is ObjectAnimator) {
                    val value = (animator.animatedValue as Float).toInt() / 1000
                    if (value == 0) {
                        binding.view.isVisible = true
                        binding.congrats.isVisible = true
                        binding.restart.isVisible = true
                        binding.smurf.isVisible=false
                        binding.outline.isVisible=false
                        binding.start.isVisible=false
                    }
                }
            }
            binding.restart.setOnClickListener {
                animator.start()
                binding.start.text = "PAUSE"
                binding.view.isVisible = false
                binding.congrats.isVisible = false
                binding.restart.isVisible = false
                binding.start.isVisible = true
                binding.smurf.isVisible=true
                binding.outline.isVisible=true
            }


        }
    }
}

//
//                        binding.apply {
//
//                            smurf.isVisible = true
//                            smurf.startAnimation(
//                                AnimationUtils.loadAnimation(
//                                    this@MainActivity, R.anim.terbeliw
//                                )
//
//                            )
//                        }
//
//
//                                binding.apply {
//
//                                    smurf.isVisible = true
//                                    smurf.startAnimation(
//                                        AnimationUtils.loadAnimation(
//                                            this@MainActivity, R.anim.terbeliw2
//                                        )
//
//                                    )
//                                }
//
//
//                                        binding.apply {
//
//                                            smurf.isVisible = true
//                                            smurf.startAnimation(
//                                                AnimationUtils.loadAnimation(
//                                                    this@MainActivity, R.anim.terbeliw3
//                                                )
//
//                                            )
//                                        }

//                    binding.smurf.startAnimation(
//                        AnimationUtils.loadAnimation(
//                            this@MainActivity, R.anim.terbeliw
//                        )
//
//                    )






//                binding.smurf.startAnimation(
//                    AnimationUtils.loadAnimation(
//                        this@MainActivity, R.anim.terbeliw3
//                    )
//
//                )
//                binding.smurf.startAnimation(
//                    AnimationUtils.loadAnimation(
//                        this@MainActivity, R.anim.terbeliw2
//                    )
//
//                )
//                binding.smurf.startAnimation(
//                    AnimationUtils.loadAnimation(
//                        this@MainActivity, R.anim.terbeliw
//                    )
//
//                )

//                binding.smurf.startAnimation(
//                    AnimationUtils.loadAnimation(
//                        this@MainActivity, R.anim.terbeliw2
//                    )
//                )



//        binding.start.setOnClickListener {
//            binding.start.text ="поймать"
//        }


