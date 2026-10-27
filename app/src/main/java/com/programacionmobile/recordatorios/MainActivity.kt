package com.programacionmobile.recordatorios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.programacionmobile.recordatorios.model.Reminder
import com.programacionmobile.recordatorios.model.ReminderCategory
import com.programacionmobile.recordatorios.model.ReminderSamples
import com.programacionmobile.recordatorios.model.ReminderStatus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecordatoriosTheme {
                ReminderHomeScreen()
            }
        }
    }
}

@Composable
private fun RecordatoriosTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF315CBB),
            background = Color(0xFFF5F6FA),
            surface = Color.White
        ),
        content = content
    )
}

@Composable
private fun ReminderHomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Mis recordatorios",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Organizá tus tareas importantes",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF666B78)
            )
            Spacer(modifier = Modifier.height(20.dp))

            SummaryCard()

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Todas las tareas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(ReminderSamples.reminders, key = Reminder::id) { reminder ->
                    ReminderCard(reminder)
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
            }
        }
    }
}

@Composable
private fun SummaryCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8EDFC))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Pendientes", color = Color(0xFF555D70))
                Text(
                    text = ReminderSamples.pendingReminders.size.toString(),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF244B9E)
                )
            }
            Text(
                text = "${ReminderSamples.uniqueCategories.size} categorías",
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xFF244B9E)
            )
        }
    }
}

@Composable
private fun ReminderCard(reminder: Reminder) {
    val categoryColor = Color(
        ReminderSamples.categoryColors[reminder.category] ?: 0xFF667085
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = reminder.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                StatusBadge(reminder.status)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = reminder.category.label,
                    color = categoryColor,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Text("  ·  ${reminder.priority.label}", color = Color(0xFF616775))
            }
            reminder.dueAtLabel?.let {
                Spacer(modifier = Modifier.height(6.dp))
                Text(it, style = MaterialTheme.typography.bodySmall, color = Color(0xFF616775))
            }
            reminder.location?.let {
                Spacer(modifier = Modifier.height(6.dp))
                Text("Ubicación: $it", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
private fun StatusBadge(status: ReminderStatus) {
    val (label, color) = when (status) {
        ReminderStatus.Pending -> "Pendiente" to Color(0xFFB05A2A)
        ReminderStatus.InProgress -> "En curso" to Color(0xFF315CBB)
        ReminderStatus.Completed -> "Hecho" to Color(0xFF23836A)
    }

    Row(
        modifier = Modifier
            .background(color.copy(alpha = 0.12f), CircleShape)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Spacer(
            modifier = Modifier
                .size(7.dp)
                .background(color, CircleShape)
        )
        Text(label, color = color, style = MaterialTheme.typography.labelMedium)
    }
}
