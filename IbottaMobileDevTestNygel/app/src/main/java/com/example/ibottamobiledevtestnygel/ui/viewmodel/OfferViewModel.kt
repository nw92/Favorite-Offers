package com.example.ibottamobiledevtestnygel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabaseEntity
import com.example.ibottamobiledevtestnygel.data.repository.OfferRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val repo: OfferRepository
) : ViewModel() {

    private var _offers = repo.offers
    val offers: LiveData<List<OfferDatabaseEntity>>
        get() = _offers.value

    private var favorites = MutableLiveData<List<OfferDatabaseEntity>>()

    init {
        viewModelScope.launch {
            if (repo.getFavorites().isEmpty()) {
                repo.refreshOffers()
            }
        }
    }

    enum class Filter {
        SHOW_FAVORITE,
        SHOW_ALL
    }

    fun filterOffers(filter: Filter) {
        when (filter) {
            Filter.SHOW_FAVORITE -> {
                getFavoriteOffers()
            }
            else -> {
                getAllOffers()
            }
        }
    }

    fun getFavoriteOffers() {
        viewModelScope.launch {
            favorites.value = repo.getFavorites()
            _offers.value = favorites
        }
    }

    fun getAllOffers() {
        _offers.value = repo.getAllOffers()
    }

    fun updateOfferFavoriteStatus(offer: OfferDatabaseEntity) {
        viewModelScope.launch {
            repo.updateOfferFavoriteStatusInRoom(offer)
            favorites.value = repo.getFavorites()
        }
    }

}
