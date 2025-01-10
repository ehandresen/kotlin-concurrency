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

            val news: Deferred<String> = async {
                getNews()
            }

            val article: Deferred<String> = async {
                getArticle()
            }

            println("${news.await()} ${article.await()}")

            println("Connection closed")
        }
    }
    println("Execution time: ${time / 1000} seconds")
}

suspend fun getNews(): String {
    delay(2000)
    return "NEWS"
}

suspend fun getArticle(): String {
    delay(1000)
    return "Article 1"
}