package de.novatec.cg.sc.hanabi;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

import de.novatec.cg.sc.hanabi.common.configuration.Config;
import de.novatec.cg.sc.hanabi.common.configuration.LiveConfig;
import de.novatec.cg.sc.hanabi.common.configuration.LocalConfig;

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
            bind(Config.class).annotatedWith(Names.named("local")).to(LocalConfig.class);
            bind(Config.class).annotatedWith(Names.named("live")).to(LiveConfig.class);
        }
    }
}
