package com.example.uf1_proyecto.data

class Datasource {
    fun loadQuestionsCompatibility(): List<Question> {
        return listOf<Question>(
            ButtonQuest("¿Cuál es tu saga de televisión favorita?", listOf("Star Wars", "Torrente", "Fast & Furious", "Dragon Ball"), 3),
            LineQuest("En una escala del 1 al 10, ¿qué tan cómodo te sientes programando en Kotlin?", 9, 6),
            ButtonQuest("¿Qué tipo de música te gusta para una cita romántica?", listOf("Baladas", "Pop romántico", "R&B suave", "Indie acústico"), 0),
            LineQuest("En una escala del 1 al 5, ¿qué tan extrovertido/a te consideras en tu grupo de amigos?", 4, 2),
            ButtonQuest("¿Cuál es tu postre favorito?", listOf("Pastel de chocolate", "Helado", "Frutas frescas", "Tiramisú"), 2),
            ButtonQuest("¿Cuál es tu videojuego preferido?", listOf("Pokemon", "Minecraft", "GTA", "The Legend Of Zelda"), 3),
            ButtonQuest("¿Prefieres mensajes de texto o llamadas?", listOf("Mensajes de texto", "Llamadas"), 1),
            LineQuest("En una escala del 1 al 5, ¿qué tan organizado/a eres con tus estudios?", 4, 2),
            ButtonQuest("¿Cuál es tu película romántica favorita?", listOf("Titanic", "Nothing Hill", "Aladin", "La La Land"), 1),
            ButtonQuest("¿Cuál es tu anime favorito?", listOf("Dragon Ball", "Doraemon", "ShinChan", "Death Note"), 0),
            LineQuest("En una escala del 1 al 10, ¿qué tan aficionado/a eres a las redes sociales?", 9, 6),
            ButtonQuest("¿Cuál es tu color favorito?", listOf("Azul", "Rojo", "Verde", "Rosa"), 1),
            LineQuest("En una escala del 1 al 5, ¿qué tan importante es la amistad para ti?", 4, 4),
            ButtonQuest("¿Prefieres ver películas en el cine o en casa?", listOf("Cine", "En casa"), 1),
            LineQuest("En una escala del 1 al 10, ¿qué tan interesado/a estás en la moda?", 9, 3),
            ButtonQuest("¿Cuál es tu comida rápida favorita?", listOf("Pizza", "Hamburguesas", "Tacos", "Sushi"), 1),
            ButtonQuest("¿Cuál es tu actividad al aire libre favorita?", listOf("Senderismo", "Picnic en el parque", "Bicicleta", "Jugar al fútbol"), 0),
            LineQuest("En una escala del 1 al 5, ¿qué tan creativo/a te consideras?", 4, 3),
            ButtonQuest("¿Que estación del año es tu favorita?", listOf("Invierno","Primavera","Verano","Otoño"), 1),
            ButtonQuest("¿Cuál es tu red social favorita?", listOf("Instagram", "BeReal", "TikTok", "Twitter"), 0),
            LineQuest("En una escala del 1 al 10, ¿como de fan eres de Dwayne Douglas Johnson, \"The Rock\"?", 9, 8),
            ButtonQuest("¿Cuál es tu género favorito en general(peliculas/series/Libros)?", listOf("Acción", "Fantasía", "Aventuras", "Misterio"), 3),
            ButtonQuest("¿Que prefieres, el pueblo(muy natural) o la ciudad?", listOf("Pueblo", "Ciudad"), 0),
            ButtonQuest("¿Cuál es tu lugar ideal para pasar las vacaciones de verano?", listOf("Playa tropical", "Montañas", "Ciudad animada", "Rios de Montaña"), 3),
            LineQuest("En una escala del 1 al 10, ¿qué tan aventurero/a eres en la cocina?", 9, 2),
            ButtonQuest("¿Eres más de gatos o perros?", listOf("Gatos", "Perros"), 0)
        )
    }

    fun loadQuestionsIvan(): List<Question> {
        return listOf<Question>(
            ButtonQuest("¿Que hizo que casi muriera muy joven?", listOf("Atragantandose comiendo unos Chasquis", "Tirarse de un lugar muy alto de cabeza", "Tanto la primera como la segunda son correctas", "Que tonterias, nunca le paso nada"),0),
            ButtonQuest("¿Como saluda a todo el mundo?", listOf("No saluda, eso lo considera de debiles", "Dice buenos dias o buenas tardes, dependiendo del momento del dia", "Grita ¡Bueeeeeeeeeeeenas! De una forma que se considera muy exagerada", "Dice chao (se cree italiano)"),2),
            LineQuest("¿Cuantos herman@s tiene?(0-5)", 5,1)
        )
    }

}