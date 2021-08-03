package com.ibrajix.branchclone.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ibrajix.branchclone.databinding.ActivityMainBinding
import com.ibrajix.branchclone.ui.utils.Utility.transparentStatusBar
import com.ibrajix.branchclone.utils.Constants.SPLASH_SCREEN_TIME
import com.ibrajix.branchclone.utils.Utility.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide the status bar
        @Suppress("DEPRECATION")
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        transparentStatusBar()
        setContentView(binding.root)

        initView()

    }

    private fun initView(){

        startAnimation()
        goToNextActivity()

    }


    private fun startAnimation(){

        YoYo.with(Techniques.RotateInDownLeft)
                .duration(3000)
                .repeat(0)
                .playOn(binding.imgLogo)

        YoYo.with(Techniques.BounceInRight)
                .duration(3000)
                .repeat(0)
                .playOn(binding.imgText)

    }

    private fun goToNextActivity(){

        //delay for 5 seconds and move to next activity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()}, SPLASH_SCREEN_TIME)

    }

}