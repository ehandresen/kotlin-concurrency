package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Fetching news...")
            printNews()
            printArticle()
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