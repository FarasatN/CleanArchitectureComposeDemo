package com.farasatnovruzov.cleanarchitecturecomposedemo.domain.usecase.imdbbyid

import com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto.toImdbById
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbById
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.repository.ImdbByIdRepository
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImdbByIdUseCase @Inject constructor(private val imdbByIdRepository: ImdbByIdRepository) {
//    fun getImdbById(): LiveData<Resource<List<ImdbById>>>
    fun getImdbById(query: String): Flow<Resource<ImdbById>> = flow {
        try {
            emit(Resource.Loading())
            val imdbById = imdbByIdRepository.getImdbById(query = query)
            if (imdbById.success) {
//                emit(Resource.Success(imdbById.toImdbById()))
                emit(Resource.Success(imdbById.toImdbById()))
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