package com.example.legend.moviedb.service.model

import com.google.gson.annotations.SerializedName

data class Genre(
	@SerializedName("name")
	val name: String? = null,
	@SerializedName("id")
	val id: Int? = null
)
