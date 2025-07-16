# 🛍️ 스프링부트 쇼핑몰 프로젝트 (parrotshop)

**포트폴리오용으로 제작된 기본적인 기능을 갖춘 쇼핑몰 웹 애플리케이션입니다.**

이 프로젝트는 Spring Boot, JPA, Spring Security 등 최신 백엔드 기술 스택을 활용하여 웹 쇼핑몰의 핵심 기능들을 구현한 결과물입니다. 사용자 및 관리자 기능, 인증/인가, 데이터베이스 설계, 그리고 실제 서비스 배포까지의 전 과정을 경험하며 학습하는 것을 목표로 했습니다.

<br>

## 🌟 주요 기능 (Key Features)

<table>
  <tr>
    <td align="center"><strong>로그인 / 회원가입</strong></td>
    <td align="center"><strong>상품 목록</strong></td>
    <td align="center"><strong>장바구니</strong></td>
  </tr>
  <tr>
    <td><img src="URL_TO_YOUR_SCREENSHOT_1" alt="로그인 화면" width="250"/></td>
    <td><img src="URL_TO_YOUR_SCREENSHOT_2" alt="상품 목록 화면" width="250"/></td>
    <td><img src="URL_TO_YOUR_SCREENSHOT_3" alt="장바구니 화면" width="250"/></td>
  </tr>
</table>

*   **회원 기능**
    *   JWT(JSON Web Token) 기반의 안전한 회원가입 및 로그인/로그아웃
    *   사용자 역할(USER, ADMIN)에 따른 API 접근 제어
*   **상품 기능**
    *   (관리자) 상품 등록, 정보 수정, 삭제 기능
    *   (사용자) 상품 목록 조회 (페이징 기능 포함), 상세 정보 조회
*   **장바구니 기능**
    *   장바구니에 상품 추가, 수량 변경, 삭제
    *   장바구니 목록 조회
*   **주문 기능**
    *   장바구니의 상품들을 기반으로 주문 생성
    *   주문 시 상품 재고 차감 (동시성 제어 적용)
    *   나의 주문 내역 조회 및 주문 취소

<br>

## 🛠️ 기술 스택 (Tech Stack)

### Backend
- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Data JPA**: ORM 기술
- **Spring Security**: 인증/인가
- **JWT (JSON Web Token)**: 토큰 기반 인증
- **Gradle**: 빌드 도구
- **Lombok**: 보일러플레이트 코드 제거
- **Validation**: 데이터 유효성 검증

### Database
- **PostgreSQL**
- **H2** (테스트 및 로컬 개발용)

### Frontend
- **Thymeleaf**: 서버 사이드 템플릿 엔진
- **HTML, CSS, JavaScript**

### DevOps
- **Docker**: 애플리케이션 컨테이너화
- **AWS EC2 / Elastic Beanstalk**: 클라우드 배포
- **GitHub Actions**: CI/CD (테스트 및 빌드 자동화)

<br>

## 🏛️ 아키텍처 및 데이터베이스 설계

### 시스템 아키텍처
이 프로젝트는 일반적인 **계층형 아키텍처(Layered Architecture)**를 따릅니다.
- **Controller Layer**: HTTP 요청을 처리하고 응답을 반환합니다.
- **Service Layer**: 핵심 비즈니스 로직을 처리하고 트랜잭션을 관리합니다.
- **Repository Layer**: 데이터베이스와의 통신(CRUD)을 담당합니다.
