package io.openems.edge.bridge.knx.driver;

import com.sun.jna.Pointer;

public class NativeClient {

    private final NativeKnxClientLibrary nativeLibrary = NativeKnxClientLibrary.INSTANCE;

    public NativeClient(String mfgName) {
        nativeLibrary.oc_init_platform(mfgName,null, null);

    }
}
