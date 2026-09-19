package com.example

import com.example.data.CourseRepository
import com.example.data.FaqRepository
import com.example.data.FreeLearningRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
  @Test
  fun testCoursesIntegrity() {
    val courses = CourseRepository.courses
    assertEquals(7, courses.size)

    val expectedCourseIds = listOf(
      "cyber_security",
      "ethical_hacking",
      "web_development",
      "python",
      "linux",
      "networking",
      "database"
    )

    for (id in expectedCourseIds) {
      val course = CourseRepository.getCourseById(id)
      assertNotNull("Course $id should exist", course)
      assertTrue("Course $id should have modules", course!!.modules.isNotEmpty())
      assertTrue("Course $id should have learning outcomes", course.learningOutcomes.isNotEmpty())
      assertTrue("Course $id should have requirements", course.requirements.isNotEmpty())
    }
  }

  @Test
  fun testFaqRepository() {
    val faqs = FaqRepository.faqs
    assertEquals(10, faqs.size)
    assertTrue(faqs.any { it.question.contains("TWH ORG") })
  }

  @Test
  fun testFreeLearningRepository() {
    val categories = FreeLearningRepository.categories
    assertEquals(7, categories.size)
    categories.forEach { cat ->
      assertTrue(cat.lessons.isNotEmpty())
    }
  }
}

