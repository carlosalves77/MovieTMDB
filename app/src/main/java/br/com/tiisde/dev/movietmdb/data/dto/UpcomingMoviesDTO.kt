package br.com.tiisde.dev.movietmdb.data.dto


import br.com.tiisde.dev.movietmdb.domain.model.UpcomingMovies
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpcomingMoviesDTO(
    @Json(name = "dates")
    val dates: Dates,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<ResultX>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun UpcomingMoviesDTO.toUpcomingMovies(): UpcomingMovies {
    return UpcomingMovies(
        dates = dates,
        page = page,
        results = results,
        totalPages = totalPages,
        totalResults = totalResults
    )
}