package co.id.test_apps.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import co.id.test_apps.R
import co.id.test_apps.screens.HomeScreen
import co.id.test_apps.ui.theme.Test_appsTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test_appsTheme {
                HomeScreen()
            }
        }
    }
}