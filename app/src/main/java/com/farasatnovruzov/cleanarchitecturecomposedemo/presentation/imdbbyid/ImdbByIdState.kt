package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid

import androidx.collection.emptyObjectList
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbById

data class ImdbByIdState (
    val isLoading: Boolean = false,
    val imdbById: ImdbById? = null,
    val error: String = ""
)
