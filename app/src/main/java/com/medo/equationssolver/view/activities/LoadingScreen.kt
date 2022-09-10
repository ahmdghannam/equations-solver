package com.medo.equationssolver.view.activities;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import com.medo.equationssolver.R;
import com.medo.equationssolver.view.activities.infoScreen.infoScreen
import kotlinx.android.synthetic.main.activity_loading_screen.*

 class LoadingScreen : AppCompatActivity() {
    override fun onCreate( savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
         val animation=AnimationUtils.loadAnimation(applicationContext,R.anim.animation_splash)
        ivLogo.animation=animation
           animation.setAnimationListener(object :Animation.AnimationListener{
               override fun onAnimationStart(p0: Animation?) {

               }

               override fun onAnimationEnd(p0: Animation?) {
                 Handler(Looper.getMainLooper())
                .postDelayed({ startActivity(Intent(this@LoadingScreen, infoScreen::class.java));finish()},10)
               }

               override fun onAnimationRepeat(p0: Animation?) {

               }


           })
    }
}