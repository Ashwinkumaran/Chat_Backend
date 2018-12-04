package com.coll.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.Model.ApplyingJob;
import com.coll.Model.Blog;
import com.coll.Model.BlogComment;
import com.coll.Model.Forum;
import com.coll.Model.ForumComment;
import com.coll.Model.Friend;
import com.coll.Model.Job;
import com.coll.Model.ProfilePicture;
import com.coll.Model.UserDetail;

@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement
public class DBConfig 
{   @Bean(name="dataSource")
	public DataSource getDataSource()
	{
	    DriverManagerDataSource dataSource=new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("mycoll");
		dataSource.setPassword("pass123");
	    return dataSource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder localsessionFactory = new LocalSessionFactoryBuilder(getDataSource());
		localsessionFactory.addProperties(hibernateProperties);
		localsessionFactory.addAnnotatedClass(Blog.class);	
		localsessionFactory.addAnnotatedClass(BlogComment.class);
		localsessionFactory.addAnnotatedClass(UserDetail.class);
		localsessionFactory.addAnnotatedClass(Forum.class);
		localsessionFactory.addAnnotatedClass(ForumComment.class);
		localsessionFactory.addAnnotatedClass(Friend.class);
	    localsessionFactory.addAnnotatedClass(ApplyingJob.class);
		localsessionFactory.addAnnotatedClass(Job.class);
		localsessionFactory.addAnnotatedClass(ProfilePicture.class);
		SessionFactory sessionFactory = localsessionFactory.buildSessionFactory();
		return sessionFactory;
		
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
	return new HibernateTransactionManager(sessionFactory);
}
}
