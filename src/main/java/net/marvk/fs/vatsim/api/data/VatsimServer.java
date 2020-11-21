package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VatsimServer {
    @Expose
    private final String ident;
    @Expose
    @SerializedName("hostname_or_ip")
    private final String hostname;
    @Expose
    private final String location;
    @Expose
    private final String name;
    @Expose
    @SerializedName("clients_connection_allowed")
    private final String clientsConnectionAllowed;
}
