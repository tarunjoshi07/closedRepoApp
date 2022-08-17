package com.example.closedgithubpullrequestsapp.di

import com.example.closedgithubpullrequestsapp.model.PullRequestApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModule {

    private val BASE_URL = "https://api.github.com/"

    @Provides
    fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePulRequestApiInterface(retrofit: Retrofit):PullRequestApiInterface{
        return retrofit.create(PullRequestApiInterface::class.java)
    }
}