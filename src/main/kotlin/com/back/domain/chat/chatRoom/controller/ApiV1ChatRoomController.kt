package com.back.domain.chat.chatRoom.controller

import com.back.domain.chat.chatRoom.entity.ChatRoom
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/chat/rooms")
class ApiV1ChatRoomController {
    val chatRooms: MutableList<ChatRoom> = mutableListOf(
        ChatRoom(
            1,
            LocalDateTime.now(),
            LocalDateTime.now(),
            "풋살하실 분?"
        ),
        ChatRoom(
            2,
            LocalDateTime.now(),
            LocalDateTime.now(),
            "농구 하실 분?"
        ),
        ChatRoom(
            3,
            LocalDateTime.now(),
            LocalDateTime.now(),
            "야구 하실 분?"
        )
    )

    @GetMapping
    fun getItems() = chatRooms

    
}