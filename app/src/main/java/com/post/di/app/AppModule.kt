package com.post.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/15/18.
 */
@Module
class AppModule constructor(val mApplication: Application) {

    @Provides
    @Singleton
    fun providesAppModule() : Application {
        return mApplication
    }

}