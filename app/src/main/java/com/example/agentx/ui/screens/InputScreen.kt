package com.example.agentx.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputScreen() {
    val weight = remember { mutableStateOf("") }
    val calories = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Ввод данных", style = MaterialTheme.typography.titleLarge)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Быстрый ввод веса")
                OutlinedTextField(
                    value = weight.value,
                    onValueChange = { weight.value = it },
                    label = { Text("Вес, кг") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                    Text("Сохранить вес")
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Добавление еды")
                OutlinedTextField(
                    value = calories.value,
                    onValueChange = { calories.value = it },
                    label = { Text("Калории") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                    Text("Добавить")
                }
            }
        }
    }
}
