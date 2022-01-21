package org.quaerense.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.quaerense.shoppinglist.R

class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.findViewById(R.id.tv_name)
    val tvCount: TextView = itemView.findViewById(R.id.tv_count)
}