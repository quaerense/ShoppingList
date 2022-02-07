package org.quaerense.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import org.quaerense.shoppinglist.R
import org.quaerense.shoppinglist.databinding.ItemShopDisabledBinding
import org.quaerense.shoppinglist.databinding.ItemShopEnabledBinding
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

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )

        return ShopItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = getItem(position)
        val binding = holder.binding

        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(item)
        }
        binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(item)
            true
        }
        when (binding) {
            is ItemShopDisabledBinding -> {
                binding.shopItem = item
            }
            is ItemShopEnabledBinding -> {
                binding.shopItem = item
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