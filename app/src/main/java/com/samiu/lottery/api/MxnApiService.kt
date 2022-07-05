package com.samiu.lottery.api

import com.samiu.lottery.data.entiry.AimDto
import com.samiu.lottery.data.entiry.LotResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author samiu 2022/7/4
 * @email samiuzhong@outlook.com
 */
interface MxnApiService {

    @GET("lottery/common/aim_lottery")
    suspend fun queryAimLottery(
        @Query("expect") expect: String,    //彩票期号
        @Query("code") code: String,        //彩票种类标识
        @Query("app_id") appId: String = APP_ID,
        @Query("app_secret") appSecret: String = APP_SECRET
    ): LotResponse<AimDto>

    companion object {
        private const val BASE_URL = "https://www.mxnzp.com/api/"
        private const val APP_ID = "qogssimiufejqimp"
        private const val APP_SECRET = "Ung2VHE5eG5kc0NVNEx4bUtNZTNaQT09"

        fun create(): MxnApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MxnApiService::class.java)
        }
    }
}