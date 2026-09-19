package com.example.data

data class FreeLesson(
    val title: String,
    val readTime: String,
    val summary: String,
    val keyPoints: List<String>,
    val practicalTip: String
)

data class FreeCategory(
    val id: String,
    val title: String,
    val description: String,
    val iconName: String,
    val lessons: List<FreeLesson>
)

object FreeLearningRepository {
    val categories: List<FreeCategory> = listOf(
        FreeCategory(
            id = "cyber_security_basics",
            title = "Cyber Security Basics",
            description = "Fundamental principles of digital defense, CIA triad, threat hygiene, and password management.",
            iconName = "Shield",
            lessons = listOf(
                FreeLesson(
                    title = "The CIA Triad Explained",
                    readTime = "4 min read",
                    summary = "The bedrock of all information security frameworks: Confidentiality, Integrity, and Availability.",
                    keyPoints = listOf(
                        "Confidentiality: Protecting sensitive data from unauthorized eyes via encryption and access controls.",
                        "Integrity: Ensuring information cannot be modified or tampered with silently (hashes and signatures).",
                        "Availability: Ensuring authorized users can access systems when required (redundancy, backups, DDoS defenses)."
                    ),
                    practicalTip = "Never store plain-text credentials. Always combine strong hashing with per-user salt."
                ),
                FreeLesson(
                    title = "Spotting Modern Phishing Attacks",
                    readTime = "5 min read",
                    summary = "How deceptive communications mimic legitimate organizations to capture credentials.",
                    keyPoints = listOf(
                        "Verify sender domain headers carefully rather than trusting the display name.",
                        "Inspect embedded hyperlink targets before clicking.",
                        "Look for artificial urgency demanding immediate account verification."
                    ),
                    practicalTip = "Enable hardware or authenticator app MFA across all your primary accounts."
                )
            )
        ),
        FreeCategory(
            id = "ethical_hacking_fundamentals",
            title = "Ethical Hacking Fundamentals",
            description = "Legal standards, rules of engagement, authorized reconnaissance, and vulnerability scoping.",
            iconName = "Security",
            lessons = listOf(
                FreeLesson(
                    title = "Rules of Engagement & Legal Scopes",
                    readTime = "6 min read",
                    summary = "Why ethical security auditing demands explicit written authorization before running a single probe.",
                    keyPoints = listOf(
                        "Always obtain clear written consent stating allowed IP ranges and permitted time windows.",
                        "Understand out-of-bounds assets (third-party services, medical systems, production critical databases).",
                        "Maintain an accurate timestamped log of all test actions and source addresses."
                    ),
                    practicalTip = "Practice exclusively in controlled environments such as local VMs or intentional capture-the-flag platforms."
                ),
                FreeLesson(
                    title = "Reconnaissance: Active vs Passive",
                    readTime = "5 min read",
                    summary = "Understanding how information is collected during the first phase of an authorized audit.",
                    keyPoints = listOf(
                        "Passive Recon: Inspecting public DNS records, WHOIS data, and published certificates without contacting the target directly.",
                        "Active Recon: Sending packets directly to target ports to identify listening services and version banners."
                    ),
                    practicalTip = "Always start with passive reconnaissance to map targets safely without disrupting services."
                )
            )
        ),
        FreeCategory(
            id = "linux_basics",
            title = "Linux Basics",
            description = "Command-line essentials, directory navigation, file permissions, and piping commands.",
            iconName = "Terminal",
            lessons = listOf(
                FreeLesson(
                    title = "Mastering File Navigation & Manipulation",
                    readTime = "5 min read",
                    summary = "Essential CLI commands: pwd, ls, cd, cp, mv, and rm.",
                    keyPoints = listOf(
                        "pwd displays current working directory; ls -la lists all files including hidden dotfiles.",
                        "cd .. steps up one directory level; cd ~ jumps directly to home.",
                        "cp copies files; mv moves or renames files; rm -r removes directory trees safely."
                    ),
                    practicalTip = "Use TAB auto-completion frequently to speed up navigation and prevent typing errors."
                ),
                FreeLesson(
                    title = "Linux Permissions Demystified (chmod & chown)",
                    readTime = "6 min read",
                    summary = "Understanding User, Group, and Others permission octets (rwx / 4-2-1).",
                    keyPoints = listOf(
                        "Read = 4, Write = 2, Execute = 1.",
                        "chmod 755 grants owner full access (7), while group and others can read and execute (5).",
                        "chmod 600 restricts sensitive config files so only the owner can read and write."
                    ),
                    practicalTip = "Check SSH key permissions with 'ls -l ~/.ssh' and enforce 'chmod 600 id_rsa'."
                )
            )
        ),
        FreeCategory(
            id = "python_basics",
            title = "Python Basics",
            description = "Variables, loops, functions, lists, and simple automation scripts.",
            iconName = "Code",
            lessons = listOf(
                FreeLesson(
                    title = "Python Types & Control Flow",
                    readTime = "5 min read",
                    summary = "Working with strings, numbers, booleans, and conditional if/elif/else statements.",
                    keyPoints = listOf(
                        "Dynamic typing allows swift prototyping without verbose type declarations.",
                        "Indentation defines code blocks; always use 4 consistent spaces.",
                        "Boolean operations (and, or, not) control program decision branches."
                    ),
                    practicalTip = "Use f-strings like f'Hello, {name}' for clean string formatting."
                ),
                FreeLesson(
                    title = "Working with Lists & Dictionaries",
                    readTime = "6 min read",
                    summary = "Storing collections in ordered lists and key-value mapping dictionaries.",
                    keyPoints = listOf(
                        "Lists: ordered, zero-indexed collections [item1, item2].",
                        "Dictionaries: key-value lookups {'port': 80, 'protocol': 'HTTP'}.",
                        "Iterate through dictionaries using .items() in a for loop."
                    ),
                    practicalTip = "Use .get(key, default_value) to safely retrieve dictionary values without crashing."
                )
            )
        ),
        FreeCategory(
            id = "networking_basics",
            title = "Networking Basics",
            description = "IP addressing, subnets, DNS, TCP vs UDP, and the OSI 7-layer model.",
            iconName = "Lan",
            lessons = listOf(
                FreeLesson(
                    title = "Understanding the OSI 7-Layer Model",
                    readTime = "7 min read",
                    summary = "How data travels from application software down to physical electrical and optical cables.",
                    keyPoints = listOf(
                        "Layer 7 (Application): HTTP, DNS, SSH, SMTP.",
                        "Layer 4 (Transport): TCP (reliable, ordered) vs UDP (fast, connectionless).",
                        "Layer 3 (Network): IP addressing and routing across routers.",
                        "Layer 2 (Data Link): Ethernet frames and MAC addresses on local switches."
                    ),
                    practicalTip = "Use 'ping 8.8.8.8' to test Layer 3 connectivity, and 'nslookup google.com' to test Layer 7 DNS."
                ),
                FreeLesson(
                    title = "IPv4 Addresses & Subnetting 101",
                    readTime = "6 min read",
                    summary = "Understanding 32-bit IP addresses and how subnet masks divide network from host.",
                    keyPoints = listOf(
                        "A /24 subnet mask (255.255.255.0) provides 256 total addresses (254 usable for hosts).",
                        "Private IP ranges: 10.0.0.0/8, 172.16.0.0/12, and 192.168.0.0/16.",
                        "Default gateway is the local router IP that forwards packets outside your subnet."
                    ),
                    practicalTip = "Check your current IP configuration with 'ip a' on Linux or 'ipconfig' on Windows."
                )
            )
        ),
        FreeCategory(
            id = "web_development_basics",
            title = "Web Development Basics",
            description = "HTML tags, CSS layout fundamentals, Flexbox, and JavaScript interaction.",
            iconName = "Web",
            lessons = listOf(
                FreeLesson(
                    title = "Semantic HTML5 & Accessibility",
                    readTime = "4 min read",
                    summary = "Structuring web pages with meaningful elements: header, nav, main, article, section, footer.",
                    keyPoints = listOf(
                        "Semantic elements provide context to search engines and screen readers.",
                        "Always supply descriptive alt text for images.",
                        "Use proper button and anchor tags rather than generic clickable divs."
                    ),
                    practicalTip = "Test page readability using keyboard TAB navigation."
                ),
                FreeLesson(
                    title = "CSS Flexbox Layout Basics",
                    readTime = "5 min read",
                    summary = "Effortlessly align and distribute elements along main and cross axes.",
                    keyPoints = listOf(
                        "display: flex activates the flex formatting context.",
                        "justify-content controls spacing along the main axis (flex-start, center, space-between).",
                        "align-items aligns items along the perpendicular cross axis."
                    ),
                    practicalTip = "Use 'gap: 16px' inside flex containers to create clean spacing between items."
                )
            )
        ),
        FreeCategory(
            id = "database_basics",
            title = "Database Basics",
            description = "Tables, columns, rows, primary keys, and essential SQL queries.",
            iconName = "Storage",
            lessons = listOf(
                FreeLesson(
                    title = "Relational Database Concepts",
                    readTime = "5 min read",
                    summary = "Why relational databases excel at maintaining data integrity across connected records.",
                    keyPoints = listOf(
                        "Each table represents an entity (e.g., Students, Courses, Registrations).",
                        "Primary keys uniquely identify each row in a table.",
                        "Foreign keys link a row in one table to the primary key of another."
                    ),
                    practicalTip = "Always define NOT NULL constraints on essential fields like emails and creation dates."
                ),
                FreeLesson(
                    title = "Writing Your First SQL Queries",
                    readTime = "6 min read",
                    summary = "Extracting filtered and sorted data using standard SQL syntax.",
                    keyPoints = listOf(
                        "SELECT name, email FROM students WHERE active = true;",
                        "ORDER BY enrollment_date DESC sorts newest registrations first.",
                        "LIMIT 10 restricts output to the first ten results."
                    ),
                    practicalTip = "Use parameter binding rather than string concatenation to prevent SQL injection."
                )
            )
        )
    )

    fun getCategoryById(id: String): FreeCategory? {
        return categories.find { it.id.equals(id, ignoreCase = true) }
    }
}
