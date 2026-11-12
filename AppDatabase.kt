package com.logistics.ur.data

import androidx.room.*

@Entity(tableName = "classes")
data class UniClass(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subjectName: String,
    val targetGroup: Int, // 1, 2, 3
    val startTime: Long, 
    val endTime: Long,
    val isCanceled: Boolean = false
)

@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val classId: Int,
    val type: String, // "Kolokwium", "Egzamin", "Projekt"
    val date: Long,
    val description: String
)

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM classes WHERE targetGroup = :group ORDER BY startTime ASC")
    fun getClassesForGroup(group: Int): List<UniClass>
    
    @Insert
    fun insertExam(exam: Exam)
}
