package com.example.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Lan
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.filled.Web
import androidx.compose.ui.graphics.vector.ImageVector

data class CourseModule(
    val title: String,
    val description: String,
    val topics: List<String>
)

data class CourseFaq(
    val question: String,
    val answer: String
)

data class CourseItem(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val level: String,
    val duration: String,
    val modulesCount: Int,
    val icon: ImageVector,
    val whatYouWillLearn: List<String>,
    val modules: List<CourseModule>,
    val requirements: List<String>,
    val learningOutcomes: List<String>,
    val faqs: List<CourseFaq>,
    val ethicalDisclaimer: String? = null
)

object CourseRepository {
    val courses: List<CourseItem> = listOf(
        CourseItem(
            id = "cyber_security",
            title = "Cyber Security",
            shortDescription = "Security fundamentals, threats, vulnerabilities, defensive concepts and security awareness.",
            fullDescription = "Gain a foundational and practical understanding of modern cybersecurity architecture, threat landscapes, defense-in-depth principles, vulnerability assessments, and enterprise security hygiene.",
            level = "Beginner to Intermediate",
            duration = "8 Weeks • Practical Labs",
            modulesCount = 6,
            icon = Icons.Default.Shield,
            ethicalDisclaimer = "Learn and practice only on systems you own or have explicit authorization to test.",
            whatYouWillLearn = listOf(
                "Core security concepts: Confidentiality, Integrity, and Availability (CIA Triad)",
                "Common attack vectors: Phishing, malware, social engineering, and man-in-the-middle",
                "Authentication protocols, multi-factor authentication (MFA), and encryption basics",
                "Defensive concepts: Firewalls, IDS/IPS, SIEM logging, and perimeter defense",
                "Security audits, vulnerability scanning methodologies, and hardening systems",
                "Developing defensive strategies and organizational security policies"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Foundations of Cybersecurity",
                    description = "Understanding core security pillars, asset classification, and threat agents.",
                    topics = listOf("CIA Triad & Risk Assessment", "Threat Modeling Basics", "Asset Classification & Protection")
                ),
                CourseModule(
                    title = "Module 2: Network & Perimeter Security",
                    description = "Defending communication channels, ports, and external interfaces.",
                    topics = listOf("Firewall Configurations", "IDS vs IPS Overview", "VPNs & Secure Tunnels")
                ),
                CourseModule(
                    title = "Module 3: Cryptography & Identity Management",
                    description = "Modern symmetric/asymmetric encryption, hashing, and IAM best practices.",
                    topics = listOf("AES, RSA, and SHA Hashing", "Public Key Infrastructure (PKI)", "MFA & Role-Based Access Control")
                ),
                CourseModule(
                    title = "Module 4: Vulnerability Assessment & Management",
                    description = "Identifying misconfigurations, outdated services, and patching workflows.",
                    topics = listOf("Common Vulnerabilities & Exposures (CVE)", "Vulnerability Scanning Tools", "Patch Management Cycles")
                ),
                CourseModule(
                    title = "Module 5: Incident Response & Security Operations",
                    description = "Logging, monitoring, containment, and recovery fundamentals.",
                    topics = listOf("SIEM Event Correlation", "Log Analysis & Anomaly Detection", "Incident Response Lifecycle")
                ),
                CourseModule(
                    title = "Module 6: Security Hygiene & Compliance Overview",
                    description = "Industry standards, physical security, and building proactive security habits.",
                    topics = listOf("ISO 27001 & NIST Frameworks Overview", "Endpoint Hardening Checklists", "Final Defensive Lab Project")
                )
            ),
            requirements = listOf(
                "Basic familiarity with computer operations and internet fundamentals",
                "A computer running Windows, macOS, or Linux with minimum 4GB RAM",
                "A dedicated commitment to ethical learning and defensive security"
            ),
            learningOutcomes = listOf(
                "Analyze and identify security risks within home and small business networks",
                "Deploy proactive defense measures including firewalls, backups, and encryption",
                "Evaluate vulnerabilities systematically using standard security assessment principles",
                "Understand compliance frameworks and organizational cybersecurity hygiene"
            ),
            faqs = listOf(
                CourseFaq("Do I need coding experience for this course?", "No prior programming experience is required; we teach all technical concepts from the ground up."),
                CourseFaq("Are the practice labs hands-on?", "Yes, all lessons feature hands-on walkthroughs in safe, isolated virtual environments.")
            )
        ),
        CourseItem(
            id = "ethical_hacking",
            title = "Ethical Hacking",
            shortDescription = "Authorized security testing concepts, reconnaissance, vulnerability assessment and penetration-testing methodology.",
            fullDescription = "Learn how authorized security professionals evaluate and audit systems through structured reconnaissance, vulnerability discovery, scanning techniques, and defensive reporting.",
            level = "Intermediate",
            duration = "10 Weeks • Hands-on Labs",
            modulesCount = 7,
            icon = Icons.Default.Security,
            ethicalDisclaimer = "Learn and practice only on systems you own or have explicit authorization to test. All testing concepts are taught exclusively for defensive auditing and authorization.",
            whatYouWillLearn = listOf(
                "Legal frameworks, rules of engagement, and formal written authorization",
                "Passive and active reconnaissance methodologies using open-source tools",
                "Port scanning, service fingerprinting, and banner grabbing techniques",
                "Vulnerability assessment and vulnerability ranking systems (CVSS)",
                "Web application security testing fundamentals (OWASP Top 10)",
                "Remediation reporting and communicating findings to stakeholders"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Ethics, Law & Rules of Engagement",
                    description = "Legal authorization, written scopes of work, and professional conduct.",
                    topics = listOf("Legal Boundaries & Cyber Law", "Contracts & Scope Definitions", "Safe Lab Environment Setup")
                ),
                CourseModule(
                    title = "Module 2: Reconnaissance & Information Gathering",
                    description = "OSINT techniques, DNS interrogation, and footprinting targets safely.",
                    topics = listOf("Passive Reconnaissance & OSINT", "DNS Footprinting", "Public Directory Enumeration")
                ),
                CourseModule(
                    title = "Module 3: Network Scanning & Enumeration",
                    description = "Discovering active hosts, services, versions, and network topology.",
                    topics = listOf("Nmap Port Scanning", "Service & OS Fingerprinting", "Banner Grabbing & Protocol Analysis")
                ),
                CourseModule(
                    title = "Module 4: Vulnerability Analysis",
                    description = "Assessing weaknesses against vulnerability databases and evaluating risk.",
                    topics = listOf("CVSS Scoring & Vulnerability Priority", "Automated vs Manual Scanning", "False Positive Verification")
                ),
                CourseModule(
                    title = "Module 5: Web Application Security Testing",
                    description = "Identifying OWASP Top 10 vulnerabilities in authorized test applications.",
                    topics = listOf("OWASP Top 10 Concepts", "SQL Injection Basics", "Cross-Site Scripting (XSS) Analysis")
                ),
                CourseModule(
                    title = "Module 6: Wireless & Network Auditing Concepts",
                    description = "Understanding Wi-Fi encryption types, authentication handshakes, and defenses.",
                    topics = listOf("WPA2/WPA3 Standards", "Rogue AP Detection", "Wireless Security Best Practices")
                ),
                CourseModule(
                    title = "Module 7: Technical Reporting & Remediation",
                    description = "Writing structured audit reports and actionable defense recommendations.",
                    topics = listOf("Executive Summaries & Technical Details", "Proof-of-Concept Documentation", "Remediation Roadmaps")
                )
            ),
            requirements = listOf(
                "Basic understanding of TCP/IP networking (IP addresses, ports, routers)",
                "Familiarity with basic command line interfaces (Linux/Windows terminal)",
                "Strict agreement to uphold the ethical pledge and only test authorized labs"
            ),
            learningOutcomes = listOf(
                "Conduct authorized security assessments using structured industry methodologies",
                "Identify and remediate critical security vulnerabilities before adversaries do",
                "Compile professional vulnerability assessment reports with actionable mitigations"
            ),
            faqs = listOf(
                CourseFaq("Is ethical hacking legal?", "Yes, ethical hacking is completely legal and actively employed worldwide when conducted with explicit written authorization on systems you own or have permission to audit."),
                CourseFaq("Where do students practice?", "All exercises take place within dedicated local virtual lab environments installed on your personal computer.")
            )
        ),
        CourseItem(
            id = "web_development",
            title = "Web Development",
            shortDescription = "HTML, CSS, JavaScript and web development fundamentals.",
            fullDescription = "Build responsive, accessible, and interactive modern websites from scratch. Master semantic HTML5, modern CSS layouts (Flexbox & Grid), and vanilla JavaScript programming.",
            level = "Beginner",
            duration = "8 Weeks • 5 Real Projects",
            modulesCount = 6,
            icon = Icons.Default.Web,
            ethicalDisclaimer = null,
            whatYouWillLearn = listOf(
                "Semantic HTML5 structuring for accessibility and search engine visibility",
                "Modern CSS3 styling, Flexbox, CSS Grid, and responsive mobile-first media queries",
                "Core JavaScript: variables, functions, loops, arrays, and object manipulation",
                "DOM manipulation and event listeners for dynamic UI interactions",
                "Working with REST APIs using the modern Fetch API and JSON",
                "Version control with Git and publishing projects online"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Semantic HTML5 Architecture",
                    description = "Writing structured, accessible, and standardized web content.",
                    topics = listOf("Document Structure & Elements", "Semantic Tags & Headings", "Forms, Inputs & Validation")
                ),
                CourseModule(
                    title = "Module 2: Modern CSS3 & Responsive Design",
                    description = "Visual design, typography, spacing, and mobile responsive layouts.",
                    topics = listOf("CSS Selectors & Box Model", "Flexbox Layout Architecture", "CSS Grid & Media Queries")
                ),
                CourseModule(
                    title = "Module 3: JavaScript Programming Core",
                    description = "The foundational programming language of the modern web.",
                    topics = listOf("Variables, Types & Operators", "Conditionals & Loops", "Functions & Scope")
                ),
                CourseModule(
                    title = "Module 4: DOM Manipulation & User Events",
                    description = "Connecting JavaScript code to HTML buttons, inputs, and screens.",
                    topics = listOf("Selecting & Modifying Elements", "Event Listeners & Handling", "Dynamic Class & Style Toggles")
                ),
                CourseModule(
                    title = "Module 5: Asynchronous JavaScript & Web APIs",
                    description = "Fetching data asynchronously from web endpoints and parsing JSON.",
                    topics = listOf("Promises & Async/Await", "Fetch API & JSON Processing", "Error Handling & Loading States")
                ),
                CourseModule(
                    title = "Module 6: Capstone Web Project & Hosting",
                    description = "Building a complete responsive portfolio website and hosting it.",
                    topics = listOf("Project Architecture & Cleanup", "Git & GitHub Basics", "Deployment to Free Web Hosts")
                )
            ),
            requirements = listOf(
                "Any standard computer (Windows, Mac, or Linux) with a web browser",
                "A free code editor like VS Code installed",
                "No prior programming experience required"
            ),
            learningOutcomes = listOf(
                "Build functional, mobile-friendly websites from scratch using clean code",
                "Understand the core interaction cycle between HTML, CSS, and JavaScript",
                "Deploy and publish real websites accessible across phones, tablets, and desktops"
            ),
            faqs = listOf(
                CourseFaq("Do I need any math skills for web development?", "No advanced math is needed; web development primarily focuses on logic, layout, and user design."),
                CourseFaq("Can I build websites after completing this course?", "Yes! You will build 5 full web projects throughout the course to showcase in your portfolio.")
            )
        ),
        CourseItem(
            id = "python",
            title = "Python",
            shortDescription = "Python programming from fundamentals to practical programming.",
            fullDescription = "Learn one of the world's most versatile programming languages. From core syntax to data structures, file I/O, automation scripts, and object-oriented programming.",
            level = "Beginner to Intermediate",
            duration = "7 Weeks • Coding Labs",
            modulesCount = 6,
            icon = Icons.Default.Code,
            ethicalDisclaimer = null,
            whatYouWillLearn = listOf(
                "Python syntax, variables, data types, and operators",
                "Control flow: conditional statements and iteration with loops",
                "Data collections: lists, tuples, dictionaries, and sets",
                "Modular code creation with functions and custom modules",
                "File handling (reading/writing text and CSV files)",
                "Object-Oriented Programming (Classes, Objects, Methods, and Inheritance)",
                "Building automation scripts for practical repetitive tasks"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Getting Started with Python",
                    description = "Setting up the Python interpreter, running scripts, and fundamental types.",
                    topics = listOf("Installing Python & VS Code", "Print, Input & Variables", "Integers, Floats & Strings")
                ),
                CourseModule(
                    title = "Module 2: Logic, Conditionals & Loops",
                    description = "Guiding program execution flow with robust logic.",
                    topics = listOf("If, Elif, Else Statements", "While & For Loops", "Range, Break & Continue")
                ),
                CourseModule(
                    title = "Module 3: Core Data Structures",
                    description = "Storing and manipulating structured data efficiently.",
                    topics = listOf("Lists & List Comprehensions", "Dictionaries & Key-Value Pairs", "Tuples & Sets")
                ),
                CourseModule(
                    title = "Module 4: Functions & Reusable Code",
                    description = "Writing clean, maintainable, and reusable functions.",
                    topics = listOf("Defining Functions & Return Values", "Arguments & Default Parameters", "Variable Scope & Lambda Basics")
                ),
                CourseModule(
                    title = "Module 5: File Operations & Error Handling",
                    description = "Working with disk files and preventing program crashes with try-except.",
                    topics = listOf("Reading & Writing Files", "CSV Parsing", "Try, Except & Finally Blocks")
                ),
                CourseModule(
                    title = "Module 6: OOP & Practical Automation Projects",
                    description = "Object-Oriented design and building automation tools.",
                    topics = listOf("Classes & Object Instances", "Methods & Inheritance", "Building Real Automation Scripts")
                )
            ),
            requirements = listOf(
                "A computer running Windows, macOS, or Linux",
                "Basic typing skills and a desire to learn logical problem-solving",
                "Zero prior coding knowledge needed"
            ),
            learningOutcomes = listOf(
                "Write clean, idiomatic Python code for practical software problems",
                "Automate repetitive daily tasks such as file sorting and data extraction",
                "Read, parse, and analyze external data files with robust exception handling"
            ),
            faqs = listOf(
                CourseFaq("Why should I learn Python first?", "Python is known for its clean, English-like syntax, making it the ideal first language for beginners."),
                CourseFaq("Can I use Python for cybersecurity or web development later?", "Yes! Python is heavily used in cybersecurity scripting, data science, and web development.")
            )
        ),
        CourseItem(
            id = "linux",
            title = "Linux",
            shortDescription = "Linux command line, system administration concepts and server basics.",
            fullDescription = "Master the open-source operating system that powers over 90% of the world's cloud servers, cybersecurity tools, and modern software backends. Learn the terminal, permissions, processes, and administration.",
            level = "Beginner to Intermediate",
            duration = "6 Weeks • Terminal Practice",
            modulesCount = 5,
            icon = Icons.Default.Terminal,
            ethicalDisclaimer = null,
            whatYouWillLearn = listOf(
                "Linux filesystem hierarchy, directory navigation, and file operations",
                "Terminal commands: grep, find, cat, less, sed, awk, and pipes",
                "User management, groups, file permissions (chmod/chown), and sudo",
                "Process monitoring, systemd service management, and cron jobs",
                "Package management across Debian/Ubuntu and RHEL distributions",
                "Bash shell scripting fundamentals for system automation"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Introduction to Linux & Terminal Basics",
                    description = "Navigating directories and managing files from the command line.",
                    topics = listOf("Linux Flavors & Installation", "pwd, cd, ls, mkdir, rm", "Path Exploration (Absolute vs Relative)")
                ),
                CourseModule(
                    title = "Module 2: File Viewing, Searching & Text Streams",
                    description = "Inspecting system logs and piping command outputs.",
                    topics = listOf("cat, head, tail, and less", "Grep & Regular Expressions", "Input/Output Redirection & Pipes")
                ),
                CourseModule(
                    title = "Module 3: Permissions & User Administration",
                    description = "Controlling who can read, write, and execute files.",
                    topics = listOf("User & Group Creation", "chmod Numeric & Symbolic Modes", "chown & Root / Sudo Privileges")
                ),
                CourseModule(
                    title = "Module 4: Process Control & System Services",
                    description = "Monitoring CPU/memory usage and managing background daemons.",
                    topics = listOf("ps, top, and htop", "Killing & Backgrounding Processes", "systemctl & Service Management")
                ),
                CourseModule(
                    title = "Module 5: Networking & Shell Scripting Basics",
                    description = "Configuring interfaces, SSH remote login, and simple bash scripts.",
                    topics = listOf("ifconfig/ip, ping, netstat/ss", "SSH Remote Access & Keys", "Writing First Bash Automation Script")
                )
            ),
            requirements = listOf(
                "A computer capable of running a free VirtualBox VM or WSL (Windows Subsystem for Linux)",
                "No prior command line experience required"
            ),
            learningOutcomes = listOf(
                "Comfortably navigate and administer any Linux server via the terminal",
                "Configure robust file permissions and enforce least-privilege security",
                "Automate recurring administrative tasks using bash scripts and cron jobs"
            ),
            faqs = listOf(
                CourseFaq("Do I have to erase Windows or Mac to learn Linux?", "No! We guide you on setting up Linux inside a free Virtual Machine or WSL without touching your main OS."),
                CourseFaq("Is Linux necessary for cybersecurity?", "Yes, nearly all security audit tools and servers run natively on Linux.")
            )
        ),
        CourseItem(
            id = "networking",
            title = "Networking",
            shortDescription = "Networking fundamentals, IP addressing, protocols, routing, switching and network security concepts.",
            fullDescription = "Discover how devices communicate across local networks and the global internet. Learn the OSI 7-layer model, IPv4 & IPv6 addressing, subnetting, switching, routing protocols, and perimeter defense.",
            level = "Beginner to Intermediate",
            duration = "7 Weeks • Packet Analysis",
            modulesCount = 6,
            icon = Icons.Default.Lan,
            ethicalDisclaimer = null,
            whatYouWillLearn = listOf(
                "The OSI 7-Layer Model and TCP/IP protocol stack",
                "IPv4 addressing, subnet masks, CIDR notation, and IPv6 fundamentals",
                "Core protocols: TCP vs UDP, DNS, DHCP, HTTP/HTTPS, and ARP",
                "Switching concepts: MAC tables, VLANs, and collision/broadcast domains",
                "Routing principles, default gateways, and dynamic routing concepts",
                "Network troubleshooting using ping, traceroute, and packet capture tools"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: The Anatomy of Computer Networks",
                    description = "Network topologies, client-server models, and communication media.",
                    topics = listOf("LAN, WAN, and WLAN Architecture", "The 7 Layers of the OSI Model", "TCP/IP Suite Comparison")
                ),
                CourseModule(
                    title = "Module 2: IP Addressing & Subnetting Demystified",
                    description = "Mastering binary calculations, IPv4 classes, and CIDR masks.",
                    topics = listOf("IPv4 Structure & Octets", "Subnetting & Network/Broadcast IDs", "IPv6 Essentials")
                ),
                CourseModule(
                    title = "Module 3: Core Network Protocols",
                    description = "How data gets located, requested, and transported across routers.",
                    topics = listOf("TCP Handshake & UDP Comparison", "DNS Resolution Architecture", "DHCP Address Leases & ARP")
                ),
                CourseModule(
                    title = "Module 4: Switching & Local Area Networks",
                    description = "How data frames move inside an office or home network.",
                    topics = listOf("Switches & MAC Address Tables", "VLAN Segmentation", "Broadcast Storms & STP Basics")
                ),
                CourseModule(
                    title = "Module 5: Routing & Internet Connectivity",
                    description = "Moving packets between networks and across the public internet.",
                    topics = listOf("Default Gateways & Routing Tables", "Static vs Dynamic Routing", "NAT (Network Address Translation)")
                ),
                CourseModule(
                    title = "Module 6: Network Troubleshooting & Packet Inspection",
                    description = "Diagnosing connection drops and inspecting raw packets.",
                    topics = listOf("Using ping, traceroute & netstat", "Packet Sniffing Concepts with Wireshark", "Network Defense Fundamentals")
                )
            ),
            requirements = listOf(
                "Basic computer user skills",
                "Curiosity about how the internet and home Wi-Fi routers work"
            ),
            learningOutcomes = listOf(
                "Calculate IP subnets and configure network adapter settings confidently",
                "Diagnose and troubleshoot everyday connectivity problems systematically",
                "Understand the exact communication flow between web browsers and servers"
            ),
            faqs = listOf(
                CourseFaq("Is networking hard for beginners?", "We teach subnetting and protocols with intuitive visual analogies that make learning simple and enjoyable."),
                CourseFaq("Is networking relevant for web developers and cybersecurity?", "Absolutely. Networking is the foundational backbone for both cloud web apps and cyber defense.")
            )
        ),
        CourseItem(
            id = "database",
            title = "Database",
            shortDescription = "SQL, relational databases and database management fundamentals.",
            fullDescription = "Understand how modern applications store, organize, query, and safeguard mission-critical data. Master Structured Query Language (SQL), relational design, normal forms, and integrity constraints.",
            level = "Beginner",
            duration = "6 Weeks • Hands-on Queries",
            modulesCount = 5,
            icon = Icons.Default.Storage,
            ethicalDisclaimer = null,
            whatYouWillLearn = listOf(
                "Relational database concepts, tables, records, columns, and keys",
                "Writing SQL queries: SELECT, WHERE, ORDER BY, GROUP BY, and HAVING",
                "Data manipulation: INSERT, UPDATE, and DELETE operations",
                "Joining relational tables: INNER JOIN, LEFT JOIN, and RIGHT JOIN",
                "Database schema design, primary & foreign keys, and normalization (1NF, 2NF, 3NF)",
                "Data integrity, transactions (ACID properties), and backup basics"
            ),
            modules = listOf(
                CourseModule(
                    title = "Module 1: Relational Data Fundamentals",
                    description = "Why databases exist, spreadsheets vs databases, and RDBMS concepts.",
                    topics = listOf("Spreadsheet Limits vs RDBMS", "Tables, Rows & Fields", "Primary Keys & Unique Identifiers")
                ),
                CourseModule(
                    title = "Module 2: Basic SQL Querying",
                    description = "Extracting and filtering records from relational tables.",
                    topics = listOf("SELECT, FROM, WHERE Filtering", "Comparison & Logical Operators", "ORDER BY, LIMIT, and DISTINCT")
                ),
                CourseModule(
                    title = "Module 3: Aggregations & Data Grouping",
                    description = "Summarizing data with counts, averages, sums, and groupings.",
                    topics = listOf("COUNT, SUM, AVG, MIN, MAX", "GROUP BY Aggregations", "Filtering Groups with HAVING")
                ),
                CourseModule(
                    title = "Module 4: Table Joins & Relationships",
                    description = "Combining data from multiple interconnected tables.",
                    topics = listOf("Foreign Key Constraints", "INNER JOIN Queries", "LEFT & RIGHT OUTER JOINS")
                ),
                CourseModule(
                    title = "Module 5: Schema Design & Data Integrity",
                    description = "Creating resilient schemas, indexes, and atomic transactions.",
                    topics = listOf("CREATE TABLE & ALTER TABLE", "Database Normalization Principles", "ACID Transactions & Security")
                )
            ),
            requirements = listOf(
                "Any modern computer with internet access",
                "No prior programming or database knowledge needed"
            ),
            learningOutcomes = listOf(
                "Write complex SQL queries to extract meaningful insights from large datasets",
                "Design normalized relational database schemas with solid referential integrity",
                "Perform standard database administration, indexing, and backup procedures"
            ),
            faqs = listOf(
                CourseFaq("Which database system do we use?", "We focus on ANSI-standard SQL using PostgreSQL/SQLite, which transfers seamlessly to MySQL and SQL Server."),
                CourseFaq("Can non-programmers learn SQL?", "Yes! SQL is declarative and reads like plain English sentences, making it very beginner-friendly.")
            )
        )
    )

    fun getCourseById(id: String): CourseItem? {
        return courses.find { it.id.equals(id, ignoreCase = true) }
    }
}
