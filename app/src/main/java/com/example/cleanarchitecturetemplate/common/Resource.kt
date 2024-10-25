package com.example.cleanarchitecturetemplate.common

/**
 * This sealed class represents different states of a resource, such as
 * success, error, or loading, and is used to manage data flow in
 * asynchronous operations (e.g., API requests, database operations)
 *
 * Example:
 * fun fetchDataFromApi(): Resource<String> {
 *     return try {
 *         val data = apiRequest()
 *         Resource.Success(data)
 *     } catch (e: Exception) {
 *         Resource.Error("Error message", null)
 *     }
 * }
 *
 *
 * val resource: Resource<String> = fetchDataFromApi()
 *
 * when (resource) {
 *     is Resource.Success -> {
 *         println("Data: ${resource.data}")
 *     }
 *     is Resource.Error -> {
 *         println("Error: ${resource.message}")
 *     }
 *     is Resource.Loading -> {
 *         println("Loading...")
 *     }
 * }
 *
 * */

sealed class Resource<T> (
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}
