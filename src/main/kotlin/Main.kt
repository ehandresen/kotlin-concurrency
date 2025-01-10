package org.example

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//Coroutines
//Co -> Cooperative
//Routines -> a set of tasks, like functions
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Fetching news...")

            val newsReport = getNewsReport()
            println(newsReport)

            println("Connection closed")
        }
    }
    println("Execution time: ${time / 1000} seconds")
}

// coroutineScope ensures the execution of all child coroutines it launches.
// It suspends until all child coroutines complete and returns the result of the last line of the block.
suspend fun getNewsReport() = coroutineScope {
    val news = async { getNews() }
    val article = async { getArticle() }

    "${news.await()} ${article.await()}"
}

suspend fun getNews(): String {
    delay(2000)
    return "NEWS"
}

suspend fun getArticle(): String {
    delay(1000)
    return "Article 1"
}