package com.gui.backend.resources.exceptions

abstract class ErrorFilds {
    abstract val status: Int
    abstract val msg: String
    abstract val timestamp: Long
}