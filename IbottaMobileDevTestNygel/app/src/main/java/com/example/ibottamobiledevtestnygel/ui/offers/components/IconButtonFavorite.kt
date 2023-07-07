package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.ibottamobiledevtestnygel.R

@Composable
fun IconButtonFavorite(
    enabled: Boolean,
    onFavoriteClicked: () -> Unit
) {
    val resourceId = if (enabled) R.drawable.baseline_favorite_enabled else R.drawable.baseline_favorite_disabled
    IconButton(onClick = {
        onFavoriteClicked() }
    ) {
        Icon(painter = painterResource(id = resourceId),
            contentDescription = null)
    }
}