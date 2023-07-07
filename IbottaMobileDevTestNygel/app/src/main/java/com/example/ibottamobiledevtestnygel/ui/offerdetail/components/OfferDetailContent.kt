package com.example.ibottamobiledevtestnygel.ui.offerdetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity
import com.example.ibottamobiledevtestnygel.ui.offers.components.IconButtonFavorite
import com.example.ibottamobiledevtestnygel.ui.theme.Typography

@Composable
fun OfferDetailContent(
    offer: OfferDatabaseEntity,
    paddingValues: PaddingValues,
    favoriteStatus : MutableState<Boolean>,
    onFavoriteClicked: () -> Unit
) {
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
        ) {
            Image(offer = offer)
            OfferDetails(
                offer = offer,
                favoriteStatus = favoriteStatus,
                onFavoriteClicked = onFavoriteClicked)
        }
}

@Composable
fun Image(offer: OfferDatabaseEntity) {
    Card(
        shape = RoundedCornerShape(0.dp),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f)
                .padding(12.dp)
            ,
            model = offer.url,
            contentDescription = offer.name
        )
    }
}

@Composable
fun OfferDetails(
    offer: OfferDatabaseEntity,
    favoriteStatus : MutableState<Boolean>,
    onFavoriteClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = offer.current_value,
                    maxLines = 1,
                    style = Typography.labelLarge,
                )

                IconButtonFavorite(
                    enabled = favoriteStatus.value,
                    onFavoriteClicked = onFavoriteClicked
                )

            }
            Column(Modifier.padding(end = 24.dp)) {
                Text(
                    text = offer.name,
                    style = Typography.labelMedium
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = offer.terms,
                    style = Typography.labelSmall
                )

            }
        }
    }
}