package forfendsec.com.sgr;
/**
 * Created by Joshua Munaweza on 11/21/17.
 */
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.support.design.widget.TextInputLayout;


public class InputValidation extends AppCompatActivity{
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(AppCompatEditText AppCompatEditText, TextInputLayout TextInputLayout, String message) {
        String value = AppCompatEditText.getText().toString().trim();
        if (value.isEmpty()) {
            TextInputLayout.setError(message);
            hideKeyboardFrom(AppCompatEditText);
            return false;
        } else {
            TextInputLayout.setErrorEnabled(false);
        }

        return true;
    }


    public boolean isInputEditTextEmail(AppCompatEditText AppCompatEditText, TextInputLayout TextInputLayout, String message) {
        String value = AppCompatEditText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            TextInputLayout.setError(message);
            hideKeyboardFrom(AppCompatEditText);
            return false;
        } else {
            TextInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextMatches(AppCompatEditText AppCompatEditText1, AppCompatEditText AppCompatEditText2, TextInputLayout TextInputLayout, String message) {
        String value1 = AppCompatEditText1.getText().toString().trim();
        String value2 = AppCompatEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            TextInputLayout.setError(message);
            hideKeyboardFrom(AppCompatEditText2);
            return false;
        } else {
            TextInputLayout.setErrorEnabled(false);
        }
        return true;
    }


    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}