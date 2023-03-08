package com.example.readfipscodetest

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
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}