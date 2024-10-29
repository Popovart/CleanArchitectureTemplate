package com.example.cleanarchitecturetemplate.presenation.coin_detail_screen

import com.example.cleanarchitecturetemplate.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
