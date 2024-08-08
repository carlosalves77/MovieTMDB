package br.com.tiisde.dev.movietmdb.domain.model

import br.com.tiisde.dev.movietmdb.data.dto.Dates
import br.com.tiisde.dev.movietmdb.data.dto.ResultX

data class UpcomingMovies(
    val dates: Dates,
    val page: Int,
    val results: List<ResultX>,
    val totalPages: Int,
    val totalResults: Int
)
