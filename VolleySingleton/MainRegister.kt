package com.example.mysqlbd

import android.content.Context
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_main_register.*
import org.json.JSONException
import org.json.JSONObject


class MainRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_register)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val conexion = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val status = conexion.activeNetworkInfo

        btnRegister.setOnClickListener() {

            if (status != null && status.isConnected) {
                addUser()
            } else {
                Toast.makeText(this, "Revise su conexion a internet", Toast.LENGTH_LONG).show()
            }

        }
    }

    //adding a new record to database
    private fun addUser() {
        //getting the record values
        val cedula = edtCed?.text.toString()
        val apellido = edtApe?.text.toString()
        val nombres = edtNom?.text.toString()
        val pass = edtPass?.text.toString()

        val url = "http://67.207.91.60/KotlinAPI/v1/index.php"

        //creating volley string request
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                try {
                    val obj = JSONObject(response)
                    Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_LONG).show()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { volleyError -> Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show() }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("Cedula", cedula)
                params.put("Apellidos", apellido)
                params.put("Nombres", nombres)
                params.put("Password", pass)
                return params
            }
        }

        //adding request to queue
        VolleySingleton.instance?.addToRequestQueue(stringRequest)
    }

}
