package com.example.ibottamobiledevtestnygel.navigation

import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFERS_SCREEN
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_DETAIL_SCREEN

sealed class Screen(val route: String) {
    object OffersScreen : Screen(OFFERS_SCREEN)
    object OfferDetailScreen : Screen(OFFER_DETAIL_SCREEN)
}
