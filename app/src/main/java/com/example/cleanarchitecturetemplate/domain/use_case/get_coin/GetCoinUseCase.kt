package com.example.cleanarchitecturetemplate.domain.use_case.get_coin

import com.example.cleanarchitecturetemplate.common.Resource
import com.example.cleanarchitecturetemplate.data.remote.dto.toCoin
import com.example.cleanarchitecturetemplate.data.remote.dto.toCoinDetail
import com.example.cleanarchitecturetemplate.domain.model.Coin
import com.example.cleanarchitecturetemplate.domain.model.CoinDetail
import com.example.cleanarchitecturetemplate.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * error validation can be here, but not the one related to API calls
 *(so not HttpException and IOException).
 * Error Handling:
 * Business Logic Errors:
 * * Validate inputs.
 * * Enforce business rules.
 * Use Case Failures:
 * * Return failure results.
 * * Throw domain-specific exceptions.
 * Error Propagation:
 * * Map data layer errors to domain-relevant errors.
 *
 * Do Not:
 * * Handle technical exceptions (e.g., network, database errors).
 * * Depend on frameworks or external libraries.
 **/
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}
