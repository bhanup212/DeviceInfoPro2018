package latestdeviceinfpro2018.pasupula.bhanupro.deviceinfopro;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends Fragment {

    TextView busybox, superuser, rootaccess, path;


    public RootFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_root, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rootaccess = view.findViewById(R.id.roo_access_txt);
        superuser = view.findViewById(R.id.super_user_txt);
        busybox = view.findViewById(R.id.busy_box_txt);
        path = view.findViewById(R.id.path_txt);
        isRooted();

    }

    public  void isRooted(){
        String buildTags = Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")){
            rootaccess.setText("Device rooted");
            rootaccess.setTextColor(Color.GREEN);

            superuser.setTextColor(Color.GREEN);
            superuser.setText("SU FOUND");

            busybox.setTextColor(Color.GREEN);
            busybox.setText("Busy box installed");
        }else{
            rootaccess.setText("Device is not rooted");
            rootaccess.setTextColor(Color.RED);

            superuser.setText("SU NOT FOUND");
            superuser.setTextColor(Color.RED);

            busybox.setTextColor(Color.RED);
            busybox.setText("Busy box not installed");
        }

        File file = new File("/system/app/Superuser.apk");
        if (file.exists()){
            rootaccess.setTextColor(Color.BLUE);
        }
    }
}
