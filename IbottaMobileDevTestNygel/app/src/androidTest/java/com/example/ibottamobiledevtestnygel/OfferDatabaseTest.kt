package com.example.ibottamobiledevtestnygel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ibottamobiledevtestnygel.data.database.OfferDao
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabase
import com.example.ibottamobiledevtestnygel.domain.Offer
import com.example.ibottamobiledevtestnygel.domain.toDatabaseModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class OfferDatabaseTest {
    private lateinit var offerDao: OfferDao
    private lateinit var db: OfferDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, OfferDatabase::class.java).build()
        offerDao = db.offerDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @Throws(Exception::class)
    fun writeAndRead() = runTest {
        val offer = Offer(
            id = "1",
            url = "https://product-images.ibotta.com/offer/dUxYcQPeq391-DiywFZF8g-normal.png",
            name = "Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges",
            description = "Any variety - 2 ct. pack or larger",
            terms =  "Rebate valid on Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges for any variety",
            current_value = "$0.75 Cash Back"
        )

        val offers = listOf(offer)
        assertEquals(1, offers.size)

        val dbOffers = offers.toDatabaseModel()
        assertEquals(1, dbOffers.size)

        offerDao.addOffers(*dbOffers)
        assertEquals(offer.name, offerDao.getOffer(id = "1").name)
    }
}