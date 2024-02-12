package com.app.applicationlib.di.module


import android.content.Context
import android.content.Intent
import com.app.applicationlib.R
import com.app.applicationlib.data.repository.AuthRepository
import com.app.applicationlib.data.repository.AuthRepositorylmpl
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun providaAuthentivation():FirebaseAuth = Firebase.auth

    @Provides
    fun providesRepositoryImpl(
        firebaseAuth: FirebaseAuth): AuthRepository {
        return  AuthRepositorylmpl(firebaseAuth)
    }

//    @Provides
//    fun providesGoogleSignInOptions(@ApplicationContext context: Context): Intent {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(context.getString(R.string.web_client_id))
//            .requestEmail()
//            .build()
//        return GoogleSignIn.getClient(context, gso).signInIntent
//    }
//
//    @Provides
//    fun provideLauncher(activity: Activity): ActivityResultLauncher<Intent> {
//        return activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            val task = try {
//                val account = GoogleSignIn.getSignedInAccountFromIntent(result.data).getResult(ApiException::class.java)
//                val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
//                FirebaseAuth.getInstance().signInWithCredential(credential)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            // Handle successful sign-in
//                        }
//                    }
//            } catch (e: ApiException) {
//                Log.w("TAG", "GoogleSign in Failed", e)
//            }
//        }
//    }

}