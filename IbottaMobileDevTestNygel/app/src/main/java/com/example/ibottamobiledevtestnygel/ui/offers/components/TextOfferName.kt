package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.example.ibottamobiledevtestnygel.ui.theme.Typography

@Composable
fun TextOfferName(name: String) {
    Text(
        text = name,
        style = Typography.labelSmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}