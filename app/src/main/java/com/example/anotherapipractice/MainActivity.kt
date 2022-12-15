package com.example.anotherapipractice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.anotherapipractice.models.LoginModel
import com.example.anotherapipractice.models.LoginRequest
import com.example.anotherapipractice.models.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    // var apiInt: ApiInterface? = null
    var loginR = LoginRequest()
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var btnSave: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnSave = findViewById(R.id.btnSave)


        btnSave?.setOnClickListener {
            /*var intent = Intent(this, MainActivity::class.java)
            startActivity(intent) */

            getLogin()
        }


    }

    fun getLogin() {

        loginR.email = etEmail?.text.toString().trim()
        loginR.password = etPassword?.text.toString().trim()


        val postLogin = RetrofitClient.instance?.myApi?.getLogin(loginR)
        postLogin?.enqueue(object : Callback<LoginModel> {

            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                //TODO("Not yet implemented")
                if (response.isSuccessful) {

                    Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
                } else if (response.errorBody() != null) {

                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                //TODO("Not yet implemented")
            }

        })
    }

}



