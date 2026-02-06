package com.example.agentx.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AgentScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Агент", style = MaterialTheme.typography.titleLarge)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Доброе утро. Вес в рабочем диапазоне."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Сегодня держим план без изменений."
                )
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {}) { Text("Ок") }
            Button(onClick = {}) { Text("Поясни") }
            Button(onClick = {}) { Text("Игнорировать") }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "История сообщений", style = MaterialTheme.typography.titleMedium)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Вчера: Отличный день. Фиксируем результат.")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Позавчера: Калории выше нормы — компенсируем движением.")
            }
        }
    }
}
