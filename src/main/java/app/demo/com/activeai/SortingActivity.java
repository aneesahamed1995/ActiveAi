package app.demo.com.activeai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortingActivity extends AppCompatActivity {


    @BindView(R.id.btnSort)
    Button btnSort;
    String code;
    int arr[] = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_layout);
        ButterKnife.bind(this);
        if(getIntent()!= null){
            code = getIntent().getStringExtra("value");
            for(int i=0;i<code.length();i++){
                arr[i] = Character.getNumericValue(code.charAt(i));
            }
        }

    }
}
