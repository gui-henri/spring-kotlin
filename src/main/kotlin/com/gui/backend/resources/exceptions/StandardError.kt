package com.gui.backend.resources.exceptions

data class StandardError(
    val status: Int,
    val msg: String,
    val timestamp: Long
)