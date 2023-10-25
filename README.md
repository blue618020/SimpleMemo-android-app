# 간단한 메모 앱

📝 <b> tistory : </b> https://blue618020.tistory.com/88

### 🔍 학습 내용
-  ArrayList를 RecyclerView를 사용하여 화면에 띄우기

### 💻 실습
#### 1. .xml 
-  activity_main.xml 화면뷰에서 recyclerView를 추가
-  recyclerView 안에 들어갈 res 파일의 새 layout 파일인 memo_row를 생성해서 CardView와 TextView를 추가

#### 2. adapter
-  model 폴더를 생성하여 Memo 클래스 파일을 생성. 여기에 유저가 작성한 메모 내용이 들어감
-  adapter 폴더를 생성하여 MemoAdapter 자바 클래스를 생성하여 화면에 출력하기 위한 코드를 작성함

#### 3. activity 
-  MainActivity 클래스 파일에서 메모 생성 버튼을 클릭하면, Memo 클래스에 내용이 저장
-  MemoAdapter를 호출해서 recyclerView에 적용되도록 하기
