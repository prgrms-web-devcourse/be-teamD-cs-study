## URI

### URI( Uniform Resouce Identifier )이란?

- Uniform Resource Identifier → 해석하면 **자원의 식별자**라는 뜻.
- 네트워크 상에서 자원을 식별하기 위한 문자열의 구성을 말한다.

### URI? URL? URN?

![Untitled](https://user-images.githubusercontent.com/78334008/129329128-df53fcaa-fdd2-45cc-b6f5-fca511866acc.png)

- URL과 URN은 URI의 하위 개념
- 자원을 식별한다는 목적은 같으나 서로의 식별 방식이 다르다.

  - URL ( Uniform Resource Locator ) : 자원의 위치로 식별

    ```
    http://www.school.com/grade/2
    ```

  - URN ( Uniform Resource Name ) : 위치 정보 없이 자원의 이름으로 식별 ( 잘 사용 안함 )

    ```
    urn : isbn : 1234567891234 (국제표준도서번호)
    ```

### URL 형식

```
scheme://[userinfo@]host[:port][/path][?query][#fragment]

http://www.example.com:80/path/to/myfile.html?key1=value1&key2=value2#SomewhereInTheDocument
```

- scheme

  ```
  http://www.example.com:80
  ```

  - 통신에 사용할 프로토콜을 지정한다.
  - 주로 http, https 프로토콜을 사용한다.

- userinfo

  - 어떤 서버들은 사용자 이름과 비밀번호를 요구하기도 한다고 한다.
  - URL에 사용자 정보를 인증해야 할 떄 사용 (거의 사용X)

- host

  ```
  http://www.example.com:80
  ```

  - 연결할 서버의 주소 (도메인명이나 IP 주소) 를 나타낸다.

- port

  ```
  http://www.example.com:**80**
  http://www.example.com ( 기본 포트는 생략 가능 )
  ```

  - 연결할 서버 프로세스의 포트번호를 나타낸다.
  - 기본포트로 접근한다면 포트번호 생략 가능 ( http는 80, https는 443 )

- path

  ```
  http://www.example.com:80/path/to/myfile.html
  ```

  - 서버상에 요청할 리소스 경로를 나타낸다.

- query

  ```
  http://www.example.com:80/path/to/myfile.html?key1=value1&key2=value2
  ```

  - URL을 통해 서버에 String형태로 전달할 데이터를 나타낸다. ( key=value 형태 )

- fragment

  ```
  http://www.example.com:80/path/to/myfile.html#SomewhereInTheDocumen
  ```

  - 자원 내에서 특정한 위치를 지정한다. ex) html 내부 북마크

    ![Untitled 1](https://user-images.githubusercontent.com/78334008/129329179-92bec0a3-2de8-4545-916d-4272aebab970.png)
