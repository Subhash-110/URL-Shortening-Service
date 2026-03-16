# URL Shortening Service 🔗

A simple **RESTful URL Shortener API** built using **Java and Spring Boot**.
This service allows users to convert long URLs into short codes and redirect to the original URL when accessed.

The project implements core backend concepts such as **REST APIs, database persistence, URL redirection, and access tracking**.

---

## 🚀 Features

* Create a short URL from a long URL
* Redirect short URL to the original URL
* Update an existing URL
* Delete a short URL
* Track number of times a short URL is accessed
* Retrieve statistics for a short URL
* Random short code generation
* In-memory database using H2

---

## 🛠️ Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database**
* **Maven**

---

## 📁 Project Structure

```
url-shortening-service
│
├── controller
│   └── ShortUrlController.java
│
├── service
│   ├── UrlService.java
│   └── UrlServiceImpl.java
│
├── repository
│   └── UrlRepository.java
│
├── model
│   └── UrlMapping.java
│
├── dto
│   └── UrlRequest.java
│
├── util
│   └── ShortCodeGenerator.java
│
└── UrlShortenerApplication.java
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```
git clone https://github.com/your-username/url-shortening-service.git
cd url-shortening-service
```

---

### 2. Run the Application

Run the Spring Boot application:

```
mvn spring-boot:run
```

or run `UrlShortenerApplication.java` from your IDE.

Server starts at:

```
http://localhost:8080
```

---

## 🗄️ Database

This project uses **H2 in-memory database**.

H2 Console:

```
http://localhost:8080/h2-console
```

Login details:

```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (empty)
```

---

## 📡 API Endpoints

### 1️⃣ Create Short URL

```
POST /shorten
```

Request Body

```json
{
"url": "https://google.com"
}
```

Response

```json
{
"id": 1,
"url": "https://google.com",
"shortCode": "a8K2Lp",
"createdAt": "2026-03-16T10:20:00",
"updatedAt": "2026-03-16T10:20:00",
"accessCount": 0
}
```

---

### 2️⃣ Redirect to Original URL

```
GET /{shortCode}
```

Example

```
http://localhost:8080/a8K2Lp
```

This automatically redirects to the original URL.

---

### 3️⃣ Get URL Details

```
GET /shorten/{shortCode}
```

---

### 4️⃣ Update URL

```
PUT /shorten/{shortCode}
```

Request

```json
{
"url": "https://openai.com"
}
```

---

### 5️⃣ Delete Short URL

```
DELETE /shorten/{shortCode}
```

Response

```
204 No Content
```

---

### 6️⃣ Get URL Statistics

```
GET /shorten/{shortCode}/stats
```

Response

```json
{
"id": 1,
"url": "https://google.com",
"shortCode": "a8K2Lp",
"createdAt": "...",
"updatedAt": "...",
"accessCount": 5
}
```

---

## 🧪 Testing the API

You can test the API using:

* Postman
* curl
* Browser (for redirect endpoint)

Example:

```
POST http://localhost:8080/shorten
```

---

## 📊 Example Workflow

1. Create short URL
2. Receive generated shortCode
3. Open short URL in browser
4. Service redirects to original URL
5. Access count increases

---

## 🔮 Possible Improvements

* Add custom short codes
* Add URL validation
* Prevent duplicate short codes
* Use Redis caching
* Use Base62 encoding for shorter codes
* Add authentication
* Deploy using Docker

---

## 📚 Learning Outcomes

This project demonstrates:

* REST API design
* URL redirection
* Spring Boot backend architecture
* Database persistence with JPA
* Random code generation
* API testing

---

## 📄 License

This project is for learning purposes.

---

⭐ If you found this project useful, consider giving it a star on GitHub!
