package com.farasatnovruzov.cleanarchitecturecomposedemo.data.repository

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.ImdbAPI
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByIdDto
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByIdRepository
import javax.inject.Inject

class ImdbByIdRepositoryImpl @Inject constructor(
    private val imdbApi: ImdbAPI
): ImdbByIdRepository {
    override suspend fun getImdbById(query: String): ImdbByIdDto{
        return imdbApi.getImdbById(query = query)
    }
}