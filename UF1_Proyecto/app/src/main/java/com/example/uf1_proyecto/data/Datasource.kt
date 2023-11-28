package com.example.uf1_proyecto.data

class Datasource {
    fun loadQuestionsCompatibility(): List<Question> {
        return listOf<Question>(
            ButtonQuest("¿Cuál es tu preferencia en cuanto a género?", listOf("Masculino", "Femenino", "No binario", "Prefiero no decirlo")),
            ButtonQuest("¿Cómo describirías tu orientación sexual?", listOf("Heterosexual", "Homosexual", "Bisexual", "Pansexual", "Prefiero no decirlo")),
            LineQuest("En una escala de 1 a 10, ¿cómo describirías tu nivel de comodidad al hablar abiertamente sobre sexualidad?", 10),
            LineQuest("¿Cuál es tu experiencia sexual más positiva o memorable hasta ahora?", 5),
            ButtonQuest("¿Practicas algún tipo de protección sexual?", listOf("Sí, siempre", "A veces", "No", "Prefiero no decirlo")),
            ButtonQuest("¿Consideras importante la comunicación abierta sobre preferencias y límites sexuales en una relación?", listOf("Sí", "No", "Depende de la relación")),
            LineQuest("¿Cuál es tu opinión sobre la educación sexual en la sociedad?", 10),
            ButtonQuest("¿Has experimentado algún tipo de discriminación o estigma relacionado con tu identidad de género u orientación sexual?", listOf("Sí", "No", "Prefiero no decirlo")),
            ButtonQuest("¿Qué opinas sobre la diversidad de expresiones de género en la sociedad?", listOf("Es positiva", "No tengo una opinión", "Podría mejorar", "Prefiero no decirlo")),
            LineQuest("Describe brevemente cómo te gustaría que fuera tu vida sexual ideal.", 5),
            ButtonQuest("¿Cómo defines la intimidad emocional en una relación?", listOf("Compartir sentimientos profundos", "Compartir secretos", "Conexión emocional y física", "Prefiero no decirlo")),
            ButtonQuest("En tu opinión, ¿cuál es la importancia de la comunicación sexual en una relación?", listOf("Muy importante", "Importante", "Menos importante", "Prefiero no decirlo")),
            LineQuest("¿Cómo manejas la presión social o cultural en relación con tu vida sexual?", 10),
            ButtonQuest("¿Consideras que la educación sexual debería incluir información sobre diversidad de orientaciones y identidades sexuales?", listOf("Sí", "No", "No estoy seguro", "Prefiero no decirlo")),
            ButtonQuest("¿Qué importancia le das al consentimiento en tus relaciones sexuales?", listOf("Muy importante", "Importante", "Menos importante", "Prefiero no decirlo")),
            LineQuest("¿Cómo influyen tus experiencias pasadas en tu vida sexual presente?", 5),
            ButtonQuest("¿Qué opinas sobre la representación de la sexualidad en los medios de comunicación?", listOf("Demasiado exagerada", "Apropiada", "Insuficiente", "Prefiero no decirlo")),
            ButtonQuest("¿Has participado alguna vez en actividades relacionadas con la comunidad LGBTQ+?", listOf("Sí", "No", "No estoy seguro", "Prefiero no decirlo")),
            LineQuest("¿Qué desafíos crees que enfrenta la comunidad LGBTQ+ en relación con la aceptación y la igualdad?", 10),
            ButtonQuest("¿Cómo te sientes acerca de la monogamia en las relaciones?", listOf("A favor", "En contra", "Depende de la persona", "Prefiero no decirlo")),
            LineQuest("En tu opinión, ¿cuál es la clave para una buena comunicación sexual?", 5)
        )
    }

}