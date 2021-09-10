[작성링크](https://delirious-sock-4dc.notion.site/2e3c519c51b9456fbdb652ff59c303b1)

# 디미터 법칙

생성 일시: 2021년 9월 3일
태그: OOP

# 디미터 법칙
The Law of Demeter

---

`"Object-Oriented Programming: An Objective Sense of Style"` 에서 처음 소개된 개념

칼 리베헤와 그의 동료들이 디미터(Demeter)라는 프로젝트를 진행하던 중 이 법칙을 발견

## 의미

객체들의 결합도를 낮추는 방법을 제시

그 방법은 객체들의 협력 경로를 제한하는 것

더 자세히 말하면, 긴 객체 구조의 경로를 따라 멀리 떨어져 있는 간접적인 객체에 메시지를 보내는 설계는 피하라는 것이다.

이러한 특징 때문에 `Don't Talk to Strangers` 혹은 `Principle of least knowledge`라고도 부른다.

디미터 법칙에서는 다음 조건을 만족해야한다.

**클래스 C의 메서드 M은 다음과 같은 객체의 메서드만 호출해야함**

- `Case 1.`  C 자신
- `Case 2.`  M 내부에서 생성된 객체
- `Case 3.`  M의 인수로 넘어온 객체
- `Case 4.`  C 멤버 객체
- `Case 5.`  M에서 접근 가능한 전역변수 객체

**안되는거**

- `Case 6.`  위 객체에서 허용된 메서드가 반환하는 객체

코드로 풀어보면 다음과 같다.

```java
public class Demeter {

		private Case4 case4;

		private Object case1Method() {}

		public void good(Case3 case3) {
				case1Method(); 
				Case2 case2 = new Case2();
				case2.Method();
				case3.Method();
				case4.Method();
				Utils.Case5.Method();
		}

		public void bad(Case3 case3) {
				case1Method().Method(); 
				Case2 case2 = new Case2();
				case2.getObject().Method();
				case3.getObject().Method();
				case4.getObject().Method();
				Utils.Case5.getObject().Method();
		}
}
```

**즉, 바로 옆 친구와만 이야기하고 친구의 친구와는 이야기 하지 말라는 것이 핵심이다.**

**대표적인 디미터 법칙 위반 코드**

```java
object.getChild().getContent().getItem().getTitle();
```

- getter 메서드가 연이어진 모습이 기차와 닮아서 `열차 전복, 기차 충돌` 코드 라고 부른다.

## 사용 안하면 어떻게 되는데?

- 객체의 내부 구조에 강하게 결합된다.
- 객체 구조의 변화에 부서지기 쉽다.

## 오해

디미터 법칙은 "오직 하나의 도트만을 사용하라"는 말로 요약되기도 한다.

그래서 다음과 같은 오해들을 하기 쉽다.

### 코드 체이닝 된건 전부 디미터 법칙 위반 아님?

다음의 코드는 디미터 법칙을 위반했을까?

```java
Customer.Builder()
				.name(name)
				.address(address)
				.build()
```

- 답은

    # 🙅🏻‍♂️

    위 코드는 전형적인 빌더 패던으로써 `Builder()` , `name` , `address` 모두 Customer 내부의 

    CustomerBuilder라는 객체를 반환하게 되어 있다.

    그러므로 디미터 법칙 조건 중 Case4에 해당하기 때문에 디미터 법칙을 위반하지 않는다.

다음의 코드는 디미터 법칙을 위반했을까?

```java
IntStream.of(1, 15, 20, 3, 9)
    .filter(x -> x > 10)
    .distinct()
    .count();
```

- 답은

    # 🙅🏻‍♂️

    `of` , `filter` , `distinct` 는 모두 `IntStream` 이라는 동일한 클래스의 인스턴스를 반환한다.

    IntStream을 다른 IntStream으로 변환할 뿐, 객체를 둘러싸고 있는 캡슐은 그대로 유지된다.

    따라서 위 코드는 디미터 법칙을 위반하지 않는다.

다음의 코드는 디미터 법칙을 위반했을까?

```java
String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
```

- 답은

    # 🙆🏻‍♂️

    하지만 다음의 경우는 No

    ```java
    String outputDir = ctxt.options.scratchDir.absolutePath;
    ```

    이유는 Yes에서 `getOptions()` , `getScratchDir()` 는 객체를 반환하지만

    No의 경우에는 자료구조에 해당되기 때문이다.

    객체라면 내부 구조를 숨겨야 하므로 확실히 디미터 법칙을 위반한다. 

    반면, 자료 구조라면 당연히 내부 구조를 노출하므로 디미터 법칙이 적용되지 않는다.

    **객체 vs 자료구조**

    `객체` : 추상화 뒤로 자료를 숨긴 채 자료를 다루는 함수만 공개
    `자료 구조` : 자료를 그대로 공개 (ex. Point)

다음의 코드는 디미터 법칙을 위반했을까?

```java
String command = input.getCommand().toUpperCase();
```

- 답은

    # 🙅🏻‍♂️

    `getCommand()` , `toUpperCase()` 는 String 객체를 반환한다.

    String은 자바의 내장 객체로 언어의 기본 스펙이다.

    때문에 해당 메소드가 변경되거나 String 타입 자체가 없어지는 일은 아마 없다.

    그러므로 String 객체는 의존해도 무방하기 때문에 디미터 법칙에 위반되지 않는다.

    실질적으로 주의해야될 것 은 우리가 직접 만든 코드이다.

    ```java
    object.getChild().getContent().getItem().getTitle();
    ```

    위 코드를 우리가 만들었다고 가정했다면
    개발 도중 해당 객체들은 언제든지 변경이 일어날 가능성이 있다.

    심지어 타입자체가 없어질 수 도 있다.

    그렇게 되면 위처럼 사용된 모든 코드를 찾아다니며 수정을 해줘야되는 불상사가 발생할 수 있다.

    답변해주신 멘토 에프님께 감사를 👍

### 그러면 코드 체이닝만 안하면 되는거 아님?

- 답은

    # 🙅🏻‍♂️

    일단 다음의 코드를 먼저 보자

    ```java
    public class Customer {
        private Address address;

        public Address getAddress() {
            return address;
        }
    }

    ---

    public class Address {
        private String city;

        public String getCity() {
            return city;
        }
    }
    ```

    CustomerService에서 부천에 사는 고객만 insert하고 싶다면?

    ```java
    public class CustomerService {
    		
    		private CustomerRepository customerRepository;

    		public void insertIfBucheon(Customer customer) {
    				if(**"부천".equals(cutomer.getAddress().getCity())**){
    						customerRepository.insert(customer);
    				}
    		}
    }
    ```

    이젠 딱봐도 디미터 법칙을 위반했음이 보이지 않는가?

    코드 체이닝을 방지하기 위해 다음과 같이 바꿔보자

    ```java
    public class CustomerService {
    		
    		private CustomerRepository customerRepository;

    		public void insertIfBucheon(Customer customer) {
    				Address address = cutomer.getAddress();
    				String city = address.getCity();
    				if("부천".equals(city)){
    						customerRepository.insert(customer);
    				}
    		}
    }
    ```

    위 코드는 디미터 법칙을 준수하고 있다고 할 수 있을까?

    **디미터 법칙은 결합도와 관련된 것이며, 이 결합도가 문제가 되는 것은 객체의 내부 구조가 외부로 노출되는 경우로 한정된다.**

    위 코드에서는 Customer의 도시 정보를 알기 위해서 Address와 City정보를 드러내고 있다.

    결과적으로 CustomerService는 알 필요 없었던 객체를 알게 되었고 의존관계가 형성되었다. 

    이를 해결하려면 다음과 같이 코드를 바꿔보자

    ```java
    public class Customer {
        private Address address;

        public boolean livesInBucheon() {
            return address.isBucheon();
        }
    }

    ---

    public class Address {
        private String city;

        public boolean isBucheon() {
    				return "부천".equals(city);
    		}
    }
    ```

    각각의 객체별로 디미터 법칙을 준수하도록 바꾸었다.

    ```java
    public class CustomerService {

    		private CustomerRepository customerRepository;

    		public void insertIfBucheon(Customer customer) {
    				if(customer.livesInBucheon()){
    						customerRepository.insert(customer);
    				}
    		}
    }
    ```

    이제 CustomerService는  Customer 내부 데이터 구조를 알 수 없게 되었다.

    Customer 데이터 구조가 바뀌어도 CustomerService에 끼치는 영향은 줄어들었을 것이다.

    **디미터 법칙을 다른식으로 해석하면 무분별한 getter를 생성하지 말라는 뜻이 된다.**
    위 코드도 처음에는 getter를 생성했다가 제거 하였다.

## 결론

- 디미터 법칙은 객체들의 결합도를 낮추는 방법에 대한 가이드
- 결합도를 낮추기 위해서는 객체의 내부 구조를 외부로 노출하는것을 방지 해야함
- 그러기 위해서 객체는 자료를 숨기고 함수를 공개해야 한다.

하지만 무비판적으로 디미터 법칙을 수용하면 퍼블릭 인터페이스 관점에서 객체의 응집도가 낮아질 수도 있다.( ← 이거 아직 필자도 이해못함)

## 참조

- "Clean Code"
- [https://bperhaps.tistory.com/entry/디미터의-법칙Law-of-Demeter이란-뭘까-그리고-왜-지켜야-할까](https://bperhaps.tistory.com/entry/%EB%94%94%EB%AF%B8%ED%84%B0%EC%9D%98-%EB%B2%95%EC%B9%99Law-of-Demeter%EC%9D%B4%EB%9E%80-%EB%AD%98%EA%B9%8C-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%99%9C-%EC%A7%80%EC%BC%9C%EC%95%BC-%ED%95%A0%EA%B9%8C)
- [https://mangkyu.tistory.com/147](https://mangkyu.tistory.com/147)