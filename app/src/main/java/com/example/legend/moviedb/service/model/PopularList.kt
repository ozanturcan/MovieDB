package com.example.legend.moviedb.service.model

import com.google.gson.annotations.SerializedName

data class PopularList(
	@SerializedName("page")
	val page: Int?,
	@SerializedName("total_pages")
	val totalPages: Int?,
	@SerializedName("results")
	val results: List<Movie?>?,
	@SerializedName("total_results")
	val totalResults: Int?
)
