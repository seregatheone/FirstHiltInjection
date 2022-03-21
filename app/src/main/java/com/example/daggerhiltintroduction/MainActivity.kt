package com.example.daggerhiltintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //field injector
    @Inject
    lateinit var firstInjection: FirstHiltInjection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("firstInjection",firstInjection.helloWorld())
        Log.i("helloWorldSecondTime",firstInjection.helloWorldSecondTime())
    }

}
//constructor injection
class FirstHiltInjection @Inject constructor(private val secondHiltInjection : SecondHiltInjection){
    fun helloWorld() = "Hello World"
    fun helloWorldSecondTime() = secondHiltInjection.helloWorldSecondTime()
}
class SecondHiltInjection @Inject constructor(){
    fun helloWorldSecondTime() = "Hello World Second Time"
}