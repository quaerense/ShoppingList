package org.quaerense.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import org.quaerense.shoppinglist.domain.ShopItem
import org.quaerense.shoppinglist.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val dao: ShopListDao,
    private val mapper: ShopListMapper
) : ShopListRepository {

    override suspend fun addShopItem(item: ShopItem) {
        dao.addShopItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun deleteShopItem(item: ShopItem) {
        dao.deleteShopItem(item.id)
    }

    override suspend fun editShopItem(item: ShopItem) {
        dao.addShopItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun getShopItemById(id: Int): ShopItem {
        return mapper.mapDbModelToEntity(dao.getShopItem(id))
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(dao.getShopList()) {
        mapper.mapListDbModelToListEntity(it)
    }
}