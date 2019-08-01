package ru.levin.tmspring.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.hibernate.cfg.Environment;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.levin.tmspring.api.endpoint.IProjectEndpoint;
import ru.levin.tmspring.api.endpoint.ITaskEndpoint;
import ru.levin.tmspring.api.feign.IProjectClient;
import ru.levin.tmspring.api.feign.ITaskClient;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ru.levin.tmspring")
@EnableJpaRepositories(basePackages = "ru.levin.tmspring.api.repository")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
@EnableWebMvc
@EnableFeignClients
public class WebMvcConfig implements WebMvcConfigurer {

    private SpringBus bus;

    @Bean
    public IProjectClient getIProject() {
        return IProjectClient.client("http://localhost:8888/tmspring/api");
    }

    @Bean
    public ITaskClient getITask() {
        return ITaskClient.client("http://localhost:8888/tmspring/api");
    }

    @Bean
    public Endpoint endpointProject(IProjectEndpoint projectEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, projectEndpoint);
        endpoint.publish("/projectEndpoint");
        return endpoint;
    }

    @Bean
    public Endpoint endpointTask(ITaskEndpoint taskEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, taskEndpoint);
        endpoint.publish("/taskEndpoint");
        return endpoint;
    }

    @Autowired
    public void setBus(final SpringBus bus) {
        this.bus = bus;
    }

    @Bean
    public DataSource dataSource(
            @Value("${datasource.driver}") final String dataSourceDriver,
            @Value("${datasource.url}") final String dataSourceUrl,
            @Value("${datasource.user}") final String dataSourceUser,
            @Value("${datasource.password}") final String dataSourcePassword) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceDriver);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUser);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource dataSource,
            @Value("${hibernate.show_sql}") final boolean showSql,
            @Value("${hibernate.hbm2ddl.auto}") final String tableStrategy,
            @Value("${hibernate.dialect}") final String dialect) {
        final LocalContainerEntityManagerFactoryBean factoryBean;
        factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("ru.levin.tmspring.entity", "ru.levin.tmspring.dto");
        final Properties properties = new Properties();
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", tableStrategy);
        properties.put("hibernate.dialect", dialect);
        properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
        properties.put(Environment.USE_QUERY_CACHE, "true");
        properties.put(Environment.USE_MINIMAL_PUTS, "true");
        properties.put(Environment.CACHE_REGION_PREFIX, "tmspring");
        properties.put(Environment.CACHE_PROVIDER_CONFIG, "hazelcast.xml");
        properties.put(Environment.CACHE_REGION_FACTORY, "com.hazelcast.hibernate.HazelcastLocalCacheRegionFactory");
        properties.put("hibernate.cache.hazelcast.use_lite_member", "true");
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final LocalContainerEntityManagerFactoryBean emf) {
        @NotNull final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;
    }

}