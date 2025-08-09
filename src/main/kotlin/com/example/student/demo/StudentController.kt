package com.example.student.demo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController private constructor(private val studentRepository: StudentRepository) {

    // CREATE
    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        return studentRepository.save(student)
    }

    // READ all
    @GetMapping
    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    // READ one
    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): Student? {
        return studentRepository.findById(id).orElse(null)
    }

    // UPDATE
    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody updatedStudent: Student): Student? {
        val existing = studentRepository.findById(id).orElse(null) ?: return null
        existing.name = updatedStudent.name
        existing.email = updatedStudent.email
        return studentRepository.save(existing)
    }

    // DELETE
    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): String {
        return if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id)
            "Student with ID $id deleted successfully"
        } else {
            "Student not found"
        }
    }

    @GetMapping("/")
    fun studentHome(): String {
        return "🎯 Student API with MySQL is working fine"
    }
}
