package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//Coroutines
//Co -> Cooperative
//Routines -> a set of tasks, like functions
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Fetching news...")
            launch {
                printNews()
            }
            launch {
                printArticle()
            }

            println("Connection closed")
        }
    }
    println("Execution time: ${time / 1000} seconds")
}

suspend fun printNews() {
    delay(1000)
    println("NEWS")
}

suspend fun printArticle() {
    delay(1000)
    println("Article 1")
}