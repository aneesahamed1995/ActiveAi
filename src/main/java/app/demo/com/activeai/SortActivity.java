package app.demo.com.activeai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortActivity extends AppCompatActivity implements SortObserver{

    @BindView(R.id.inputOne)
    EditText inputOne;
    @BindView(R.id.inputTwo)
    EditText inputTwo;
    @BindView(R.id.inputThree)
    EditText inputThree;
    @BindView(R.id.inputFour)
    EditText inputFour;
    @BindView(R.id.inputFive)
    EditText inputFive;
    @BindView(R.id.btnVerify)
    Button btnVerify;
    @BindView(R.id.edLayout)
    LinearLayout edLayout;
    @BindView(R.id.txtLayout)
    LinearLayout txtLayout;
    @BindView(R.id.btnSort)
    Button btnSort;
    @BindView(R.id.restart)
    Button restart;
    @BindView(R.id.txtOne)
    TextView txtOne;
    @BindView(R.id.txtTwo)
    TextView txtTwo;
    @BindView(R.id.txtThree)
    TextView txtThree;
    @BindView(R.id.txtFour)
    TextView txtFour;
    @BindView(R.id.txtFive)
    TextView txtFive;
    SelectionSorter selectionSorter;
    List<Integer> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setListener();
        btnSort.setVisibility(View.GONE);
        restart.setVisibility(View.GONE);
        btnVerify.setVisibility(View.VISIBLE);
        edLayout.setVisibility(View.VISIBLE);
        txtLayout.setVisibility(View.GONE);
        setIndicator(false);
        selectionSorter = new SelectionSorter(this);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = inputOne.getText().toString().trim()
                        +inputTwo.getText().toString().trim()
                        +inputThree.getText().toString().trim()
                        +inputFour.getText().toString().trim()
                        +inputFive.getText().toString().trim();
                if(number.length()==5){
                    list =  new ArrayList<>();
                    list.add(Integer.valueOf(inputOne.getText().toString()));
                    list.add(Integer.valueOf(inputTwo.getText().toString()));
                    list.add(Integer.valueOf(inputThree.getText().toString()));
                    list.add(Integer.valueOf(inputFour.getText().toString()));
                    list.add(Integer.valueOf(inputFive.getText().toString()));
                    btnSort.setVisibility(View.VISIBLE);
                    btnVerify.setVisibility(View.GONE);
                    edLayout.setVisibility(View.GONE);
                    txtLayout.setVisibility(View.VISIBLE);
                    onArrayUpdate(list.toArray(new Integer[list.size()]));
                }
            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart.setVisibility(View.VISIBLE);
                setIndicator(false);
                selectionSorter.sortArray(list);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
                edLayout.setVisibility(View.VISIBLE);
                txtLayout.setVisibility(View.GONE);
                btnSort.setVisibility(View.GONE);
                btnVerify.setVisibility(View.VISIBLE);
                restart.setVisibility(View.GONE);

            }
        });
    }
    private void setListener(){
        inputOne.addTextChangedListener(new ValidatorTextWatcher(this, inputOne, inputTwo));
        inputTwo.addTextChangedListener(new ValidatorTextWatcher(this, inputTwo, inputThree));
        inputThree.addTextChangedListener(new ValidatorTextWatcher(this, inputThree, inputFour));
        inputFour.addTextChangedListener(new ValidatorTextWatcher(this ,inputFour ,inputFive));
        inputFive.addTextChangedListener(new ValidatorTextWatcher(this ,inputFive ,null));

        inputOne.setOnKeyListener(new KeyListener(this ,null ,inputOne));
        inputTwo.setOnKeyListener(new KeyListener(this ,inputOne ,inputTwo));
        inputThree.setOnKeyListener(new KeyListener(this ,inputTwo ,inputThree));
        inputFour.setOnKeyListener(new KeyListener(this ,inputThree ,inputFour));
        inputFive.setOnKeyListener(new KeyListener(this ,inputFour ,inputFive));
        Utils.requestFocus(this ,inputOne);
    }

    @Override
    public void onArrayUpdate(Integer [] mList) {
        txtOne.setText(String.valueOf(mList[0]));
        txtTwo.setText(String.valueOf(mList[1]));
        txtThree.setText(String.valueOf(mList[2]));
        txtFour.setText(String.valueOf(mList[3]));
        txtFive.setText(String.valueOf(mList[4]));
        list = Arrays.asList(mList);
    }

    @Override
    public void onFinish() {
        setIndicator(true);
        Toast.makeText(this ,"Sorted" ,Toast.LENGTH_SHORT).show();

    }

    private void setIndicator(boolean isFinished){
        txtOne.setBackground(getResources().getDrawable(isFinished?R.drawable.bg_text_success:R.drawable.bg_text));
        txtTwo.setBackground(getResources().getDrawable(isFinished?R.drawable.bg_text_success:R.drawable.bg_text));
        txtThree.setBackground(getResources().getDrawable(isFinished?R.drawable.bg_text_success:R.drawable.bg_text));
        txtFour.setBackground(getResources().getDrawable(isFinished?R.drawable.bg_text_success:R.drawable.bg_text));
        txtFive.setBackground(getResources().getDrawable(isFinished?R.drawable.bg_text_success:R.drawable.bg_text));
    }
    public void clearAll(){
        setIndicator(false);
        inputOne.setText("");
        inputTwo.setText("");
        inputThree.setText("");
        inputFour.setText("");
        inputFive.setText("");
        txtOne.setText("");
        txtTwo.setText("");
        txtThree.setText("");
        txtFour.setText("");
        txtFive.setText("");
    }
}
