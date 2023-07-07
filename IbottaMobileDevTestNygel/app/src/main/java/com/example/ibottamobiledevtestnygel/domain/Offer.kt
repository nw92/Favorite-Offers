package com.example.ibottamobiledevtestnygel.domain

import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Offer(
    val id: String,
    val current_value: String,
    val description: String,
    val name: String,
    val terms: String,
    val url: String?
)

fun List<Offer>.toDatabaseModel() : Array<OfferDatabaseEntity> {
    return this.map {
        OfferDatabaseEntity(
            id = it.id,
            current_value = it.current_value,
            description = it.description,
            name = it.name,
            terms = it.terms,
            url = it.url ?: ""
        )
    }.toTypedArray()
}