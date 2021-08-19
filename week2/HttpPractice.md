# HTTP Request / Response 헤더와 바디 분석 실습
> Ex. Github - Issue Tracker

## 전체 이슈 목록 - 열려있는 상태

![스크린샷, 2021-08-19 22-40-24](https://user-images.githubusercontent.com/58318786/130079228-2b1addf7-7e8f-49b1-8640-e267956998aa.png)

### **Request Headers**

![image](https://user-images.githubusercontent.com/58318786/130080749-3a6243b2-f5fe-461b-b229-63053a785378.png)

* Request URL: `https://github.com/suhyunsim/Algorithm_Practice/issues`
* Request Method: GET -> 전체 목록을 봐야하기 떄문

---

### **Response Headers**

![스크린샷, 2021-08-19 22-40-38](https://user-images.githubusercontent.com/58318786/130079287-69e49d43-2bf9-4876-94ad-02ba18f7c2e1.png)

![스크린샷, 2021-08-19 22-53-54](https://user-images.githubusercontent.com/58318786/130080981-201d1fdc-4b3f-4b91-a171-200c9e40fd3e.png)

* Status Code: 200 OK
    * GET 요청에 대한 응답이 200으로 온 상황

<br>

---

## 전체 이슈 목록 - 닫힌 이슈들만

![스크린샷, 2021-08-19 23-00-28](https://user-images.githubusercontent.com/58318786/130082177-47a13ae7-1fb7-424b-91f2-76d35e15e6a3.png)

### **Request Headers**

![스크린샷, 2021-08-19 23-00-43](https://user-images.githubusercontent.com/58318786/130082184-bbd39367-3c45-47bf-b07e-f96a9e353314.png)

* Request URL: `https://github.com/suhyunsim/Algorithm_Practice/issues?q=is%3Aissue+is%3Aclosed`
    * URL 에서 Request param 확인할 수 있음

<br>

---

## 이슈 생성

![스크린샷, 2021-08-19 23-06-50](https://user-images.githubusercontent.com/58318786/130083347-35583614-893f-4c63-8ba6-e569ececc0b4.png)

* Submit new Issue 버튼을 누르는 순간 POST 요청이 간다.
* 이슈가 생성된 후 이슈 화면으로 이동 -> Redirection 예상

* **Request Headers**

![image](https://user-images.githubusercontent.com/58318786/130085446-fc941a37-a747-4f88-a476-b6236140a6c1.png)

* Request URL: `https://github.com/suhyunsim/Algorithm_Practice/issues`

* Request Method: POST -> 이슈 생성을 POST로 요청
* 생성될 때 필요한 내용들은 Form Data에 담아서 요청

* **Response Headers**

![스크린샷, 2021-08-19 23-07-22](https://user-images.githubusercontent.com/58318786/130083722-f47a0a29-e6ce-4ac3-aaef-43a44056b25d.png)

![image](https://user-images.githubusercontent.com/58318786/130085027-2fca81ed-f990-421e-90f3-09ba49005c6b.png)

* POST 요청 후 생성된 이슈로 이동해야 하기 떄문에 Status Code가 302
* Response에는 redirection 될 location을 표시한다.
    * `https://github.com/suhyunsim/Algorithm_Practice/issues/169`
    * 169번 이슈로 이동하게끔 위치가 명시되어있음


<br>

---

## 이슈에 라벨 추가 & 삭제

![스크린샷, 2021-08-19 23-24-11](https://user-images.githubusercontent.com/58318786/130087267-95ad1f0a-240e-49bd-b881-c2d4c298e66c.png)

* 이슈에 여러 라벨을 추가하거나 삭제할 수 있음

![스크린샷, 2021-08-19 23-28-31](https://user-images.githubusercontent.com/58318786/130087362-3446e57b-0109-464a-b5af-a67041298504.png)

* 해당 상황이 발생할 때마다 위 형태의 요청과 응답이 발생하는 것을 알 수 있음

![스크린샷, 2021-08-19 23-31-34](https://user-images.githubusercontent.com/58318786/130087536-a6939e85-f384-4120-8986-a8feccb7d395.png)

![스크린샷, 2021-08-19 23-31-14](https://user-images.githubusercontent.com/58318786/130087554-617d0452-5ab3-42e9-a09f-1f5ef5051da9.png)

* Form Data를 확인해보면 라벨의 아이디들을 가지고 요청이 이루어짐

<br>

---

## 이슈 (코멘트) 수정

![스크린샷, 2021-08-19 23-34-51](https://user-images.githubusercontent.com/58318786/130087871-35175d94-0810-4d33-9129-3ed5468f447a.png)

![스크린샷, 2021-08-19 23-35-18](https://user-images.githubusercontent.com/58318786/130087971-d7a1c1e7-8829-4fe1-ba58-41290b0b9aac.png)

* 이슈를 수정하는 상황이 발생했을 때 POST 요청이 가고 200 응답을 확인할 수 있다.
<br>

---

## 이슈 삭제

![스크린샷, 2021-08-19 23-37-53](https://user-images.githubusercontent.com/58318786/130088445-8e45aa8d-81bb-4768-bb47-58938ddee202.png)

* 이슈를 삭제할 때 요청과 응답을 확인


* **Request Headers**

![image](https://user-images.githubusercontent.com/58318786/130089250-6d88f88f-df4d-4dd7-8b28-614d4cac096a.png)

* 삭제 요청이 POST로 전달된 것을 알 수 있음
> ❓ Form data의 method에 delete라고 나와있는 부분 확인

* **Response Headers**

![image](https://user-images.githubusercontent.com/58318786/130089652-3af371a6-b399-4df7-8760-dd51cd8a3f1b.png)

* 삭제 요청 후 전체 이슈 목록 화면으로 돌아가기 위해 302 응답이 오고 location에 명시된 곳으로 이동