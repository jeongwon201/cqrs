# cqrs-polyglot | CQRS Polyglot

Domain Driven Design에 기초하여 CQRS 패턴을 적용한 CRUD 웹 어플리케이션

- Command Model은 H2 Database를, Query Model은 MongoDB를 사용하는 Polyglot Database 아키텍처를 적용
- Command Model과 Query Model의 데이터를 동기화하는 수단으로 Spring Framework에서 제공하는 Event 사용
