package com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByIdDto

interface ImdbByIdRepository {

    suspend fun getImdbById(query: String): ImdbByIdDto
}