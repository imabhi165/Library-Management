# 📚 Library Management System — Java CLI

A complete **Library Management System** built using **Core Java (OOP)** with a clean and interactive **Command-Line Interface (CLI)**.  
This project helps beginners learn **Object-Oriented Programming, Collections, Exception Handling, and CLI-driven architecture** in Java.

---

## ⭐ Features

- **Add books to library**
- **Register members**
- **Borrow & return books**
- **Auto-generated Book & Member IDs**
- **Membership Types (Standard / Premium)**
- **Search books by title**
- **Show all books, members, borrowed books**
- **Track book availability**
- **Custom Exceptions**
- **Clean CLI Menus**

---

## 🧠 OOP Concepts Used

| Concept | Where Used |
|--------|-----------|
Encapsulation | Private fields, getters/setters  
Inheritance | Class structure design  
Polymorphism | Overridden `displayInfo()`  
Abstraction | LibraryService layer  
Composition | `Member` has `Address`  
Exception Handling | Custom exceptions  

---

## 📂 Project Structure
---

```markdown
## 📂 Project Structure

src/
└── library/
├── models/
│   ├── Book.java
│   ├── Member.java
│   ├── Address.java
│   └── MembershipType.java
├── services/
│   └── LibraryService.java
├── exceptions/
│   ├── BookNotFoundException.java
│   └── MemberNotFoundException.java
└── Main.java

````
---

## ✅ Requirements
- Java JDK 8 or higher
- Any Java IDE (VS Code, IntelliJ, Eclipse) or command line
---

## 🚀 Run Project Locally

### 1️⃣ Clone repo

```bash
git clone https://github.com/imabhi165/Library-Management.git
cd Library-Management
````

### 2️⃣ Compile

```bash
javac -d out $(find src -name "*.java")
```

### 3️⃣ Run

```bash
java -cp out library.Main
```

---

## 🧪 Demo Menu

```
===== MENU =====
1. Add Book
2. Register Member
3. Borrow Book
4. Return Book
5. Search Books
6. Display All Books
7. Display Available Books
8. Display All Members
9. Exit
```

---

## 🍴 Fork & Contribute

### Fork the repo → Clone your fork

```bash
git clone https://github.com/YOUR_USERNAME/Library-Management.git
cd Library-Management
```

### Create branch

```bash
git checkout -b feature-name
```

### Commit & Push

```bash
git add .
git commit -m "Added new feature"
git push origin feature-name
```

### Create Pull Request ✅

Go to your repo → **Pull Requests → New PR**

---



