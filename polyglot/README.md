# CQRS - CQRS with Separated Persistance Mechanisms

Domain Driven Design 에 기초하여 CQRS 패턴 중 CQRS with Separated Persistance Mechanisms 방식을 적용한 웹 어플리케이션입니다.  

H2 Database 와 MongoDB 를 Polyglot 구조로 구성하였습니다.  

명령 모델은 H2 Database, 쿼리 모델은 MongoDB 를 이용하며,  
Spring 에서 제공되는 Event 클래스를 이용하여 두 Data Store 를 동기화합니다.  

> Language - Java 1.8  
> Framework - Spring Boot 3.1.0.
> API - JPA
> Database - H2 Database, MongoDB<br />
> Build Tool - Gradle<br />
