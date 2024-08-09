package br.com.tiisde.dev.movietmdb.data

import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.data.dto.UpcomingMoviesDTO
import br.com.tiisde.dev.movietmdb.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieTMDBApi {

    @GET("movie/popular")
    @Headers("Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getPopularMovies(
//        @Path("movie/upcoming") upcomingMovie : String = "upcoming",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<PopularMoviesDTO>

    @GET("movie/upcoming")
    @Headers("Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getUpcomingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<UpcomingMoviesDTO>

}