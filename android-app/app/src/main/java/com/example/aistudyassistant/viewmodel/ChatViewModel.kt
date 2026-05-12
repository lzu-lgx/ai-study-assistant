package com.example.aistudyassistant.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aistudyassistant.model.ChatMessage

class ChatViewModel : ViewModel() {

    var inputText = mutableStateOf("")
        private set

    val messages = mutableStateListOf(
        ChatMessage(
            role = "你",
            content = "什么是虚拟内存？"
        ),
        ChatMessage(
            role = "AI 学习助手",
            content = "虚拟内存是一种内存管理技术，它为进程提供了连续、独立的虚拟地址空间，并通过页表完成虚拟地址到物理地址的映射。后续接入 RAG 后，这里会基于你上传的资料生成回答。"
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
                role = "你",
                content = question
            )
        )

        messages.add(
            ChatMessage(
                role = "AI 学习助手",
                content = "这是一个模拟回复。后续这里会调用后端接口，并基于你的知识库资料生成回答。"
            )
        )

        inputText.value = ""
    }
}