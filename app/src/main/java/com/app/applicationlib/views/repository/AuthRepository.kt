package com.app.applicationlib.views.repository

import com.app.applicationlib.views.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun getCurrentUser():Flow<Resource<FirebaseUser>>
    suspend fun loginUser(email:String,password:String):Flow<Resource<AuthResult>>
    suspend fun registerUser(email:String,password:String):Flow<Resource<AuthResult>>
    fun googleSignIn(credential:AuthCredential):Flow<Resource<AuthResult>>
    fun logOutUser()

}