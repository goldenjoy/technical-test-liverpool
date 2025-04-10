# 🚀 API de Gestión de Ususarios y Pedidos

Aplicación Spring Boot con PostgreSQL y MongoDB para operaciones CRUD de usuarios y pedidos, diseñada para Docker.

## 📋 Requisitos Previos
- Java 17
- Docker
- Maven
- Postman (para pruebas)

## 🛠️ Configuración Inicial

### 1. Clonar el repositorio
```Terminal
git clone https://github.com/goldenjoy/technical-test-liverpool.git
cd technical-test-liverpool
```

### 2. Levantar PostgreSQL y Mongo con el docker-compose.yml
```Terminal
docker-compose up -d
```

## 📚 Endpoints API

| Método | Endpoint                             | Descripción                                           |
|--------|--------------------------------------|-------------------------------------------------------|
| GET    | `/api/v1/users`                      | Obtener todos los usuarios (PostgreSQL)              |
| GET    | `/api/v1/users/{id}`                 | Obtener usuario por ID (PostgreSQL)                  |
| POST   | `/api/v1/users`                      | Crear nuevo usuario (PostgreSQL)                     |
| PUT    | `/api/v1/users/{id}`                 | Actualizar usuario existente (PostgreSQL)            |
| DELETE | `/api/v1/users/{id}`                 | Eliminar usuario (PostgreSQL)                        |
| GET    | `/api/v1/orders`                     | Obtener todos los pedidos (PostgreSQL)               |
| GET    | `/api/v1/orders/{id}`                | Obtener pedido por ID (PostgreSQL)                   |
| POST   | `/api/v1/orders`                     | Crear nuevo pedido (PostgreSQL)                      |
| PUT    | `/api/v1/orders/{id}`                | Actualizar pedido existente (PostgreSQL)             |
| DELETE | `/api/v1/orders/{id}`                | Eliminar pedido (PostgreSQL)                         |
| GET    | `/api/v1/mongo/users`                | Obtener todos los usuarios (MongoDB)                 |
| GET    | `/api/v1/mongo/users/{id}`           | Obtener usuario por ID (MongoDB)                     |
| POST   | `/api/v1/mongo/users`                | Crear nuevo usuario (MongoDB)                        |
| PUT    | `/api/v1/mongo/users/{id}`           | Actualizar usuario existente (MongoDB)               |
| DELETE | `/api/v1/mongo/users/{id}`           | Eliminar usuario (MongoDB)                           |
| GET    | `/api/v1/mongo/orders`               | Obtener todos los pedidos (MongoDB)                  |
| GET    | `/api/v1/mongo/orders/{id}`          | Obtener pedido por ID (MongoDB)                      |
| POST   | `/api/v1/mongo/orders`               | Crear nuevo pedido (MongoDB)                         |
| PUT    | `/api/v1/mongo/orders/{id}`          | Actualizar pedido existente (MongoDB)                |
| DELETE | `/api/v1/mongo/orders/{id}`          | Eliminar pedido (MongoDB)                            |

## 🧪 Pruebas con Postman
cd docs\postman_collection