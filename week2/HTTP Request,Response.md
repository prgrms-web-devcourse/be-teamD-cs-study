## HTTP 
- 서버와 클라이언트 간에 데이터가 교환되는 방식
- 요청(request)은 클라이언트가 서버로 전달해서 서버의 액션이 일어나게 하는 메시지
- 응답(response)은 요청에 대한 서버의 메시지



먼저 쉬운 이해를 위해 127.0.0.1에 접속한다. 

![](https://images.velog.io/images/eunseo2/post/3a393ce6-4027-460c-98f9-ef4400172271/image.png)

### 요청(request) 헤더
![](https://images.velog.io/images/eunseo2/post/52c49907-a89b-485e-bb95-9cc4012c5218/image.png)

![](https://images.velog.io/images/eunseo2/post/11415bf3-a591-4611-9c80-550c011fbb89/image.png)

RequestLine : GET 방식(데이터를 가져올 때 사용)이며 웹브라우저가 사용하는 통신방법은 HTTP 1.1이다. 

Host : 웹 브라우저가 어떤 웹 서버의 주소로 접속했다는 것을 알려준다.

Connection :  keep-alive면, 연결은 지속되고 끊기지 않으며, 동일한 서버에 대한 후속 요청을 수행할 수 있다는 것을 의미한다. 

User-Agent : 웹브라우저의 다른 표현이다. ()안을 보면 사용하고 있는 운영체제에 대한 정보이다. 
ex) 로봇이 접근할 때 이 User-Agent를 보고 그 요청을 차단할 수 있다. 

Accept-Encoding : 응답하는 데이터의 양이 많을 경우 압축해서 전송하면 웹 브라우저가 압축을 풀어서 처리한다. -> 네트워크 자원을 아낄 수 있다. 이 웹 브라우저는 gzip,deflate, br 방식을 지원하는 것을 볼 수 있다. 

If-Modified-Since : 이 파일을 마지막으로 다운로드 받은 시각이다. 웹 서버 응답을 해줄 때 최신이 아니면 보내주지 않아도 되는 것을 의미한다. 

### 응답(response) 헤더
![](https://images.velog.io/images/eunseo2/post/97864a43-2ec3-4f3f-8a4c-84cf5ea825cb/image.png)

phrase는 응답 결과를 사람이 이해하기 쉽도록 말로 풀어쓴 것이다. 

![](https://images.velog.io/images/eunseo2/post/2d17151d-0cf5-48f6-ae88-4a30b2d8c775/image.png)


웹서버는 HTTP 1.1로 통신하며, 200은 성공적으로 데이터를 찾아서 보내준다는 의미이다. 

Content-Encoding : 이 컨텐츠는 gzip 방식으로 압축함을 의미한다. 

Content-Length : 이 컨텐츠의 길이가 전체 길이가 1289byte라는 의미이다. 

keep-Alive : 연결에 대한 타임아웃과 요청 최대 개수에 대한 정보이다. 타임아웃은 5초이며, 요청은 100개 까지 할 수 있다. 

Content-Type: 웹 서버가 웹 브라우저한테 응답하는 정보가 text이고 text중 html이다라는 것을 알려준다. 


Last - modified : 이 정보는 마지막으로 언제 수정됬는지를 보여줌.

### 응답(response) 바디
```
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Bitnami: Open Source. Simplified</title>
<link href="bitnami.css" media="all" rel="Stylesheet" type="text/css" />
</head>
<body>
<div id="container">
```

참고자료
https://developer.mozilla.org/ko/docs/Web/HTTP/Messages

https://gnaseel.tistory.com/23
