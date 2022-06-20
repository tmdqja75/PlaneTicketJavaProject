# PlaneTicketJavaProject

# 자바 프로젝트(6/20 ~ 6/26)

팀장 : 이정호

주제 : 비행기 티켓 예매 기능

# 기능 구현(상세 기능)

## 항공사

- 비행편 취소, 등록, 수정
- 마일리지

## 여행사

- 여행상품 출력
- 패키지 상품
- 구매자 리스트
- 예약 취소, 수정

## 소비자

- 항공편 예약
- 여권발급
- 결제

## 공항

- 수하물 관리
- 면세점
- 항공편 정보

## 결제

- 결제수단
- 마일리지?
- 

# 테이블 구현

## 항공편

- 비행기 번호(PK) - int
- 시간 - datetime
- 국가명 - String
- 좌석 정보 - String
- 잔여석 - int
- 운행사 - String
- 해외 / 국내 여부 - boolean

## 소비자

- 결제자 id(PK)(FK - 여권 번호) - String
- 결제한 여행사 - String
- 금액 - int
- 결제 여부 - boolean
- 날짜 - datetime
- 여행지 - String
- 비행기 번호(FK) - int
- 마일리지 - int
- 예매 번호 - String
- 수하물 여부 - boolean
- 호텔 숙박 예약 여부 - boolean
- 여권 소유 여부 - boolean

## 여권

- 여권 번호(PK) - String
- 결제자 이름 - String
- 생년월일 - Date
- 

## 면세점

- 구매자 id(PK)(FK) - String
- 상품명 - String
- 브랜드 - String
- 가격 - int
- 수량 - int
-
