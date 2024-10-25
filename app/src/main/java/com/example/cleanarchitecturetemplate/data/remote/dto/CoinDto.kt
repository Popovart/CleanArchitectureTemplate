package com.example.cleanarchitecturetemplate.data.remote.dto

import com.example.cleanarchitecturetemplate.domain.model.Coin
import com.google.gson.annotations.*

/**
 * This data class is a Date Transfer Object.
 * It is used when you get your data from some network source
 * Typically, DTOs can't be used in a UI, as UI doesn't require
 * each field every time. So, this class is used only for remote data sources.
 * In this example it will be used for fetching data from coinApi
 */

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

/**
 * @CoinDto.toCoin() is used to map our DTO to the UI appropriate form.
 * Here CoinDto will be mapped to Coin
 * */

fun CoinDto.toCoin() : Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}