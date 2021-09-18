package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.Iterator;
import java.util.List;

@Data
public class VatsimEvents implements Iterable<VatsimEvent> {
    private final List<VatsimEvent> events;

    @Override
    public Iterator<VatsimEvent> iterator() {
        return events.iterator();
    }
}
