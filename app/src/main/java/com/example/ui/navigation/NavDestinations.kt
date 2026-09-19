package com.example.ui.navigation

object NavDestinations {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val ABOUT = "about"
    const val COURSES = "courses"
    const val COURSE_DETAIL = "course_detail/{courseId}"
    const val FREE_LEARNING = "free_learning"
    const val YOUTUBE = "youtube"
    const val REGISTRATION = "registration?courseId={courseId}"
    const val CONTACT = "contact"
    const val FAQ = "faq"
    const val PROFILE = "profile"
    const val SETTINGS = "settings"

    fun courseDetail(courseId: String) = "course_detail/$courseId"
    fun registration(courseId: String? = null) = if (courseId.isNullOrEmpty()) "registration?courseId=" else "registration?courseId=$courseId"

    fun createCourseDetailRoute(courseId: String) = courseDetail(courseId)
    fun createRegistrationRoute(course: String? = null) = registration(course)
}

object InstituteContact {
    const val PHONE_NUMBER = "+91 9528935578"
    const val EMAIL_ADDRESS = "twah.org@gmail.com"
    const val PHONE_URI = "tel:+919528935578"
    const val EMAIL_URI = "mailto:twah.org@gmail.com"
    const val YOUTUBE_URL = "https://youtube.com/@twhorg?si=Yfhdc-yn6PLW5b0H"
    const val INSTAGRAM_URL = "https://www.instagram.com/nasirz11?stkn=MWdlbXdraHZxNms0ag=="
    const val APP_VERSION = "1.0.0"
}
