# Port, Well Known Port

### Port 란?

- 현실세계에서 Port는 "항구"나 "공항" 이라는 뜻으로 외부세계와 접속 할 수 있는 관문을 의미한다.

  프로그램에서 Port는 전송한 데이터가 실제로 가야할 목적지가 어딘지 나타내는
  실제 접근할 프로세스의 관문을 의미한다.

### Port 번호의 역할

![Untitled](https://user-images.githubusercontent.com/78334008/129330381-3bc11dbc-cbba-4a9a-8dc9-8cf4b73d76a6.png)

> 우리는 특정 서버로 접근할떄 URL을 입력한다.  
> 그러면 URL을 통해 해당 서버가 있는 컴퓨터로 찾아오게 되는데  
> 서버에는 여러개의 프로그램이 동시에 실행되고 있어서 어느 프로그램이 내가 접근할 프로그램인지 알 수가 없다.  
> 여기서 Port 번호는 내가 접근할 프로그램에 들어가는 관문이 어디인지 알려준다.

### Port 번호 종류

- 0번 ~  1023번  : Well-known port, 잘 알려진 포트

  ![Untitled 1](https://user-images.githubusercontent.com/78334008/129330426-9bff0eec-9db1-4e21-bbde-5dae44783ae1.png)

  출처 : [https://captcha.tistory.com/5](https://captcha.tistory.com/5)

  - 특정 용도로 사용하기 위해 ICANN에서 지정한 포트번호를 말한다.

- 1024번 ~  49151번 : registered port, 등록된 포트

  ![Untitled 2](https://user-images.githubusercontent.com/78334008/129330465-c0bf1e67-e8eb-47c6-984d-567ec7b5673d.png)

  - ICANN에서 지정하지는 않았지만 사용자가 직접 ICANN에 등록을 요청할 수 있는 포트들을 말한다.

- 49152번 ~ 65535번 : dynamic port, 동적 포트
  - ICANN에서 관리하지 않는 포트번호를 말한다.
  - 누구나 등록 없이 사용할 수 있어서 특정 기관에서만 사용하는 사설 프로토콜에 적합하다.

> HTTP의 기본 포트는 80이라고 지정되어 있는데,
> 만약 SSH를 80으로 서비스 하면 어떻게 될까요? 잘 동작할까요?

    기본 포트로 지정되어 있지만 그건 IANA의 권고안일뿐 강제적으로 지정된것은 아닙니다.
    SSH를 80번포트로 지정한다해도 서비스는 되겠지만
    기존에 80번으로 세팅되어있는 HTTP와 포트 충돌이 날 수 있기 때문에
    SSH를 80 포트로 바꿀 경우 HTTP의 서비스 포트 또한 바꿔줘야 합니다.
