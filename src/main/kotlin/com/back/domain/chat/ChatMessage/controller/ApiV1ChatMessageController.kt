package com.back.domain.chat.ChatMessage.controller

import com.back.domain.chat.ChatMessage.entity.ChatMessage
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/chat/rooms/{chatRoomId}/messages")
@CrossOrigin(origins = ["https://cdpn.io"])
class ApiV1ChatMessageController {
    private var lastChatMessageId = 0
    private val chatMessagesByRoomId: MutableMap<Int, MutableList<ChatMessage>> = mutableMapOf(
        1 to mutableListOf(
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 1,
                writerName = "김철수",
                content = "풋살하실 분 계신가요?"
            ),
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 1,
                writerName = "이영희",
                content = "네, 저요!"
            )
        ),
        2 to mutableListOf(
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 2,
                writerName = "박철수",
                content = "농구하실 분 계신가요?"
            ),
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 2,
                writerName = "김영희",
                content = "네, 저요!"
            )
        ),
        3 to mutableListOf(
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 3,
                writerName = "이철수",
                content = "야구하실 분 계신가요?"
            ),
            ChatMessage(
                id = ++lastChatMessageId,
                createDate = LocalDateTime.now(),
                modifyDate = LocalDateTime.now(),
                chatRoomId = 3,
                writerName = "박영희",
                content = "네, 저요!"
            )
        )
    )

    @GetMapping
    fun getItems(
        @PathVariable chatRoomId: Int,
        @RequestParam(defaultValue = "-1") afterChatMessageId: Int
    ): List<ChatMessage> =
        chatMessagesByRoomId
            .getOrDefault(chatRoomId, emptyList())
            .filter { it.id > afterChatMessageId }
            .toList()

    data class ChatMessageWriteReqBody(
        val writerName: String,
        val content: String
    )

    @PostMapping
    fun write(
        @PathVariable chatRoomId: Int,
        @RequestBody reqBody: ChatMessageWriteReqBody
    ): ChatMessage {
        val chatMessages = chatMessagesByRoomId.getOrPut(chatRoomId) { mutableListOf() }

        val chatMessage = ChatMessage(
            ++lastChatMessageId,
            LocalDateTime.now(),
            LocalDateTime.now(),
            chatRoomId,
            reqBody.writerName,
            reqBody.content
        )

        chatMessages.add(chatMessage)

        return chatMessage
    }
}