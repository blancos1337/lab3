package com.example.profile.data

/**
 * Модель данных пользователя.
 *
 * @property name имя пользователя.
 * @property surname фамилия пользователя.
 * @property status краткий статус пользователя.
 * @property followers количество подписчиков.
 * @property isSubscribed состояние подписки текущего пользователя.
 */
data class User(
    val name: String = ProfileDefaults.NAME,
    val surname: String = ProfileDefaults.SURNAME,
    val status: String = ProfileDefaults.STATUS,
    val followers: Int = ProfileDefaults.FOLLOWERS,
    val isSubscribed: Boolean = false
)
