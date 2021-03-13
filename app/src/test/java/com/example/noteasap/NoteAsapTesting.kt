package com.example.noteasap

import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import org.junit.Assert
import org.junit.Test

class NoteAsapTesting {
    private lateinit var repository: UserRepository;

    @Test
    fun checkRegisterUSer() = runBlocking {
        val user =
            User(name = "this is test", email = "thisisemail1212@gmail.com", password = "testing12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.registerUser(user)
        val actualResult = response.success!!
        Assert.assertEquals(expectedResult, actualResult)

    }

    @Test
    fun loginUser() = runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }


    //-----------------------------Student Testing-----------------------------//
    @Test
    fun getme()= runBlocking{
        val repository=UserRepository()
        val response = repository.getme()
    }

}