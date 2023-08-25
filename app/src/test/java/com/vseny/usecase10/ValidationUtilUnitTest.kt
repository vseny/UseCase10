package com.vseny.usecase10

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidationUtilUnitTest {

    @Test
    fun validationTrue_minCharsAmount_withoutMaxSize() {
        assertTrue(ValidationUtil.validate("Qw1!"))
    }

    @Test
    fun validationTrue_minCharsCase_withMaxSize() {
        assertTrue(ValidationUtil.validate("Qw1!", 6))
    }

    @Test
    fun validationTrue_bigCharsAmount() {
        assertTrue(ValidationUtil.validate("ww2wQw1!QS$", 20))
    }

    @Test
    fun validationTrue_specialSymbols() {
        assertTrue(ValidationUtil.validate("Qw1![]{}\\", 10))
    }

    @Test
    fun validationTrue_minCharsLimit() {
        assertTrue(ValidationUtil.validate("Qw1!", 4))
    }

    @Test
    fun validationTrue_withDots() {
        assertTrue(ValidationUtil.validate("Q.w1!"))
    }

    @Test
    fun validationFalse_charsCountAboveLimit() {
        assertFalse(ValidationUtil.validate("Qw1!5", 4))
    }

    @Test
    fun validationFalse_tooSmallLimit() {
        assertFalse(ValidationUtil.validate("Qw1!", 2))
    }

    @Test
    fun validationFalse_withoutSpecialChars() {
        assertFalse(ValidationUtil.validate("Qw1"))
    }

    @Test
    fun validationFalse_withSpaces() {
        assertFalse(ValidationUtil.validate("Q w1!"))
    }

    @Test
    fun validationFalse_withNewLines() {
        assertFalse(ValidationUtil.validate("Qw${System.lineSeparator()}1!"))
    }
}
