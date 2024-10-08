package br.com.tiisde.dev.movietmdb.util

sealed interface Result<out T> {

    data object Idle: Result<Nothing>
    data object Loading: Result<Nothing>
    data class Success<T>(val data: T) : Result<T>
    data class Error(val error: Throwable) : Result<Nothing>
}