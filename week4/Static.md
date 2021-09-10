# Static

## Static 사용

- static 필드와 static 메서드를 선언 가능함

  ```java
  class StaticSample {

  	String insstanceField = "Instance Field";
  	static String staticField = "Static Field"; // static 필드

  	void instanceMethod(){}
  	static void staticMethod() {...} // static 메서드

  }

  ```

- 인스턴스 생성 없이 접근이 가능하다.

  ```java
  StaticSample.staticField; // "Static Field"

  StaticSample.staticMethod();
  ```

## Static 특징

![image](https://user-images.githubusercontent.com/78334008/131943908-00bf4846-1239-4cbf-882c-4cc13e377f3e.png)

- Static 영역
  - 모든 쓰레드가 공유하는 영역
  - 클래스, 인터페이스, Static 변수 등을 저장함
  - GC의 관리를 받지 않음
- Heap 영역
  - 모든 쓰레드가 공유하는 영역
  - new 연산자로 생성된 인스턴스들이 저장된
  - GC의 관리를 받음

### 공간적 특성

- 모든 쓰레드가 공유하는 static 영역에 저장된다.
- 클래스당 하나씩 생성된다.

### 시간적 측성

- JVM이 시작해서 클래스를 로드할 떄 static 을 먼저 읽고 메모리에 올린다.
  ( 즉, 인스턴스 생성 전에도 해당 값에 접근해서 사용할 수 있음 ) - 여기서 나타나는 특징! = static메서드안에서는 static 필드만 사용할 수 있다.

          ![image](https://user-images.githubusercontent.com/78334008/131943768-d51d6cdd-4c41-4c6a-8cb8-6954011aa0fb.png)

          - 이유

              ![image](https://user-images.githubusercontent.com/78334008/131943794-6134e502-2103-46d9-9abd-6e17244dee29.png)

              클래스 로딩 시점

              클래스가 로딩되는 시점에 static 데이터가 만들어 지는데
              이 시점에는 지역변수가 존재하지 않는다.
              클래스 로딩 후 main메서드가 실행되고
              new 연산자로 해당 인스턴스가 생성되고 나서야
              지역변수, 메소드가 생성되기 떄문에..

          - 그 반대는 가능 ( 지역메소드에서 static 필드에 접근 가능 )

- GC에 의해 관리되지 않기 때문에 어플리케이션 종료시점까지 삭제되지 않는다.

### 공유의 특성

- 값이 생성되면 그 하나의 값을 모든 클래스가 공유한다.

  ```java
  class StaticSample {

     static int count = 0;

      void instanceMethod(){
          count++;
      }

  }

  class MyMain {

      public static void main(String[] args) {

          new StaticSample().instanceMethod(); // (1)

          new StaticSample().instanceMethod(); // (2)
      }

  }
  ```

  - (1), (2) 둘다 동일한 변수를 참조한다.

    ![image](https://user-images.githubusercontent.com/78334008/131943821-55a89f22-aec6-485d-b5f8-572746787fe2.png)

    ![image](https://user-images.githubusercontent.com/78334008/131943878-2c191da6-dbfa-4e84-ab98-d4661d2c7411.png)

## 단점

1. 사용하는 순간 클래스간의 강결합이 생김

   ```java
   class A {

   	public void method01() {
   		StaticSample.staticMethod();
   		System.out.println("Hello World");
   	}

   }
   ```

1. OOP에 맞지 않음
   - 객체지향이란 각자의 상태와 행위를 가지는 객체들간의 협력관계를 통해 어플리케이션을 구현함 → 궁극적으로 유지보수하기 좋은 시스템을 설계하는데 목적이 있다.
   - 인터페이스 X, 인스턴스 생성 불가능, 오버라이드 불가능 → 유연셩X

## Static은 어디에서 사용하지?

1. 모든 클래스간에 공유할 전역변수를 만들고자 할 떄 사용
2. 모든 클래스에서 자주 사용되는 Utility 메소드를 만드는데 사용

   ex) java.lang.Math

## Utility Class 과연 Static을 써야 할까?

### Utility Class?

static 메소드로만 구성된 클래스로써
클래스 전역에서 자주 사용되는 메소드들을 모아놓은 클래스이다.

```java
public class UuidUtil {

    private UuidUtil() {}

    /**
     * UUID Generater
     * @return
     */
    public static UUID generateRandomUuid() {
        return UUID.randomUUID();
    }

    /**
     * UUID 변환 메서드
     * @param bytes UUID로 변환할 데이터 바이트
     * @return
     */
    public static UUID toUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

}
```

```java
@Repository
public class VoucherJdbcRepository implements VoucherRepository{

	private static Voucher voucherRowMapper(ResultSet resultSet, int i) throws SQLException {

	    final UUID voucherId = UuidUtil.toUUID(resultSet.getBytes("voucher_id"));
	    final UUID customerId = resultSet.getBytes("customer_id") != null ? UuidUtil.toUUID(resultSet.getBytes("customer_id")) : null;

			...

			return VoucherType.findVoucherType(voucherType).createVoucher(voucherId, customerId, discount, useYn, createdAt, usedAt);
	}

}
```

### 왜 Utility Class를 사용하는가?

1. 편리하다.
   - 인스턴스화 할 필요 없기 떄문에 코드도 적고 더 사용이 간편하다.
2. 클래스에 책임에 대해 고민하는 것 보다 애매하면 Utility Class에 넣어서 사용하면 되니 고민할 필요가 없다.

### Avoid Utility Class

1. 객체는 기본적으로 자신의 상태와 행위를 가지고 자율적으로 행동한다.

   1. Utility Class는?
      → 상태는 없고 행위만 가진다.
      → 모든 데이터를 입력으로만 전달 받는다. ( 자율성X )

1. 사용하는 순간 Utility Class와 강결합이 된다.

보통 인터페이스나 추상클래스에 의존함으로써 구현체를 갈아끼울수 있는 유연성이 제공되지만, 이걸 사용하는 순간 그 유연성을 가질 수 없음...

1. 단위 테스트를 어렵게 만든다.

   - 단위테스트는 대상 메소드가 가진 기능만을 테스트해야한다.
   - Utility 클래스에 강결합 되어있기 떄문에 의존성을 분리하여 테스트 하는 것이 어렵다.

1. 보통 한번 메모리에 올려놓고 다양한 곳에서 자주 사용할 것이니 static으로 메소드를 만들어 사용한다고 하는데.. → 그렇게 얻는 메모리 이점은 크지 않다고 한다.
   - 오히려 인스턴스는 사용할떄만 생성되고 GC에 의해 반환됨...

### 결론

1. 객체를 객체답게 사용하자.

   ```java
   @Repository
   public class VoucherJdbcRepository implements VoucherRepository{

   	// IOC에서 의존성 주입
   	public VoucherJdbcRepository(
           NamedParameterJdbcTemplate jdbcTemplate,
           UuidUtil uuidUtil
   	) {
           this.jdbcTemplate = jdbcTemplate;
           this.uuidUtil = uuidUtil;
     }

   	private static Voucher voucherRowMapper(ResultSet resultSet, int i) throws SQLException {

   	    final UUID voucherId = uuidUtil.toUUID(resultSet.getBytes("voucher_id"));
   	    final UUID customerId = resultSet.getBytes("customer_id") != null ? uuidUtil.toUUID(resultSet.getBytes("customer_id")) : null;

   			...

   			return VoucherType.findVoucherType(voucherType).createVoucher(voucherId, customerId, discount, useYn, createdAt, usedAt);
   	}

   }
   ```

   - 위의 문제는 결국 객체를 객체답게 사용한다면 해결되는 문제이다.
   - 그 메소드를 가질 적절한 객체를 만들고, 필요 할 때 그 객체를 주입받아서 사용하자.

   Utility Class를 절대 사용하지 말라는 것은 아니다.
   다만 객체지향의 장점들을 포기하면서까지 사용해야하는 것인지 한번 생각해보자.

   아마도 그 메소드에 맞는 클래스는 이미 존재할 것이고
   없다면 새로 만들어서 사용할 수 있을 것이다.

   혹시 적절한 장소를 찾고 고민하는게 귀찮은게 아닌지 다시한번 생각해보자.

### 굳이 써야한다면

1. 위의 단점을 고려하여 사이드 이펙트가 없다고 판단될 떄 사용하자.
2. Utility Class는 그 어떤 상태도 가져서는 안된다. ( 상수는 괜찮다. )
3. 순수하게 Input을 넣으면 Output을 반환하는 메서드만으로 구성한다.
4. 생성자를 private로 선언하자. → 인스턴스 생성을 방지

   ```java
   public final class UtilityClass {

       // Private constructor to prevent instantiation
       private UtilityClass() {
           throw new UnsupportedOperationException();
       }

       //public static methods here

   }
   ```

5. 하나의 Utility 클래스에 관련없는 메소드들을 다 집어놓지 말고 → 적어도 목적에 맞는 클래스들로 분리해서 사용하자.

### 추천영상

[https://www.youtube.com/watch?v=qRZL2NkXRdo](https://www.youtube.com/watch?v=qRZL2NkXRdo)

참고링크

[https://www.youtube.com/watch?v=C6CczyrkYXU](https://www.youtube.com/watch?v=C6CczyrkYXU)

[https://www.youtube.com/watch?v=lJES5TQTTWE](https://www.youtube.com/watch?v=lJES5TQTTWE)

[https://imasoftwareengineer.tistory.com/73](https://imasoftwareengineer.tistory.com/73)

[https://mangkyu.tistory.com/47](https://mangkyu.tistory.com/47)

[https://www.vojtechruzicka.com/avoid-utility-classes/](https://www.vojtechruzicka.com/avoid-utility-classes/)
