package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimServer {
    @SerializedName("ident")
    private final String id;

    @SerializedName("hostname_or_ip")
    private final String hostname;

    private final String location;

    private final String name;

    @SerializedName("clients_connection_allowed")
    private final String clientsConnectionAllowed;
}
