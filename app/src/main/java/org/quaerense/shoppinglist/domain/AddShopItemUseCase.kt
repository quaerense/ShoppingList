package org.quaerense.shoppinglist.domain

import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
    ) {
    suspend fun addShopItem(item: ShopItem) {
        shopListRepository.addShopItem(item)
    }
}