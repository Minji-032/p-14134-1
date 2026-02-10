package com.back.domain.chat.chatRoom.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/chat/rooms")
class ApiV1ChatRoomController {
    @GetMapping
    fun getItems() = listOf("room1", "room2", "room3")
}