package com.example.ibottamobiledevtestnygel.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_TABLE

@Entity(tableName = OFFER_TABLE)
data class OfferDatabaseEntity(
    @PrimaryKey
    val id: String,
    val current_value: String,
    val description: String,
    val name: String,
    val terms: String,
    val url: String,
    var favorite: Boolean = false
)