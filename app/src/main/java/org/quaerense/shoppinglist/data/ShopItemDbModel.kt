package org.quaerense.shoppinglist.data

import androidx.room.Entity

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)