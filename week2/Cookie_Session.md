[작성 링크](https://delirious-sock-4dc.notion.site/bae9053cb0c64299a4f16d8b81caa1c3)

# 쿠키와 세션? 먹는건가?

생성 일시: 2021년 8월 17일
태그: CS, Network

# 🤔 쿠키와 세션 왜 사용하지?

이를 이해하기 위해서는 HTTP 프로토콜의 특성을 먼저 알아야한다.

### HTTP의 특성

**비연결성(Connectionless)**

클라이언트가 요청을 하고 서버가 해당 요청에 응답 하게 되면 연결을 유지 하지 않고 바로 끊는 성질

**비상태성(Stateless)**

통신이 끝나면 상태 정보를 유지하지 않는 성질

![https://user-images.githubusercontent.com/75105213/130167647-f0472443-6263-48ce-866d-47fafbbd053c.png](https://user-images.githubusercontent.com/75105213/130167647-f0472443-6263-48ce-866d-47fafbbd053c.png)

이러한 특징 때문에 특정 **클라이언트가 서버에 여러번 요청을 보내더라도** 서버는 그 요청을 하나의 클라이언트에서 보냈다고 인식하지 않고 **매번 새로운 클라이언트에서 요청이 들어온다고 인식**한다.

원래대로라면 우리가 쇼핑몰에 로그인을 하고 장바구니에 옷을 담아도 페이지를 이동하면 로그인이 풀리고 장바구니에 담았던 옷이 사라지게 된다.

하지만 쿠키와 세션을 사용함으로써 이를 해결할 수 있다.

`**HTTP의 비연결성과 비상태성을 보완하여 서버와 클라이언트가 물리적으로 차단되어 있더라도 논리적으로 연결을 유지 시켜주는 기능을 하는 것이 바로 쿠키와 세션이다.**`

# 🍪 쿠키

클라이언트(브라우저) **로컬에 저장**되는 **키와 값**이 들어있는 **작은 데이터 파일**

- 쿠키는 서버를 대신해서 클라이언트 정보를 웹브라우저에 저장한다.
- 클라이언트가 요청을 보낼때 쿠키를 함께 보내서 서버가 클라이언트를 식별 할 수 있게 해준다.
- **심화 - 쿠키의 구조**

    ## 🏗️ 쿠키의 구조

    ```java
    Set-Cookie: name=value; expires=[Date]; domain=[Domanin]; path=[Path] [secure]
    ```

    - 쿠키는 `4개의 속성`과 `하나의 데이터`를 가지는 구조체
        - 데이터는 이름=값 쌍 구조
        - 속성은 expires, domain, path, secure
    - 웹서버는 Response에 Set-Cookie 헤더를 포함시키는 방식으로 쿠키를 설정

    ### expires 유효기간

    - 쿠키가 생성되면 기본적으로 브라우저가 종료될 때까지는 쿠키 사용가능
    - 유효기간을 지정하면 브라우저가 종료되어도 지정한 기간 동안 쿠키 사용가능. 기간이 지나면 소멸

    ### path 패스

    - 쿠키를 읽고 쓰는 권한을 설정하는 방법 중 하나
    - path를 지정 하지 않으면 쿠키는 쿠키를 생성한 웹페이지에서만 읽을 수 있음
    - path 항목을 지정해주면 해당 path 이하에서 쿠키를 공유할 수 있음

    **https://www.naver.com/blog/hello.html** 에서 생성한 쿠키를 **c1**이라고 하면
    **c1**은 **https://www.naver.com/blog/hello.html 에서만 읽을 수 있음**
    이때 path를 
    **path=/blog** 로 설정하면 **https://www.naver.com/blog** 모든 페이지에서 c1을 읽을 수 있고
    **path=/로** 설정하면 **https://www.naver.com/** 모든 페이지에서 c1을 읽을 수 있음

    ### domain 도메인

    - path의 확장 버전

    [[서블릿/JSP] 쿠키(Cookie)의 domain 속성 설명. 쿠키 전송 범위 설정하기](https://dololak.tistory.com/543)

    ### secure 보안

    - 쿠키의 전송 방법을 지정
    - 보통 HTTP를 사용. 안전하게 전송하려면 HTTPS 사용

![https://user-images.githubusercontent.com/75105213/129669530-b6efb479-e93a-4f1c-b5a8-ce9427d80d2a.png](https://user-images.githubusercontent.com/75105213/129669530-b6efb479-e93a-4f1c-b5a8-ce9427d80d2a.png)

크롬 웹브라우저 주소창의 자물쇠 표시를 눌러보자

![https://user-images.githubusercontent.com/75105213/129669533-ae0013b8-3197-4830-b559-1ebea48ed6cd.PNG](https://user-images.githubusercontent.com/75105213/129669533-ae0013b8-3197-4830-b559-1ebea48ed6cd.PNG)

현재 페이지의 쿠키 정보를 확인할 수 있다.

## 쿠키의 전달 과정

![https://miro.medium.com/max/700/0*-O_EhIU-5TfsqOzO.PNG](https://miro.medium.com/max/700/0*-O_EhIU-5TfsqOzO.PNG)

                                        [https://miro.medium.com/max/700/0*-O_EhIU-5TfsqOzO.PNG](https://miro.medium.com/max/700/0*-O_EhIU-5TfsqOzO.PNG)

1. 클라이언트에서 Request시 웹 서버는 Set-Cookie Header에 쿠키 정보를 담아서 Response함
2. Response를 받은 클라이언트는 쿠키 정보를 저장
3. 클라이언트가 다시 Request할때는 저장되어 있는 쿠키 정보를 Cookie Header에 담아서 웹서버에 보냄

![https://user-images.githubusercontent.com/75105213/130166138-524ce20c-6ee9-4b0f-82d1-849532441c4b.png](https://user-images.githubusercontent.com/75105213/130166138-524ce20c-6ee9-4b0f-82d1-849532441c4b.png)

![https://user-images.githubusercontent.com/75105213/130166140-7a81560f-7741-4e97-b7e7-4054f1c87937.png](https://user-images.githubusercontent.com/75105213/130166140-7a81560f-7741-4e97-b7e7-4054f1c87937.png)

# 🔑 세션

쿠키가 클라이언트 측에 저장이 된다면, 세션 정보는 서버측에 저장이 된다.

## 세션의 전달 과정

보통 로그인을 유지할때 세션을 사용하는데 다음과 같은 전달 과정을 거친다.

![https://user-images.githubusercontent.com/75105213/130171170-0d69907a-6d2a-4a3b-a33a-fcc09446e57b.png](https://user-images.githubusercontent.com/75105213/130171170-0d69907a-6d2a-4a3b-a33a-fcc09446e57b.png)

1. 클라이언트가 로그인 정보를 포함하여 서버로 Request
2. 서버는 로그인 정보를 확인
3. 정보가 올바르면 서버는 세션을 생성하고 세션에 로그인 정보를 저장
4. 서버는 생성한 세션 아이디를 클라이언트에게 쿠키로 저장하도록 Response
5. 클라이언트는 쿠키로 세션 아이디를 저장
6. 클라이언트가 다시 Request시 세션 아이디를 담아서 보냄
7. 서버는 받은 세션 아이디를 통해 해당하는 세션을 찾고 사용자 정보를 확인함
- **심화 - JSP에서의 세션**

    ## 🧐 JSP에서의 세션

    ### 주인공 session 내장 객체

    JSP에서는 `session`이라는 미리 생성된 `내장 객체`를 사용하여 세션을 관리한다.

    **내장 객체란?**
    사용자가 객체를 생성하지 않고 바로 사용할 수 있는 객체
    JSP에서 제공되는 내장 객체는 JSP 컨테이너에 의해 Servlet으로 변환될 때 자동으로 객체가 생성된다.

    내장 객체는

    - **Attribute :** 공유되는 데이터인 속성
    - **Scope :** 속성을 공유할 수 있는 유효 범위 영역

    이란 개념을 가지고 있어서 각각의 영역에서 지정한 속성을 다른 페이지에서 동일한 값으로 사용이 가능하다.

    우리의 주인공 session 내장 객체는 `첫 요청부터 세션이 종료되는 시점까지를 영역`으로 가지고 있다. 그래서 세션이 살아있는 동안은 여러 페이지에서 session 내장 객체에 있는 속성을 공유하여 사용할 수 있다.

    [https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbty3g3%2FbtqB5hkdQ1c%2FCtAsPb7s7mYBhrp47L2QBk%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbty3g3%2FbtqB5hkdQ1c%2FCtAsPb7s7mYBhrp47L2QBk%2Fimg.png)

    [https://codevang.tistory.com/202](https://codevang.tistory.com/202)

    ### 코드로 보는 세션 동작 과정

    - **클라이언트에서 첫 요청을 하는 경우**

        위에서 JSP는 session 내장 객체를 사용한다고 했다.

        별다른 설정을 하지 않으면 첫 요청시 session 객체가 자동으로 생성되서 sessionId를 클라이언트로 response한다.

        이후에도 클라이언트가 sessionId를 보내면 이를 사용해 이미 생성되어 있는 session 내장 객체를 찾아준다.

        JSP의 session 속성을 false로 하면 내장 객체가 생성되지 않는데, 이때는 다음과 같이 직접 코드로 작성해서 session을 생성해야한다.

        ```java
        HttpSession session = request.getSession(true);
        String sessionId = ssession.getId();
        Cookie cookie = new Cookie("sessionId", sessionId);
        response.addCookie(cookie);
        ```

        이후에는 개발자가 세션 정보를 알맞게 저장한다.

        ```java
        //id : maenguin을 가져옴
        String id = requset.getParameter("id");
        //pw : 1234을 가져옴
        String pw = requset.getParameter("pw");

        //.. db 조회해서 로그인 정보 검사

        //session객체에 로그인 정보를 저장
        session.setAttribute("id",id);
        session.setAttribute("pw",pw);
        ```

    - **로그아웃 요청시**

        ```java
        //세션의 모든 속성 데이터가 제거됨
        session.invalidate();
        ```

    - **세션 검사**

        ```java
        //현재 세션의 속성 id 항목을 확인해서 null이면 세션이 만료되었다고 판단하고
        //로그인 페이지로 보냄
        String id = (String)session.getAttribute("id");
        if (id == null){
        	response.sendRedirect("로그인페이지로");
        }
        ```

# 🌓 쿠키와 세션 비교

[https://embed.notion-tools.com/block/table/?t=white&tb=%7C%EC%A0%9C%EB%AA%A9%7C%EC%BF%A0%ED%82%A4%7C%EC%84%B8%EC%85%98%7C%0A%7C%3A----%3A%7C%3A--%3A%7C%3A-----%3A%7C%0A%7C%EC%A0%80%EC%9E%A5%EC%9C%84%EC%B9%98%7C%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8%7C%EC%84%9C%EB%B2%84%7C%0A%7C%EC%A0%80%EC%9E%A5%ED%98%95%EC%8B%9D%7Ctext%7Cobject%7C%0A%7C%EC%9A%A9%EB%9F%89%EC%A0%9C%ED%95%9C%7C%EB%8F%84%EB%A9%94%EC%9D%B8%EB%8B%B9%2020%EA%B0%9C%2C%201%EC%BF%A0%ED%82%A4%EB%8B%B9%204KB%7C%EC%A0%9C%ED%95%9C%20%EC%97%86%EC%9D%8C%7C%0A%7C%EB%A7%8C%EB%A3%8C%EC%8B%9C%EC%A0%90%7C%EC%BF%A0%ED%82%A4%20%EC%A0%80%EC%9E%A5%EC%8B%9C%20%EC%84%A4%EC%A0%95(%EC%84%A4%EC%A0%95%20%EC%97%86%EC%9D%84%20%EC%8B%9C%EC%97%90%EB%8A%94%20%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%20%EC%A2%85%EB%A3%8C%EC%8B%9C%20%EB%A7%8C%EB%A3%8C)%7C%EC%84%B8%EC%85%98%20%EC%84%A4%EC%A0%95%20%EB%A7%88%EB%8B%A4%20%EB%8B%A4%EB%A6%84%7C](https://embed.notion-tools.com/block/table/?t=white&tb=%7C%EC%A0%9C%EB%AA%A9%7C%EC%BF%A0%ED%82%A4%7C%EC%84%B8%EC%85%98%7C%0A%7C%3A----%3A%7C%3A--%3A%7C%3A-----%3A%7C%0A%7C%EC%A0%80%EC%9E%A5%EC%9C%84%EC%B9%98%7C%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8%7C%EC%84%9C%EB%B2%84%7C%0A%7C%EC%A0%80%EC%9E%A5%ED%98%95%EC%8B%9D%7Ctext%7Cobject%7C%0A%7C%EC%9A%A9%EB%9F%89%EC%A0%9C%ED%95%9C%7C%EB%8F%84%EB%A9%94%EC%9D%B8%EB%8B%B9%2020%EA%B0%9C%2C%201%EC%BF%A0%ED%82%A4%EB%8B%B9%204KB%7C%EC%A0%9C%ED%95%9C%20%EC%97%86%EC%9D%8C%7C%0A%7C%EB%A7%8C%EB%A3%8C%EC%8B%9C%EC%A0%90%7C%EC%BF%A0%ED%82%A4%20%EC%A0%80%EC%9E%A5%EC%8B%9C%20%EC%84%A4%EC%A0%95(%EC%84%A4%EC%A0%95%20%EC%97%86%EC%9D%84%20%EC%8B%9C%EC%97%90%EB%8A%94%20%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%20%EC%A2%85%EB%A3%8C%EC%8B%9C%20%EB%A7%8C%EB%A3%8C)%7C%EC%84%B8%EC%85%98%20%EC%84%A4%EC%A0%95%20%EB%A7%88%EB%8B%A4%20%EB%8B%A4%EB%A6%84%7C)

[https://devuna.tistory.com/23](https://devuna.tistory.com/23)

**가장 큰 차이점은 `저장 위치`**

- 쿠키는 `클라이언트에 저장` 되기 때문에
    - 클라이언트의 리소스를 사용하여 서버의 자원이 절약된다.
    - 3자가 읽거나 변경 하기 쉬어 보안에 취약하다.
- 세션은 `서버에 저장` 되기 때문에
    - 서버의 리소스를 사용하여 세션이 많아지면 서버의 부담이 커진다.
    - 3자가 사용자 정보를 읽거나 변경할 수 없어서 쿠키 보다 안전하다.
