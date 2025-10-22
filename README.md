# ESG API — Gestão Sustentável (Spring Boot)

**Status:** Em construção (MVP).  
**Objetivo:** API REST para métricas ESG (Environmental, Social, Governance), com endpoints públicos inicialmente e autenticação nas próximas versões.

## Stack
- Java 17, Spring Boot 3
- Spring Web, Lombok, springdoc-openapi (Swagger)
- (Próximo) JPA + Banco de dados (Oracle/MySQL)
- Docker

## MVP (escopo inicial)
- `GET /api/health` → status do serviço
- `GET /api/projects` → retorno in-memory
- `POST /api/projects` → cria in-memory
- Swagger UI em `/swagger-ui.html`

## Roadmap
- [ ] MVP: health + CRUD in-memory + Swagger
- [ ] V1: persistência (JPA + Oracle/MySQL)
- [ ] V1.1: autenticação (JWT) e roles
- [ ] V1.2: Dockerfile + Docker Compose

## Contato

Portfólio: https://portfolio-gabriel-three.vercel.app/
Email: gabrielnavas2212@gmail.com

## Como rodar (quando o código estiver)
```bash
# compilar e executar
./mvnw spring-boot:run
# ou
mvn spring-boot:run

# Swagger
http://localhost:8080/swagger-ui.html
