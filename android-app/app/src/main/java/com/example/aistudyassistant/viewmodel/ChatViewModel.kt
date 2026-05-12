package com.example.aistudyassistant.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aistudyassistant.model.ChatMessage
import com.example.aistudyassistant.model.ChatRole

class ChatViewModel : ViewModel() {

    var inputText = mutableStateOf("")
        private set

    val messages = mutableStateListOf(
        ChatMessage(
            role = ChatRole.USER,
            content = "什么是虚拟内存？"
        ),
        ChatMessage(
            role = ChatRole.ASSISTANT,
            content = "虚拟内存是一种内存管理技术..."
        )
    )

    fun onInputTextChange(newText: String) {
        inputText.value = newText
    }

    fun sendMessage() {
        val question = inputText.value.trim()

        if (question.isEmpty()) {
            return
        }

        messages.add(
            ChatMessage(
                role = ChatRole.USER,
                content = question
            )
        )

        messages.add(
            ChatMessage(
                role = ChatRole.ASSISTANT,
                content = "这是一个模拟回复。后续这里会调用后端接口，并基于你的知识库资料生成回答。"
            )
        )

        inputText.value = ""
    }
}