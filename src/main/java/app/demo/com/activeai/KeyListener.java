package app.demo.com.activeai;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import static app.demo.com.activeai.Utils.requestFocus;


public class KeyListener implements View.OnKeyListener{
    private EditText editText;
    private EditText edtTxtPrevToFocus;
    private Context context;
    public KeyListener(Context context ,EditText edtTxtPrevToFocus, EditText editText) {
        this.editText = editText;
        this.edtTxtPrevToFocus = edtTxtPrevToFocus;
        this.context = context;
    }

    @Override
    public boolean onKey(View view, int actionId, KeyEvent keyEvent) {
        if (KeyEvent.KEYCODE_DEL == actionId) {
            if (editText.getText().length() == 0) {
                if (edtTxtPrevToFocus != null) {
                    editText.clearFocus();
                    requestFocus(context ,edtTxtPrevToFocus);
                }
                return true;
            }
        }
        return false;
    }

}
