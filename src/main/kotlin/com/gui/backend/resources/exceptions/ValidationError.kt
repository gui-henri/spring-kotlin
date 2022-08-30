package com.gui.backend.resources.exceptions

data class ValidationError (
    override val status: Int,
    override val msg: String,
    override val timestamp: Long,
    val errors: MutableList<FieldMessage>
): ErrorFilds() {
    fun addError(fieldName: String, message: String) = errors.add(FieldMessage(fieldName, message))
}