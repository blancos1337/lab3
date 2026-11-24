package com.example.profile.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.profile.data.User
import com.example.profile.ui.components.ActionButtons
import com.example.profile.ui.components.Avatar
import com.example.profile.ui.components.CounterCard
import com.example.profile.ui.components.NameEditor
import com.example.profile.ui.components.ProfileInfo
import com.example.profile.ui.components.ProfileTopBar
import com.example.profile.util.NameFormatter

/**
 * Основной экран профиля с редактированием имени и интерактивными элементами.
 *
 * @param darkTheme признак включённой тёмной темы.
 * @param onThemeChange callback изменения темы приложения.
 * @param user исходные данные профиля.
 * @param modifier модификатор внешнего расположения экрана.
 */
@Composable
fun ProfileScreen(
    darkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    user: User = User(),
    modifier: Modifier = Modifier
) {
    var isSubscribed by remember { mutableStateOf(user.isSubscribed) }
    var followers by remember { mutableIntStateOf(user.followers) }
    var clickCount by remember { mutableIntStateOf(0) }
    val defaultName = NameFormatter.fullName(user.name, user.surname)
    var editedName by remember { mutableStateOf(defaultName) }

    val buttonColor by animateColorAsState(
        targetValue = if (isSubscribed) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.primary,
        label = "subscriptionColor"
    )
    val buttonScale by animateFloatAsState(
        targetValue = if (isSubscribed) 1.04f else 1f,
        label = "subscriptionScale"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 22.dp, vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileTopBar(darkTheme = darkTheme, onThemeChange = onThemeChange)
        Avatar()
        ProfileInfo(
            user = user.copy(followers = followers),
            displayName = editedName
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.outlineVariant
        )

        NameEditor(value = editedName, onValueChange = { editedName = it })

        ActionButtons(
            isSubscribed = isSubscribed,
            onSubscribeClick = {
                isSubscribed = !isSubscribed
                followers = (followers + if (isSubscribed) 1 else -1).coerceAtLeast(0)
            },
            onResetClick = { editedName = defaultName },
            buttonColor = buttonColor,
            buttonScale = buttonScale
        )

        CounterCard(count = clickCount, onIncrement = { clickCount++ })
    }
}

/** Предпросмотр основного экрана профиля. */
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(darkTheme = false, onThemeChange = {})
    }
}
