package com.softwindevs.kotlinfoodrecyclerview

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.Food_RV) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val Foods = ArrayList<FoodModel>()

        //adding food data to the RV list
        Foods.add(FoodModel("Gulab Jamun", "Indian Sweets"))
        Foods.add(FoodModel("Biryani", "Indian Cusine"))
        Foods.add(FoodModel("Pizza", "Italian Snack"))
        Foods.add(FoodModel("Burger", "American Snack"))
        Foods.add(FoodModel("Pasta", "Italian Cusine"))
        Foods.add(FoodModel("Fried Rice", "Chinese Cusine"))
        Foods.add(FoodModel("Taco", "Italian Cusine"))

        //creating our adapter
        val adapter = FoodAdapter(Foods)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

    }
}
