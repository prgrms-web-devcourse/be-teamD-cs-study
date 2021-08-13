# TCP/IP 4계층

![20210811-045402](https://user-images.githubusercontent.com/58318786/128926308-8fdb0c09-c387-49af-8063-ea07cbbda78c.jpg)

## TCP/IP 계층 vs OSI 계층
* TCP/IP 프로토콜이 OSI 모델보다 먼저 개발
* TCP/IP는 인터넷 개발 이후 계속 표준화되어 신뢰성이 높음, 실질적 통신 관련 / OSI 계층은 장비 개발과 통신 표준을 위해 사용됨
* 범용적으로 사용하는 TCP 프로토콜과 IP 프로토콜을 OSI 7계층 형식에 맞춰 더 추상화(간략화) 시킨 모델

## 4계층: 응용 계층
* OSI에서 세션, 표현, 응용 계층에 해당
* 송신
    * 실제 데이터를 응용 계층에 넘기기, 데이터 인코딩하고 통신준비
* 수신
    * 데이터 디코딩 -> 사용자에게 넘기기
- 주요 프로토콜

    |프로토콜|설명|
    |-|-|
    |HTTP|TCP 기반 프로토콜, 포트번호 80번 사용|
    |DNS|도메인명에 대한 호스트 정보 제공
    |FTP|파일 전송 프로토콜
    |SMTP|메일 송신 프로토콜
    |POP3|메일 수신 프로토콜
    |SNMP|네트워크 구성관리, 성능관리, 장비관리, 보안관리를 위하여 UDP상에 정의된 응용 계층 표준 프로토콜
    |Telnet|원격 터미널 접속할 때 사용하는 프로토콜, 포트번호 23번 사용

## 3계층: 전송 계층
* OSI에서 전송 계층 해당
* 통신 노드 간의 연결을 제어하고 **신뢰성** 있는 데이터 전송 담당
* 송신
    * 상위 계층 데이터에 TCP 헤더를 붙임
    * 데이터 크기 크면 최대 전송 단위(MTU, 해당 레이어가 전송할 수 있는 최대 프로토콜 데이터 단위)로 쪼갬 => **세그먼트**
    * 세그먼트 송신할 때마다 어떤 순서로 쪼개졌는지 알기 위해 sequence 번호가 TCP 헤더에 기록 ⏩ 네트워킹 상황 따라 수신지에 도착하는 데이터의 순서가 바뀔 수 있기 때문, 패킷 누락 여부 확인
* 수신: TCP 헤더의 sequence 번호 검사 -> 누락 확인, 모두 수신될 때까지 대기 후 재조립
- 주요 프로토콜

    |프로토콜|설명|
    |-|-|
    |TCP|정확한 패킷의 전송을 보장
    |UDP|정확한 전송보다 빠른 속도의 전송이 필요한 멀티미디어 통신에서 사용

## 2계층: 인터넷 계층
* OSI에서 네트워크 계층 해당
* 데이터 단위: 패킷
* 송신
    * 통신 노드 간의 IP 패킷을 전송하는 기능과 라우팅 기능 담당
    * 세그먼트에 IP 헤더 붙임
* 수신
    * IP 헤더 검사 -> Destination IP 자신의 IP 주소와 일치하는지 비교 후 상위 계층으로 보냄
- 주요 프로토콜

    |프로토콜|설명|
    |-|-|
    |IP|비신뢰성, 비연결성 프로토콜
    |ARP| IP 주소로 MAC 주소를 알아오는 프로토콜
    |RARP|MAC 주소에 해당하는 IP 주소 알아오는 프로토콜
    |GARP|송, 수신 IP가 동일한 ARP 요청
    |ICMP|TCP/IP에서 IP 패킷 처리할 때 발생되는 문제를 알려주는 프로토콜

## 1계층: 네트워크 접속 계층
* OSI에서 물리, 데이터 링크 계층에 해당
* 데이터 단위: 프레임
* 송신
    * 패킷에 Ethernet 헤더와 Tail(FCS 붙음)
        * 이더넷: 랜에서 적용되는 규칙, 허브와 같은 장비에 연결된 데이터를 주고받을 때 사용
        * 헤더에는 송, 수신자의 물리적인 MAC 주소 담겨있음
        * FCS(Frame Check Squence): 데이터 전송 도중에 에러가 있는지 판별
* 수신
    * Ethernet 헤더 검사해서 Destination MAC 주소가 자신의 주소와 일치하는지 비교 후 상위 계층으로 보냄

# IP
- 주소
- HTTP 메시지 만들기 -> OS에 의뢰 -> 액세스 대상의 웹 서버에게 송신
- URL안에 쓰여있는 서버의 도메인명에서 IP 주소를 조사 -> why? OS에 송신을 의뢰할 때는 도메인 명이 아니라 IP 주소로 메시지를 받을 상대를 지정해야 하기 때문, 즉 데이터를 다른 네트워크의 목적지로 보내려면 IP주소가 필요
- 패킷(Packet)이라는 통신 단위로 데이터 전달
- IP 주소는 인터넷 서비스 제공자(ISP)에게 받을 수 있음 (통신사와 계약해서 사용)

## IP 프로토콜의 한계
- 비연결성
    - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송(보낸 사람은 모르는 상태)
- 비신뢰성
    - 중간에 패킷이 사라지면?
    - 패킷이 순서대로 안 오면?
* ⏩ TCP, UDP
- 프로그램 구분
    - 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면? (ex. 게임하면서 음악듣고 메세지 보내고...)
* ⏩ 포트 번호

# TCP
> 장비들 간의 통신 과정에서 정보를 안정적으로, 순서대로, 에러없이 교환할 수 있도록 하는 것에 목적을 둔 프로토콜
* 신뢰성 있는 데이터 통신 프로토콜
* 데이터 순차 전송을 보장
* 흐름 제어(Flow Control)
* 혼잡 제어(Congestion Control)
* 에러 감지(Error Detection)
* Connection 연결 (3 way handshake): 양방향 통신

## 왜 이런 방식?
* 패킷 교환 방식
Q: 전송 중간에 패킷이 쥐도새도 모르게 사라지거나 훼손되면 어떡해요?
A: 그럼 그 패킷만 다시 보내라고 해!(ARQ)

Q: 송신 측이 패킷을 쪼갠 순서를 알아야 수신 측이 재조립할 수 있겠는데요?
A: 그럼 순서번호를 패킷이랑 같이 보내!(시퀀스 번호)

Q: 수신 측이 처리할 수 있는 속도보다 송신 측이 패킷을 빠르게 보내버리면 어떡하죠?
A: 그럼 수신 측이 처리할 수 있는 양을 송신 측에 알려주고 그 만큼만 보내라고 해! (슬라이딩 윈도우)

## Segment
![image](https://user-images.githubusercontent.com/58318786/129299103-65936cf8-295f-4ea8-9290-0b0da0b7ba6d.png)

* TCP 프로토콜의 PDU(Protocol Data Unit)

## TCP Header
![image](https://user-images.githubusercontent.com/58318786/129299867-3d5d9fc7-0608-4bee-8f3c-fad270dbefd9.png)

### Source port, Destination Port
* 출발지, 목적지
* 포트 번호 나타내는 필드 존재
* IP 주소는 네트워크 계층에 있는 IP 헤더에 담김

### Sequence Number
* 전송하는 데이터의 순서 의미 (32bits)
* 수신자는 쪼개진 세그먼트의 순서 파악 가능, 올바른 순서로 데이터를 재조립
* 송신자가 데이터를 최초로 전송할 때 이 번호를 초기화

### Acknowledgement Number
* 승인번호: 데이터를 받은 수신자가 예상하는 다음 시퀀스 번호를 의미 (32bits)
* 다음에 보내줘야하는 데이터의 시작점을 의미

### Data Offset
* 전체 세그먼트 중에서 헤더가 아닌 데이터가 시작되는 위치가 어디부터인지를 표시
* 옵션 필드 길이가 가변적이라서 필요함

### Flags(NS ~ FIN)
* ACK(Acknowledgement): 필드에 값이 채워져있음을 알림
* RST(Reset): 이미 연결이 확립되어 Established 상태인 상대방에게 연결을 강제로 리셋해달라는 요청의 의미
* PSH(Push): 수신 측에게 이 데이터 최대한 빨리 전달해달라는 의미, 0일 때 수신 측은 자신의 버퍼가 다 채워질 때까지 기다림, 1일 때는 이 세그먼트 이후에 더 이상 연결된 세그먼트가 없음을 의미하기도 함
* SYN(Synchronize): 상대방과 연결 생성 시 시퀀스 번호의 동기화를 맞추기 위한 세그먼트임을 의미
* FIN(Finish): 상대방과 연결을 종료하고 싶다는 의미

### Checksum
* 데이터 송신 중 발생할 수 있는 오류 검출

### Options
* 가변적 -> 수신 측이 어디까지 헤더고 어디서부터 데이터인지 알기 위해서 오프셋 필드를 사용

<br>

---

> 참고: `tcpdump -c 10`

# 3 way handshake (Connection 성립)

![image](https://user-images.githubusercontent.com/58318786/128863927-da4d3864-c7a5-4f0e-bbf8-acbe85b5b99b.png)

- 논리적 연결을 의미함
- 물리적 연결은 중간의 수많은 서버가 어떨지 몰라서 확신할 수 없음
```
1. SYN 비트를 1로 설정해 패킷 송신
2. SYN, ACK 비트를 1로 설정해 패킷 송신
3. ACk 비트를 1로 설정해 패킷 송신
```

## TCP 데이터 전송 방식

```
1. Client가 패킷 송신
2. Server에서 ACK 송신
3. ACK를 수신하지 못하면 재전송
```

# 4 way handshake(Connection 해제)

![image](https://user-images.githubusercontent.com/58318786/129303585-88e3b490-f715-4905-99f4-e26e15379661.png)
> 이미지 출처: [블로그](https://steffen-lee.tistory.com/31)

```
1. 데이터를 전부 송신한 Client가 FIN 송신
2. Server가 ACK 송신
3. Server에서 남은 패킷 송신(일정 시간 대기, 서버가 남은 패킷 보내기)
4. Server가 FIN 송신
5. Client가 ACK 송신
```

## TCP의 문제점
* 신뢰성은 보장하지만 매번 connection -> 시간 손실 발생
* 패킷을 조금만 손실해도 재전송

## UDP 특징

![image](https://user-images.githubusercontent.com/58318786/129303999-e7daa2b4-86c9-474f-8b91-1824c0c5efe2.png)

- 사용자 데이터그램 프로토콜 (User Datagram Protocol)
- 과거에는 TCP를 많이하고 UDP는 깨져도 되는 것들(영상 스트리밍)을 주로 전송함 → 요즘은 TCP의 3 way handshake도 줄이기 위해 UDP를 사용하곤 함
- 하얀 도화지에 비유(기능이 거의 없음)
- 연결지향 X
- 데이터 전달 보증 X
- 순서 보장 X
⇒ 데이터 전달 및 순서가 보장되지 않지만 단순하고 빠름
- 정리
    - IP와 거의 같다 + PORT + 체크섬 정도(검증 데이터)만 추가
    - 애플리케이션에서 추가 작업 필요

### 참고
> 책 - [모두의 네트워크](http://www.yes24.com/Product/Goods/61794014)

> 책 - [성공과 실패를 결정하는 1%의 네트워크 원리](http://www.yes24.com/Product/Goods/90640081)

> 강의 - [인프런 - 모든 개발자를 위한 HTTP 웹 기본 지식
](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC)

> 강의 - [부스트코스 - 웹 백엔드](https://www.boostcourse.org/web326/lecture/58942/?isDesc=false)

> 강의 - [[10분 테코톡] 👨‍🏫르윈의 TCP UDP](https://www.youtube.com/watch?v=ikDVGYp5dhg)

> 블로그 - [[UDP, UDP Header] 개념잡기](https://rednooby.tistory.com/17)

> 블로그 - [TCP의 헤더에는 어떤 정보들이 담겨있는걸까?](https://evan-moon.github.io/2019/11/10/header-of-tcp/)

> 블로그 - [[Network] TCP/IP 모델 패킷 전송 과정](https://icarus8050.tistory.com/103)