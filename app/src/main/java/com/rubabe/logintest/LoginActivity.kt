package com.rubabe.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rubabe.logintest.databinding.ActivityLoginBinding
import com.rubabe.logintest.model.Students
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val username = binding.usernameTextView.text.toString()
            val password = binding.passwordTextView.text.toString()
            getStudentData(username, password)
        }

    }

    private fun getStudentData(username: String, password: String){
        val api = Constants.getAPI()
        api.checkLoginStudent(username, password).enqueue(object: Callback<List<Students>>{
            override fun onResponse(call: Call<List<Students>>, response: Response<List<Students>>) {
               startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }

            override fun onFailure(call: Call<List<Students>>, t: Throwable) {
               Toast.makeText(this@LoginActivity, "An error has occurred", Toast.LENGTH_SHORT).show()
            }

        })
    }
}