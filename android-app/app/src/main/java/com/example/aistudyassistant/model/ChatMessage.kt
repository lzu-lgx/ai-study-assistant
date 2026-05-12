package com.example.aistudyassistant.model

data class ChatMessage(
    val role: ChatRole,
    val content: String
)

enum class ChatRole {
    USER,
    ASSISTANT
}