package com.example.appfortest

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NullDomain_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("test"))
    }

    @Test
    fun emailValidator_Whitespaces_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("   "))
    }

    @Test
    fun emailValidator_StartWithDot_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail(".123@mail.ru"))
    }

    @Test
    fun emailValidator_HaveManyAt_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("12@3@mail.ru"))
    }

    @Test
    fun emailValidator_HaveSpecSymbols_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("asdf&@mail.ru"))
    }

    @Test
    fun emailValidator_EndWithDot_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("asdf@mail.ru."))
    }

}