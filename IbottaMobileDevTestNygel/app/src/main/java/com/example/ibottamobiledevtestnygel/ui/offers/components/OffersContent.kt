package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel

@Composable
fun OffersContent(
    padding: PaddingValues? = null,
    offers: List<OfferDatabaseEntity>?,
    viewModel: OfferViewModel,
    navigateToOfferDetailScreen: (offerId: String) -> Unit
) {
    if (!offers.isNullOrEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            modifier = Modifier
                .padding(
                    top = padding?.calculateTopPadding() ?: 0.dp,
                    start = 8.dp,
                    end = 8.dp
                )
                .fillMaxWidth()
        ) {
            items(offers) { offer ->
                val favoriteStatus = mutableStateOf(offer.favorite)
                OfferItem(
                    offer,
                    navigateToOfferDetailScreen = navigateToOfferDetailScreen,
                    favoriteStatus = favoriteStatus,
                    onFavoriteClicked = {
                        viewModel.updateOfferFavoriteStatus(offer)
                        favoriteStatus.value = !favoriteStatus.value
                    }
                )
            }
        }
    } else {
        NoOffersToDisplayText()
    }
}

@Preview
@Composable
private fun OffersContentPreview() {
    val offers = arrayListOf<OfferDatabaseEntity>()
    repeat(13) {
        offers.add(
            OfferDatabaseEntity(
                id = "121231",
                url = "https://product-images.ibotta.com/offer/Jp9DuC4ASBrwK-6mmV3sow-normal.png",
                name = "Trail's End",
                description = "750 ml. bottle",
                terms = "Rebate valid on Trail's End, 750 ml. bottle.",
                current_value = "$10.00 Cash Back"
            )
        )
    }
    OffersContent(offers = offers, viewModel = hiltViewModel()) {}
}