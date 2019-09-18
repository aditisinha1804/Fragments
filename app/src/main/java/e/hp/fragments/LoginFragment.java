package e.hp.fragments;




import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import static android.content.ContentValues.TAG;
import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;


public class LoginFragment extends Fragment {

    EditText et_email;
    Button btn_login;




    private Object AwesomeValidation;

    public LoginFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText et_email = (EditText) view.findViewById(R.id.et_email);
        Button btn_login = (Button) view.findViewById(R.id.btn_login);
        AwesomeValidation = new AwesomeValidation(BASIC);EditText et_password = (EditText) view.findViewById(R.id.et_password);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_email, "regex", "Invalid");
        ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).addValidation(et_password,regexPassword, "Invalid");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.basgeekball.awesomevalidation.AwesomeValidation) AwesomeValidation).validate();
            }
        });
        return view;
    }}



