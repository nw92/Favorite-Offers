package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferImage(url: String,
               name: String,
               offerId: String,
               navigateToOfferDetailScreen: (offerId: String) -> Unit
) {
    Card(
        modifier = Modifier
            .height(125.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            navigateToOfferDetailScreen(offerId)
        }
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxSize(),
            model = url,
            contentDescription = name
        )
    }
}