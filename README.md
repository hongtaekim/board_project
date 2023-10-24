# 스프링 부트로 구현한 게시판 프로젝트

<div align=center><h1>📚 STACKS</h1></div>
<div align=center>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><br>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><br>
  <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>

## 프로젝트 설명

- 스프링 부트 프레임워크를 이용해 CRUD 기능이 탑제된 간단한 게시판 프로젝트입니다.
- 글 작성, 조회, 수정, 삭제 기능이용이 가능하며 댓글 CRUD 기능이 포함되어있습니다.
- MVC 패턴, 프레젠테이션 레이어, 서비스 레이어, 데이터 액세스 레이어등 3레이어를 활용하여
- 프로젝트 구조를 만들었습니다. 또한 Mybatis를 통해 코드와 xml파일 분리의 장점과 효용성을 느꼈습니다.

## DB 테이블 구성
<img width="580" alt="DB구조" src="https://github.com/hongtaekim/board_project/assets/39915171/5c6b03b4-8d30-471a-8bd3-b1d012c8affa">


- reply테이블은 board_idx의 외래키를 참조하여
- 글 조회시 해당 board_idx를 참조하여 해당 글에대한 댓글 목록을 표시하게 됩니다.


  ## 1. 메인 페이지
  <img width="440" alt="게시판 메인 리스트" src="https://github.com/hongtaekim/board_project/assets/39915171/d0402793-82cf-4c4e-a911-9346df2e78bc">

  ### 화면 설명
  -  Orable 데이터베이스 내에 board 테이블에 있는 데이터들을 끌어와 글 목록 리스트를 확인합니다.
  -  글 제목 앵커 테그를 누르게 되면 글에 대한 상세 조회가 가능합니다.
  -  글 작성 앵커 태그를 누르게 되면 글 작성 폼으로 이동하게 됩니다.
  -  사용자가 글제목을 누르게 되면 조회수가 증가합니다.

```
  window.onpageshow = function(e){
	  if(e.persisted){
		  document.location.reload();
	  }
  }
```

- 해당 자바스크립트 코드로 인해 글 상세조회시 뒤로가기 버튼을 누르게 되더라도 리프레시 되어 조회수가 증가하게 됩니다.


## 2. 글 작성 폼
<img width="450" alt="글 작성 폼" src="https://github.com/hongtaekim/board_project/assets/39915171/ae62f6f2-e17a-43d6-b0b8-72347628448d">

### 화면 설명
- 이름 제목 내용을 입력하고 글쓰기 버튼을 통해 게시판 글을 작성할 수 있습니다.
- 목록보기를 통해 글 쓰기를 취소하고 글 리스트 메인 화면으로 이동할 수 있습니다.


## 3. 글 상세 보기
<img width="347" alt="글 상세 보기" src="https://github.com/hongtaekim/board_project/assets/39915171/e36a6285-a19a-4ea2-a3e1-15a546ce1c14">

### 화면 설명
- 글 수정 버튼을 통해 사용자가 글을 수정할 수 있습니다.
- 목록 보기를 통해 메인 페이지로 이동할 수 있습니다.
- 삭제하기 버튼을 통해 작성한 글을 삭제할 수 있습니다.


### 댓글 폼 설명
- 댓글달기 버튼을 통해 댓글과 별명을 지정해 댓글을 달아줄 수 있습니다.
- 댓글을 달게 되면 글 상세 페이지로 redirect 되며 댓글 리스트에 댓글이 달리게 됩니다.
- 댓글 리스트의 오른쪽 삭제 버튼을 통해 댓글 삭제가 가능합니다.


## 프로젝트 회고

Java, Oracle, Mybatis, Srping boot 프레임워크를 이용해 간단한 게시판을 구현해 보았습니다.


직접 만들면서 느낀점은 레이어 3계층에 대해 직접 구성을 해보고 각 레이어에 맞춰 프로젝트를
구조화 하면서 왜 3계층으로 나누는지 알게 되었습니다.

또한 해당 프로젝트를 만들기 전에 서블릿과 JSP에 대한 학습을 하고 만드니

스프링 컨테이너가 @ 어노테이션을 통해 각 컴포넌트의 생명주기를 어떻게 관리하게 되는지도 알게 되었습니다.

그외로 @Autowired, @Mapper, @controller, @Service 등등 이전엔 왜 어노테이션을 사용하는지에대해 알지 못하고
사용했던 반면 해당 어노테이션을 스프링 컨테이너에게 알려줌으로써 스프링이 해당 컴포넌트들을 관리함에 따라
개발자는 더 개발에만 집중할 수 있게 된 사실도 알게되었습니다.

이렇게 작은 프로젝트를 직접 만들면서 저의 부족한 점을 보완하기 위해 새로운 프로젝트를 직접 만들어봄으로써
저의 실력을 다져나가 보겠습니다. 글 읽어주셔서 감사합니다.





