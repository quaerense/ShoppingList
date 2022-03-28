package org.quaerense.shoppinglist.presentation

import android.app.Application
import org.quaerense.shoppinglist.di.DaggerApplicationComponent

class ShopApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}