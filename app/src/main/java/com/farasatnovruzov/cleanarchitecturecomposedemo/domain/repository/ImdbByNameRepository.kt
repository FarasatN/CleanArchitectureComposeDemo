package com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByNameDto

interface ImdbByNameRepository {

    suspend fun getImdbByName(query: String): ImdbByNameDto
}