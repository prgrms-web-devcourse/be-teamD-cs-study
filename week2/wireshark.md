# Wireshark란?

![image](https://user-images.githubusercontent.com/58318786/130044949-4a2167cc-5d1c-4100-ad63-b6f707589b0e.png)

* 네트워크 패킷 캡쳐, 분석하는 오픈소스 도구
* 해킹, 보안 취약점 분석, 보안 컨설팅 등 여러 분야에서 사용
* 네트워크 상의 데이터인 패킷을 수신하여 저장
* 운영체제에서 지원하는 캡쳐 라이브러리 이용하여 수집

# Wireshark 설치 방법 - Ubuntu 20.04 기준

* 설치

```shell
$ sudo apt update
$ sudo apt get upgrade
$ sudo apt install wireshark
```

* 권한 설정 필요
```shell
$ sudo dpkg-reconfigure wireshark-common
$ sudo usermod -a -G wireshark $USER
$ gnome-session-quit--logout --no-prompt #로그아웃
```

* `sudo wireshark`로도 실행 가능

<br>

---

# Wireshark 전체 구조

![image](https://user-images.githubusercontent.com/58318786/130029948-9eae1db3-772b-44ee-984f-09bfc7daf968.png)

> 사진 출처: [By Software:The Wireshark teamScreenshot:Vulphere - Self-taken; derivative work, GPL](https://commons.wikimedia.org/w/index.php?curid=81692859)

* 캡쳐된 패킷들은 패킷 리스트 영역에 명시
* 상세 영역에 내용 기술
* 패킷들은 색깔 별로 구분해서 파악 가능
  * 색깔 분류 커스텀도 가능
* 특정 패킷을 마킹해서 마킹한 패킷만 모아서 보는 것도 가능

## 필터
### 패킷필터
* 메뉴 - Capture - Options
![image](https://user-images.githubusercontent.com/58318786/130029959-f859e4d6-60ce-4b09-9044-8c2f2824a0ea.png)

* 들어오는 패킷 자체를 필터링
  * 캡쳐 자체를 안하는 패킷들이 있기 때문에 놓치는 패킷이 발생할 수도 있음
* 주로 대용량으로 들어올 때 원하는 조건의 패킷만 캡쳐
* 필터 조건: 지정 ip, 포트, 프로토콜 등 다양한 조건을 논리 연산으로 조합해서 사용하는 것도 가능

### 화면필터
* Tool Bar 아래 책갈피 표시
* 다 캡쳐한 패킷들 중 보고싶은 것만 볼 때 사용
* 일단 모든 패킷을 다 캡쳐하기 때문에 부담이 클 수 있음

<br>

---

# 실습
## ❓ wireshark 설치하고 내가 만든 웹 애플리케이션으로 접속하는 패킷 캡처하여 분석해보기 

* 실습을 위해서 현재 구동중인 웹 애플리케이션으로 Postman을 통해 요청을 보내고 응답을 받는다.
* 해당 프로그램은 Apple OAuth를 활용해서 로그인하며 사진과 글을 첨부한 노트를 작성, 수정, 삭제할 수 있다.

### Apple OAuth 활용한 로그인 요청

![image](https://user-images.githubusercontent.com/58318786/130039394-dca285ee-5e7b-4d94-984d-da3e91ad6437.png)

* HTTP 요청 메서드: `POST`
* Request headers: `User-Agent PostmanRuntime`
* Authorization: 현재 인증 Bearer Token 정보
* Entity headers
  * `Content-Type` - 표현 데이터 형식: application/json -> 현재 jwtToken이 들어가있는 상태

### Apple OAuth 활용한 로그인 응답

![image](https://user-images.githubusercontent.com/58318786/130040547-761956bd-35c5-4f7e-a823-d751bc559eb6.png)

* HTTP 응답 상태 코드: 200 OK

### 노트 생성 요청

![image](https://user-images.githubusercontent.com/58318786/130043147-51def033-1765-47b2-915d-58df04a861af.png)

* 사진 파일 첨부 -> `multipart/form-data`

### 노트 수정 요청

![image](https://user-images.githubusercontent.com/58318786/130043402-55a64694-0bab-4687-af79-f3c3118e477f.png)

* `application/json` 형식으로 수정할 내용을 Request Boday에 넣어서 요청 -> 확인 가능

### TCP 헤더 Flag 변경 확인

![image](https://user-images.githubusercontent.com/58318786/130047834-31038713-a0ae-4dca-b2b6-39d5c6400487.png)

* ACK(Acknowledgement): 필드에 값이 채워져있음을 알림
* RST(Reset): 이미 연결이 확립되어 Established 상태인 상대방에게 연결을 강제로 리셋해달라는 요청의 의미
* PSH(Push): 수신 측에게 이 데이터 최대한 빨리 전달해달라는 의미, 0일 때 수신 측은 자신의 버퍼가 다 채워질 때까지 기다림, 1일 때는 이 세그먼트 이후에 더 이상 연결된 세그먼트가 없음을 의미하기도 함
* SYN(Synchronize): 상대방과 연결 생성 시 시퀀스 번호의 동기화를 맞추기 위한 세그먼트임을 의미
* FIN(Finish): 상대방과 연결을 종료하고 싶다는 의미
