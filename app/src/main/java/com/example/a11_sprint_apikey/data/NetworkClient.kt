package com.example.a11_sprint_apikey.data

import com.example.a11_sprint_apikey.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response

}