package com.home_trial.myapplication;

import java.util.Vector;

public class EventsInjection {

    private static EventsInjection eventsInjection;
    //    private Vector<Injector> injectorList = new Vector<>();
    private Injector injector;

    private EventsInjection() {
    }


    public static EventsInjection getInstance() {
        if (eventsInjection == null) {
            eventsInjection = new EventsInjection();
        }
        return eventsInjection;
    }

    public void addListener(Injector injector) {
//        if (injector != null)
//            injectorList.add(injector);
        this.injector = injector;
    }

    public void removeListener() {
//        injectorList.removeAllElements();
        injector = null;
    }


    public void inject(int injectedEvent) {
        injector.injectEvent(injectedEvent);
    }

    public interface Injector {

        void injectEvent(int injectedEvent);
    }
}
