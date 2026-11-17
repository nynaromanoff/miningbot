
# Price Hunter

Bot pessoal de monitoramento de preços desenvolvido com Java 21 e Spring Boot.

## Tecnologias

- Java 21
- Spring Boot 4.1.2
- Spring JDBC
- SQLite
- Telegram Bot API
- Maven

## Funcionalidades da base

- Persistência local com SQLite.
- Cadastro de produtos monitorados por URL.
- Consulta de produtos ativos.
- Agendamento de verificações.
- Envio de mensagens pelo Telegram.

## Configuração

Configure as variáveis de ambiente:

- TELEGRAM_BOT_TOKEN
- TELEGRAM_CHAT_ID

## Executar

```powershell
mvn spring-boot:run
```

## API

GET /api/v1/health

POST /api/v1/tracked-products

GET /api/v1/tracked-products

POST /api/v1/telegram/test

## Banco de dados

O arquivo SQLite é criado em:

data/price-hunter.db
