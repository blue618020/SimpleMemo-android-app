package com.blue.simplememo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blue.simplememo.adapter.MemoAdapter;
import com.blue.simplememo.model.Memo;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editMemo;
    Button btnSave;

    // 리사이클러뷰(리스트)는 함께 사용하는 변수들이 있음
    // MemoAdapter.java 파일에서 코드작업 끝내고 작성!

    // 7. 어댑터(Adapter)를 만든 후에 리사이클러뷰(recyclerView) 관련 변수들을 작성하기
    RecyclerView recyclerView;
    MemoAdapter adapter;
    ArrayList<Memo> memoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMemo = findViewById(R.id.editMemo);
        btnSave = findViewById(R.id.btnSave);

        recyclerView = findViewById(R.id.recyclerView);
        // 8. 리사이클러뷰 초기화 작업
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        // 9. 메모버튼 누르면, 메모 생성해서 화면에 나오게하기
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 9-1. 작성한 메모 가져오기
                String content = editMemo.getText().toString().trim();

                // 9-2. 메모 내용 작성은 필수
                if(content.isEmpty()){
                    Snackbar.make(btnSave,
                            "메모는 필수입니다.",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // 9-3. 메모클래스 만들고 데이터저장
                Memo memo = new Memo();
                memo.content = content;

                // 9-4. 여러개의 메모들을 어레이리스트에 넣어주기
                // memoList 객체생성(new) 필수
                // 최근에 입력한 메모가 가장 위에 나오게 하기 => 인덱스를 정해주기
                memoList.add(0,memo);

                // 버그1
                // memoList = new ArrayList<>(); 객체생성을 여기에 쓰면 안됨
                // 메모리 동작하는 순서로 생각해보자....
                // 실행하면 memoList 에 유저가 입력한 memo 데이터 들어감. 여기까진 ㅇㅋ
                // 근데 두번째 실행부터는 또 새로 만들라고 선언하는 꼴이라 처음엔 저장한건 날라감
                // 그래서 여기 버튼 함수 말고 바깥에 멤버변수 쪽에 객체 생성해야한다.


                // 어댑터 생성과 리사이클러뷰 셋팅하는 코드를 변경 => 버튼 코드 바깥으로 뺌(10번 코드)
                // 버튼 누를때마다 어뎁터에게 알려주기?
                adapter.notifyDataSetChanged();

                // 저장을 누르면 전에 입력한 텍스트는 삭제되도록
                editMemo.setText("");
            }
        });

        // 10. 어뎁터 만들어서 데이터 연결해달라고 하기...
        adapter = new MemoAdapter(MainActivity.this, memoList);
        recyclerView.setAdapter(adapter);
    }
}