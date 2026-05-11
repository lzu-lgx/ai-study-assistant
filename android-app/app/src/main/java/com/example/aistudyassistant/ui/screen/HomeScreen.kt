package com.example.aistudyassistant.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aistudyassistant.ui.theme.AIStudyAssistantTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AI Study Assistant",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "你的个人 AI 学习助手",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "上传课程资料、笔记和文档，构建个人知识库，并基于资料进行 AI 问答、总结和复习。",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // TODO: 后续跳转到知识库页面
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "开始学习")
        }

        Spacer(modifier = Modifier.height(24.dp))

        FeatureCard(
            title = "个人知识库",
            description = "管理你的课程资料、PDF、Markdown 和学习笔记。"
        )

        Spacer(modifier = Modifier.height(12.dp))

        FeatureCard(
            title = "AI 问答",
            description = "基于你上传的资料进行 RAG 检索增强回答。"
        )

        Spacer(modifier = Modifier.height(12.dp))

        FeatureCard(
            title = "学习记录",
            description = "保存历史会话、收藏重点回答，并整理复习内容。"
        )
    }
}

@Composable
private fun FeatureCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AIStudyAssistantTheme {
        HomeScreen()
    }
}