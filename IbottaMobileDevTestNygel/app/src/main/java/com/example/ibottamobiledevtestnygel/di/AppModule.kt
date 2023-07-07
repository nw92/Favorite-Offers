package com.example.ibottamobiledevtestnygel.di

import android.content.Context
import androidx.room.Room
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.BASE_URL
import com.example.ibottamobiledevtestnygel.core.Constants.Companion.OFFER_TABLE
import com.example.ibottamobiledevtestnygel.data.database.OfferDatabase
import com.example.ibottamobiledevtestnygel.data.network.NetworkInterceptor
import com.example.ibottamobiledevtestnygel.data.network.OfferApi
import com.example.ibottamobiledevtestnygel.data.repository.OfferRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOfferDatabase(
        @ApplicationContext
        appContext: Context
    ) = Room.databaseBuilder(
        context = appContext,
        klass = OfferDatabase::class.java,
        name = OFFER_TABLE
    ).build()

    @Provides
    @Singleton
    fun provideDao(offerDatabase: OfferDatabase) = offerDatabase.offerDao

    @Provides
    @Singleton
    fun provideOfferRepository(offerDatabase: OfferDatabase, offerApi: OfferApi): OfferRepository {
        return OfferRepository(offerDatabase, offerApi)
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(
        converterFactory: MoshiConverterFactory,
        @ApplicationContext
        context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(interceptorOfferApi(context)) // Using an interceptor to provide a mock response
            .baseUrl(BASE_URL) // Using a fake url for development
            .build()
    }

    @Provides
    @Singleton
    fun provideOfferApi(retrofit: Retrofit): OfferApi {
        return retrofit.create(OfferApi::class.java)
    }

    @Provides
    @Singleton
    fun interceptorOfferApi(context: Context): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(NetworkInterceptor(context))
            .build()
    }

}