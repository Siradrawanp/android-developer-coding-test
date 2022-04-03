package com.example.androiddevcodingtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Adapter(val context: Context): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var recipeList : List<Recipe> = listOf()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recipeImage     : ImageView = itemView.findViewById(R.id.card_image)
        val recipeName      : TextView  = itemView.findViewById(R.id.cardview_title)
        val recipeHeadline  : TextView  = itemView.findViewById(R.id.cardview_headline)
        val recipeDesc      : TextView  = itemView.findViewById(R.id.cardview_description)
        val recipeCalor     : TextView  = itemView.findViewById(R.id.cardview_calories)
        val recipeFats      : TextView  = itemView.findViewById(R.id.cardview_fats)
        val recipeProtein   : TextView  = itemView.findViewById(R.id.cardview_proteins)
        val recipeCarb      : TextView  = itemView.findViewById(R.id.cardview_carbos)
        val recipeDiff      : TextView  = itemView.findViewById(R.id.cardview_difficulty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_recipe,parent,false)
        return MyViewHolder(View)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        Glide.with(context).load(recipeList.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.recipeImage)

        holder.recipeName.text = recipeList.get(position).name
        holder.recipeHeadline.text = recipeList.get(position).headlines
        holder.recipeDesc.text = recipeList.get(position).description
        holder.recipeCalor.text = recipeList.get(position).calories
        holder.recipeFats.text = recipeList.get(position).fats
        holder.recipeProtein.text = recipeList.get(position).proteins
        holder.recipeCarb.text = recipeList.get(position).carbos
        holder.recipeDiff.text = recipeList.get(position).difficulty.toString()
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun setRecipeListItems(recipeList: List<Recipe>){
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

}