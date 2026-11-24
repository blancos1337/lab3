package com.example.profile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.profile.data.User

/**
 * Показывает имя, статус и число подписчиков пользователя.
 *
 * @param user данные отображаемого пользователя.
 * @param displayName имя для показа, включая возможные изменения из поля ввода.
 * @param modifier модификатор внешнего расположения компонента.
 */
@Composable
fun ProfileInfo(
    user: User,
    displayName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = displayName,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = user.status,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Подписчиков: ${user.followers}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/** Предпросмотр блока информации о пользователе. */
@Preview(showBackground = true)
@Composable
fun ProfileInfoPreview() {
    MaterialTheme {
        ProfileInfo(user = User(), displayName = "Денис Черемисов")
    }
}
