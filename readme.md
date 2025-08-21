# stumpVision 🏏

A modular Spring Boot application for real-time processing, management, and distribution of cricket match events like score updates, wickets, commentary, milestones, and more. Built with clean architecture, Kafka integration, and high performance in mind.

---

## 🌐 Overview

stumpVision ingests structured match data, processes it through a robust service layer, and publishes real-time updates to downstream consumers via Kafka. It's built for scalability, maintainability, and modularity.

---

## 🧰 Architecture

**Multi-Module Maven Project:**

```
stumpVision/
├── crick-model
├── crick-dao
├── crick-service
├── crick-web
├── crick-kafka
├── crick-exception-handler
```

### Module Summary:

| Module                    | Responsibility                                  |
| ------------------------- | ----------------------------------------------- |
| `crick-model`             | Contains all event and domain models            |
| `crick-dao`               | Database interaction layer with Spring Data JPA |
| `crick-service`           | Core business logic and event processing        |
| `crick-web`               | REST API endpoints                              |
| `crick-kafka`             | Kafka producer to publish match events          |
| `crick-exception-handler` | Global exception handling across all modules    |

---

## 🔄 Event Flow

1. **API Request:** JSON containing `eventType` + `payload` received via `crick-web`
2. **Deserialization:** Custom polymorphic handling maps payload to appropriate `EventPayload` class
3. **Service Layer:** `crick-service` processes the payload
4. **Kafka Push:** `crick-kafka` publishes the event to the relevant Kafka topic
5. **API Response:** Returns `CustomResponse` with success/failure status

---

## 🎟️ Event Types Supported

- **Match Flow:** `MATCH_START`, `MATCH_END`, `END_INNINGS`, `END_MATCH`
- **Game Events:** `RUN`, `WICKET`, `NO_BALL`, `WIDE`, `BYE`, `LEG_BYE`, `FOUR`, `SIX`, `OUT`
- **Miscellaneous:** `SCORE_UPDATE`, `MILESTONE`, `COMMENTARY`

All event types extend from a base interface: `EventPayload`

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot (Multi-module)**
- **Spring Data JPA**
- **Spring Kafka**
- **Maven**
- **H2 / MySQL**
- **Lombok**
- **Jackson**
- **(Optional) Docker**

---

## 🌐 Future Enhancements

- Kafka **Consumers** for live dashboards
- **WebSocket** / **GraphQL** for real-time frontends
- Match summary & analytics dashboard
- Admin interface for manual corrections
- Authentication using **JWT/OAuth2**

---

## 📁 Sample Request

```json
{
  "eventType": "WICKET",
  "payload": {
    "over": 10.4,
    "bowler": "M. Shami",
    "batsman": "B. Azam",
    "wicketType": "Bowled",
    "commentary": "Clean bowled him!"
  }
}
```

---

## 📝 Author - Shrey Shourya

Built with passion for cricket and code.

> For any contributions, bug reports, or feature requests, please open an issue or pull request.

