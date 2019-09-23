package io.cro.android.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HttpHeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder().apply {
            // add your http headers
            addHeader(Headers.ACCEPT.key, Headers.ACCEPT.value)
        }

        return chain.proceed(requestBuilder.build())
    }

    private companion object {
        enum class Headers(val key: String, val value: String) {
            // add your header key and value type
            ACCEPT("Accept", "application/vnd.github.v3+json");
        }
    }
}
