package com.rich.testingexercise

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RegistrationUtilsTest{
    private lateinit var regis : RegistrationUtils

    @Before
    fun setUp(){
        regis = RegistrationUtils
    }

    @Test
    fun valid_registration(){
        val result = regis.validateRegistrationInput("Bambang","bamb@gmail.com","aAa123","aAa123")
        assertEquals(true,result)
    }

    @Test
    fun empty_username_false(){
        val result = regis.validateRegistrationInput(
            username = "",
            email = "test",
            password = "test",
            confirmedPassword = "test")
        assertEquals(result, false)
    }

    @Test
    fun empty_email_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "",
            password = "test",
            confirmedPassword = "test")
        assertEquals(result, false)
    }

    @Test
    fun empty_password_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "",
            confirmedPassword = "test")
        assertEquals(result, false)
    }

    @Test
    fun empty_confirmedPassword_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "test",
            confirmedPassword = "")
        assertEquals(result, false)
    }

    @Test
    fun empty_username_true(){
        val result = regis.validateRegistrationInput(
            username = "",
            email = "test",
            password = "test",
            confirmedPassword = "test")
        assertEquals(true,result)
    }

    @Test
    fun empty_email_true(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "",
            password = "test",
            confirmedPassword = "test")
        assertEquals(true,result)
    }

    @Test
    fun empty_password_true(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "",
            confirmedPassword = "test")
        assertEquals(true,result)
    }

    @Test
    fun empty_confirmedPassword_true(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "test",
            confirmedPassword = "")
        assertEquals(true,result)
    }

    @Test
    fun exisiting_username_false(){
        val result = regis.validateRegistrationInput(
            username = "Peter",
            email = "test",
            password = "test",
            confirmedPassword = "test")
        assertEquals(false,result)
    }

    @Test
    fun exisiting_email_false() {
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "peter@gmail.com",
            password = "test",
            confirmedPassword = "test"
        )
        assertFalse(result)
    }

    @Test
    fun password_less_than_6_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "not",
            confirmedPassword = "not")
        assertFalse(result)
    }

    @Test
    fun password_more_than_50_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "adkjfadfjapfdijapdfiajpdfiajsfoijapsdfiojadspfjadpsfjpadsf",
            confirmedPassword = "adkjfadfjapfdijapdfiajpdfiajsfoijapsdfiojadspfjadpsfjpadsf")
        assertFalse(result)
    }

    @Test
    fun password_not_contain_uppercase_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "aaaaaaa",
            confirmedPassword = "aaaaa")
        assertFalse(result)
    }

    @Test
    fun password_not_contain_lowercase_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "AAAAAAA",
            confirmedPassword = "AAAAAAA")
        assertFalse(result)
    }

    @Test
    fun password_digit_less_than_2_false(){
        val result = regis.validateRegistrationInput(
            username = "test",
            email = "test",
            password = "aaa1",
            confirmedPassword = "aaa1")
        assertFalse(result)
    }
}