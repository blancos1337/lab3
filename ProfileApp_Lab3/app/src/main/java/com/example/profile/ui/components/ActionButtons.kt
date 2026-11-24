package com.example.profile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

/**
 * Набор основных кнопок управления профилем.
 *
 * @param isSubscribed текущее состояние подписки.
 * @param onSubscribeClick обработчик нажатия на кнопку подписки.
 * @param onResetClick обработчик сброса имени.
 * @param modifier модификатор внешнего расположения компонента.
 * @param buttonColor цвет кнопки подписки.
 * @param buttonScale коэффициент масштаба кнопки подписки для анимации.
 */
@Composable
fun ActionButtons(
    isSubscribed: Boolean,
    onSubscribeClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color? = null,
    buttonScale: Float = 1f
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onSubscribeClick,
            modifier = Modifier.graphicsLayer {
                scaleX = buttonScale
                scaleY = buttonScale
            },
            colors = if (buttonColor != null) {
                ButtonDefaults.buttonColors(containerColor = buttonColor)
            } else {
                ButtonDefaults.buttonColors()
            }
        ) {
            Text(if (isSubscribed) "Отписаться" else "Подписаться")
        }
        OutlinedButton(onClick = onResetClick) {
            Text("Сбросить")
        }
    }
}

/** Предпросмотр кнопок действий. */
@Preview(showBackground = true)
@Composable
fun ActionButtonsPreview() {
    androidx.compose.material3.MaterialTheme {
        ActionButtons(false, {}, {})
    }
}
