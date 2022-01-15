package org.quaerense.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(item: ShopItem) {
        shopListRepository.addShopItem(item)
    }
}