package com.example.ibottamobiledevtestnygel.ui.offers

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.ibottamobiledevtestnygel.ui.offers.components.OffersContent
import com.example.ibottamobiledevtestnygel.ui.offers.components.OffersTopBar
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel

@Composable
fun OffersListScreen(
    viewModel: OfferViewModel,
    navigateToOfferDetailScreen: (offerId: String) -> Unit
) {

    val offers by viewModel.offers.observeAsState(
        initial = emptyList()
    )

     Scaffold(
         topBar = {
             OffersTopBar(viewModel)
         },
         content = { padding ->
             OffersContent(
                 padding = padding,
                 offers = offers,
                 viewModel = viewModel,
                 navigateToOfferDetailScreen = navigateToOfferDetailScreen
             )
         }
     )

}