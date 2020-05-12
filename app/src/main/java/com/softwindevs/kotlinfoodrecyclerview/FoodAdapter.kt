package com.softwindevs.kotlinfoodrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_food_item.view.*

class FoodAdapter(val FoodList: ArrayList<FoodModel>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_food_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        holder.bindItems(FoodList[position])
        holder.itemView.setOnClickListener {
           // Toast.makeText(this@MainActivity, FoodList[position], Toast.LENGTH_SHORT).show()
            Toast.makeText( holder.itemView.context, "${FoodList[position].Fname} is clicked!", Toast.LENGTH_SHORT).show()
           // Log.i("Food",FoodList[position].Fname)
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return FoodList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvFood = itemView.FoodTv
        val tvFoodType  = itemView.TypeTv

        fun bindItems(Foods: FoodModel) {

            tvFood.text = Foods.Fname
            tvFoodType.text = Foods.Ftype

        }
    }

}