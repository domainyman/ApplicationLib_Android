package com.app.applicationlib.data.repository

import com.app.applicationlib.di.resource.Resource
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun getCurrentUser():Flow<Resource<FirebaseUser>>
    suspend fun loginUser(email:String,password:String):Flow<Resource<AuthResult>>
    suspend fun registerUser(email:String,password:String):Flow<Resource<AuthResult>>
    suspend fun firebaseSignInWithGoogle(credential:AuthCredential):Flow<Resource<AuthResult>>
    fun logOutUser()

}