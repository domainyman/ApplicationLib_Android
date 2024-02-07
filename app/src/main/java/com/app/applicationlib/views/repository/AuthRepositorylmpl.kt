package com.app.applicationlib.views.repository

import com.app.applicationlib.views.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositorylmpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
):AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun getCurrentUser(): Flow<Resource<FirebaseUser>> {
        return flow {
            emit(Resource.Loading())
            val user = firebaseAuth.currentUser
            if (user != null) {
                emit(Resource.Success(user))
            } else {
                emit(Resource.Error("No Login"))}
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override suspend fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email,password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override suspend fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email,password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }

    override fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>> {
        return  flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithCredential(credential).await()
            emit(Resource.Success(result))
            }.catch {
                emit(Resource.Error(it.message.toString()))
            }
        }

    override fun logOutUser(){
        firebaseAuth.signOut()
    }
}

