package org.quaerense.shoppinglist.domain

import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun getShopItemById(id: Int): ShopItem {
        return shopListRepository.getShopItemById(id)
    }
}