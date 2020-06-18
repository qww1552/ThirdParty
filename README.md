# THIRDPARTY
## 2020 오픈소스프로젝트
<br/>

## 개요

- ### 팀 소개


    #### **< 서드파티 >**
    오픈소스를 이용해 새로운 파생작을 만드는 세 명의 파티원


    |팀원|역할|학번|
    |:----:|:----:|:----:|
    | **오민성** | 팀장, 개발 | 2016108272 |
    | **이승훈** | 기획, 개발 | 2016108277 |
    | **김석현** | 디자인, 개발 | 2016108255 |

<br/>



- ### 목표

    <COVID19:지역알리미>

    >지역별 확진자 수(전체, 일일) 알림
        
    >코로나 관련 뉴스 필터링

    >약국 위치 및 마스크 재고량 알림

<br/>


***

## 계획 및 성과 

- ### 계획

- ### 진행과정
    ### 오민성
    >네이버 뉴스 검색 > 코로나 관련 뉴스 검색 결과 지역별 필터링 >모듈 연결 > Notice 및 라이센스 고지  

    ### 이승훈
    >네이버 지도 앱 > 약국 위치, 주소 및 공적 마스크 재고량 알림 > 메인 엑티비티 제작 > 지도 마커 디자인  

    ### 김석현
    >지역별 확진자 수 현황 api 호출(발생률, 증감수) > UI 리소스 확보 > 엑티비티 디자인 > UI/UX 디자인


- ### 성과



- ### 사용한 api, 사용한 오픈소스

    - **<공공데이터 API>**

        - 보건복지부_코로나19 시·도발생_현황  
        https://www.data.go.kr/data/15043378/openapi.do  

  
        - 외교부_국가·지역별 최신안전소식(코로나관련)  
        https://www.data.go.kr/data/15043145/openapi.do


        - 공적마스크 판매처 및 재고 현황 조회 API 서비스  
        https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1



    - **<네이버 open API>**
        - 네이버 Mobile Dynamic Map   
        https://developers.naver.com/products/intro/plan/


        - 네이버 뉴스 검색  
        https://developers.naver.com/docs/search/news/

    [![160818_NAVER OpenAPI_SimpleGuide](https://user-images.githubusercontent.com/62738554/84974099-88989f80-b15d-11ea-9831-0b999c81d87e.png)](https://developers.naver.com)


    - **< Jsoup >**
        - Jsoup HTML parser<br>
        https://jsoup.org/
        
    - **< Retrofit >**
        - A type-safe HTTP client for Android and Java<br>
        http://devflow.github.io/retrofit-kr/
***

## 개인별 성과

### 오민성
>네이버 뉴스검색 API 활용 코로나 관련 뉴스기사 검색
- 코로나 관련 뉴스 지역별로 필터링<br>
![image](https://user-images.githubusercontent.com/62738554/84743486-012c1e80-afed-11ea-951e-51e3c88e606c.png) <br>
>라이센스 표기 <br>
![라이센스정보](https://user-images.githubusercontent.com/62738554/84851499-676c7c00-b095-11ea-9bfc-81811714ff3b.PNG) <br>
>오픈소스 라이센스 표기 <br>
![오픈소스정보](https://user-images.githubusercontent.com/62738554/84851502-6a676c80-b095-11ea-81db-ef4c383d9b80.PNG) <br>


### 이승훈
>GPS 현재 위치 기반 움직임 추적 및 자동 탐색   
- 지도 화면 중심점 기준 2km 이내, 지도 화면 이동 시 자동 탐색
![IMG_20200616_015655](https://user-images.githubusercontent.com/49307262/84687702-1b2c1980-af79-11ea-8c7d-1f49980c5198.jpg)

>공적 마스크 판매 약국 이름 및 위치, 주소 / 마스크 재고량 알림
- 약국 정보 알림
![IMG_20200616_015444](https://user-images.githubusercontent.com/49307262/84687685-15cecf00-af79-11ea-8232-4d6639ee1ccf.jpg)

### 김석현
- 시도별 확진자 관련 최신 정보 표시

![KakaoTalk_20200617_104824568](https://user-images.githubusercontent.com/31850597/84884538-d87b5600-b0cc-11ea-8c0b-aff17946ffec.jpg)


- UI리소스 제작&재배치

![KakaoTalk_20200617_132724684](https://user-images.githubusercontent.com/31850597/84884555-ddd8a080-b0cc-11ea-9783-cb1f4673437f.jpg)

*** 

## 프로젝트 결과물 시연

- 프로젝트 후기 

    - 좋았던 점   

      공공데이터 api 활용하고 서로 융합하여 더 유용한 기능을 만들어내기 위해 고민하는 과정에서 부족한 점을 찾아 보완하고 공부하며 많이 배울 수 있었습니다.

    - 아쉬운 점

      코로나 바이러스의 여파로 팀원들과 직접 소통하지 못하여 시간적인 면이나 계획 수립 및 추진 과정에서 비효율적으로 진행되었던 점이 아쉬웠습니다. 
