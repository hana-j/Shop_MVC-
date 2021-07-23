## Shop_MVC2
### JSP/Servlet MVC2패턴 연습

#### MVC패턴에 익숙해지기 위해 Template페이지를 이용하여 menu부분에서 각 페이지들을 구현하였다.
___
### MVC2 기본구조
![기본 흐름](https://user-images.githubusercontent.com/80023108/126777517-e1471368-1bcd-4978-a9a5-64745ed3a63d.png)
* View : jsp페이지로 사용자 요청을 받아오는 부분
* Controller : Action객체를 생성해서 각 페이지의 경로를 제어하는 부분(포워딩)
* Action : View로 전달할 데이터 처리
* Service : 비즈니스로직 부분으로 DB작업을 처리할 객체를 받아오고 Connection객체를 생성<br> 생성한 Connection객체를 DAO의 멤버변수로 사용
* DAO : Service에서 구현한 메서드에 넘겨줄 데이터베이스 값을 조회하거나 데이터 삭제, 삽입, 수정
---
### Template 패턴
![로그인메뉴 클릭](https://user-images.githubusercontent.com/80023108/126779166-a496cd63-469e-4788-9bfc-795e0d0d10a9.png)
 메뉴를 클릭했을 때 메인이미지 아래에 페이지들이 forward되도록 페이지 구현.


