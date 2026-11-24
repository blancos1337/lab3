package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.profile.ui.ProfileScreen
import com.example.profile.ui.theme.ProfileTheme

/**
 * Главная Activity приложения.
 *
 * Создаёт Compose-интерфейс и хранит состояние выбранной темы.
 */
class MainActivity : ComponentActivity() {
    /**
     * Инициализирует интерфейс приложения.
     *
     * @param savedInstanceState сохранённое состояние Activity или null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            ProfileTheme(darkTheme = darkTheme) {
                ProfileScreen(
                    darkTheme = darkTheme,
                    onThemeChange = { darkTheme = it }
                )
            }
        }
    }
}
