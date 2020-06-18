package com.example.main

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    //@Headers("Accept: application/json")
    @GET("openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=HfqivhIZ0LdSWOWJuO6cYiOUrrrTGDG0yB22Wsc6pbmvUOfwIuIzUOqnv9ZK6Ppvw2mHnFk%2Bf2yNllDWnCrfRw%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200616&endCreateDt=&_type=json")   //getCovid19SidoInfStateJson?serviceKey=HfqivhIZ0LdSWOWJuO6cYiOUrrrTGDG0yB22Wsc6pbmvUOfwIuIzUOqnv9ZK6Ppvw2mHnFk%2Bf2yNllDWnCrfRw%3D%3D&pageNo=1&numOfRows=10&startCreateDt={startdate}&endCreateDt={enddate}&_type=json")
    fun getData() : Call<JsonStart>
//    fun getData(@Query("serviceKey") serviceKey: String,
//                @Query("pageNo") pageNo: Int,
//                @Query("numOfRows") numOfRows: Int,
//                @Query("startCreateDt") startCreateDt: String,
//                @Query("endCreateDt") endCreateDt: String,
//                @Query("_type") _type: String): Call<JsonStart>

}