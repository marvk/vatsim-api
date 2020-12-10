package net.marvk.fs.vatsim.api.data;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VatsimDataDeserializer implements JsonDeserializer<VatsimData> {
    private final Gson gson;

    public VatsimDataDeserializer() {
        this.gson = new Gson();
    }

    @Override
    public VatsimData deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        final VatsimData result = gson.fromJson(json, VatsimData.class);

        final Map<String, VatsimFacility> facilities = result
                .getFacilities()
                .stream()
                .collect(Collectors.toMap(VatsimFacility::getId, Function.identity()));
        final Map<String, VatsimControllerRating> controllerRatings = result
                .getControllerRatings()
                .stream()
                .collect(Collectors.toMap(VatsimControllerRating::getId, Function.identity()));
        final Map<String, VatsimPilotRating> pilotRatings = result
                .getPilotRatings()
                .stream()
                .collect(Collectors.toMap(VatsimPilotRating::getId, Function.identity()));
        final Map<String, VatsimServer> servers = result
                .getServers()
                .stream()
                .collect(Collectors.toMap(VatsimServer::getId, Function.identity()));

        for (final VatsimPilot pilot : result.getPilots()) {
            pilot.setServer(servers.get(pilot.getServerId()));
            pilot.setRating(pilotRatings.get(pilot.getRatingId()));
        }

        for (final VatsimController controller : result.getControllers()) {
            controller.setServer(servers.get(controller.getServerId()));
            controller.setRating(controllerRatings.get(controller.getRatingId()));
            controller.setFacility(facilities.get(controller.getFacilityId()));
        }

        for (final VatsimAtis atis : result.getAtis()) {
            atis.setServer(servers.get(atis.getServerId()));
            atis.setRating(controllerRatings.get(atis.getRatingId()));
            atis.setFacility(facilities.get(atis.getFacilityId()));
        }

        return result;
    }
}