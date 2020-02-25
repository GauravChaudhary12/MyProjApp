package in.nit.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import in.nit.interceptor.TimeCheckInterceptor;
import in.nit.model.Document;
import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;


@EnableTransactionManagement
@Configuration
@PropertySource("classpath:app.properties")
@EnableWebMvc
@ComponentScan("in.nit")
public class AppConfig  implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource ds() {
		BasicDataSource d = new BasicDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.user"));
		d.setPassword(env.getProperty("db.password"));
		return d;
	}
	
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean b = new LocalSessionFactoryBean();
		b.setDataSource(ds());
		b.setAnnotatedClasses(ShipmentType.class,OrderMethod.class,Uom.class,Document.class);
		//b.setAnnotatedPackages("in.nit.model");
		b.setHibernateProperties(props());
		return b;
	}
	
	private Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect",env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		return p;
	}
	
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h = new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	
	@Bean
	public HibernateTransactionManager htx() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	}
	
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}
	
	
//	@Bean
//	public  TimeCheckInterceptor tci() {
//		TimeCheckInterceptor t = new TimeCheckInterceptor();
//		return t;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(tci());
//	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}



