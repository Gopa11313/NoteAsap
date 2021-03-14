package com.example.noteasap

import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Notes
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
        val expectedResult = false
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

    @Test
    fun getme() = runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        if (response.success == true) {
            val actualResult = repository.getme(ServiceBuilder.id!!).success
            Assert.assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun updateUser() = runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val actualResult = repository.updateUser(User(_id=ServiceBuilder.id!!,name = "Gopal Thapa",email = "gopal@gmail.com",password = "gopal123")).success
        Assert.assertEquals(expectedResult, actualResult)
    }

    //---------------NoteApi--------------//
    @Test
    fun uploadnote()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=NoteRepository()
        val actualResult=repo.uploadnotes(Notes(userId = ServiceBuilder.id!!,level = "testing",subject = "testing",c_name = "testing",file = "nofile",topic = "testing",description = "testing")).success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun getAllNotes()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=NoteRepository()
        val actualResult=repo.getAllNote().success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun getAllbookmarkedNotes()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = false
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=NoteRepository()
        val actualResult=repo.getAllbookmarkedNotes("6034cf1a6857a9b7c859990a").success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun rateNote()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=NoteRepository()
        val actualResult=repo.RateNote(id = "6034cf1a6857a9b7c859990a",noofRating = "3",ratting = "4").success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun getOwnNotes()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=NoteRepository()
        val actualResult=repo.getOwnNotes(ServiceBuilder.id!!).success
        Assert.assertEquals(expectedResult, actualResult)
    }

    //----------------BookMarkApi--------------//
    @Test
    fun getAllBookMarkedNotes()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=BookmarkRepository()
        val actualResult=repo.getallbookmarkedNotes(ServiceBuilder.id!!).success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun bookmarkTheNote()= runBlocking {
        val user = User(email = "gopal@gmail.com", password = "gopal123")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUSer(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=BookmarkRepository()
        val actualResult=repo.BookamarkNote(Bookmark(userId = ServiceBuilder.id!!,noteId = "604e2a5a85f36912e44bddc8")).success
        Assert.assertEquals(expectedResult, actualResult)
    }
}
// -----------------------------Student Testing-----------------------------
//@Test
//fun addStudent() = runBlocking {
//    userRepository = UserRepository()
//    val student =
//        Student(fullname = "fullName", age = 33, gender = "gender", address = "address")
//    studentRepository = StudentRepository()
//    ServiceBuilder.token ="Bearer " + userRepository.checkUser("kiran","kiran123").token
//    val expectedResult = true
//    val actualResult = studentRepository.insertStudent(student).success
//    Assert.assertEquals(expectedResult, actualResult)
//}
//}