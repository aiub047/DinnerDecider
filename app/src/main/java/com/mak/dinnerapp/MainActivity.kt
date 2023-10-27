package com.mak.dinnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var foods: ArrayList<String> =
        arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun funDecide(view: View) {
        val foodTile = findViewById<TextView>(R.id.foodTitle)
        val rangeStart = 0
        val rangeEnd = foods.size - 1
        val randomInt = Random.nextInt(rangeStart, rangeEnd + 1)
        foodTile.text = foods[randomInt]
    }

    fun addFood(view: View) {
        val txtFoodEntry = findViewById<EditText>(R.id.txtFoodEntry)
        val newFood = txtFoodEntry.text.toString().trim()
        if (newFood.isEmpty()) {
            showToastMessage("Food name missing")
            return
        }

        if (foods.contains(newFood)) {
            showToastMessage("Already exist")
            return
        }

        foods.add(newFood)
        txtFoodEntry.text.clear()
    }

    private fun showToastMessage(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}