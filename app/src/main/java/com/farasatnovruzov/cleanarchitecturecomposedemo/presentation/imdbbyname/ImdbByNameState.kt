package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname

import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbByName

data class ImdbByNameState (
    val isLoading: Boolean = false,
    val imdbByName: List<ImdbByName>? = emptyList(),
    val error: String = ""
)
