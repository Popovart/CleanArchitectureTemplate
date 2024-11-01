package com.example.cleanarchitecturetemplate.domain.use_case.get_coins

import com.example.cleanarchitecturetemplate.common.Resource
import com.example.cleanarchitecturetemplate.domain.model.Coin
import com.example.cleanarchitecturetemplate.domain.model.CoinDetail
import com.example.cleanarchitecturetemplate.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: Exception) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}