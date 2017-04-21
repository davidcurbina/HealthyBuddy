package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */


import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TabFragment4 extends Fragment {

    Button userEdit;
    Button trainerEdit;
    EditText userName;
    EditText userEmail;
    EditText trainerEmail;
    EditText trainerSummary;
    EditText trainerPhone;
    boolean trainerEditing;
    boolean userEditing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_fragment_4, container, false);

        trainerEditing = false;
        userEditing = false;

        trainerEdit = (Button) v.findViewById(R.id.trainer_edit);
        userEdit = (Button) v.findViewById(R.id.user_edit);
        userName = (EditText) v.findViewById(R.id.user_name);
        trainerEmail = (EditText) v.findViewById(R.id.trainer_email);
        userEmail = (EditText) v.findViewById(R.id.user_email);
        trainerSummary = (EditText) v.findViewById(R.id.trainer_summary);
        trainerPhone = (EditText) v.findViewById(R.id.trainer_mobile);

        userEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Frag 4", "Clicked Edit");
                if (userEditing){
                    userName.setEnabled(false);
                    userEmail.setEnabled(false);
                    userEdit.setText("Edit");
                    userEditing = false;
                }
                else{
                    userName.setEnabled(true);
                    userEmail.setEnabled(true);
                    userEdit.setText("Done");
                    userEditing = true;
                }
            }
        });
        trainerEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trainerEditing){
                    trainerEmail.setEnabled(false);
                    trainerSummary.setEnabled(false);
                    trainerSummary.setEnabled(true);
                    trainerEdit.setText("Edit");
                    trainerEditing = false;
                }
                else{
                    trainerEmail.setEnabled(true);
                    trainerSummary.setEnabled(true);
                    trainerPhone.setEnabled(true);
                    trainerEdit.setText("Done");
                    trainerEditing = true;
                }
            }
        });
        return v;
    }
}