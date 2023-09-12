# DataBase
- 자료를 저장하는 곳
- 데이터를 정리하는 곳
- 저장한 자료를 찾는 곳

- 창고다
  - 종류는?
    - 의류 창고
    - 물류 창고
    - 식료품 창고
    - 냉동 창고
    - 보온 창고
## 종류
  - noSQL
    - 크게 정해진 규격이 없다.
    - MongoDB, Redis
  - SQL, RDBMS
    - 쓰려면 규칙에 맞춰야 한다.
    - 제대로 쓰려면 좀 어렵다.
    - Oracle, mySQL
    
## SQL
  - Language << DB랑 대화한다.
  - Structured Query Language

### 명령어
ex :변수 선언 int a;
  - 구조 생성 create
    - 구조 삭제 drop
    - 구조 수정(테이블) alter
    - 테이블 명 수정 rename
    -  
  
  - 데이터 삽입 insert
  - 데이터 수정 update
  - 데이터 삭제 delete
  - 데이터 선택 select  
  
  - 권한 부여 grant
  - 권한 삭제 revoke  
  
// #### 데이터 조작어, DML

### Type
  #### 원시 타입
  #### 숫자
    - Number = Integer | Short | Long
    - Float = Double | Float
  #### 문자
    - Char(acter) => 고정길이, max : 2000byte
    - VarChar2 (mySQL VarChar) => Char보다는 더 넣을 수 있다. 가변길이 용량이 변한다. max : 4000byte
    - Long = String => 길이에 대한 조건이 없다. max : 2gb
    - Clob => Long 보다 크다. 4gb
    - NChar => 유니코드 텍스트
    - NVarChar => 유니코드 텍스트    
    - NClob => 유니코드 텍스트
    
  #### 기타
    - Date => 날짜
    - Timestamp => 시간(기간)
  
테이블을 생성할거다 => create
이름, 타입, 데이터의 길이
Number(10) 10의 자리수까지만 넣을 수 있다. Number(10, 10) 뒤는 소수점 길이(Precision : 전체길이, Scale : 소수점 이후의 길이)
Float(10) => (Precision : 전체 길이)
Char(10) 0글자까지만 가능하다. 1글자 넣어도 10칸차지
VarChar(10) 1글자 넣으면 1칸차지
VarChar(10000) 4천바이트가 끝이라 무리다.
Long
   
  
## DB
 - 데이터를 어떻게 저장을 할까?
 - DataBase || Schema를 생성한다. create
 - DB에 속하는 테이블을 생성한다. create
 - 생성한 테이블에 데이터를 넣는다. insert
 - 생성한 테이블에서 데이터를 가져온다. select
 - 

## RDBMS
  - Relational DataBase Management System
  - 관계형 데이터 베이스
  
## 비관계형 데이터 베이스
  - noSQL
  
# JSON
  - 우리가 다루는 데이터(객체, 배열) => 문자열로 바꿔준다.
  - "안녕하세요, 저는 임입니다."
  - [안녕하세요, 저는 임입니다.] => "안녕하세요, 저는 임입니다."
  - ["안녕하세요", "저는 임입니다."]
  - { name : "임" } => { "name" : "임" }
  
