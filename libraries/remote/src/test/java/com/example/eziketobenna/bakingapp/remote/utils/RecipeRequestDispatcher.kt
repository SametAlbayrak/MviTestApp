package com.example.eziketobenna.bakingapp.remote.utils

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

internal class RecipeRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            REQUEST_PATH ->
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("response/recipe_response.json"))
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}
