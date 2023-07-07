package com.example.ibottamobiledevtestnygel.ui.offerdetail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.ibottamobiledevtestnygel.ui.offerdetail.components.OfferDetailContent
import com.example.ibottamobiledevtestnygel.ui.offerdetail.components.OfferDetailTopBar
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel

@Composable
fun OfferDetailScreen(
    viewModel: OfferViewModel,
    offerId: String,
    navigateBack: () -> Unit
) {
    Scaffold(topBar = {
        OfferDetailTopBar(navigateBack = navigateBack)
    }) { padding ->
        val offer = mutableStateOf(viewModel.offers.value?.find { it.id == offerId }).value
        offer?.let {
            val favoriteStatus = mutableStateOf(offer.favorite)
            OfferDetailContent(
                paddingValues = padding,
                offer = offer,
                favoriteStatus = favoriteStatus,
                onFavoriteClicked = {
                    viewModel.updateOfferFavoriteStatus(offer)
                    favoriteStatus.value = !favoriteStatus.value
                }
            )
        }
    }
}