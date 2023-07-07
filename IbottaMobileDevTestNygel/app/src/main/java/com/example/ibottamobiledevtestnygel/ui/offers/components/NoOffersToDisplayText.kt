package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.NO_OFFERS
import com.example.ibottamobiledevtestnygel.ui.theme.Typography

@Composable
fun NoOffersToDisplayText() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = NO_OFFERS,
            style = Typography.labelMedium
        )
    }
}