package step.learning.ioc;

import com.google.inject.AbstractModule;
import step.learning.services.database.DataBaseProvider;
import step.learning.services.database.MySQLProvider;
import step.learning.services.hash.HashService;
import step.learning.services.hash.Sha1HashService;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DataBaseProvider.class).to(MySQLProvider.class);
        bind(HashService.class).to(Sha1HashService.class);
    }
}
