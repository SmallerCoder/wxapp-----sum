package club.wokao666.datasource;
	import java.sql.SQLException;
	import javax.sql.DataSource;
	import org.apache.ibatis.session.SqlSessionFactory;
	import org.mybatis.spring.SqlSessionFactoryBean;
	import org.mybatis.spring.SqlSessionTemplate;
	import org.mybatis.spring.annotation.MapperScan;
	import org.springframework.beans.factory.annotation.Qualifier;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DataSourceTransactionManager;
	import com.alibaba.druid.pool.DruidDataSource;
	/**
	 * 数据源配置(后台数据配置源)
	 */
	@Configuration
	@MapperScan(basePackages = "club.wokao666.dao", sqlSessionTemplateRef = "wxappSqlSessionTemplate")
	public class WxAppDataSourceConfig {

		@Value("${spring.datasource.wxapp.url}")
		private String dbUrl;

		@Value("${spring.datasource.wxapp.username}")
		private String username;

		@Value("${spring.datasource.wxapp.password}")
		private String password;

		@Value("${spring.datasource.wxapp.driverClassName}")
		private String driverClassName;

		@Value("${spring.datasource.wxapp.initialSize}")
		private int initialSize;

		@Value("${spring.datasource.wxapp.minIdle}")
		private int minIdle;

		@Value("${spring.datasource.wxapp.maxActive}")
		private int maxActive;

		@Value("${spring.datasource.wxapp.maxWait}")
		private int maxWait;

		@Value("${spring.datasource.wxapp.timeBetweenEvictionRunsMillis}")
		private int timeBetweenEvictionRunsMillis;

		@Value("${spring.datasource.wxapp.minEvictableIdleTimeMillis}")
		private int minEvictableIdleTimeMillis;

		@Value("${spring.datasource.wxapp.validationQuery}")
		private String validationQuery;

		@Value("${spring.datasource.wxapp.testWhileIdle}")
		private boolean testWhileIdle;

		@Value("${spring.datasource.wxapp.testOnBorrow}")
		private boolean testOnBorrow;

		@Value("${spring.datasource.wxapp.testOnReturn}")
		private boolean testOnReturn;

		@Value("${spring.datasource.wxapp.filters}")
		private String filters;
		@Bean(name = "wxappDataSource")
		@ConfigurationProperties(prefix = "spring.datasource.wxapp")
		public DataSource testDataSource() {
			// return DataSourceBuilder.create().build();
			DruidDataSource datasource = new DruidDataSource();
			datasource.setUrl(this.dbUrl);
			datasource.setUsername(username);
			datasource.setPassword(password);
			datasource.setDriverClassName(driverClassName);
			// configuration
			datasource.setInitialSize(initialSize);
			datasource.setMinIdle(minIdle);
			datasource.setMaxActive(maxActive);
			datasource.setMaxWait(maxWait);
			datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
			datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
			datasource.setValidationQuery(validationQuery);
			datasource.setTestWhileIdle(testWhileIdle);
			datasource.setTestOnBorrow(testOnBorrow);
			datasource.setTestOnReturn(testOnReturn);
			try {
				datasource.setFilters(filters);
			} catch (SQLException e) {
				System.err.println("druid configuration initialization filter:" + e);
				e.printStackTrace();
			}
			return datasource;
		}

		@Bean(name = "wxappSqlSessionFactory")
		public SqlSessionFactory testSqlSessionFactory(@Qualifier("wxappDataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "wxappTransactionManager")
		public DataSourceTransactionManager testTransactionManager(@Qualifier("wxappDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

		@Bean(name = "wxappSqlSessionTemplate")
		public SqlSessionTemplate testSqlSessionTemplate(
				@Qualifier("wxappSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
}
