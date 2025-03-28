package com.farasatnovruzov.cleanarchitecturecomposedemo.domain.usecase.imdbbyname

import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbByName
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByNameRepository
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImdbByNameUseCase @Inject constructor(private val imdbByNameRepository: ImdbByNameRepository) {
//    fun getImdbByName(): LiveData<Resource<List<ImdbByName>>>
    fun getImdbByName(query: String): Flow<Resource<List<ImdbByName>>> = flow {
        try {
            emit(Resource.Loading())
            val imdbByName = imdbByNameRepository.getImdbByName(query = query)
            if (imdbByName.success) {
//                emit(Resource.Success(imdbByName.toImdbByName()))
                emit(Resource.Success(imdbByName.result.orEmpty()))
            } else {
                emit(Resource.Error("Error: No imdb found"))
            }
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }

    }
}