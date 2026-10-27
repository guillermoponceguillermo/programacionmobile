package com.programacionmobile.recordatorios.model

object ReminderSamples {
    val reminders = listOf(
        Reminder(
            id = "reminder-1",
            title = "Entregar informe del proyecto",
            category = ReminderCategory.WORK,
            priority = ReminderPriority.HIGH,
            status = ReminderStatus.Pending,
            description = "Revisar el documento antes de enviarlo.",
            dueAtLabel = "Hoy · 16:00",
            notificationEnabled = true
        ),
        Reminder(
            id = "reminder-2",
            title = "Repasar Kotlin",
            category = ReminderCategory.STUDY,
            priority = ReminderPriority.MEDIUM,
            status = ReminderStatus.InProgress,
            dueAtLabel = "Mañana · 10:00"
        ),
        Reminder(
            id = "reminder-3",
            title = "Pedir turno con el dentista",
            category = ReminderCategory.HEALTH,
            priority = ReminderPriority.LOW,
            status = ReminderStatus.Completed,
            location = "Centro de salud"
        ),
        Reminder(
            id = "reminder-4",
            title = "Comprar víveres",
            category = ReminderCategory.PERSONAL,
            priority = ReminderPriority.MEDIUM,
            status = ReminderStatus.Pending,
            location = "Supermercado"
        )
    )

    val uniqueCategories: Set<ReminderCategory> = reminders
        .map(Reminder::category)
        .toSet()

    val categoryColors: Map<ReminderCategory, Long> = mapOf(
        ReminderCategory.WORK to 0xFF315CBB,
        ReminderCategory.STUDY to 0xFF7652B5,
        ReminderCategory.PERSONAL to 0xFFB05A2A,
        ReminderCategory.HEALTH to 0xFF23836A
    )

    val pendingReminders: List<Reminder> = reminders.filter {
        it.status == ReminderStatus.Pending
    }

    val highPriorityReminders: List<Reminder> = reminders.filter {
        it.priority == ReminderPriority.HIGH
    }
}
