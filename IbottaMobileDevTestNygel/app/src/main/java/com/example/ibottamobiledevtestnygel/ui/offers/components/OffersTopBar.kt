package com.example.ibottamobiledevtestnygel.ui.offers.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.CONTENT_DESCRIPTION_MORE
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFERS_SCREEN
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.SHOW_ALL
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.SHOW_FAVORITE
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel.Filter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OffersTopBar(viewModel: OfferViewModel) {
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(),
        title = {
            Text(
                text = OFFERS_SCREEN
            )
        },
        actions = {

            IconButton(onClick = { menuExpanded = !menuExpanded }) {
                Icon(Icons.Default.MoreVert, CONTENT_DESCRIPTION_MORE)
            }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = !menuExpanded }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(SHOW_FAVORITE)
                    },
                    onClick = {
                        viewModel.filterOffers(Filter.SHOW_FAVORITE)
                        menuExpanded = false

                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(SHOW_ALL)
                    },
                    onClick = {
                        viewModel.filterOffers(Filter.SHOW_ALL)
                        menuExpanded = false
                    },
                )
            }
        }
    )
}