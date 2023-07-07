package com.example.ibottamobiledevtestnygel.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_TABLE

@Dao
interface OfferDao {

    @Query("SELECT * FROM $OFFER_TABLE ORDER BY id ASC")
    fun getAllOffers() : LiveData<List<OfferDatabaseEntity>>

    @Query("SELECT * FROM $OFFER_TABLE WHERE favorite = 1")
    fun getFavoriteOffers() : List<OfferDatabaseEntity>

    @Query("SELECT * FROM $OFFER_TABLE WHERE id = :id")
    suspend fun getOffer(id: String) : OfferDatabaseEntity

    @Update
    suspend fun updateOffer(offer: OfferDatabaseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOffers(vararg offer: OfferDatabaseEntity)
}