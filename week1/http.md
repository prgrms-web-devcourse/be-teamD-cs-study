# HTTP

## HTTP( HyperText Transfer Protocol )

### HTTP란?

- 웹 서버와 클라이언트 간의 통신을 하기 위해 사용되는 프로토콜을말한다.

### HTTP 특징

1. 클라이언트/서버 통신 모델을 따른다.

   ![Untitled 2](https://user-images.githubusercontent.com/78334008/129329247-52f977e4-a784-4177-977d-9de48b862009.png)

   1. 클라이언트는 서버에게 Request을 보내고 응답을 받을떄까지 대기한다.
   2. 서버는 요청에 대한 결과를 만들어서 Response를 보낸다.

2. 무상태(Stateless) 프로토콜을 지향한다.

   - Stateful

     - 클라이언트와 서버간에 송/수신을 하며 단계별 과정을 진행하는데
       서버에서 클라이언트가 이전 단계에서 제공한 값을 저장하고 다음 단계에서도 저장한 상태인 것
     - 예제

       ```markdown
       클라이언트: 변수 A에는 10을 넣어줘.
       서버A: 변수A에 10을 넣겠습니다.

       클라이언트: 변수 B에는 20을 넣어줘.
       서버A: 변수 B에 20을 넣겠습니다.

       클라이언트: 변수A와 B의 합은 뭐야?
       서버A: 10 입니다.
       ```

     - 단점

       - 해당 서버가 죽으면 이전 클라리언트의 상태를 아는 서버가 없기 때문에 바로 장애가 터짐

         ```markdown
         클라이언트: 변수 A에는 10을 넣어줘.
         서버A: 변수A에 10을 넣겠습니다.

         --서버A 다운으로 서버B로 교체--

         클라이언트: 변수 B에는 20을 넣어줘.
         서버B: 변수 B에 20을 넣겠습니다.

         클라이언트: 변수A와 B의 합은 뭐야?
         서버B: 변수의 합을 계산할 수 없습니다.
         ```

       - Scale Out이 힘듬 → 한 서버가 여태 통신한 클라이언트의 상태를 저장하고 있기 떄문에 그 서버가 바뀌면 통신 불가..

   - Stateless

     - 서버가 클라이언트의 상태를 보존하지 않는다. → 따라서 매번 클라이언트가 모든 데이터를 서버로 보냄
     - 예제

       ```markdown
       클라이언트: 변수 A에 10을 넣어줘
       서버A: 변수 A에 10을 넣겠습니다.

       --서버A 다운으로 서버B로 교체--

       클라이언트: 변수 B에는 20을 넣어줘.
       서버B: 변수 B에 20을 넣겠습니다.

       클라이언트: 변수A에 10을 넣고 변수 B에는 20을 넣고 곱을 계산해줘?
       서버C: 변수의 합은 200입니다.
       ```

     - 장점 = Scale out에 용이하다.
     - 단점 = 클라이언트에 추가 데이터가 많아진다.

3. 비연결성

   - Request, Response를 받으면 현재 연결을 끊어버림
     ( 필요한 데이터만 주고받고 연결을 끊어버림 )
   - 장점
     - 연결을 유지하는데에도 자원이 듬 → 연결을 유지하지 않으니 최소한의 자원으로 데이터 통신 가능
   - 단점

     - 매번 TCP/IP 연결을 맺기 위해 3-way-handshaking을 해야함 → 매번 연결시간이 추가로듬

       ![Untitled 3](https://user-images.githubusercontent.com/78334008/129329374-42a71713-cf8a-436a-9365-4de7120ad5f7.png)

       → 현재는 HTTP 지속 연결(Persistent Connections)를 사용해서 이 문제를 해결

       ![Untitled 4](https://user-images.githubusercontent.com/78334008/129329396-0577e76e-8497-418e-aadf-4778b10df5cb.png)

4. 데이터를 HTTP 메시지에 담아서 전송한다.

### HTTP 메세지

![Untitled 5](https://user-images.githubusercontent.com/78334008/129329447-8ac28e6c-abd6-4a5f-bbf9-2d6021d1e8ec.png)

- HTTP 메시지는 Request와 Response 두가지 종류로 나누어 진다.

- 메시지 구조

  - 시작라인 : 요청 메시지에서는 서버에 무엇을 해야할지, 응답 메시지\ 에서는 그 결과가 어땠는지 알려줍니다

    - 요청 시작줄

      ```
      GET /order-new HTTP/1.1
      [HTTP 메소드] [요청 URL Path] [HTTP 버전]
      ```

      1. HTTP 메소드 : 서버가 어떤 종류의 행동을 하길 원하는지 명시함
      2. 요청 URL Path : Host 헤더를 기준으로 요청하는 url의 path를 명시하는 부분
      3. HTTP 버전 : 현재 사용된 HTTP의 버전을 명시함

    - 응답 시작줄

      ```
      HTTP/1.1 200 OK
      [HTTP 버전] [상태코드] [상태 메시지]
      ```

      - 상태코드 : Client가 보낸 요청에 대한 처리상태를 표현하는 것
      - 상태 메시지 : 상태코드에 대한 의미를 한단어로 표현한 것

  - HTTP 헤더 : HTTP 전송에 필요한 모든 부가정보를 표현한다.
    ( 공식문서 : [https://en.wikipedia.org/wiki/List_of_HTTP_header_fields](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields) ) - Content-Type: 데이터의 표현 형식을 결정 - ex) text/html; charset=utf-8, application/json - Content-Encoding: 데이터의 인코딩 방식을 결정 - 데이터를 전달하는 곳에서 인코딩 후 인코딩 헤더 추가 - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 디코딩 - Location : 리다이렉션 할 페이지 URL을 결정

  - HTTP 바디 : 실제 전송할 데이터가 들어간다.

### HTTP 메서드

- HTTP 메시지가 어떤 행위를 할지 표현함 ( 클라이언트가 서버에게 뭔가 요청을 할 때 기대하는 행동 )
- 종류

  1. GET

     - URI에 있는 자원을 요청함 ( 리소스 조회 )
     - 서버에 전달할 데이터는 쿼리 스트링을 통해서 전달

       ```
       http://www.example.com?key1=value1&key2=value2
       ```

     - 메시지 바디를 통한 데이터 전달도 가능! → But, 지원하지 않는 서버가 많아서 권장하지는 않음

  1. POST

     - 내가 전달하는 데이터를 "처리" 해줄 것을 요청함 ( 주로 신규 등록에 사용 )
     - 메시지 바디를 통해 데이터 전달

       ![Untitled 6](https://user-images.githubusercontent.com/78334008/129329541-497b3f69-c339-4564-919c-eaf9c7bb463c.png)

     - 요청데이터를 어떻게 처리한다는 거지? → 생성? 수정? 삭제? → 정해진 것 없음

       - 새 리소스 등록
       - 단순히 생성, 변경을 넘어서 어떤 프로세스를 처리하는 것

         ex) 주문 요청 시, 주문상품 등록(신규등록) → 주문상태 변경(수정) → 주문상태 반환(조회) 를 한번에 처리해야 할 경우

       - 다른 메서드로 처리하기 애매한 경우

  1. PUT

     - 리소스 전체에 대한 변경을 요청함
     - 주의사항!
       - 기존 리소스가 있으면 리소스를 완전히 대체
         ( 기존 리소스를 삭제하고 보낸걸로 갈아끼움 )
       - 기존에 변경을 요청한 리소스가 없으면 → 새로 생성

  1. PATCH

     - 리소스의 부분 변경을 요청함

  1. DELETE
     - 리소스 제거를 요청함

> 참고 : [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)
