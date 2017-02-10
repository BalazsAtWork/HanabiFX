package de.novatec.cg.sc.hanabi;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import de.novatec.cg.sc.hanabi.common.configuration.Config;
import de.novatec.cg.sc.hanabi.common.configuration.ServerConfig;

public class GuiceInjector {

    private static final Injector INJECTOR = Guice.createInjector(new ConfigModule());

    private GuiceInjector() {
    }

    public static final <T> T get(Class<T> type) {
        return INJECTOR.getInstance(type);
    }

    public static final void injectMembersInto(Object object) {
        INJECTOR.injectMembers(object);
    }

    private static class ConfigModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Config.class).to(ServerConfig.class);
        }
    }
}
