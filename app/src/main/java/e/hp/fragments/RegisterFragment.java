package e.hp.fragments;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;


import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    EditText et_email;
    Button btn_register;




    private Object AwesomeValidation;

    public RegisterFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        EditText et_email = (EditText) view.findViewById(R.id.et_email);
        Button btn_register = (Button) view.findViewById(R.id.btn_register);
        EditText et_name = (EditText) view.findViewById(R.id.et_name);
        EditText et_dob = (EditText) view.findViewById(R.id.et_dob);
        EditText et_password = (EditText) view.findViewById(R.id.et_password);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        EditText et_repassword = (EditText) view.findViewById(R.id.et_repassword);


        AwesomeValidation = new AwesomeValidation(BASIC);
        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_password,regexPassword, "Invalid");

        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_password,regexPassword, "Invalid");
        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_email, EMAIL_PATTERN, "Invalid");
        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_name, "[a-zA-Z\\s]+", "Invalid");
        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_dob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", "Invalid");
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).validate();
            }
        });
        return view;
    }

}
