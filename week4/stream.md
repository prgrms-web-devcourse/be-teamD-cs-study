> 참고:
책 - [Modern Java in Action](http://www.yes24.com/Product/Goods/77125987?OzSrank=1)

# Ch 4. 스트림 소개 & # Ch.5 스트림 활용

```java
List<Dish> lowCaloricDishes = new ArrayList<>(); //가비지
//1) filter
for (Dish dish : menu) {
    if (dish.getCalories() < 400) {
        lowCaloricDishes.add(dish);
    }
}
//2) sorted
Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
    @Override
    public int compare(Dish dish1, Dish dish2) {
        return Integer.compare(dish1.getCalories(), dish2.getCalories());
    }
});
//3) map -> 4) collect
List<String> lowCaloriesDishesNameBefore = new ArrayList<>();
for (Dish dish : lowCaloricDishes) {
    lowCaloriesDishesNameBefore.add(dish.getName());
}
//Stream으로 구현하면?
List<String> lowCaloriesDishesName = menu.stream()
        .filter(d -> d.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(Collectors.toList());
```

# 스트림이란?

* 자바 8 API에 새로 추가된 기능
* 스트림을 이용하면 선언형(데이터를 처리하는 임시 구현 코드 대신 질의로 표현할 수 있음)
* 데이터 컬렉션 반복을 *멋지게 처리*하는 기능
* 스트림을 이용하면 멀티스레드 코드를 구현하지 않아도 데이터를 투명하게 병렬로 처리 가능

# 스트림 API의 특징
![스크린샷, 2021-09-03 12-17-35](https://user-images.githubusercontent.com/58318786/131945582-8f669b0a-62e0-4b14-84e2-3f97613bc1ca.png)

<br>

# 정의
### **데이터 처리 연산**을 지원하도록 **소스**에서 추출된 **연속된 요소**
* 연속된 요소
  * 특정 요소 형식으로 이루어진 연속된 값 집합의 인터페이스를 제공
  * 컬렉션의 주제는 데이터, 스트림의 주제는 계산
* 소스
  * 컬렉션, 배열, I/O 자원 등의 데이터 제공 소스로부터 데이터를 소비
* 데이터 처리 연산
  * 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 데이터베이스와 비슷한 연산을 지원
* 파이프라이닝(Pipelining): 스트림 연산끼리 연결해서 커다란 파이프라인을 구성할 수 있도록 스트림 자신을 반환
  * -> 최적화 by 게으름(laziness), 쇼트서킷(short-circuiting)
* 내부 반복

<br>

---

# 스트림(Stream)과 컬렉션(Collection)

![스크린샷, 2021-09-03 12-17-51](https://user-images.githubusercontent.com/58318786/131945589-9dd408de-dfa2-41ed-94ec-fb9978e4b051.png)

* 둘 다 연속된 요소 형식의 값을 저장하는 자료구조의 인터페이스를 제공
* 데이터를 언제 계산하느냐가 큰 차이
## 컬렉션
* DVD에 저장된 영화
* DVD처럼 컬렉션은 현재 자료구조에 포함된 모든 값을 계산한 다음(적극적 생성) 컬렉션에 추가
* 컬렉션의 모든 요소는 컬렉션에 추가하기 전에 계산되어야 함
  * 컬렉션에 요소를 추가하거나 삭제하는 연산을 수행할 때마다 모든 요소를 메모리에 저장, 컬렉션에 추가하려는 요소는 미리 계산
## 스트림
* 인터넷 스트리밍하는 영화
  * 사용자가 시청하는 부분의 몇 프레임을 미리 내려받음 -> 다른 대부분의 값을 처리하지 않은 상태에서 미리 내려받은 프레임부터 재생 가능
* 필요할 때 값을 계산(게으른 생성)
* 한 번만 탐색할 수 있음
  * 탐색된 스트림의 요소는 소비됨

<br>

---

# 스트림의 연산

![스크린샷, 2021-09-03 12-18-00](https://user-images.githubusercontent.com/58318786/131945591-37d4c716-7685-46e8-a51e-7a4fa90aca42.png)

* 중간 연산
  * 다른 스트림을 반환
  * 여러 중간 연산을 연결해서 질의를 만들 수 있음
  * 단말 연산을 스트림 파이프라인에 실행하기 전까지는 아무 연산도 수행하지 않음 -> 게으름(Lazy)
    * 쇼트 서킷(shor circuit)
    * 루프 퓨전(loop fusion)
* 최종 연산
  * 스트림 파이프라인에서 결과를 도출

<br>

---

# 스트림의 활용

![스크린샷, 2021-09-03 12-18-08](https://user-images.githubusercontent.com/58318786/131945593-56c68630-d9f1-48fa-a16b-b462fbfb2dd6.png)
![스크린샷, 2021-09-03 12-18-15](https://user-images.githubusercontent.com/58318786/131945595-5a09a208-9b10-4f29-a02d-1bb196f0c6fe.png)
![스크린샷, 2021-09-03 12-18-22](https://user-images.githubusercontent.com/58318786/131945598-80d464ee-3752-4113-895c-61d22e28996a.png)
![스크린샷, 2021-09-03 12-18-28](https://user-images.githubusercontent.com/58318786/131945601-faf6b88f-f20b-4d3a-8a00-4f63b8750a2a.png)
![스크린샷, 2021-09-03 12-18-34](https://user-images.githubusercontent.com/58318786/131945603-77fb1d9a-72b9-449d-b5be-6f024d088a13.png)

