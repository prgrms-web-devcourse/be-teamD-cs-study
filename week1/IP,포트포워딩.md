# ๐๊ณต์ธIP, ์ฌ์คIP, ํฌํธํฌ์๋ฉ, ์ธ๋ถ,๋ด๋ถ ํฌํธ
## **๊ณต์ธ IP, ์ฌ์ค IP**

### **๊ณต์ธ(Public) IP** 
> ์ธํฐ๋ท ์ฌ์ฉ์์ ๋ก์ปฌ ๋คํธ์ํฌ๋ฅผ ์๋ณํ๊ธฐ ์ํด ISP(์ธํฐ๋ท ์๋น์ค ๊ณต๊ธ์)๊ฐ ์ ๊ณตํ๋ IP ์ฃผ์์ด๋ค. ๊ณต์ฉ IP ์ฃผ์๋ผ๊ณ ๋ ๋ถ๋ฆฌ๋ฉฐ ์ธ๋ถ์ ๊ณต๊ฐ๋์ด ์๋ IP ์ฃผ์์ด๋ค.

* ๊ณต์ธ IP๋ ์ ์ธ๊ณ์์ ์ ์ผํ IP ์ฃผ์๋ฅผ ๊ฐ๋๋ค.
* ๊ณต์ธ IP ์ฃผ์๊ฐ ์ธ๋ถ์ ๊ณต๊ฐ๋์ด ์๊ธฐ์ ์ธํฐ๋ท์ ์ฐ๊ฒฐ๋ ๋ค๋ฅธ PC๋ก๋ถํฐ์ ์ ๊ทผ์ด ๊ฐ๋ฅํ๋ค. 
  * ๊ณต์ธ์ ๊ฒฝ์ฐ ๋ฐฉํ๋ฒฝ๊ฐ์ ๋ณด์ํ๋ก๊ทธ๋จ์ ์ค์นํ  ํ์๊ฐ ์๋ค.
<br>

### **์ฌ์ค(Private) IP** 
> ์ผ๋ฐ ๊ฐ์ ์ด๋ ํ์ฌ ๋ด ๋ฑ์ ํ ๋น๋ ๋คํธ์ํฌ์ IP ์ฃผ์์ด๋ฉฐ, ๋ก์ปฌ IP, ๊ฐ์ IP๋ผ๊ณ ๋ ํ๋ค.<br>
> IPv4์ ์ฃผ์๋ถ์กฑ์ผ๋ก ์ธํด ์๋ธ๋ทํ๋ IP์ด๊ธฐ ๋๋ฌธ์ ๋ผ์ฐํฐ์ ์ํด ๋ก์ปฌ ๋คํธ์ํฌ์์ PC ๋ ์ฅ์น์ ํ ๋น๋๋ค.
<br>
<br>

### **๊ณต์ธIP์์ ์ฌ์คIP๋ก์ ๋ณํ์ ์ด๋ป๊ฒ ์ด๋ฃจ์ด์ง๋๊ฐ?**
* NAT(Network Address Translation)๋ ๊ณต์ธIP์์ ์ฌ์คIP๋ก ๋ณํํด์ฃผ๋ ์ญํ ์ ํ๋ค.(OSI 3๊ณ์ธต์ ํด๋น)
* NAT์ ํน์ง์ผ๋ก IP๋ฅผ ์จ๊ธธ ์ ์๋ ๊ธฐ๋ฅ์ด ์์ด ๋ณด์์ฑ์ ๋์ฌ์ค๋ค
  * ์ฐ๋ฆฌ์ ์ปดํจํฐ์์ ํปํท์ ์ธ๋ถ๋ก ์ ์กํ ๋ ์ฌ์คIP๊ฐ ๊ณต์ธIP๋ก์ ๋ณํ์ด ์ด๋ฃจ์ด์ง๋ฉด์ ์ฌ์คIP์ ๋ํ ์ ๋ณด๋ฅผ ์ธ๋ถ์์๋ ์ ์ ์๊ธฐ ๋๋ฌธ์ ์ฐ๋ฆฌ ์ปดํจํฐ์ ๋ด๋ถ๋ก์ ์ ๊ทผ์ ๋ณดํธํ  ์ ์๋ค.
* ์ฐ๋ฆฌ๊ฐ ํํ ์ฌ์ฉํ๋ ๊ณต์ ๊ธฐ(๋ผ์ฐํฐ)์ ๊ฒฝ์ฐ NAT์ ์ข๋ฅ์ค ํ๋์ธ NAPT๋ฅผ ์ฌ์ฉํ๋ค.
    * NAPT(Network Address Port Translation)๋ก NAT์ฒ๋ผ IP์ฃผ์๋ฅผ ๋ณํํด ์ฃผ๋ ๋์์ port๋ฒํธ๋ก ๋ณํํด ์ค๋ค.
    * ์ธํฐ๋ท์ ์ก์ถํ ๋ ์์ ์ IP ์ฃผ์์ ํฌํธ๋ฒํธ์ ์กฐํฉ์ ๊ณต์ ๊ธฐ(๋ผ์ฐํฐ)๋ฅผ ํตํด ๊ณต์ธIP์ฃผ์ + ์ธ๋ถํฌํธ๋ฒํธ ์กฐํฉ์ผ๋ก ๋ณํ์ํจ๋ค.


* NAT ๋์์๋ฆฌ  
 https://www.stevenjlee.net/2020/07/11/%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-nat-network-address-translation-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%A3%BC%EC%86%8C-%EB%B3%80%ED%99%98/


### **NAPT ๊ตฌ์กฐ**
![NATแแฎแแฉ](https://user-images.githubusercontent.com/43923432/129305601-80d1e8ba-8124-4f2b-a2b0-751511249a65.png)



### **์ฐจ์ด์ ** 
|      | ๊ณต์ธ IP | ์ฌ์ค IP             |
| ---- | ------- | ----------------- | 
| ํ ๋น ์ฃผ์ฒด | ISP(์ธํฐ๋ท ์๋น์ค ๊ณต๊ธ์) | ๊ณต์ ๊ธฐ(๋ผ์ฐํฐ) |
| ํ ๋น ๋์ | ๊ฐ์ธ ๋๋ ํ์ฌ์ ์๋ฒ(๋ผ์ฐํฐ) | ๊ฐ์ธ ๋๋ ํ์ฌ์ ๊ธฐ๊ธฐ |
| ๊ณ ์ ์ฑ | ์ธํฐ๋ท ์์์ ์ ์ผํ ์ฃผ์ | ํ๋์ ๋คํธ์ํฌ ์์์ ์ ์ผ |
| ๊ณต๊ฐ ์ฌ๋ถ | ๋ด/์ธ๋ถ ์ ๊ทผ ๊ฐ๋ฅ | ์ธ๋ถ ์ ๊ทผ ๋ถ๊ฐ๋ฅ |
> โ ์ฌ์ค IP ์ฃผ์๋ง์ผ๋ก๋ ์ธํฐ๋ท์ ์ง์  ์ฐ๊ฒฐํ  ์ ์๋ค.<br>
>  ๋ผ์ฐํฐ๋ฅผ ํตํด 1๊ฐ์ ๊ณต์ธ(Public) IP๋ง ํ ๋นํ๊ณ , ๋ผ์ฐํฐ์ ์ฐ๊ฒฐ๋ ๊ฐ์ธ PC๋ ์ฌ์ค(Private) IP๋ฅผ ๊ฐ๊ฐ ํ ๋น ๋ฐ์ ์ธํฐ๋ท์ ์ ์ํ  ์ ์๊ฒ ๋๋ค.

![image](https://user-images.githubusercontent.com/43923432/128640300-a8851f59-cde3-4a7f-81a9-cb5e03eb74b2.png)

> ๐ปโก๐ : ์ฌ์ค IP๋ฅผ ํ ๋น๋ฐ์ ์ค๋งํธํฐ ํน์ ๊ฐ์ธ PC๊ฐ ๋ฐ์ดํฐ ํจํท์ ์ธํฐ๋ท์ผ๋ก ์ ์กํ๋ฉด, ๋ผ์ฐํฐ(๊ณต์ ๊ธฐ)๊ฐ ํด๋น ์ฌ์ค IP๋ฅผ ๊ณต์ธ IP๋ก ๋ฐ๊ฟ์ ์ ์กํ๋ค.

> ๐โก๐ป : ์ธํฐ๋ท์์ ์ค๋ ๋ฐ์ดํฐ ํจํท์ ๋ชฉ์ ์ง๋ ํด๋นํ๋ ์ฌ์ค IP๋ก ๋ณ๊ฒฝํ ํ ๊ฐ์ธ ์ค๋งํธํฐ ํน์ PC์ ์ ์กํ๋ค.

* * *

## **ํฌํธ ํฌ์๋ฉ, ๋ด๋ถํฌํธ, ์ธ๋ถํฌํธ**

## **ํฌํธ ํฌ์๋ฉ** 
>ํฌํธ ํฌ์๋ฉ์ด๋ ์ปดํจํฐ ๋คํธ์ํฌ์์ ํจํท์ด ๋ผ์ฐํฐ๋ ๋ฐฉํ๋ฒฝ ๊ฐ์ ๋คํธ์ํฌ ๊ฒ์ดํธ์จ์ด๋ฅผ ํต๊ณผํ๋ ๋์ ๋คํธ์ํฌ ์ฃผ์๋ฅผ ๋ณํํด์ฃผ๋ ๊ฒ์ ์๋ฏธํฉ๋๋ค.<br>
**์ฆ, ์ธ๋ถ์์ ๋ด๊ฐ ์ํ๋ ๋ด๋ถ ๊ธฐ๊ธฐ์ ์ ์์ ํ  ์ ์๋๋ก ์ฐ๊ฒฐํด์ฃผ๋ ๊ฒ์ ์๋ฏธํ๋ค.**

## ์ธ๋ถ ํฌํธ 
* ์ธ๋ถ์์ ์ด๋ค ํฌํธ๋ก ์ ์์ ํ์์ ๋ ์ง์ ๋ ์ปดํจํฐ๋ก ์ฐ๊ฒฐ์ ํ  ๊ฒ์ธ๊ฐ ์๋๋ค.

## ๋ด๋ถ ํฌํธ
* ์ง์ ๋ ์ปดํจํฐ๋ก ์ธ๋ถํฌํธ์์ ์ฐ๊ฒฐ์ ํด์ฃผ์์ ๋, ์ง์ ๋ ๋ด๋ถ PC์์๋ ์ด๋ค ํฌํธ๋ฅผ ์ฌ์ฉํ  ์ง ์ ํด์ค๋ค.

* ํฌํธ๋ฒํธ : ์ปดํจํฐ์์์ ์๋ํ๋ Application์ ์๋ณํ๊ธฐ ์ํด ์ฌ์ฉํ๋ ์ซ์๋ฅผ ์๋ฏธ.(
0~65535)

* * *

![image](https://user-images.githubusercontent.com/43923432/128737164-1d4fdd05-45b9-40a5-abe3-a78d0de4ef9f.png)
> "๊ณต์ธ IP:์ธ๋ถํฌํธ"๋ก ์ ์์ด ์ด๋ฃจ์ด์ง๋ฉด "์ฌ์คIP:๋ด๋ถํฌํธ"๋ก ์ฐ๊ฒฐ์ด ๋๋๋ก ํด์ค๋ค.

* ์ฐ๊ฒฐ์ ํด์ฃผ๊ธฐ ์ํด์ IPTIME์ ์์๋ก ๋ค์๋ฉด 

![image](https://blog.kakaocdn.net/dn/bQKrXK/btqH5Z5vf8A/KK3GfKkWudhB16PhFLmXMk/img.png)
> ๊ท์น์ด๋ฆ์ ๋ง์๋๋ก ์ ํ๋ฉด ๋๊ณ  ์ด๋ค ํ๋กํ ์ฝ์ ์ฌ์ฉํ  ๊ฒ์ธ์ง, ์ฐ๊ฒฐํ  ์ธ๋ถํฌํธ์ ๋ด๋ถํฌํธ๋ฅผ ๊ฒฐ์ ํด์ฃผ๊ณ  ์ ์ฉ์ ๋๋ฅด๋ฉด ํฌํธ ํฌ์๋ฉ์ด ๋๋๋ค.
* ๋ฒ์ ์ง์ ์ 
  * ํฌํธ ํ๊ฐ๋ง ์ง์  : ์ธ๋ถํฌํธ(1111~1111) , ๋ด๋ถํฌํธ(22~22)
    * ์ธ๋ถํฌํธ 1111๋ก ์ ์ํ๋ฉด ๋ด๋ถํฌํธ 22๋ฒ์ผ๋ก ์ฐ๊ฒฐ๋๋ค.
  * ํฌํธ ๋ฒ์ ์ง์  : ์ธ๋ถํฌํธ(1000~1111), ๋ด๋ถํฌํธ(20~30) 
    * ์ธ๋ถํฌํธ 1000~1111๋ก ์ ์์ ๋ด๋ถํฌํธ ๋ฒ์์ ํด๋นํ๋ ๋ฒํธ์ ์ฐ๊ฒฐ๋๋ค.


> ์ฌํ... -> ์๋ฃฐ๋ฌ๊ฐ ์๋ ๋ด๋ถ ip์ฃผ์์์ ๋ค๋ฅธ ๋ด๋ถ ip์ฃผ์๋ก ํฌํธํฌ์๋ฉ 

<br>

* * *

<br>

## **nginx๋ฅผ ์ด์ฉํ ํฌํธ ํฌ์๋ฉ ์ค์ต!!** 

### **๐ํฌํธ ํฌ์๋ฉ ์ค์ **
1. **Kthub์ ์ ์**ํ์ฌ "ํฌํธ ํฌ์๋ฉ"ํ  **์ธ๋ถ ํฌํธ, ๋ด๋ถ ํฌํธ, ๋ด๋ถ IP์ฃผ์**๋ฅผ ์ค์ ํด ์ค๋ค.
<img width="774" alt="แแณแแณแแตแซแแฃแบ 2021-08-11 แแฉแแฅแซ 2 18 42" src="https://user-images.githubusercontent.com/43923432/128905301-4cd53557-d412-4d69-ad1f-c33f21941165.png">

2. nginx ์ vi๋ก ์ ์ํ์ฌ default๋ก ์ค์ ๋ ๋ด๋ถ ํฌํธ๋ฒํธ๋ฅผ ๋ฐ๊ฟ์ค๋ค. 
<img width="387" alt="แแณแแณแแตแซแแฃแบ 2021-08-11 แแฉแแฅแซ 2 12 57" src="https://user-images.githubusercontent.com/43923432/128904539-8ea25518-acc4-435a-8481-5ceac0b05cba.png">
    > **vi  /usr/local/etc/nginx.nginx.conf** <br>
      ์ ํตํด viํธ์ง์ผ๋ก ๋ค์ด๊ฐ์ Server-listen์ port๋ฒํธ๋ฅผ ์์์ ์ค์ ํ **๋ด๋ถ ํฌํธ ๋ฒํธ** ๋ก ๋ฐ๊ฟ์ค๋ค.

    <img width="355" alt="แแณแแณแแตแซแแฃแบ 2021-08-11 แแฉแแฅแซ 2 13 37" src="https://user-images.githubusercontent.com/43923432/128904615-329568ec-5397-40f1-8b5c-1d60a630d1a3.png">

    > ์์ฉํ๋ก๊ทธ๋จ์ ์คํํ ๋๋ location์ ์คํํ๊ณ ์ ํ๋ ํ์ผ์์น๋ฅผ ์ ์ด์ค๋ค. 

    <img width="580" alt="แแณแแณแแตแซแแฃแบ 2021-08-11 แแฉแแฅแซ 1 49 45" src="https://user-images.githubusercontent.com/43923432/128902752-71b7a286-323f-4309-a84a-d191cdacfb33.png">

    > **nginx์ 5156 ํฌํธ**๋ก ์ฐ๊ฒฐ๋๊ฑธ ์ ์ ์๋ค.
<br>

### **๐์ค๋งํธํฐ์ผ๋ก ์คํ**
* ### ์ฒ์ ์๋๋... ์คํจ๐จ 

<img width="250" alt="ํฌํธํฌ์๋ฉ์คํจ" src="https://user-images.githubusercontent.com/43923432/128903622-417b44f9-abd7-4806-a2b4-a14f0fb33f6b.jpeg">

> ์ ์์ด ๋์ง ์์ ์์ธ์ ์ฐพ์๋ณด๋ KT๊ณต์ ๊ธฐ์ ๊ฒฝ์ฐ MAC์ฃผ์๋ณ๋ก ๊ณ ์  IPํ ๋น์ด ๋ถ๊ฐ๋ฅํ์ฌ ์์ดํ์ด๋ฅผ ์ฌ์ ์ํ๊ฒ๋๋ฉด ๋ด๋ถIP์ฃผ์๊ฐ ๋ฐ๋์ด์ ํฌํธ ํฌ์๋ฉ์ ๋ค์ ์ค์ ํด ์ฃผ์ด์ผ ํ๋ ๋ฌธ์ ๊ฐ ๋ฐ์ํ์๋ค.

* ### ๐๋๋ฒ์งธ ์๋ ์ฑ๊ณต!!! 
<img width="280" alt="ํฌํธํฌ์๋ฉ์ฑ๊ณต" src="https://user-images.githubusercontent.com/43923432/128903676-952f43e1-8e92-4264-a24e-d4be09e036d9.jpeg">

> ์์๋ฐฉํธ์ผ๋ก ์์ดํ์ด๋ฅผ ์ ์งํ์ฑ ํฌํธํฌ์๋ฉ์ ๋ค์ ์ค์ ํด ์ฃผ๊ณ  ๋์์ผ ์ฑ๊ณตํ  ์ ์์๋ค.


## **์ ๋ฆฌ**
> ๊ฐ๋จํ๊ฒ ํฌํธ ํฌ์๋ฉ์ ๋ํ ์ค์ต์ ํด๋ดค๋๋ฐ ๋ค์์๋ ์ค์  ์์ฉํ๋ก๊ทธ๋จ์ผ๋ก ๋๋ ค์ ์คํํด๋ณด๊ณ  ์์์ ๋ฌธ์ ๊ฐ ๋ฐ์ํ IP๊ณ ์  ํ ๋น์ ๋ํด์๋ ๋ค๋ฅธ ๋ฐฉ๋ฒ์ด ์๋์ง ์ฐพ์๋ด์ผ๊ฒ ๋ค. 





