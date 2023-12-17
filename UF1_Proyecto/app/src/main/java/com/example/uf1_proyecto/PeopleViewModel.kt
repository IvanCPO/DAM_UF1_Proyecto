package com.example.uf1_proyecto

import androidx.lifecycle.ViewModel
import com.example.uf1_proyecto.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class PeopleViewModel : ViewModel() {
    companion object {
        private var users : ArrayList<Person> = ArrayList()
        private const val NOMBRE_ARCHIVO_JSON = "usuarios.json"
        public var userUse: Person ?= null

        fun saveListPeopleJson() {
            try {
                if (!File("data", NOMBRE_ARCHIVO_JSON).exists())
                    File("data", NOMBRE_ARCHIVO_JSON).createNewFile()
                val archivo = File("data", NOMBRE_ARCHIVO_JSON)
                val gson = Gson()
                val json = gson.toJson(users)
                archivo.writeText(json)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun loadListPeopleJson(): List<Person>? {
            try {
                val archivo = File("data", NOMBRE_ARCHIVO_JSON)
                val gson = Gson()
                val json = archivo.readText()
                val tipoListaUsuarios = object : TypeToken<List<Person>>() {}.type
                users = gson.fromJson(json, tipoListaUsuarios)

                return users
            } catch (e: Exception) {
                users.add(Person("ivan","a"))
                users.add(Person("angel","a"))
                users.add(Person("pouso","a"))
                users.add(Person("mateiño","a",R.drawable.the_rock))
                saveListPeopleJson()
                return emptyList()
            }
        }
        fun takeUser(username: String, password: String): Person?{
            for (user in users){
                if (user.userName.equals(username))
                    if (user.password.equals(password))
                        userUse = user
            }

            return userUse
        }
        fun addUser(username: String, password: String){
            var p: Person = Person(username, password)
            users.add(p)
            userUse = p
        }

        fun configUser(username:String,password: String){
            for (i in 0 until users.size)
                if (users[i]== userUse){
                    users[i] = Person(username,password)
                    userUse = users[i]
                }

        }
        fun exit(){
            userUse = null
            saveListPeopleJson()
        }
    }
}