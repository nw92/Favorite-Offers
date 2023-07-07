package com.example.ibottamobiledevtestnygel.ui.offerdetail.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_DETAIL_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferDetailTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = OFFER_DETAIL_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}