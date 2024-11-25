# E-Commerce Microservices Project

This project is an example of an e-commerce application built using microservices architecture. The application consists of microservices, each responsible for a specific domain of the e-commerce platform. All services have been containerized and converted into Docker images. All services and dependencies are brought up using Docker.

## Table of Contents
- [Getting Started](#getting-started)
  - [Installation](#installation)
  - [Architecture](#architecture)
- [Technologies](#technologies)
- [Docker Containers](#docker-containers)
- [Services](#services)
  - [Config Server](#config-server)
  - [Service Registry](#service-registry)
  - [API Gateway](#api-gateway)
  - [Customer Service](#customer-service)
  - [Product Service](#product-service)
  - [Review Service](#review-service)
  - [Order Service](#order-service)
  - [Payment Service](#payment-service)
  - [Notification Service](#notification-service)


# Getting Started
## Installation

1. Clone the repository:

```bash
git clone https://github.com/muratkistan/e-commerce-microservices-spring.git
```

2. Navigate to the main folder:

```bash
cd e-commerce-microservices-spring
```
3. Start application using docker-compose:

```bash
docker-compose up -d
```

## Architecture

The application follows a microservices architecture, where each service is independently deployable and scalable. The services are deployed on the same Docker network. They can discover each other using Docker service names and Eureka Service Registry. They communicate with each other using Apache Kafka and Feign Client.<br><br>
![e-commerce-diagram-Murat drawio1 svg](https://github.com/user-attachments/assets/6ec5caee-98d0-407b-b3d7-e5b0094b80e6)


## Technologies
- Java 17
- Spring Boot 3.3.5
- Spring Cloud 2023.0.3
- Netflix Eureka Service Registry
- Netflix Eureka Service Client
- Spring Cloud API Gateway
- Spring Cloud Config Server
- Spring Validation
- Zipkin
- Open Feign
- Apache Kafka
- PostgreSql
- Mongo DB
- Redis
- Elasticsearch
- Docker

## Docker Containers
Container Name | Expose Port Mapping |
--- | --- |
config-server | `8888`
service-registry | `8761`
api-gateway | `8020`
customer-service | `8090`
product-service | `8050`
review-service | `8030`
notification-service | `8040`
order-service | `8070`
payment-service | `8060`
ms-postgre | `5433`
ms-pgadmin | `5050`
ms-mongo | `27018`
mongo-express | `8081`
ms-redis | `6379`
ms-zipkin | `9411`
ms-kafka | `9092`
ms-elasticsearch | `9200`
kibana | `5601`


## Services

### Config Server
The Config Server is responsible for managing the configuration of all microservices in the application. It provides a central place to manage external properties for applications across all environments.

### Service Registry
The Service Registry is responsible for registering and discovering microservices in the application. It allows services to find and communicate with each other without hardcoding their locations.

### API Gateway
The API Gateway handles routing, security, and load balancing for the microservices. It acts as a single entry point for all client requests.

### Customer Service

The Customer Service is responsible for managing customer information within the e-commerce platform. It allows clients to create, update, delete, and view customer details.

#### Technologies
- Spring Boot
- MongoDB

#### Endpoints
| Http Methods | Endpoints               | Explanations                       |
| :--------    | :-------                | :--------------------------------  |
| GET          | `/api/v1/customers`            | Fetch all customers                |
| GET          | `/api/v1/customers/{id}`       | Fetch customer by ID               |
| POST         | `/api/v1/customers`            | Create a new customer              |
| PUT          | `/api/v1/customers/{id}`       | Update customer information        |
| DELETE       | `/api/v1/customers/{id}`       | Delete customer by ID              |
| GET          | `/api/v1/customers/exists/{customerId}` | Check if customer exists by ID |

### Product Service

The Product Service is responsible for managing product information within the e-commerce platform. It allows clients to create, update, delete, and view product details. The service also uses Redis to cache product listings for improved performance. Additionally, it uses a scheduled task to periodically update the cache.

#### Technologies
- Spring Boot
- PostgreSQL
- Redis

#### Endpoints
| Http Methods | Endpoints                  | Explanations                       |
| :--------    | :-------                   | :--------------------------------  |
| GET          | `/api/v1/products`                | Fetch all products                 |
| GET          | `/api/v1/products/{id}`           | Fetch product by ID                |
| POST         | `/api/v1/products`                | Create a new product               |
| PUT          | `/api/v1/products/{id}`           | Update product information         |
| DELETE       | `/api/v1/products/{id}`           | Delete product by ID               |
| POST         | `/api/v1/products/purchase`       | Purchase a product                 |
| GET          | `/api/v1/products/exists/{productId}` | Check if product exists by ID  |



### Review Service

The Review Service is responsible for managing product reviews within the e-commerce platform. It allows clients to create, update, delete, and view reviews for products. This service communicates with both the Customer Service and Product Service. Elasticsearch is used for fast text-based search capabilities.

#### Technologies
- Spring Boot
- Elasticsearch
- Feign Client

#### Communication
- Communicates with Customer Service
- Communicates with Product Service

#### Endpoints
| Http Methods | Endpoints                       | Explanations                       |
| :--------    | :-------                        | :--------------------------------  |
| GET          | `/api/v1/reviews`               | Fetch all reviews                  |
| POST         | `/api/v1/reviews`               | Create a new review                |
| GET          | `/api/v1/reviews/search`        | Search reviews by content          |
| GET          | `/api/v1/reviews/product/{productId}` | Fetch reviews by product ID  |


### Order Service

The Order Service is responsible for managing orders within the e-commerce platform. It allows clients to create, update, delete, and view order details. This service communicates with the Customer Service, Product Service, and Payment Service. Orders are sent to Apache Kafka for processing. Additionally, it contains an OrderLine service to manage order line items.

#### Technologies
- Spring Boot
- PostgreSQL
- Apache Kafka
- Feign Client

#### Communication
- Communicates with Customer Service
- Communicates with Product Service
- Communicates with Payment Service
- Sends orders to Apache Kafka

#### Endpoints
| Http Methods | Endpoints                       | Explanations                       |
| :--------    | :-------                        | :--------------------------------  |
| POST         | `/api/v1/orders`                | Create a new order                 |
| GET          | `/api/v1/orders`                | Fetch all orders                   |
| GET          | `/api/v1/orders/{orderId}`      | Fetch order by ID                  |
| GET          | `/api/v1/orderlines/order/{orderId}` | Fetch order lines by order ID  |



### Payment Service

The Payment Service is responsible for managing payments within the e-commerce platform. It allows clients to process payments for orders. This service communicates with other services using Feign Client and sends completed payment information to Apache Kafka.

#### Technologies
- Spring Boot
- PostgreSQL
- Apache Kafka
- Feign Client

#### Communication
- Sends completed payments to Apache Kafka

#### Endpoints
| Http Methods | Endpoints                  | Explanations                       |
| :--------    | :-------                   | :--------------------------------  |
| POST         | `/api/v1/payments`         | Process a new payment              |
| GET          | `/api/v1/payments/{paymentId}` | Fetch payment by ID             |
| DELETE       | `/api/v1/payments/{paymentId}` | Delete payment by ID            |



## Notification Service

The Notification Service is responsible for managing notifications within the e-commerce platform. It consumes messages from Apache Kafka related to orders or payments, writes them to the database, and sends email notifications to users.

#### Technologies
- Spring Boot
- MongoDB
- Apache Kafka

#### Communication
- Consumes messages from Apache Kafka

#### Endpoints
This service does not expose any REST endpoints as it functions as a Kafka consumer. It listens for order and payment messages from Kafka, saves them to MongoDB, and sends email notifications to users








