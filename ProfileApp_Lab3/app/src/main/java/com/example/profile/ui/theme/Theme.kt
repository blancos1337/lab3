package com.example.profile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

private val LightColors = lightColorScheme(
    primary = Color(0xFF315DA8),
    secondary = Color(0xFF52647F),
    background = Color(0xFFF8F9FF),
    surface = Color(0xFFF8F9FF)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFAAC7FF),
    secondary = Color(0xFFBBC7DF)
)

/**
 * Применяет светлую или тёмную цветовую схему приложения.
 *
 * @param darkTheme true для тёмной темы, false для светлой.
 * @param content содержимое интерфейса внутри темы.
 */
@Composable
fun ProfileTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = MaterialTheme.typography,
        content = content
    )
}


/** Предпросмотр содержимого в светлой теме. */
@Preview(showBackground = true)
@Composable
fun ProfileThemePreview() {
    ProfileTheme(darkTheme = false) {
        Text("Предпросмотр цветовой темы")
    }
}
