package latestdeviceinfpro2018.pasupula.bhanupro.deviceinfopro;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HardwareFragment extends Fragment {

    TextView Bootloader,Board, Cpu_one, Cpu_two, Fingerrint, Release, Base_os, Preview_sdk, Security_patch,
                Hardware, Host, Id, Tags, Type, Codename,Incremental, Sdk_int, Radio, user;


    public HardwareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hardware, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bootloader = view.findViewById(R.id.bootloader_txt);
        String booloader = Build.BOOTLOADER;
        Bootloader.setText(booloader);

        Board = view.findViewById(R.id.board_txt);
        String board = Build.BOARD;
        Board.setText(board);

        Cpu_one = view.findViewById(R.id.cpu_one_txt);
        String cpu1 = Build.CPU_ABI;
        Cpu_one.setText(cpu1);

        Cpu_two = view.findViewById(R.id.cpu_two_txt);
        String cpu2 = Build.CPU_ABI2;
        Cpu_two.setText(cpu2);

        Fingerrint = view.findViewById(R.id.fingerprint_txt);
        String finger = Build.FINGERPRINT;
        Fingerrint.setText(finger);

        Hardware = view.findViewById(R.id.hardware_txt);
        String hardware = Build.HARDWARE;
        Hardware.setText(hardware);

        Host = view.findViewById(R.id.host_txt);
        String host = Build.HOST;
        Host.setText(host);

        Id = view.findViewById(R.id.id_txt);
        String id = Build.ID;
        Id.setText(id);

        Tags = view.findViewById(R.id.tags_txt);
        String tags = Build.TAGS;
        Tags.setText(tags);

        Codename = view.findViewById(R.id.codename_txt);
        String codename = Build.VERSION.CODENAME;
        Codename.setText(codename);

        Radio = view.findViewById(R.id.radio_txt);
        String radio = Build.RADIO;
        Radio.setText(radio);

        Type = view.findViewById(R.id.type_txt);
        String type = Build.TYPE;
        Type.setText(type);

        Incremental = view.findViewById(R.id.incremental_txt);
        String incre = Build.VERSION.INCREMENTAL;
        Incremental.setText(incre);

        Sdk_int = view.findViewById(R.id.sdk_int_txt);
        String sdk = String.valueOf(Build.VERSION.SDK_INT);
        Sdk_int.setText(sdk);

        Release = view.findViewById(R.id.release_txt);
        String rele = Build.VERSION.RELEASE;
        Release.setText(rele);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Security_patch = view.findViewById(R.id.security_patch_txt);
            String patch = Build.VERSION.SECURITY_PATCH;
            Security_patch.setText(patch);

            Preview_sdk = view.findViewById(R.id.preview_sdk_int_txt);
            String preview = String.valueOf(Build.VERSION.PREVIEW_SDK_INT);
            Preview_sdk.setText(preview);

            Base_os = view.findViewById(R.id.base_os_txt);
            String base_os = Build.VERSION.BASE_OS;
            Base_os.setText(base_os);
        }

        user = view.findViewById(R.id.user_text);
        String u = Build.USER;
        user.setText(u);

        super.onViewCreated(view, savedInstanceState);
    }
}
