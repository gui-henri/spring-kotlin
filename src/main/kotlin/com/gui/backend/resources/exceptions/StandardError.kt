package com.gui.backend.resources.exceptions

data class StandardError(
    override val status: Int,
    override val msg: String,
    override val timestamp: Long
): ErrorFilds()