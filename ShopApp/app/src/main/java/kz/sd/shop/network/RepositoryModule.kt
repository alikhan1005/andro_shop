package kz.sd.shop.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepositoryModule(api: AmazonApi): AmazonRepository {
        return AmazonRepositoryImpl(api)
    }
}
