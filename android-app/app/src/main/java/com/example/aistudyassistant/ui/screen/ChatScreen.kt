package com.example.aistudyassistant.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aistudyassistant.ui.theme.AIStudyAssistantTheme

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    knowledgeBaseTitle: String = "408 计算机基础",
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = knowledgeBaseTitle,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "基于当前知识库进行 AI 问答",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        ChatMessageCard(
            role = "你",
            content = "什么是虚拟内存？"
        )

        Spacer(modifier = Modifier.height(12.dp))

        ChatMessageCard(
            role = "AI 学习助手",
            content = "虚拟内存是一种内存管理技术，它为进程提供了连续、独立的虚拟地址空间，并通过页表完成虚拟地址到物理地址的映射。后续接入 RAG 后，这里会基于你上传的资料生成回答。"
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedTextField(
            value = "",
            onValueChange = {
                // TODO: 后续保存用户输入
            },
            placeholder = {
                Text(text = "输入你的问题...")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = onBackClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "返回")
            }

            Spacer(modifier = Modifier.weight(0.08f))

            Button(
                onClick = {
                    // TODO: 后续发送问题
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "发送")
            }
        }
    }
}

@Composable
private fun ChatMessageCard(
    role: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = role,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatScreenPreview() {
    AIStudyAssistantTheme {
        ChatScreen()
    }
}

