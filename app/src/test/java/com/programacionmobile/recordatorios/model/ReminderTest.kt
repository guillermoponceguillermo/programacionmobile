package com.programacionmobile.recordatorios.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ReminderTest {
    @Test
    fun `rechaza recordatorios sin identificador o titulo`() {
        val validReminder = ReminderSamples.reminders.first()

        val blankIdError = runCatching { validReminder.copy(id = " ") }.exceptionOrNull()
        val blankTitleError = runCatching { validReminder.copy(title = " ") }.exceptionOrNull()

        assertTrue(blankIdError is IllegalArgumentException)
        assertTrue(blankTitleError is IllegalArgumentException)
    }

    @Test
    fun `datos de ejemplo contienen categorias unicas y filtros correctos`() {
        assertEquals(
            ReminderSamples.reminders.map(Reminder::category).toSet(),
            ReminderSamples.uniqueCategories
        )
        assertTrue(ReminderSamples.pendingReminders.all {
            it.status == ReminderStatus.Pending
        })
        assertTrue(ReminderSamples.highPriorityReminders.all {
            it.priority == ReminderPriority.HIGH
        })
    }
}
