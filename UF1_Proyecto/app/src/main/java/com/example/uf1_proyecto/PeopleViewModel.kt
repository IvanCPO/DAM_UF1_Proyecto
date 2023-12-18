package com.example.uf1_proyecto

import androidx.lifecycle.ViewModel
import com.example.uf1_proyecto.data.Datasource
import com.example.uf1_proyecto.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class PeopleViewModel : ViewModel() {
    private var users : ArrayList<Person> = Datasource.loadUsers()
    public var userUse: Person ?= Datasource.userUse
    var perc: Int = Datasource.getPercent()
    var meet: Boolean = Datasource.meet

    fun takeUser(username: String, password: String): Person?{
        userUse = Datasource.takeUser(username,password)
        return userUse
    }
    fun addUser(username: String, password: String){
        var can = true
        for (user in users)
            if (user.userName==username && user.password==password)
                can = false
        if (can) {
            users.add(Person(username,password))
            saveListUser()
        }
    }

    fun configUser(username:String,password: String){
        for (i in 0 until users.size)
            if (users[i]== userUse){
                users[i] = Person(username,password)
                userUse = users[i]
            }
        saveListUser()
        Datasource.takeUser(userUse!!.userName,userUse!!.password)
    }
    fun saveListUser(){
        Datasource.saveList(users)
    }
    fun exit(){
        Datasource.userUse = null
        userUse = null
    }
    fun setResult(maxPoints: Int, res: Int){
        perc = (100 * res).div(maxPoints)
        Datasource.setPercent(perc,meet)
    }
    fun getResult(): Int{
        return perc
    }
    fun setMeet() {
        meet=true
    }
    fun setCompatibility(){
        meet=false
    }
}