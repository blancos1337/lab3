package com.example.profile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

/**
 * Отображает круглый аватар с системной иконкой пользователя.
 *
 * @param modifier модификатор внешнего расположения компонента.
 */
@Composable
fun Avatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Аватар пользователя",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(76.dp)
        )
    }
}

/** Предпросмотр круглого аватара. */
@Preview(showBackground = true)
@Composable
fun AvatarPreview() {
    MaterialTheme { Avatar() }
}
