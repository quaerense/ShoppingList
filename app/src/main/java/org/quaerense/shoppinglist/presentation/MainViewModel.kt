package org.quaerense.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.quaerense.shoppinglist.domain.DeleteShopItemUseCase
import org.quaerense.shoppinglist.domain.EditShopItemUseCase
import org.quaerense.shoppinglist.domain.GetShopListUseCase
import org.quaerense.shoppinglist.domain.ShopItem
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getShopListUseCase: GetShopListUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase
) : ViewModel() {

    val shopList: LiveData<List<ShopItem>> = getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(item)
        }
    }

    fun changeEnableState(item: ShopItem) {
        viewModelScope.launch {
            val newItem = item.copy(enabled = !item.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}