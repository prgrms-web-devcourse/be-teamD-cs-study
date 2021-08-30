  
## Blocking , Non-Blocking + (Sync,  Async)

# **Blocking , Non-Blocking**

## 1. Blocking
> 직접 제어할 수 없는 대상의 작업이 끝날 때까지 제어권을 넘겨주지 않는다.

![image](https://user-images.githubusercontent.com/43923432/131016105-d68ce446-c634-4a17-a9de-76fd5831b1f3.png)

<br />

## 2. Non-Blocking
> 직접 제어할 수 없는 대상의 작업 처리 여부와 상관이 없다.

![image](https://blog.kakaocdn.net/dn/bhUznB/btqLuC6OlaH/ywEXoqxvTnSzghPHktciKK/img.png)



### **정리**
> 다른 사람이 작업할때 내가 일을 처리할 수 있는 `제어권`(권한)이 있는지 없는지로 **Blocking과 Non-Blocking**으로 나눌 수 있습니다.


* * *


# **Synchronous 와 Asynchronous**

## 3. Synchronous(동기)
> 뜻 : 작업을 동시에 수행하거나, 동시에 끝나거나, 끝나는 동시에 시작함을 의미한다.<br />
> 호출되는 대상의 처리 완료 여부를 호출하는 자신이 신경을 쓴다.

![싱크](https://user-images.githubusercontent.com/43923432/131062129-693fd804-fd4c-4425-8f5a-fafeee9060d2.png)


<br />

## 4. Asynchronous(비동기)
> 뜻 : 시작, 종료가 일치하지 않으며, 끝나는 동시에 시작을 하지 않음을 의미한다.
> 호출되는 대상의 처리 완료의 여부를 호출 되는 대상이 신경을 쓴다.
 
![어싱크](https://user-images.githubusercontent.com/43923432/131062165-3b30c3f4-654a-43b4-93bd-fc60f13eb6c4.png)


* CallBack 함수?
  * CallBack 함수란 이름 그대로 나중에 호출되는 함수를 말한다.
  * 예시로는 자바스크립트의 이벤트 핸들러 처리가 있다.
``` javascript
<button id="button1" onclick="button1_click();">버튼1</button>
<script>
function button1_click() {
	alert("버튼을 눌렀습니다.");
}
</script>
```


### 정리
> 요청한 작업에 대한 결과를 돌려줄때 `순서와 결과에 관심`이 있는지 없는지로 판단할 수 있습니다.

* * *

## **4가지 조합**

![4가지조합표](https://user-images.githubusercontent.com/43923432/131020865-c1204a48-5bc4-4672-b36b-8f00295c6deb.png)

## 1. Blocking + Synchronous
> Blocking-Sync는 `함수B`가 바로 리턴(제어권X)하지 않고 작업이 완료되는 결과에 함께 `함수A`에게 전달 한다.


<p align="center"><img src="https://user-images.githubusercontent.com/43923432/131018079-5df71cd1-e8e8-4329-8175-6d21899adc44.png"></p>

* 사용 예시
  * JAVA의 입출력에 사용된다.
  * <img width="471" alt="javaIO" src="https://user-images.githubusercontent.com/43923432/131026344-44fea6d8-3589-4044-b287-0f65b1e3fbfc.png">
  * 제어권과 결과를 같이 받아서 처리한다.


## 2. Blocking + Asynchronous 
> Blocking-Async는 `함수B`가 바로 리턴(제어권X)하지 않고, 이 `함수A`는 작업 완료 여부를 신경쓰지 않는다.

<p align="center"><img src="https://user-images.githubusercontent.com/43923432/131019759-313be02e-ec14-42c4-8214-bcf75672b08c.png"></p>


* 사용 예시
  * Node.js 와 MySQL의 조합

## 3. Non-Blocking + Synchronous
> NonBlocking-Sync는 `함수B`가 바로 리턴(제어권O)하고, `함수A`는 작업 완료 여부를 신경쓰게 된다.

<p align="center"><img src="https://user-images.githubusercontent.com/43923432/131018051-64fe4d17-54de-485c-a7e1-cc48562c034a.png"></p>

* 사용 예시
  * message polling 방식
  * `카카오톡`과 같은 채팅방에서 많이 사용한다. 
  

## 4. Non-Blocking + Asynchronous
> NonBlocking-Async는 `함수B`가 바로 리턴(제어권O)하고, 작업이 완료되면 결과를 `함수A`에게 전달한다. 

<p align="center"><img src="https://user-images.githubusercontent.com/43923432/131019643-c00633f8-ae49-47ab-82b6-0cf5cfeb1061.png"></p>


* 사용 예시
  * JAVA SCRIPT
  * API요청을 하고 다른작업을 하다가 callBack을 통해서 추가적인 작업을 처리할 떄 쓰인다. 

### 총 정리
* Blocking / Non-Blocking
  * `제어`의 관점
* Sync / Async 
  * `순서`와 `결과`의 관점 


*참고 사이트
  * https://www.youtube.com/watch?v=oEIoqGd-Sns
  * https://velog.io/@codemcd/Sync-VS-Async-Blocking-VS-Non-Blocking-sak6d01fhx
  * http://homoefficio.github.io/2017/02/19/Blocking-NonBlocking-Synchronous-Asynchronous/
  * https://www.slipp.net/questions/367
  * https://velog.io/@wonhee010/%EB%8F%99%EA%B8%B0vs%EB%B9%84%EB%8F%99%EA%B8%B0-feat.-blocking-vs-non-blocking
  * https://merry-nightmare.tistory.com/273
