package com.programacionmobile.recordatorios.model

enum class ReminderCategory(val label: String) {
    WORK("Trabajo"),
    STUDY("Estudio"),
    PERSONAL("Personal"),
    HEALTH("Salud")
}

enum class ReminderPriority(val label: String) {
    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta")
}

sealed interface ReminderStatus {
    data object Pending : ReminderStatus
    data object InProgress : ReminderStatus
    data object Completed : ReminderStatus
}

data class Reminder(
    val id: String,
    val title: String,
    val category: ReminderCategory,
    val priority: ReminderPriority,
    val status: ReminderStatus,
    val description: String? = null,
    val dueAtLabel: String? = null,
    val location: String? = null,
    val notificationEnabled: Boolean = false
) {
    init {
        require(id.isNotBlank()) { "El identificador no puede estar vacío." }
        require(title.isNotBlank()) { "El título no puede estar vacío." }
        require(description == null || description.isNotBlank()) {
            "La descripción debe omitirse si no tiene contenido."
        }
    }
}
