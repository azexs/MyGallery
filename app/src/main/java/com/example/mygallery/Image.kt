package com.example.mygallery
import java.io.Serializable

data class Image (
    val imageId: Int,
    val description: String,
    var rating: Float
): Serializable