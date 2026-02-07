package com.example.sbdocker.domain.model.repository;

import com.example.sbdocker.SbDockerApplication;
import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = SbDockerApplication.class,
        properties = {
                "spring.profiles.active=test",
                "spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1",
                "spring.datasource.driverClassName=org.h2.Driver",
                "spring.datasource.username=sa",
                "spring.datasource.password=",
                "spring.sql.init.mode=never",
                "mybatis.configuration.map-underscore-to-camel-case=true",
                "mybatis.mapper-locations=classpath*:/mapper/*.xml"
        }
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SearchRepository searchRepository;

    @BeforeAll
    void setUpSchema() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(
                new ClassPathResource("dbunit/schema.sql")
        );
        populator.execute(dataSource);
    }

    @BeforeEach
    void setUpData() throws SQLException, DatabaseUnitException, IOException {
        try (Connection connection = dataSource.getConnection()) {
            IDatabaseConnection dbUnitConnection = new DatabaseConnection(connection);
            DatabaseConfig config = dbUnitConnection.getConfig();
            config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

            IDataSet dataSet = new FlatXmlDataSetBuilder()
                    .setColumnSensing(true)
                    .build(new ClassPathResource("dbunit/profiles-dataset.xml").getInputStream());

            DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataSet);
        }
    }

    @Test
    void selectProfiles_filtersByNameAndUnitName() {
        List<SearchResponseResource> results = searchRepository.selectProfiles("A", "U1");

        assertEquals(1, results.size());
        assertEquals("A", results.getFirst().getName());
        assertEquals("U1", results.getFirst().getUnitName());
    }

    @Test
    void selectProfiles_filtersByNameOnly() {
        List<SearchResponseResource> results = searchRepository.selectProfiles("A", null);

        assertEquals(1, results.size());
        assertEquals("A", results.getFirst().getName());
    }

    @Test
    void selectProfiles_filtersByUnitNameOnly() {
        List<SearchResponseResource> results = searchRepository.selectProfiles(null, "U2");

        assertEquals(1, results.size());
        assertEquals("U2", results.getFirst().getUnitName());
    }

    @Test
    void selectProfiles_returnsAllWhenNoFilters() {
        List<SearchResponseResource> results = searchRepository.selectProfiles(null, null);

        assertEquals(2, results.size());
    }
}
