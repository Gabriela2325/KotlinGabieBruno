package com.example.kotlingabiebruno.api

import com.example.kotlingabiebruno.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 10
    ): BookResponse
}