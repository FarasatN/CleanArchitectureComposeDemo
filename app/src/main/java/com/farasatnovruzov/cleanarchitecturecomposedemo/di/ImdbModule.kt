package com.farasatnovruzov.cleanarchitecturecomposedemo.di

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.ImdbAPI
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByNameDto
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.ImdbByNameDtoDeserializer
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.repository.ImdbByIdRepositoryImpl
import com.farasatnovruzov.cleanarchitecturecomposedemo.data.repository.ImdbByNameRepositoryImpl
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByIdRepository
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByNameRepository
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Constants.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ImdbModule {
    val gson = GsonBuilder()
        .registerTypeAdapter(ImdbByNameDto::class.java, ImdbByNameDtoDeserializer())
        .create()

    @Singleton
    @Provides
    fun provideApi(): ImdbAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ImdbAPI::class.java)
    }



    @Singleton
    @Provides
    fun provideImdbByNameRepository(imdbApi: ImdbAPI): ImdbByNameRepository {
        return ImdbByNameRepositoryImpl(imdbApi)
    }

    @Singleton
    @Provides
    fun provideImdbByIdRepository(imdbApi: ImdbAPI): ImdbByIdRepository {
        return ImdbByIdRepositoryImpl(imdbApi)
    }

}