package com.softwindevs.kotlinfoodrecyclerview

import android.content.Context
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.layout_food_item.view.*

class FoodAdapter(val FoodList: ArrayList<FoodModel>, val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_food_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        holder.bindItems(FoodList[position], itemClickListener)

        //setting direct onclick from Bind View Holder
        /*  holder.itemView.setOnClickListener {
             // Toast.makeText(this@MainActivity, FoodList[position], Toast.LENGTH_SHORT).show()
              // Log.i("Food",FoodList[position].Fname)
              Toast.makeText( holder.itemView.context, "${FoodList[position].Fname} is clicked!", Toast.LENGTH_SHORT).show()
          }*/

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return FoodList.size
    }


    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvFood = itemView.FoodTv
        val tvFoodType = itemView.TypeTv

        fun bindItems(Foods: FoodModel, clickListener: OnItemClickListener) {
            tvFood.text = Foods.Fname
            tvFoodType.text = Foods.Ftype

            //set click listner
            itemView.setOnClickListener {
                clickListener.onItemClicked(Foods)
            }
        }
    }

}

//creating interface where we can access an item click through main activity
interface OnItemClickListener {
    fun onItemClicked(user: FoodModel)
}