package com.example.ibottamobiledevtestnygel.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_ID
import com.example.ibottamobiledevtestnygel.navigation.Screen.OfferDetailScreen
import com.example.ibottamobiledevtestnygel.navigation.Screen.OffersScreen
import com.example.ibottamobiledevtestnygel.ui.offerdetail.OfferDetailScreen
import com.example.ibottamobiledevtestnygel.ui.offers.OffersListScreen
import com.example.ibottamobiledevtestnygel.ui.viewmodel.OfferViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: OfferViewModel = hiltViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = OffersScreen.route
    ) {
        composable(
            route = OffersScreen.route
        ) {
            OffersListScreen(
                viewModel = viewModel,
                navigateToOfferDetailScreen = { offerId ->
                    navHostController.navigate(
                        route = "${OfferDetailScreen.route}/$offerId"
                    )
                }
            )
        }
        composable(
            route = "${OfferDetailScreen.route}/{$OFFER_ID}",
            arguments = listOf(navArgument(OFFER_ID) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString(OFFER_ID)?.let { offerId ->
                OfferDetailScreen(
                    viewModel = viewModel,
                    offerId = offerId,
                    navigateBack = {
                        navHostController.popBackStack()
                    }
                )
            }
        }
    }
}