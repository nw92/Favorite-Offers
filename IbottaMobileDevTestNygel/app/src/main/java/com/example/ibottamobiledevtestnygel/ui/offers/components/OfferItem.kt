package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity

@Composable
fun OfferItem(
    offer: OfferDatabaseEntity,
    navigateToOfferDetailScreen: (offerId: String) -> Unit,
    favoriteStatus : MutableState<Boolean>,
    onFavoriteClicked: () -> Unit
) {
    Column(
        modifier =
        Modifier
            .padding(
                top = 24.dp,
                start = 4.dp,
                end = 4.dp
            )
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OfferImage(url = offer.url, name = offer.name, offerId = offer.id, navigateToOfferDetailScreen)
        }
        Row {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(.75F),
            ) {
                TextOfferAmount(currentValue = offer.current_value)
                Spacer(modifier = Modifier.padding(top = 3.dp))
                TextOfferName(name = offer.name)
            }

            IconButtonFavorite(enabled = favoriteStatus.value, onFavoriteClicked = onFavoriteClicked)

        }
    }
}