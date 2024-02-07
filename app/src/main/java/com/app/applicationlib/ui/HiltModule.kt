package com.app.applicationlib.ui


import com.app.applicationlib.views.repository.AuthRepository
import com.app.applicationlib.views.repository.AuthRepositorylmpl
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun providaAuthentivation():FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth):AuthRepository{
        return  AuthRepositorylmpl(firebaseAuth)
    }
}