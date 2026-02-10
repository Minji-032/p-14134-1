package com.back.domain.chat.ChatMessage.entity

import java.time.LocalDateTime

data class ChatMessage(
    private val id: Int,
    val createDate: LocalDateTime,
    var modifyDate: LocalDateTime,
    val chatRoomId: Int,
    val writerName: String,
    val content: String
)