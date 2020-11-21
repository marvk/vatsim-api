package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.List;

@Data
public class VatsimData {
    private final VatsimGeneral general;
    private final List<VatsimClient> clients;
    private final List<VatsimServer> servers;
    private final List<VatsimClient> prefiles;
}
