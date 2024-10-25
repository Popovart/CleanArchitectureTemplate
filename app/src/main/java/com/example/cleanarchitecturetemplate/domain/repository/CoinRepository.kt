package com.example.cleanarchitecturetemplate.domain.repository

import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturetemplate.data.remote.dto.CoinDto

/**
 * This is a repository. There is two repositories to each data source:
 * The first is located in a data layer, the second - here in a domain layer.
 * Repository in a domain layer is used only to 'define' the repository by
 * creating an interface.
 *
 * Why do we have two repositories for each data source?
 * It is useful for testcases, as we can avoid using the repository with Api,
 * which could be time consuming in some cases, and just use the 'fake' versions
 * of repository that simulates the behavior of the API in this case and this fake repository
 * can implement this interface.
 */

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}