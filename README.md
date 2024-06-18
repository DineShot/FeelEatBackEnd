clone 시 application.yml 설정 필요

### Rules
1. 서버 응답은 ResponseEntity<ResponseDTO>를 원칙으로 함.
2. 에러를 응답할 때 try - catch로 관련 Exception 체크 혹은 custom exception 으로 http에 존재하는 코드로 반환해야함.
3. Controller 에서는 DTO만 다뤄야하고, Service에서만 Entity를 다뤄야함.
4. 공통 코드, 다른 팀원 코드 edit전 팀원에게 말해야함.
5. 버그를 해결하지 못할 때는 개인 branch에 push 후 issue를 상세하게 등록하고 팀원에게 알린다.

# PR 기능은 아직 없음

ERD 주소
https://www.erdcloud.com/d/mzj2qMK8ESkjy4mP3
