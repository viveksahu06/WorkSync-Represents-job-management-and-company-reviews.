# WorkSync-Represents-job-management-and-company-reviews.
📝 Overview

This project is a microservices-based Company Management System that includes services for managing companies, job postings, and reviews.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Technologies Used
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🖥️ Spring Boot - Microservices framework

🐳 Docker & Docker Compose - Containerization

🛢️ PostgreSQL - Primary database

📡 Eureka Service Registry - Service discovery

🌐 API Gateway - Routing and load balancing

📊 Zipkin - Distributed tracing

📩 RabbitMQ - Asynchronous messaging

🏗️ Services and Components
------------------------------------------------------------------------------------------------

🐄️ 1. Databases and Monitoring
-

🛢️ PostgreSQL (postgres) - Primary relational database

🌐 pgAdmin (pgadmin) - Web-based UI to manage PostgreSQL

📊 Zipkin (zipkin) - Distributed tracing for microservices

📩 RabbitMQ (rabbitmq) - Message broker for event-driven architecture

⚙️ 2. Core Microservices
-

📡 Service Registry (servicereg) - Eureka-based service discovery
-

🔧 Config Server (config-server-ms) - Centralized configuration management
-

🚪 API Gateway (gateway-ms) - Single entry point for routing API requests
-
🏢 Company Service (companyms) - Handles company-related operations
-
💼 Job Service (jobms) - Manages job postings
-
⭐ Review Service (reviewms) - Stores and manages reviews
-

⚙️ Prerequisites
------

Ensure you have the following installed before running the system:

🐳 Docker (latest version)
-

📜 Docker Compose
-

▶️ Running the Application
-

To start all services in detached mode, run:

docker-compose up -d
-

To stop all services, run:

docker-compose down
-

To restart a specific service, run:

docker-compose restart service-name
-

🌐 Accessing Services
--------------------------
| Service                  | URL                                      | Description                  |
|--------------------------|-----------------------------------------|------------------------------|
| 🛢️ pgAdmin              | [http://localhost:5050](http://localhost:5050)   | PostgreSQL web interface    |
| 📡 Service Registry (Eureka) | [http://localhost:8761](http://localhost:8761) | Microservice discovery      |
| 🚪 API Gateway          | [http://localhost:8084](http://localhost:8084) | Main API entry point       |
| 📊 Zipkin Dashboard     | [http://localhost:9411](http://localhost:9411) | Microservice tracing       |
| 📩 RabbitMQ Dashboard  | [http://localhost:15672](http://localhost:15672) | Message queue admin panel  |


⚙️ Environment Variables

📌 Service

📲 Port

⚙️ Environment Variables
--
| Service              | Port  | Environment Variables |
|----------------------|------|-----------------------------------------------|
| 🛢️ Postgres         | 5432 | `POSTGRES_USER=vivek`, `POSTGRES_PASSWORD=1234` |
| 🌐 pgAdmin         | 5050 | `PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org`, `PGADMIN_DEFAULT_PASSWORD=admin` |
| 📡 Service Registry | 8761 | - |
| 🔧 Config Server MS | 8080 | `SPRING_PROFILES_ACTIVE=docker` |
| 🚪 Gateway MS      | 8084 | `SPRING_PROFILES_ACTIVE=docker` |
| 🏢 Company MS      | 8081 | `SPRING_PROFILES_ACTIVE=docker` |
| 💼 Job MS         | 8082 | `SPRING_PROFILES_ACTIVE=docker`, `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://servicereg:8761/eureka` |
| ⭐ Review MS       | 8083 | `SPRING_PROFILES_ACTIVE=docker` |


🔗 Networks and Volumes
-

🛣️ Networks:
-
microservice-network - Connects all microservices.

postgres - Used for database-related services.

💾 Volumes:
-

postgres - Persistent PostgreSQL database storage.

pgadmin - Stores pgAdmin configurations.

❗ Notes
-----------------

Ensure all container images (vivek1006/...) exist or replace them with your own.

Modify docker-compose.yml if you need to change ports or configurations.

If a container fails to start, check logs with:

docker logs container_name
-

📜 License
-

This project is open-source and available for modifications.
-


