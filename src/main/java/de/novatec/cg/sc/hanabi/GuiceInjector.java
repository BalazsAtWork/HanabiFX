package de.novatec.cg.sc.hanabi;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceInjector {

    private static final Injector INJECTOR = Guice.createInjector();

    private GuiceInjector() {
    }

    public static final <T> T get(Class<T> type) {
        return INJECTOR.getInstance(type);
    }

    public static final void injectMembersInto(Object object) {
        INJECTOR.injectMembers(object);
    }
}
