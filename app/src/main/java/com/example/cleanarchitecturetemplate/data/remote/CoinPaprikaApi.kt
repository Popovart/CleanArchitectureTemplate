package com.example.cleanarchitecturetemplate.data.remote

import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * This is the place where data fetches from CoinApi.
 * Retrofit is used here for HTTP requests
 * */

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto

}