package org.quaerense.shoppinglist.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import org.quaerense.shoppinglist.presentation.MainActivity
import org.quaerense.shoppinglist.presentation.ShopItemFragment

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}