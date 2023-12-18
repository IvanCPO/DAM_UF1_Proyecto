package com.example.uf1_proyecto.data

import android.content.Context
import com.example.uf1_proyecto.PeopleViewModel
import com.example.uf1_proyecto.R

class Datasource (private val context: Context) {
    val resources = context.resources
    fun loadQuestionsCompatibility(): List<Question> {
        return listOf<Question>(
            ButtonQuest(resources.getString(R.string.pregunta_serie_tv), resources.getStringArray(R.array.opciones_serie_tv).toList(), 3),
            LineQuest(resources.getString(R.string.pregunta_kotlin), 9, 6),
            ButtonQuest(resources.getString(R.string.pregunta_musica_romantica), resources.getStringArray(R.array.opciones_musica_romantica).toList(), 0),
            LineQuest(resources.getString(R.string.pregunta_extroversion), 4, 2),
            ButtonQuest(resources.getString(R.string.pregunta_postre), resources.getStringArray(R.array.opciones_postre).toList(), 2),
            ButtonQuest(resources.getString(R.string.pregunta_videojuego), resources.getStringArray(R.array.opciones_videojuego).toList(), 3),
            ButtonQuest(resources.getString(R.string.pregunta_mensajes), resources.getStringArray(R.array.opciones_mensajes).toList(), 1),
            LineQuest(resources.getString(R.string.pregunta_organizacion), 4, 2),
            ButtonQuest(resources.getString(R.string.pregunta_pelicula_romantica), resources.getStringArray(R.array.opciones_pelicula_romantica).toList(), 1),
            ButtonQuest(resources.getString(R.string.pregunta_anime), resources.getStringArray(R.array.opciones_anime).toList(), 0),
            LineQuest(resources.getString(R.string.pregunta_redes_sociales), 9, 6),
            ButtonQuest(resources.getString(R.string.pregunta_color), resources.getStringArray(R.array.opciones_color).toList(), 1),
            LineQuest(resources.getString(R.string.pregunta_amistad), 4, 4),
            ButtonQuest(resources.getString(R.string.pregunta_pelicula_cine), resources.getStringArray(R.array.opciones_pelicula_cine).toList(), 1),
            LineQuest(resources.getString(R.string.pregunta_moda), 9, 3),
            ButtonQuest(resources.getString(R.string.pregunta_comida_rapida), resources.getStringArray(R.array.opciones_comida_rapida).toList(), 1),
            ButtonQuest(resources.getString(R.string.pregunta_actividad_aire_libre), resources.getStringArray(R.array.opciones_actividad_aire_libre).toList(), 0),
            LineQuest(resources.getString(R.string.pregunta_creatividad), 4, 3),
            ButtonQuest(resources.getString(R.string.pregunta_estacion_anio), resources.getStringArray(R.array.opciones_estacion_anio).toList(), 1),
            ButtonQuest(resources.getString(R.string.pregunta_red_social), resources.getStringArray(R.array.opciones_red_social).toList(), 2),
            LineQuest(resources.getString(R.string.pregunta_fan_rock), 9, 8),
            ButtonQuest(resources.getString(R.string.pregunta_genero_favorito), resources.getStringArray(R.array.opciones_genero_favorito).toList(), 3),
            ButtonQuest(resources.getString(R.string.pregunta_pueblo_ciudad), resources.getStringArray(R.array.opciones_pueblo_ciudad).toList(), 0),
            ButtonQuest(resources.getString(R.string.pregunta_vacaciones_verano), resources.getStringArray(R.array.opciones_vacaciones_verano).toList(), 3),
            LineQuest(resources.getString(R.string.pregunta_aventura_cocina), 9, 2),
            ButtonQuest(resources.getString(R.string.pregunta_mascotas), resources.getStringArray(R.array.opciones_mascotas).toList(), 0)
        )
    }

    fun loadQuestionsIvan(): List<Question> {
        return listOf<Question>(
            ButtonQuest(resources.getString(R.string.pregunta_casi_muerte), resources.getStringArray(R.array.opciones_casi_muerte).toList(), 0),
            ButtonQuest(resources.getString(R.string.pregunta_saludo), resources.getStringArray(R.array.opciones_saludo).toList(), 2),
            LineQuest(resources.getString(R.string.pregunta_hermanos), 5, 1),
            ButtonQuest(resources.getString(R.string.pregunta_fecha_nacimiento), resources.getStringArray(R.array.opciones_fecha_nacimiento).toList(), 2),
            ButtonQuest(resources.getString(R.string.pregunta_mascota_no_pertenecio), resources.getStringArray(R.array.opciones_mascota_no_pertenecio).toList(), 3),
            ButtonQuest(resources.getString(R.string.pregunta_serie_infancia), resources.getStringArray(R.array.opciones_serie_infancia).toList(), 0),
            ButtonQuest(resources.getString(R.string.pregunta_lugar_origen), resources.getStringArray(R.array.opciones_lugar_origen).toList(), 3),
            ButtonQuest(resources.getString(R.string.pregunta_color_favorito_2), resources.getStringArray(R.array.opciones_color_favorito_2).toList(), 3)
        )
    }
    companion object{
        var listUsers: ArrayList<Person> = ArrayList<Person>()

        public var userUse: Person ?= null
        var perc:Int = 0
        var meet:Boolean = false


        fun takeUser(username: String, password: String): Person?{
            for (user in listUsers){
                if (user.userName.equals(username))
                    if (user.password.equals(password))
                        userUse = user
            }

            return userUse
        }
        fun loadUsers():ArrayList<Person>{
            listUsers.add(Person("ivan","a"))
            listUsers.add(Person("pouso","a",R.drawable.pouso_example))
            listUsers.add(Person("maziws","a",R.drawable.the_rock))
            return listUsers
        }
        fun addUser(person : Person){
            listUsers.add(person)
        }

        fun saveList(users: ArrayList<Person>) {
            listUsers=users

        }

        fun setPercent(p: Int, m: Boolean) {
            perc = p
            meet = m
        }
        fun getPercent():Int{
            return perc
        }
    }

}