package latestdeviceinfpro2018.pasupula.bhanupro.deviceinfopro;


import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceFragment extends Fragment {

    TextView brand, model, display,version,sdk_version,sdk_release, device_id, hardware_serial, local_ip, mac_address;


    public DeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_device, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        brand = view.findViewById(R.id.device_name_txt);
        String brandName = Build.MANUFACTURER;
        brand.setText(brandName);

        String modelname = Build.MODEL;
        model = view.findViewById(R.id.device_model_txt);
        model.setText(modelname);
        //version = view.findViewById(R.id.device_version_txt);
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;

        //String versionname = Build.VERSION;
        sdk_release = view.findViewById(R.id.device_sdk_release_txt);
        sdk_release.setText(release);

        sdk_version = view.findViewById(R.id.device_sdk_version_txt);
        //String sdk_version_string = Integer.toString(sdkVersion);
        sdk_version.setText(Integer.toString(sdkVersion));

        device_id = view.findViewById(R.id.device_id_txt);
        String deviceidname = Build.ID;
        device_id.setText(deviceidname);

        hardware_serial = view.findViewById(R.id.device_serial_txt);
        String hwserialName = Build.HARDWARE;
        hardware_serial.setText(hwserialName);

        display = view.findViewById(R.id.display_txt);
        String dis = Build.DISPLAY;
        display.setText(dis);

        local_ip = view.findViewById(R.id.device_local_ip_txt);

        //String macAddress = wimanager.getConnectionInfo().getMacAddress();
        mac_address = view.findViewById(R.id.device_mac_address_txt);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            String address = getMacAddr();
            mac_address.setText(address);
        }else{
            WifiManager manager = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            String address2 = info.getMacAddress();
            mac_address.setText(address2);
        }

    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }
}
