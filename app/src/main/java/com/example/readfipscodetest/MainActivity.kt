package com.example.readfipscodetest

import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

data class CountyData(
    val county: String, val FipsCode: String
)

data class StateData(
    val state: String, val code: String, val counties: ArrayList<CountyData>
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usFips = ArrayList<StateData>()
/*
        BufferedReader(InputStreamReader(this.assets.open("fips.txt"))).use {
            it.lines().forEach { line ->
                val str = line.split(",")
                if (str[0].substring(2, 5) == "000") {
                    usFips.add(StateData(str[1], str[0].substring(0, 2), ArrayList()))
                } else {
                    usFips.forEach { state->
                        if (state.code == str[0].substring(0, 2))
                            state.counties.add(CountyData(str[1], str[0].substring(2, 5)))
                    }
                }
            }
        }


        usFips.forEach { state ->
            Log.i(TAG, "${state.code} ${state.state}")
            state.counties.forEach { county ->
                Log.i(TAG, "    ${county.FipsCode} ${county.county}")
            }
        }
 */


        Log.d(TAG, "Start!")
        var temp = ""
        val usFips2 = ArrayList<StateData>()
        BufferedReader(InputStreamReader(this.assets.open("kr_code2.txt"),"MS949")).use {
            it.lines().forEach { line ->
                val str = line.split("\t")
                //Log.d(TAG, "$str")

                if(str[0] == "법정동코드"){
                    Log.d(TAG, "첫번째 라인 Continue")
                    return@forEach
                }

                if(str[2] == "존재") {
                    if(str[0].substring(2,4) == "00" || str[0].substring(0,6) == "361100") {
                        //Log.d(TAG, "state = ${str[0].substring(0,2)}, ${str[1]}")
                        usFips2.add(StateData(str[1], str[0].substring(0,2), ArrayList()))
                    } else {
                        val name = str[1].split(" ")
                        if(name[1] != " ") {
                            usFips2.forEach { state->
                                if(temp == str[0].substring(0,4)) {
                                    return@forEach
                                } else {
                                    if(state.code == str[0].substring(0,2)) {
                                        state.counties.add(CountyData(name[1], str[0].substring(0,4)))
                                        temp = str[0].substring(0,4)
                                        //Log.d(TAG, " county = ${str[0].substring(0,4)}, ${name[1]}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Log.d(TAG, "size : ${usFips2.size}")

        usFips2.forEach { state->
            Log.d(TAG, "${state.code}-${state.state}")
            state.counties.forEach { counties->
                Log.d(TAG, "  ${counties.FipsCode}-${counties.county}")
            }
        }
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}