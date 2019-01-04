package app.demo.com.activeai;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ValidatorTextWatcher implements TextWatcher {
    private EditText editText;
    private EditText edtTxtNextToFocus;
    private Context context;

    public ValidatorTextWatcher(Context context, EditText editText, EditText edtTxtNextToFocus) {
        this.editText = editText;
        this.edtTxtNextToFocus = edtTxtNextToFocus;
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() > 0) {
            editText.clearFocus();
            if (edtTxtNextToFocus != null) {
                Utils.requestFocus(context, edtTxtNextToFocus);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
