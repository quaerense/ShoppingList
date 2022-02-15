package org.quaerense.shoppinglist.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(item: ShopItem) {
        shopListRepository.deleteShopItem(item)
    }
}