package com.example.agentx.data

import java.time.Instant
import java.time.LocalDate
import java.util.UUID

enum class GoalType {
    DEFICIT,
    MAINTAIN,
    BULK
}

enum class GenderType {
    MALE,
    FEMALE,
    OTHER
}

enum class AgentContext {
    MORNING,
    DAY,
    EVENING,
    WEEK
}

enum class AgentAction {
    OK,
    EXPLAIN,
    IGNORE
}

data class UserProfile(
    val id: UUID,
    val heightCm: Int,
    val gender: GenderType,
    val age: Int,
    val goal: GoalType,
    val targetCalories: Int?,
    val autoCalories: Boolean
)

data class DailyMetrics(
    val date: LocalDate,
    val weightKg: Float?,
    val caloriesIn: Int,
    val steps: Int,
    val activityMinutes: Int
)

data class AgentMessage(
    val id: UUID,
    val dateTime: Instant,
    val context: AgentContext,
    val text: String,
    val userAction: AgentAction?
)
