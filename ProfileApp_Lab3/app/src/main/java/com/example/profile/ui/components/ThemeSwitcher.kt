package com.example.profile.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Переключатель светлого и тёмного оформления. */
@Composable
fun ThemeSwitcher(darkTheme: Boolean, onThemeChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(if (darkTheme) "Тёмная" else "Светлая")
        Spacer(Modifier.width(8.dp))
        Switch(checked = darkTheme, onCheckedChange = onThemeChange)
    }
}
