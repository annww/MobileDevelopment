package ntu.duongthianhhong.th_bai8_quizappgui2fullcode;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private TextView tvQuestion, tvKQ;
    private CardView cardA, cardB, cardC, cardD;
    private TextView answerA, answerB, answerC, answerD;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        tvQuestion = findViewById(R.id.textview1);
        tvKQ = findViewById(R.id.tvKQ);

        cardA = findViewById(R.id.cardViewA);
        cardB = findViewById(R.id.cardViewB);
        cardC = findViewById(R.id.cardViewC);
        cardD = findViewById(R.id.cardViewD);

        answerA = findViewById(R.id.anwserA);
        answerB = findViewById(R.id.anwserB);
        answerC = findViewById(R.id.anwserC);
        answerD = findViewById(R.id.anwserD);

        // Tạo danh sách câu hỏi
        questionList = getQuestionList();

        displayQuestion();

        cardA.setOnClickListener(v -> checkAnswer(0, cardA));
        cardB.setOnClickListener(v -> checkAnswer(1, cardB));
        cardC.setOnClickListener(v -> checkAnswer(2, cardC));
        cardD.setOnClickListener(v -> checkAnswer(3, cardD));
        findViewById(R.id.btnnext).setOnClickListener(v -> {
            if (!isAnswered) {
                // Nếu chưa trả lời, báo lỗi trong tvKQ
                tvKQ.setText("Hãy chọn câu trả lời");
                return;
            }
            if (currentQuestionIndex < questionList.size() - 1) {
                currentQuestionIndex++;
                resetState(); // Reset lại trạng thái
                displayQuestion();
            } else {
                tvKQ.setText("Đã hết câu hỏi!");
                tvKQ.setTextColor(getResources().getColor(R.color.black));
            }
        });
    }

    private void displayQuestion() {
        Question question = questionList.get(currentQuestionIndex);
        tvQuestion.setText(question.getQuestionText());
        answerA.setText(question.getOptions().get(0));
        answerB.setText(question.getOptions().get(1));
        answerC.setText(question.getOptions().get(2));
        answerD.setText(question.getOptions().get(3));
    }

    private void checkAnswer(int selectedIndex, CardView selectedCard) {
        if (isAnswered) return;
        isAnswered = true;
        Question currentQuestion = questionList.get(currentQuestionIndex);

        if (selectedIndex == currentQuestion.getCorrectAnswerIndex()) {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            tvKQ.setText("Correct..");
            tvKQ.setTextColor(getResources().getColor(R.color.green));
        } else {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            tvKQ.setText("Wrong..");
            tvKQ.setTextColor(getResources().getColor(R.color.red));
            highlightCorrectAnswer(currentQuestion.getCorrectAnswerIndex());
        }
    }

    private void highlightCorrectAnswer(int correctIndex) {
        switch (correctIndex) {
            case 0:
                cardA.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 1:
                cardB.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 2:
                cardC.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 3:
                cardD.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
        }
    }
    private void resetState() {
        isAnswered = false;
        tvKQ.setText("");

        cardA.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
    }

    private List<Question> getQuestionList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Từ khóa nào được sử dụng để kế thừa lớp trong Java?",
                Arrays.asList("extend", "implements", "inherit", "extends"), 3));
        questions.add(new Question("Phương thức nào trong Java được sử dụng để lấy độ dài của chuỗi?",
                Arrays.asList("length()", "size()", "getLength()", "charAt()"), 0));
        questions.add(new Question("Interface trong Java được khai báo bằng từ khóa nào?",
                Arrays.asList("abstract", "interface", "implements", "class"), 1));
        questions.add(new Question("Trong Java, kiểu dữ liệu nào dùng để lưu trữ một ký tự?",
                Arrays.asList("String", "char", "boolean", "int"), 1));
        questions.add(new Question("Lệnh nào dùng để thoát khỏi vòng lặp trong Java?",
                Arrays.asList("stop", "exit", "break", "return"), 2));
        questions.add(new Question("Từ khóa nào dùng để xử lý ngoại lệ trong Java?",
                Arrays.asList("catch", "try", "finally", "throw"), 1));
        questions.add(new Question("Biến cục bộ trong Java được khai báo ở đâu?",
                Arrays.asList("Trong một lớp", "Trong một phương thức", "Trong một interface", "Ngoài mọi lớp"), 1));
        questions.add(new Question("Kiểu dữ liệu nào trong Java được dùng để lưu giá trị logic đúng hoặc sai?",
                Arrays.asList("boolean", "int", "float", "String"), 0));
        return questions;
    }

}