package com.example.cleanarchitecturetemplate.domain.model

import com.google.gson.annotations.SerializedName

/**
 * This data class is a shrink version of coinDto
 * as UI require only this fields.
 *
 * That means that each time you create a new DTO class
 * you need also create a small version of it, which will be
 * exposed to the UI layer
 */

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
