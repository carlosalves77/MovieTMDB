package br.com.tiisde.dev.movietmdb.data.dto


import br.com.tiisde.dev.movietmdb.domain.model.PopularMovies
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMoviesDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun PopularMoviesDTO.toPopularMovies(): PopularMovies {
    return PopularMovies(
        page = page,
        results = results,
        totalPages = totalPages,
        totalResults = totalResults
    )
}