# WorkSync-Represents-job-management-and-company-reviews.
📌 Overview
This project is a microservices-based Company Management System that includes services for managing companies, job postings, and reviews. It leverages:
✅ Spring Boot for service development
✅ Docker & Docker Compose for containerization
✅ PostgreSQL as the primary database
✅ Eureka Service Registry for service discovery
✅ API Gateway for request routing
✅ Zipkin for distributed tracing
✅ RabbitMQ for messaging between services

📂 Services and Components
🔹 1. Databases and Monitoring
🛢️ PostgreSQL (postgres) - Primary relational database
📊 pgAdmin (pgadmin) - Web-based UI to manage PostgreSQL
📡 Zipkin (zipkin) - Distributed tracing for microservices
📩 RabbitMQ (rabbitmq) - Message broker for event-driven architecture

🔹 2. Core Microservices
🗂️ Service Registry (servicereg) - Eureka-based service discovery
⚙️ Config Server (config-server-ms) - Centralized configuration management
🌐 API Gateway (gateway-ms) - Single entry point for routing API requests
🏢 Company Service (companyms) - Handles company-related operations
💼 Job Service (jobms) - Manages job postings
⭐ Review Service (reviewms) - Stores and manages reviews

🛠️ Prerequisites
Ensure you have the following installed before running the system:
🔹 Docker (latest version)
🔹 Docker Compose

🚀 Running the Application
To start all services in detached mode, run:

sh
Copy
Edit
docker-compose up -d
To stop all services, run:

sh
Copy
Edit
docker-compose down
To restart a specific service, run:

sh
Copy
Edit
docker-compose restart service-name
🌍 Accessing Services
🏷️ Service	🔗 URL	📝 Description
📊 pgAdmin	http://localhost:5050	PostgreSQL web interface
📜 Service Registry (Eureka)	http://localhost:8761	Microservice discovery
🌐 API Gateway	http://localhost:8084	Main API entry point
🔎 Zipkin Dashboard	http://localhost:9411	Microservice tracing
📩 RabbitMQ Dashboard	http://localhost:15672	Message queue admin panel
⚙️ Environment Variables
📌 Service	🔢 Port	🔧 Environment Variables
🛢️ postgres	5432	POSTGRES_USER=vivek, POSTGRES_PASSWORD=1234
📊 pgadmin	5050	PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org, PGADMIN_DEFAULT_PASSWORD=admin
📜 servicereg	8761	-
⚙️ config-server-ms	8080	SPRING_PROFILES_ACTIVE=docker
🌐 gateway-ms	8084	SPRING_PROFILES_ACTIVE=docker
🏢 companyms	8081	SPRING_PROFILES_ACTIVE=docker
💼 jobms	8082	SPRING_PROFILES_ACTIVE=docker, EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://servicereg:8761/eureka
⭐ reviewms	8083	SPRING_PROFILES_ACTIVE=docker
🔗 Networks and Volumes
🔄 Networks:

microservice-network: Connects all microservices.

postgres: Used for database-related services.

💾 Volumes:

postgres: Persistent PostgreSQL database storage.

pgadmin: Stores pgAdmin configurations.

📝 Notes
✅ Ensure all container images (vivek1006/...) exist or replace them with your own.
✅ Modify docker-compose.yml if you need to change ports or configurations.
✅ If a container fails to start, check logs with:

sh
Copy
Edit
docker logs container_name
📜 License
This project is open-source and available for modifications. 🚀


