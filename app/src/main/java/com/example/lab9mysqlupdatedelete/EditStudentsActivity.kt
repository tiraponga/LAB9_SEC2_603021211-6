package com.example.lab9mysqlupdatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_students.*

import layout.StudentAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EditStudentsActivity : AppCompatActivity() {
    val createClient = StudentAPI.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_students)

        val mId = intent.getStringExtra("mId")
        val mName = intent.getStringExtra("mName")
        val mAge = intent.getStringExtra("mAge")

        edit_id.setText(mId)
        edit_id.isEnabled = false
        edit_name.setText(mName)
        edit_age.setText(mAge)
    }

    fun saveStudent(v: View) {
        createClient.updateStudent(
            edit_id.text.toString(),
            edit_name.text.toString(),
            edit_age.text.toString().toInt()).enqueue(object : Callback<Student> {

            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext,"Successfully Updated", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Error ", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Student>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailre " + t.message, Toast.LENGTH_LONG).show()
        }
        })
}
    fun  deleteStudent(v: View){

    }
}