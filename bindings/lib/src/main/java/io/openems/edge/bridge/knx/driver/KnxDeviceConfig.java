package io.openems.edge.bridge.knx.driver;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KnxDeviceConfig {
    private String name;
    private String version;
    private String base;
    private String serialnumber;
}
