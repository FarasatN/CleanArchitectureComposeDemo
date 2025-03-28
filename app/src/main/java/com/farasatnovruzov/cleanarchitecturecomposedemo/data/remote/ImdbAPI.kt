package com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByIdDto
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByNameDto
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Constants.API_KEY
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImdbAPI {
    @GET("imdb/imdbSearchByName")
    suspend fun getImdbByName(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY,
        @Query("query") query: String
    ): ImdbByNameDto

    @GET("imdb/imdbSearchById")
    suspend fun getImdbById(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY,
        @Query("movieId") query: String
    ): ImdbByIdDto


}