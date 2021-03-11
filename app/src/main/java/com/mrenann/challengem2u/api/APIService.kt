package com.mrenann.challengem2u.api

import com.mrenann.challengem2u.utils.Constants.Api.API_AUTH_NAME
import com.mrenann.challengem2u.utils.Constants.Api.API_AUTH_VALUE
import com.mrenann.challengem2u.utils.Constants.Api.API_CONTENT_TYPE_NAME
import com.mrenann.challengem2u.utils.Constants.Api.API_CONTENT_TYPE_VALUE
import com.mrenann.challengem2u.utils.Constants.Api.BASE_URL_v3
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_APPEND_LABEL
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_APPEND_VALUE
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_LANGUAGE_LABEL
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_LANGUAGE_VALUE
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_REGION_LABEL
import com.mrenann.challengem2u.utils.Constants.Api.QUERY_PARAM_REGION_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIService {

    val tmdbApiMovieDetailed: TmdbAPI= getTMDbApiClientMovieDetailed().create(TmdbAPI::class.java)

    private fun getTMDbApiClientMovieDetailed(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_v3)
            .client(getInterceptorClientMovieDetailed())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClientMovieDetailed(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(API_AUTH_NAME, API_AUTH_VALUE)
                    .addHeader(API_CONTENT_TYPE_NAME, API_CONTENT_TYPE_VALUE)
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor { chain ->
                val url = chain.request().url.newBuilder()
                    .addQueryParameter(QUERY_PARAM_LANGUAGE_LABEL, QUERY_PARAM_LANGUAGE_VALUE)
                    .addQueryParameter(QUERY_PARAM_APPEND_LABEL, QUERY_PARAM_APPEND_VALUE)
                    .addQueryParameter(QUERY_PARAM_REGION_LABEL, QUERY_PARAM_REGION_VALUE)

                    .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }

}