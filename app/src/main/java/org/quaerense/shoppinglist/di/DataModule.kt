package org.quaerense.shoppinglist.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import org.quaerense.shoppinglist.data.AppDatabase
import org.quaerense.shoppinglist.data.ShopListDao
import org.quaerense.shoppinglist.data.ShopListRepositoryImpl
import org.quaerense.shoppinglist.domain.ShopListRepository

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}