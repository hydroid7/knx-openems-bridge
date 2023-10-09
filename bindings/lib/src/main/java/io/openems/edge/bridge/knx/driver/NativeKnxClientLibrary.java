package io.openems.edge.bridge.knx.driver;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public interface NativeKnxClientLibrary extends Library {

    NativeKnxClientLibrary INSTANCE = (NativeKnxClientLibrary) Native.load(NativeKnxClientLibrary.class);
    int oc_add_device(String name, String version, String base, String serialnumber, Pointer callback, Pointer data);
    int oc_init_platform(String mfg_name, Pointer init_platform_cb, Pointer data);

    Pointer oc_core_get_device_info(int device);

    class oc_knx_version_info_t extends Structure {
        int major;
        int minor;
        int patch;
    }

    static interface oc_lsm_state {
        public static final int LSM_S_UNLOADED = 0;
        public static final int LSM_S_LOADED = 1;
        public static final int LSM_S_LOADING = 2;
        public static final int LSM_S_UNLOADING = 4;
        public static final int LSM_S_LOADCOMPLETING = 5;
    }
    class oc_device_info_t extends Structure {
        String serialnumber;
        oc_knx_version_info_t hwv;
        oc_knx_version_info_t fwv;
        oc_knx_version_info_t ap;
        String hwt;
        String model;
        String hostname;
        int mid;
        int fid;
        int ia;
        int iid;
        int port;
        int mport;
        boolean pm;

        oc_lsm_state_t lsm_s;
    }

}
