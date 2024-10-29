package com.example.cleanarchitecturetemplate.presenation.coin_list_screen

import com.example.cleanarchitecturetemplate.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
