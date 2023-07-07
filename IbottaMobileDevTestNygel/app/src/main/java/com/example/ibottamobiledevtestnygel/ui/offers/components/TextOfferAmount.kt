package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ibottamobiledevtestnygel.ui.theme.Typography

@Composable
fun TextOfferAmount(currentValue: String) {
    Text(
        text = currentValue,
        maxLines = 1,
        style = Typography.labelMedium,
    )
}