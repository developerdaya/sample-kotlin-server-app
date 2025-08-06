package com.example.student.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/students")
class StudentController {

    @GetMapping
    fun getAllStudents(): List<Student> {
        return listOf(
            Student(1, "Aarav Sharma", "aarav.sharma@example.com"),
            Student(2, "Isha Verma", "isha.verma@example.com"),
            Student(3, "Rohan Patel", "rohan.patel@example.com"),
            Student(4, "Sneha Mehta", "sneha.mehta@example.com"),
            Student(5, "Vivaan Joshi", "vivaan.joshi@example.com"),
            Student(6, "Diya Singh", "diya.singh@example.com"),
            Student(7, "Krishna Nair", "krishna.nair@example.com"),
            Student(8, "Meera Reddy", "meera.reddy@example.com"),
            Student(9, "Aditya Gupta", "aditya.gupta@example.com"),
            Student(10, "Tanya Roy", "tanya.roy@example.com")
        )
    }

    @GetMapping("/")
    fun home(): String {
        return "Server is working fine on Railway 🚀"
    }



}
