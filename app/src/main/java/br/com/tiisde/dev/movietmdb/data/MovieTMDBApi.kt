package br.com.tiisde.dev.movietmdb.data

import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.data.dto.UpcomingMoviesDTO
import br.com.tiisde.dev.movietmdb.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieTMDBApi {

    @GET(Constants.BASE_URL_POPULAR_MOVIE)
    @Headers("Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getPopularMovies(): Response<PopularMoviesDTO>

    @GET(Constants.BASE_URL_UPCOMING_MOVIE)
    @Headers("Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getUpcomingMovies(): Response<UpcomingMoviesDTO>

}