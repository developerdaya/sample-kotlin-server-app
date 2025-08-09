package com.example.student.demo

import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

data class Student(
    val id: Long,
    var name: String,
    var email: String
)

@RestController
@RequestMapping("/student")
class StudentController {

    // Auto-increment ID generator
    private val idCounter = AtomicLong(1)

    // In-memory student list
    private val students = mutableListOf<Student>(
        Student(idCounter.getAndIncrement(), "Aarav Sharma", "aarav.sharma@example.com"),
        Student(idCounter.getAndIncrement(), "Isha Verma", "isha.verma@example.com")
    )

    // 🔹 CREATE - Add a new student
    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        val newStudent = student.copy(id = idCounter.getAndIncrement())
        students.add(newStudent)
        return newStudent
    }

    // 🔹 READ - Get all students
    @GetMapping
    fun getAllStudents(): List<Student> {
        return students
    }

    // 🔹 READ - Get student by ID
    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): Student? {
        return students.find { it.id == id }
    }

    // 🔹 UPDATE - Update existing student
    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long,
        @RequestBody updatedStudent: Student
    ): Student? {
        val studentIndex = students.indexOfFirst { it.id == id }
        if (studentIndex != -1) {
            students[studentIndex] = students[studentIndex].copy(
                name = updatedStudent.name,
                email = updatedStudent.email
            )
            return students[studentIndex]
        }
        return null
    }

    // 🔹 DELETE - Remove student
    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): String {
        val removed = students.removeIf { it.id == id }
        return if (removed) "Student with ID $id deleted successfully"
        else "Student not found"
    }

    // Optional root message for Student API
    @GetMapping("/")
    fun studentHome(): String {
        return "Student API is working fine 🎯"
    }
}
