package com.logistics.ur.engine

import java.time.LocalDateTime
import java.time.Duration

class LiveTimeEngine {
    fun calculateClassStatus(currentClass: UniClass, nextClass: UniClass?): ClassStatus {
        val now = LocalDateTime.now()
        return ClassStatus(
            timeLeftMinutes = 45,
            breakDurationMinutes = 15,
            nextSubject = nextClass?.subjectName
        )
    }
}

data class ClassStatus(val timeLeftMinutes: Int, val breakDurationMinutes: Int, val nextSubject: String?)
