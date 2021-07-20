package com.example.lemonadeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private
    var lemonState = "lemon"
    var squeezeCount : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lemonImage: ImageView =findViewById(R.id.LemonImg)
        val lemonTxt : TextView = findViewById(R.id.lemonText)
        var squeezeCount : Int = 0
        lemonImage.setOnClickListener {
            when(lemonState){
                "lemon" -> selectLemon(lemonTxt,lemonImage)
                "selected" -> squeezeCheck(lemonTxt,lemonImage)
                "toDrink" -> {
                    lemonTxt.text = "Now a tree will grow in your stomach cuz I put a seed in it!!"
                    lemonImage.setImageResource(R.drawable.empty_lemonade)
                }
            }
        }

        lemonImage.setOnLongClickListener(){
            if(lemonState == "selected"){
                showSnackBar(it)
            }
            true
        }



    }

    private fun selectLemon(txt:TextView,img:ImageView)
    {
        txt.text = "Click to juice the lemon!"
        img.setImageResource(R.drawable.squeze_lemon)
        lemonState = "selected"
    }

    private fun squeezeCheck(txt:TextView,img:ImageView)
    {
        squeezeCount += 1
        if(squeezeCount == 5)
        {
            lemonState = "squeezed"
            Drink(txt,img)
        }
    }

    private fun Drink(txt:TextView,img:ImageView)
    {
        txt.text = "Click to drink your lemonade!"
        img.setImageResource(R.drawable.lemonade)
        lemonState = "toDrink"
    }

    private fun showSnackBar( v: View)
    {
        Snackbar.make( v , "Squeeze count:${squeezeCount}, keep squeezing",Snackbar.LENGTH_LONG).show()
    }

}

