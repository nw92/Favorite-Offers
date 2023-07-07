package com.example.ibottamobiledevtestnygel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [OfferDatabaseEntity::class], version = 1, exportSchema = false)
abstract class OfferDatabase : RoomDatabase() {
    abstract val offerDao : OfferDao
}