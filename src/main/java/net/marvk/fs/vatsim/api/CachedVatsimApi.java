package net.marvk.fs.vatsim.api;

import net.marvk.fs.vatsim.api.data.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class CachedVatsimApi implements VatsimApi {
    private final VatsimApi api;
    private final Duration retainFor;
    private final Cache<VatsimData> dataCache;
    private final Cache<VatsimVatSpy> vatSpy;

    public CachedVatsimApi(final VatsimApi api, final Duration retainFor) {
        this.api = api;
        this.retainFor = retainFor;

        this.dataCache = new Cache<>(api::data);
        this.vatSpy = new Cache<>(api::vatSpy);
    }

    @Override
    public VatsimData data() throws VatsimApiException {
        try {
            return dataCache.get();
        } catch (final Exception e) {
            throw new VatsimApiException(e);
        }
    }

    @Override
    public VatsimMetar metar(final String airportIcao) throws VatsimApiException {
        return api.metar(airportIcao);
    }

    @Override
    public VatsimFirBoundaries firBoundaries() throws VatsimApiException {
        return api.firBoundaries();
    }

    @Override
    public VatsimVatSpy vatSpy() throws VatsimApiException {
        try {
            return vatSpy.get();
        } catch (final Exception e) {
            throw new VatsimApiException(e);
        }
    }

    @Override
    public VatsimEvents events() throws VatsimApiException {
        return api.events();
    }

    @Override
    public VatsimMapData mapData() throws VatsimApiException {
        return api.mapData();
    }

    public void clear() {
        dataCache.clear();
    }

    private class Cache<E> {
        private final Callable<E> supplier;
        private E e;
        private LocalDateTime last;

        public Cache(final Callable<E> supplier) {
            this.supplier = supplier;
            clear();
        }

        public E get() throws Exception {
            synchronized (this) {
                final LocalDateTime now = LocalDateTime.now();
                if (e == null || Duration.between(last, now).compareTo(retainFor) > 0) {
                    last = now;
                    e = supplier.call();
                    return e;
                }

                return e;
            }
        }

        public void clear() {
            synchronized (this) {
                e = null;
                last = LocalDateTime.MIN;
            }
        }
    }

    public static void main(String[] args) throws VatsimApiException, InterruptedException {
        final SimpleVatsimApi a = new SimpleVatsimApi(new ExampleDataSource());
        final VatsimApi b = new CachedVatsimApi(a, Duration.ofSeconds(3));
        final VatsimApi api = b;

        while (true) {

            System.out.println(System.identityHashCode(api.data()));
            Thread.sleep(500);
        }
    }
}
