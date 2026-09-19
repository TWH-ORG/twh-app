package com.example.data

data class FaqItem(
    val id: Int,
    val question: String,
    val answer: String,
    val category: String = "General"
)

object FaqRepository {
    val faqs: List<FaqItem> = listOf(
        FaqItem(
            id = 1,
            question = "What is TWH ORG?",
            answer = "TWH ORG is an educational technology and cybersecurity learning institute dedicated to helping students build practical digital skills in modern tech domains including Cyber Security, Ethical Hacking, Web Development, Python, Linux, Networking, and Databases."
        ),
        FaqItem(
            id = 2,
            question = "What courses are available?",
            answer = "We currently offer seven core practical technology programs: Cyber Security, Ethical Hacking, Web Development, Python Programming, Linux Administration, Computer Networking, and Relational Databases."
        ),
        FaqItem(
            id = 3,
            question = "Are courses beginner friendly?",
            answer = "Yes! All courses are designed with beginner-friendly introductory modules that start from fundamental concepts before progressing systematically into hands-on practical applications."
        ),
        FaqItem(
            id = 4,
            question = "How can I register?",
            answer = "You can apply directly through the Student Registration screen in this app. Select your preferred course, enter your contact information, and submit your registration request."
        ),
        FaqItem(
            id = 5,
            question = "Is free learning available?",
            answer = "Yes! We provide structured free learning guides and educational resources directly in the Free Learning section of this app, alongside video tutorials on our official YouTube channel."
        ),
        FaqItem(
            id = 6,
            question = "How can I contact TWH ORG?",
            answer = "You can contact our team directly by phone at +91 9528935578, via email at twah.org@gmail.com, or through the interactive enquiry form in the Contact screen."
        ),
        FaqItem(
            id = 7,
            question = "Does TWH ORG provide cybersecurity education?",
            answer = "Yes. TWH ORG provides practical, defensive cybersecurity education and authorized security testing concepts, with strict emphasis on ethical responsibility and defensive skill development."
        ),
        FaqItem(
            id = 8,
            question = "Can I learn Linux and Networking?",
            answer = "Yes. We offer dedicated courses in Linux command line administration and Computer Networking (IP addressing, OSI model, routing, switching, and protocol troubleshooting)."
        ),
        FaqItem(
            id = 9,
            question = "Where can I watch TWH ORG videos?",
            answer = "You can watch all official TWH ORG educational tutorials and tech sessions on our verified YouTube channel at https://youtube.com/@twhorg?si=Yfhdc-yn6PLW5b0H."
        ),
        FaqItem(
            id = 10,
            question = "How can I follow TWH ORG on Instagram?",
            answer = "Follow our updates, tips, and technology announcements on our official Instagram page: https://www.instagram.com/nasirz11?stkn=MWdlbXdraHZxNms0ag=="
        )
    )
}
