package com.dynamicschema.demo;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomPhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Value("${env}")
    private String env;

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            String name = identifier.getText();
            if (name.endsWith("$")) {
                String schema = name.replace("$", env);
                return super.toPhysicalSchemaName(new Identifier(schema, identifier.isQuoted()), jdbcEnvironment);
            }
        }
        return super.toPhysicalSchemaName(identifier, jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            String name = identifier.getText();
            if (name.endsWith("$")) {
                String schema = name.replace("$", env);
                return super.toPhysicalSchemaName(new Identifier(schema, identifier.isQuoted()), jdbcEnvironment);
            }
        }
        return super.toPhysicalCatalogName(identifier, jdbcEnvironment);
    }
}