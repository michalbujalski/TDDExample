package io.tsh.mb.tddexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.tsh.mb.tddexample.signin.SignInActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, SignInActivity::class.java))
    }
}
