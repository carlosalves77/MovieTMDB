package br.com.tiisde.dev.movietmdb.domain.model

import br.com.tiisde.dev.movietmdb.data.dto.Result

data class PopularMovies(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
)
