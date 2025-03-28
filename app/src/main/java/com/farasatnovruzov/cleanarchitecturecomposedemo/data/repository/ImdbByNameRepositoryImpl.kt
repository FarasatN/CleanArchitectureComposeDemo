package com.farasatnovruzov.cleanarchitecturecomposedemo.data.repository

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.ImdbAPI
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByNameDto
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByNameRepository
import javax.inject.Inject

class ImdbByNameRepositoryImpl @Inject constructor(
    private val imdbApi: ImdbAPI
): ImdbByNameRepository {
    override suspend fun getImdbByName(query: String): ImdbByNameDto{
        return imdbApi.getImdbByName(query = query)
    }
}