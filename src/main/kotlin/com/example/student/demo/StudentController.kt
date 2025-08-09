package com.example.student.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// Root path controller
@RestController
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "Server is working fine on Railway 🚀"
    }
}

// Student path controller
@RestController
@RequestMapping("/student")
class StudentController {

    @GetMapping
    fun getAllStudents(): List<Student> {
        return listOf(
            Student(1, "Aarav Sharma", "aarav.sharma@example.com"),
            Student(2, "Isha Verma", "isha.verma@example.com")
        )
    }

    @GetMapping("/")
    fun studentHome(): String {
        return "Student API is working fine 🎯"
    }
}

