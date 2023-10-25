package com.blue.simplememo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blue.simplememo.R;
import com.blue.simplememo.model.Memo;

import java.util.ArrayList;


// 2. 어댑터 클래스를 상속받는다
public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    // 3. 위에서 상속받으면 에러뜸
    // 에러안뜨게 오버라이딩 함수 작성하기
    // 메뉴를 통해서 3개 자동생성함 (하단 6번 아래에 있음)


    // 4.이 클래스의 멤버변수를 작성하기. 기본 2개는 필수
    Context context;
    ArrayList<Memo> memoList;

    // 5. 위의 멤버변수를 셋팅할 수 있는 생성자로 만들기
    public MemoAdapter(Context context, ArrayList<Memo> memoList) {
        this.context = context;
        this.memoList = memoList;
    }

    // 6. 아래 함수 3개를 구현하기

    @NonNull
    @Override // 행 화면(memo_row)을 연결시키는 함수
    public MemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // MemoAdapter.ViewHolder 로 이름바꿈 (내가만든 뷰홀더로)

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memo_row, parent, false);

        return new MemoAdapter.ViewHolder(view);
    }

    @Override // 실제로 데이터를 화면에 적용시키는 함수
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Memo memo = memoList.get(position);
        holder.txtContent.setText(memo.content);
    }

    @Override // 데이터의 개수 (= 행의 개수)
    public int getItemCount() {

        return memoList.size(); // 0으로 되어있으면 안나온대 주의
    }



    // 1. 뷰홀더 클래스를 만든다 inner class
    // 이 클래스에는 행 화면(memo_row)에 있는 뷰들을 여기서 연결시킨다.
    public class ViewHolder extends RecyclerView.ViewHolder {

        // memo_row 화면을 가져오기
        TextView txtContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtContent = itemView.findViewById(R.id.txtContent);
            // 오류나면 R 임포트(클래스 없는거임)

        }
    }

    ;
}
