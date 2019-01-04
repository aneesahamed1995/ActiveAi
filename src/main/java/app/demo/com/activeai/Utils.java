package app.demo.com.activeai;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Utils {
    public static void requestFocus(Context context, EditText editText) {
        editText.clearFocus();
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        }
        editText.setSelection(editText.getText().length());
    }
}
