package com.example.main

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.activity_localcase.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class LocalCaseActivity : AppCompatActivity() {

    private var BASE_URL = "http://openapi.data.go.kr/"
    private lateinit var selectedLocal : String   //지역 데이터를 여기서 넣어줘야됨

//    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localcase)


//        var today : Int = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toInt()
//
//        var serviceKey : String = "HfqivhIZ0LdSWOWJuO6cYiOUrrrTGDG0yB22Wsc6pbmvUOfwIuIzUOqnv9ZK6Ppvw2mHnFk%2Bf2yNllDWnCrfRw%3D%3D"
//        var pageNo : Int = 1
//        var numOfRows : Int = 10
//        var startCreateDt : String = "20200615"
//        var endCreateDt : String = "20200616"
//        var _type : String = "json"

        val retrofit : Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()

        val api = retrofit.create(API::class.java)

        if(intent.hasExtra("location")) {
            selectedLocal = intent.getStringExtra("location")
        }
        var call = api.getData()
        call.enqueue(object : Callback<JsonStart> {
            override fun onFailure(call: retrofit2.Call<JsonStart>, t: Throwable) {
                //호출 실패
                Toast.makeText(this@LocalCaseActivity, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<JsonStart>, response: Response<JsonStart>) {
                //성공시
                try {  //null 충돌 발생 가능성
                    //Toast.makeText(this@LocalCaseActivity, response.body()?.response?.header?.resultCode!!, Toast.LENGTH_LONG).show()

                    Log.e("api success", response.body()?.response?.header?.resultCode!!)
                    var dates = arrayOf(String())
                    for(localInfo : Item in response.body()?.response?.body?.items?.item!!) {
                        if(localInfo.gubun != selectedLocal) {   //선택 지역과 일치하지 않을시
                            continue
                        }
                        else if (localInfo.gubun == selectedLocal) { //지역과 일치시
                            main_local_text_view.text = selectedLocal
                            main_local_en_text_view.text = localInfo.gubunEn
                            main_10man_num_text_view.text = localInfo.qurRate
                            main_today_num_text_view.text = localInfo.incDec
                            update_time_num_text_view.text = localInfo.createDt
                            break
                        }
                    }
                } catch (e : NullPointerException){
                    Toast.makeText(this@LocalCaseActivity, """데이터 받아오기 실패
                        | 다시 선택해 주세요.""".trimMargin(), Toast.LENGTH_LONG).show()
                    val intent = Intent(this@LocalCaseActivity ,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        })

        news_button.setOnClickListener{
            val intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("location",selectedLocal)
            startActivity(intent)
        }
        pharmacy_button.setOnClickListener{
            val intent = Intent(this,MaskActivity::class.java)
            startActivity(intent)
        }
        title_button.setOnClickListener {
            //val intent = Intent(this,MainActivity::class.java)
            //startActivity(intent)
            finish();
        }

    }
}

