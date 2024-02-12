package com.app.applicationlib.di.user

import com.google.firebase.auth.FirebaseUser

object FirebaseUserUtils {
    lateinit var userId: String
    lateinit var display: String
    lateinit var email: String
    var emailVerified: Boolean = false
    lateinit var photoUrl: String

    fun initialize(firebaseUser: FirebaseUser) {
        userId = firebaseUser.uid
        display = firebaseUser.displayName.toString()
        email = firebaseUser.email.toString()
        emailVerified = firebaseUser.isEmailVerified
        photoUrl = firebaseUser.photoUrl.toString()
    }
}