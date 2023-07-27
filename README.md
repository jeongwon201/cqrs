# CQRS Pattern | Command Query Responsibility Segregation Pattern


<br />
<br />

## 1. CQRS 패턴이란 ?
CQRS는 데이터 저장소에 대한 읽기 및 업데이트 작업을 구분하는 패턴인 명령과 쿼리의 역할 분리를 의미합니다.  

애플리케이션에서 CQRS 를 구현하면 성능, 확장성 및 보안을 최대화할 수 있습니다.  
또한 유연성이 증가하여 시스템이 점점 진화하고 업데이트 명령이 도메인 수준에서 병합 충돌을 일으키지 않도록 할 수 있습니다.
<br />
<br />
<br />
<br />

## 2. CQRS 패턴을 왜 사용하나요 ?
CQRS 패턴을 사용하는 이유에 대해 알기 전에 기존 아키텍처의 한계에 대해 알아볼 필요가 있습니다.  
<br />

### 기존 아키텍처의 한계
![image](https://github.com/jeongwon201/cqrs/assets/81132541/ee59ccab-f3bf-4544-85e4-cf6703b17694)

기존 아키텍처는 데이터베이스를 쿼리하고 업데이트하는 데 동일한 데이터 모델을 사용합니다.  
이러한 형태의 아키텍처는 다음과 같은 문제를 발생시킵니다.  
> - 불필요한 작업에 의한 데이터의 읽기와 쓰기 표현 불일치 발생
> - 동일한 데이터 세트에서 작업을 병렬로 수행 시 데이터 경합 발생
> - 데이터 저장소와 데이터 액세스 계층에 가해지는 부하, 검색 쿼리의 복잡성으로 인한 성능 저하
> - 엔터티의 읽기, 쓰기 작업이 잘못된 컨텍스트에 데이터를 노출시킬 수 있어 보안 및 권한 관리의 어려움
<br />

이러한 문제점을 해결하기 위해 명령 모델과 쿼리 모델을 구분하여 사용하는 CQRS 패턴을 사용합니다.  
<br />
<br />
<br />
<br />

## 3. CQRS 패턴의 구현
CQRS 패턴은 데이터를 추가 및 업데이트 작업인 명령 작업과 데이터를 읽는 작업인 쿼리 작업을 서로 다른 모델로 구분합니다.  

명령 모델과 쿼리 모델은 다음과 같이 분리할 수 있습니다. (반드시 다음과 같이 분리해야 하는 것은 아닙니다.)
- Simple CQRS
- CQRS with separated persistance mechanisms
- CQRS with Event Sourcing
<br />

### Simple CQRS
![image](https://github.com/jeongwon201/cqrs/assets/81132541/ba38c6d7-e5a7-48c9-a40d-4adcdfd7b9a6)

Simple CQRS 는 단일 Data Store 에서 명령 모델과 쿼리 모델을 분리하는 방식입니다.  
단순한 구조인 만큼 구현 및 적용이 편하지만, 성능 저하의 문제점을 개선하지 못합니다.  

<a href="https://github.com/jeongwon201/cqrs/tree/main/seperated-model">Simple CQRS 예제</a>
<br />
<br />
<br />

### CQRS with Separated Persistance Mechanisms
![image](https://github.com/jeongwon201/cqrs/assets/81132541/0fb1247a-f18d-4f94-8875-9b001d37c81d)

Polyglot 아키텍처를 활용하여 하나의 시스템에서 두 개의 Data Store 를 사용하는 방식입니다.  

명령 모델 전용 Data Store 과 쿼리 모델 전용 Data Store 를 분리하여 사용합니다.  

명령 모델 전용 Data Store 에서는 오로지 쓰기, 수정 작업만 가능하며,  
쿼리 모델 전용 Data Stroe 는 읽기 작업만 가능하도록 구성합니다.  

이 두 Data Store 를 동기화하기 위해 Event 를 사용합니다.  
명령 모델 작업 시 이벤트를 게시함으로써 쿼리 모델에 데이터를 동기화 할 수 있습니다.  

이전 방식보다 구현이 복잡하지만, 성능 저하의 문제점을 해결할 수 있습니다.  

<a href="https://github.com/jeongwon201/cqrs/tree/main/polyglot">CQRS with Separated Persistance Mechanisms 예제</a>
<br />
<br />
<br />

### CQRS with Event Sourcing
![Event-Handler](https://github.com/jeongwon201/cqrs/assets/81132541/996ad758-398b-43e2-8581-49c2de138f35)

CQRS 패턴은 Event Sourcing 패턴과 함께 사용되는 경우가 많습니다.  

Event Sourcing 패턴이란, 간단히 설명해서 모든 명령 작업을 Event 로 취급하여 Event 를 기록하는 패턴입니다.  

이러한 방식은 구현 및 적용이 상당히 복잡하지만, 이전 아키텍처에서 발생하는 모든 문제점을 해결합니다.
