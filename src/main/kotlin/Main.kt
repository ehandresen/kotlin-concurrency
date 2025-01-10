package org.example

import kotlinx.coroutines.delay

suspend fun main() {
    println("Fetching news...")
    delay(1000)
    println("NEWS")
}