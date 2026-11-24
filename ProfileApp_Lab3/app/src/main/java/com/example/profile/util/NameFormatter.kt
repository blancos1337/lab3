package com.example.profile.util

/** Вспомогательные операции для отображаемого имени пользователя. */
object NameFormatter {
    /** Убирает лишние пробелы по краям и повторяющиеся пробелы внутри строки. */
    fun normalize(value: String): String = value.trim().replace(Regex("\\s+"), " ")

    /** Возвращает имя по умолчанию, объединяя имя и фамилию. */
    fun fullName(name: String, surname: String): String = normalize("$name $surname")
}
