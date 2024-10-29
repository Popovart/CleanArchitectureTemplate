package com.example.cleanarchitecturetemplate.data.repository

import com.example.cleanarchitecturetemplate.common.Resource
import com.example.cleanarchitecturetemplate.data.remote.CoinPaprikaApi
import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDto
import com.example.cleanarchitecturetemplate.data.remote.dto.toCoin
import com.example.cleanarchitecturetemplate.data.remote.dto.toCoinDetail
import com.example.cleanarchitecturetemplate.domain.model.Coin
import com.example.cleanarchitecturetemplate.domain.model.CoinDetail
import com.example.cleanarchitecturetemplate.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * Hilt is used here for dependency Injection
 * (I don't know why and I don't know what is injection)
 *
 * Error Handling:
 * Technical Exceptions:
 * * Catch IOException, HttpException, SQLException, etc.
 * Network Errors:
 * * Handle connectivity issues and timeouts.
 * Data Integrity Errors:
 * * Manage corrupt or inconsistent data.
 *
 * Do Not:
 * * Let technical exceptions propagate to higher layers unhandled.
 * * Include business logic validations.
 * */
class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return try {
            val coinDtos = api.getCoins()
            coinDtos.map { it.toCoin() }
        } catch (e: HttpException) {
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            throw Exception("Couldn't reach server. Check your internet connection")
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return try {
            val coinDetailDto = api.getCoinById(coinId)
            coinDetailDto.toCoinDetail()
        } catch (e: HttpException) {
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            throw Exception("Couldn't reach server. Check your internet connection")
        }
    }
}

