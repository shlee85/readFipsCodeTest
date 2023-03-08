package com.example.readfipscodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

data class CountyData(
    val county: String, val FipsCode: String
)

data class StateData(
    val state: String, val code: String, val counties: List<CountyData>
)

data class FipsData(
    val state: String, val code: String, val county: String, val FipsCode: String
)

class MainActivity : AppCompatActivity() {
    var usFips = mutableListOf<StateData>()
    var fipsInfo2 = mutableListOf<FipsData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val file = File(assets.open("fips.txt").bufferedReader().readText())
        val assetManager = this.assets
        val inputStream: InputStream = assetManager.open("fips.txt")

        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)

        var line: String? = bufferedReader.readLine()
        var state: String = ""
        var code: String = "00"
        var counties: ArrayList<CountyData> = ArrayList()

        while(line != null) {
            var str = line.split(",")

            //주 코드 가져오기.
            if(str[0].substring(2,5) == "000") {
                state = str[1] //주 이름
                code = str[0].substring(0,2) //주 코드
                Log.d(TAG, "State = $state, Code = $code")
            } else {
                //counties.add(CountyData(str[1], str[0]))
            }

            when(code) {
                "01" -> {
                    //counties.add(CountyData(str[1], str[0]))
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "02" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "03" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "04" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "05" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "06" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "08" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "09" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "10" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "11" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "12" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "13" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "15" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "16" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "17" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "18" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "19" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "20" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "21" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "22" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "23" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "24" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "25" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "26" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "27" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "28" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "29" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "30" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "31" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "32" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "33" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "34" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "35" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "36" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "37" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "38" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "39" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "40" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "41" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "42" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "43" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "44" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "45" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "46" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "47" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "48" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "49" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "50" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "51" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "53" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "54" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "55" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
                "56" -> {
                    fipsInfo2.add(FipsData(state, code, str[1], str[0]))
                }
            }

            line = bufferedReader.readLine()
        }

        fipsInfo2.forEach {
            Log.d(TAG, "data = $it")

            if(it.county == "Yakutat") {
                Log.d(TAG, "!!!!!!!!!!!Yakutat!!!!!!!")
            }
        }


        inputStream.close()
        bufferedReader.close()
    }

    private fun setCountyData(code: String, counties: MutableList<StateData>) {

    }

    companion object {
        val TAG:String=MainActivity::class.java.simpleName
    }
}