package com.example.profile.util

import org.junit.Assert.assertEquals
import org.junit.Test

class NameFormatterTest {
    @Test fun trimsLeadingAndTrailingSpaces() {
        assertEquals("Денис", NameFormatter.normalize("  Денис  "))
    }

    @Test fun collapsesRepeatedSpaces() {
        assertEquals("Денис Черемисов", NameFormatter.normalize("Денис    Черемисов"))
    }

    @Test fun combinesNameAndSurname() {
        assertEquals("Денис Черемисов", NameFormatter.fullName("Денис", "Черемисов"))
    }
}
