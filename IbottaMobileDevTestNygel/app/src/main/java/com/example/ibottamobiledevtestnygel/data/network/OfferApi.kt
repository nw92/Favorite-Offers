package com.example.ibottamobiledevtestnygel.data.network

import com.example.ibottamobiledevtestnygel.domain.Offer
import retrofit2.Response
import retrofit2.http.GET

interface OfferApi {

    @GET("/offers")
    suspend fun getOffers() : Response<List<Offer>>
}