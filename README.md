SNS 앱 만들기 
화면 구성 
1. 메인 페이지 2. 로그인 페이지 3. 회원가입 페이지 4. 콘텐츠 디테일 페이지 5. 마이 페이지

기능 

1. 메인 페이지에서 로그인 페이지, 디테일 페이지, 마이 페이지로 이동 할 수 있게 구현\n페이지 이동 시 진입/탈출 애니메이션 효과 부여
메인 페이지에서 표시할 컨텐츠를 데이터 클래스에서 불러와 사용
릴스 페이지에서 표시할 내용을 setOnClickListener로 데이터 클래스에서 불러와 사용
circleimageview 외부 라이브러리를 사용해 간단하게 원형 이미지 구현
스타일 xml을 만들어 필요한 위젯에 사용(모서리 R 부여 및 테두리 투명화)
   
3. 회원가입 페이지에서 Email 형식이 맞지 않거나 Email 이 중복되면 가입 승인이 안되도록 구현
4. 디테일 페이지에서 사용자와 상호작용을 위해 설명 더보기/접기 기능 좋아요 표시, 댓글 입력기능 구현
5. 마이 페이지에서 이름, 자기소개, MBIT, 취미 등 편집기능, 이미지를 눌렀을 때 이미지를 선택해서 바꾸는 기능 구현

     필수 구현 기능
    - [v]  메인 화면
    - [v]  디테일 화면
    - [v]  로그인, 회원가입 화면
    - [v]  마이 페이지 화면
    - [v]  Activity 전환시 animation 구현
    - [v]  영어 버전으로 변경 적용해보기(string.xml)
      
    추가 구현 기능(선택)
    - [v]  동그란 ImageView 만들기
    - [v]  스크롤 기능 추가
    - [v]  더보기 기능
    - [ x ]  Font 크기 설정에 따라 글씨 크기 달라지도록 구현
    - [v]  Dark theme 구현
    - [v]  세로/가로 모드 ui 분리 구현
    - [ x ]  회원 정보 관리 구현
 
