# 브라우저와 웹서버가 상호작용하는 방법

## 기본적으로 HTTP를 통해 데이터 통신을 진행함

---

## HTTP를 통해 요청 → 응답

![image](https://user-images.githubusercontent.com/78334008/130063253-bbc1f03b-3071-49c3-8f8d-9574ec909f12.png)

1. 클라이언트는 URL을 통해 서버에게 Request을 보내고 응답을 받을떄까지 대기한다.
2. 서버는 요청에 대한 결과를 만들어서 Response를 보낸다.

### HTTP 통신의 단점

1. 요청을 보냈 을떄, 무조건 페이지가 바뀐다.

   ![image](https://user-images.githubusercontent.com/78334008/130063350-06ed0230-4466-455d-b1f3-3c96aab5bbc3.png)

1. 클라이언트의 요청이 있어야지만 응답을 보낸다. ( 단방향 통신 )
   - Client만이 Server로 연락할 수 있고 Server는 Client의 요청을 응답하는것만 가능

## 페이지 이동? → 그 대안으로 나온 Ajax

---

![image](https://user-images.githubusercontent.com/78334008/130063478-6c53b7c8-ceaa-424b-9e5e-774e730bffaa.png)

- URL을 통해 요청을 보낼때 마다 페이지가 이동되는 문제를 해결하기 위해 Ajax라는 기술이 나왔다.
- 동작방식
  1. 사용자가 이벤트를 발생
  2. 자바스크립트는 DOM을 사용해 필요한 정보를 구한뒤 XMLHttpRequest객체를 통해 웹서버 요청전달
  3. 웹 서버는 XMLHttprequest로 부터 요청을 처리한 후 결과를 XML이나 plain-text로 생성해 XMLHttpRequest에 전송
  4. 서버로 응답이 도착하면 XMLHttpRequest객체는 자바 스크립트에 도착사실을 알고 자바스크립트는 응답데이터와 DOM을 이용해 사용자 화면에 반영
- 즉, 페이지 이동 없이 요청에대한 응답 처리가 가능해졌다!

## 실시간 데이터 처리

---

### 문제

- 기존의 거의 모든 데이터 통신은 HTTP를 통해 진행되고 있다.
- 서비스가 고도화 되면서 클라이언트의 요청 없이 서버에서 클라이언트에게 데이터를 전달할 필요가 생겨났다. ex) Push
- 프로토콜을 아예 바꾸지 않는 이상 HTTP의 특성상 서버에서 클라이언트로 통신은 불가느

### HTTP로 해결할 방법이 없을까?

1. polling

   ![image](https://user-images.githubusercontent.com/78334008/130063626-6b981515-6067-49b8-9871-4bbd42215687.png)

   - 동작방식
     - 일정 시간 간격으로 Request를 계속 보고 응답을 받는다.
   - 특징
     - Request를 보내는 시간 간격을 늘리면 → 실시간 성이 떨어짐
     - Request를 보내는 시간 간격을 줄이면 → 서버에 통신 과부하가 발생..

2. Long Polling

   ![image](https://user-images.githubusercontent.com/78334008/130063705-c4dbc6db-8207-4a92-ba86-9d84fed55dd6.png)

   - 동작방식
     - 일정 시간 간격으로 Request를 계속 보내서 응답이 있을 때 까지 기다린다.
     - 서버는 요청에 대한 응답이 발생하면 응답을 보내고 연결을 끊는다.
     - 무한정 기다리지는 않고 Connection Time Out이 발생하면 다시 Request를 보낸다.
   - 특징
     - Polling에 비해 거의 실시간으로 데이터를 받을 수 있다.
     - Connection이 Time Out 전까지는 계속 연결되어 있어야 하기 때문에 트래픽이 많을 시 서버의 부담이 크다. ( 리소스 낭비 )

- Streaming

  ![image](https://user-images.githubusercontent.com/78334008/130063791-9e50e332-8001-4867-b788-a7a086f2c8e2.png)

  - 동작방식
    - 요청을 보내고 응답이 와도 그 연결을 끊지 않는다.
  - 특징
    - 정확한 실시간 데이터를 보장함
    - 통신이 없어도 연결을 계속 유지하기 때문에 서버 리소스 낭비가 심함
    - 서버 → 클라이언트로의 단방향 통신만 가능함

- 결론

  - 결국 단방향 통신이라는 HTTP의 한계를 벗어나지 못함
  - 그냥 서버에서 변경사항을 클라이언트에게 보내주면 될 뿐인데.. 통신 로직이 복잡해짐

  이런 꼼수에서 벗어나 정식으로 클라이언트 서버간 양방향 통신이 가능하게 하기 위해서 HTML5 표준의 일부로 webSocket이 만들어지게 되었다.

## Web Socket

- 정의

  - 브라우저와 웹서버간의 양방향 통신을 구현하기 위해 새로 만들어진 프로토콜을 말한다.
  - 서버와 클라이언트 간에 Socket Connection을 유지해서 언제든 양방향 통신 또는 데이터 전송이 가능하도록 한다.

- 동작방식

  ![image](https://user-images.githubusercontent.com/78334008/130063906-10e3ab66-ab53-4ad0-be72-fc5127ac10a8.png)

  1. 연결이 가능한지 HandShaking을 시작한다.

     1. HTTP로 웹소켓 연결이 가능한지 요청을 보냄

        ```java
        GET /chat
        Host: javascript.info
        Origin: https://javascript.info
        Connection: Upgrade
        Upgrade: websocket
        Sec-WebSocket-Key: Iv8io/9s+lYFgZWcXczP8Q==
        ```

        - Connection : 업그레이를 목적으로 하는 요청입니다.
        - Upgrade : client가 업그레이드 되길 원하는 프로토콜입니다.
        - Sec-WebSocket-Key : 브라우저에서 생성한 키입니다.

     2. 웹소켓 연결을 승인하면 웹소켓 연결 승인 Response를 보내고

        HTTP를 웹소켓 프로토콜로 바꾸는 protocol switching이 실행됨

        ```java
        101 Switching Protocols
        Upgrade: websocket
        Connection: Upgrade
        Sec-WebSocket-Accept: hsBlbuDTkk24srzEOTBUlZAlC2g=
        ```

        - Sec-WebSocket-Accept : Sec-WebSocket-Key 를 통해 생성된 Key

  2. WS(WebSocket)프로토콜을 사용하여 양방향 통신을 시작한다.
  3. UTF8로 인코딩된 페이로드를 0x00과 0xff 사이에 넣고 데이터를 주고 받는다
  4. Close Frame을 이용해 연결을 종료한다.

- 특징

  - 양방향 통신 : 한번 연결이 맺어지면 양방향으로 통신이 가능하다.
  - 실시간 네트워킹 제공 : 연결지향형 통신으로 Connection이 계속 연결되어 있기 떄문에 실시간 데이터 통신이 가능하가.

- 단점
  - 웹소켓을 지원하지 않는 브라우저들에서는 사용 불가
  - 커넥션을 유지하는데 서버 자원 소모가 큼
