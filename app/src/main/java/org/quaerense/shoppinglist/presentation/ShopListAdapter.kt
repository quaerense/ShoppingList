package org.quaerense.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.quaerense.shoppinglist.R
import org.quaerense.shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {
    var onShopItemClickListener: ((item: ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((item: ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = getItem(position)

        with(holder) {
            tvName.text = item.name
            tvCount.text = item.count.toString()

            itemView.setOnClickListener {
                onShopItemClickListener?.invoke(item)
            }
            itemView.setOnLongClickListener {
                onShopItemLongClickListener?.invoke(item)
                true
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0

        const val MAX_POOL_SIZE = 15
    }
}