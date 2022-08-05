# matching

## Back-end

### Server 정보

### DB 정보

- DB S/W: MySQL 8
- IP: user08.169.56.100.104.nip.io
- Port: 30503
- 사용계정: admin/passw0d
- root password: passw0rd

### Swagger 정보


### 도커 이미지 수동 생성 및 배포
1. 도커 이미지 만들기
 - git clone https://github.com/kb40-match/matching.git -b main
2. Back-end 소스로 이동
 - cd ./matching/backend
3. mvn 빌드
 - mvn package -DskipTests
4. 도커 이미지 빌드
 - docker build -t matching . -f ../../../Dockerfile
5. 도커 이미지 확인
 - docker images
6. 도커 이미지에 태그 주기
 - docker tag matching rmsdud2435/kb40-matching:latest
7. 도커 이미지 확인
 - docker images
8. 도커 로그인
 - docker login
9. 도커 허브에 이미지 푸쉬
 - docker push rmsdud2435/kb40-matching:latest


## Font-end
