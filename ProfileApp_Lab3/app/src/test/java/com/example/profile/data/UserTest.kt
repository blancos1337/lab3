package com.example.profile.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class UserTest {
    @Test fun defaultUserHasExpectedName() {
        val user = User()
        assertEquals("${ProfileDefaults.NAME} ${ProfileDefaults.SURNAME}", "${user.name} ${user.surname}")
    }

    @Test fun defaultFollowerCountIsPositive() {
        assertEquals(128, User().followers)
    }

    @Test fun subscriptionIsDisabledByDefault() {
        assertFalse(User().isSubscribed)
    }
}
