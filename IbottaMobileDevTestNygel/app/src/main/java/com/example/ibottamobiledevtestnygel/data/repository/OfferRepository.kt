package com.example.ibottamobiledevtestnygel.data.repository

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabase
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity
import com.example.ibottamobiledevtestnygel.data.network.OfferApi
import com.example.ibottamobiledevtestnygel.domain.toDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OfferRepository(
    offerDatabase: OfferDatabase,
    private val offerApi: OfferApi
) {
    private val offerDao = offerDatabase.offerDao

    val offers = mutableStateOf(offerDao.getAllOffers())

    suspend fun updateOfferFavoriteStatusInRoom(offer: OfferDatabaseEntity) {
        withContext(Dispatchers.IO) {
            offerDao.updateOffer(
                offer.apply {
                    this.favorite = !offer.favorite
                }
            )
        }
    }

    fun getAllOffers(): LiveData<List<OfferDatabaseEntity>> {
        return offerDao.getAllOffers()
    }

    suspend fun getFavorites(): List<OfferDatabaseEntity> {
        return withContext(Dispatchers.IO) {
            offerDao.getFavoriteOffers()
        }
    }

    suspend fun refreshOffers() {
        withContext(Dispatchers.IO) {
            val response = offerApi.getOffers()
            if (response.isSuccessful) {
                response.body()?.let { offers ->
                    val offersDb = offers.toDatabaseModel()
                    offerDao.addOffers(*offersDb)
                }
            }
        }
    }

}