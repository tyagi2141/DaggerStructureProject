package com.example.daggerproject

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.daggerproject.data.network.Routes
import com.example.daggerproject.echomodel.EchoRequestModel
import com.example.daggerproject.preferences.AuthSharedPreferences
import dagger.android.support.DaggerAppCompatActivity
import me.ebraheem.restaurants.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var auth_prefs: AuthSharedPreferences

    @Inject
    lateinit var routes: Routes

    private lateinit var viewModel: MainActivityViewModel


    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel =
            ViewModelProviders.of(this, providerFactory).get(MainActivityViewModel::class.java)

        //auth_prefs.putRefreshToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoicmVmcmVzaCIsImV4cCI6MTU4MzkzMDU5MywianRpIjoiYzE1YjQyMDg0YWViNDg4Zjg1M2I5OGU5MGUzMWVjOTMiLCJ1c2VyX2lkIjoyLCJwaG9uZSI6Ijk5MzA1ODY1MTkiLCJpc19hY3RpdmUiOnRydWUsImVtYWlsIjpudWxsLCJyb2xlIjoiIiwiZm5hbWUiOiIiLCJsbmFtZSI6IiIsImNvdW50cnkiOiJJTkRJQSJ9.CGo8PHWTrtFyDKL9-17pY-PRtj0yBdMVAGJer22xmOg")

        //auth_prefs.putAccessToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNTgzNzU2MDY4LCJqdGkiOiJlMjU5NjFhYWNlMDk0YzIxYTE0NmQ1NmVhNjM0NGM0MyIsInVzZXJfaWQiOjIsInBob25lIjoiOTkzMDU4NjUxOSIsImlzX2FjdGl2ZSI6dHJ1ZSwiZW1haWwiOm51bGwsInJvbGUiOiIiLCJmbmFtZSI6IiIsImxuYW1lIjoiIiwiY291bnRyeSI6IklORElBIn0.p4OKmEyklpUxZLtxijcuEsdBIrt_fMF33fZ6EbzDL")

        viewModel.echo(
            EchoRequestModel(
                message = "test",
                version = "1"
            )
        )


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
