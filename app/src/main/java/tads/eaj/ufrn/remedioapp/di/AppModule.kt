package tads.eaj.ufrn.remedioapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tads.eaj.ufrn.remedioapp.dao.RemedioDao
import tads.eaj.ufrn.remedioapp.database.AppDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getDatabase(applicationContext:Application):AppDatabase{
        return AppDatabase.invoke(applicationContext)
    }

    @Singleton
    @Provides
    fun getDao(database:AppDatabase):RemedioDao{
        return database.remedioDao()
    }
}