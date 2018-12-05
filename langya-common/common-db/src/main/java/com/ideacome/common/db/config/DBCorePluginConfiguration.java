package com.ideacome.common.db.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.ideacome.common.db.service.DataSourceReaderService;
import com.ideacome.common.db.vo.DataSourceVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DBCorePluginConfiguration {
	
	@Bean
	public DataSourceVO getDataSourceVO(DataSourceReaderService dataSourceReaderService){
		DataSourceVO dataSourceVO = new DataSourceVO();
		dataSourceVO.setMasterDriverClassName(dataSourceReaderService.getPropertiesValue("master.jdbc.driverClassName"));
		dataSourceVO.setMasterUrl(dataSourceReaderService.getPropertiesValue("master.jdbc.url"));
		dataSourceVO.setMasterUsername(dataSourceReaderService.getPropertiesValue("master.jdbc.username"));
		dataSourceVO.setMasterPassword(dataSourceReaderService.getPropertiesValue("master.jdbc.password"));
		
		dataSourceVO.setSlaveDriverClassName(dataSourceReaderService.getPropertiesValue("slave.jdbc.driverClassName"));
		dataSourceVO.setSlaveUrl(dataSourceReaderService.getPropertiesValue("slave.jdbc.url"));
		dataSourceVO.setSlaveUsername(dataSourceReaderService.getPropertiesValue("slave.jdbc.username"));
		dataSourceVO.setSlavePassword(dataSourceReaderService.getPropertiesValue("slave.jdbc.password"));
		
		dataSourceVO.setPoolInitialSize(dataSourceReaderService.getPropertiesValue("pool.initialSize"));
		dataSourceVO.setPoolMaxActive(dataSourceReaderService.getPropertiesValue("pool.maxActive"));
		dataSourceVO.setPoolMaxWait(dataSourceReaderService.getPropertiesValue("pool.maxWait"));
		dataSourceVO.setPoolMinIdle(dataSourceReaderService.getPropertiesValue("pool.minIdle"));
		
		return dataSourceVO;
	}
	
	
	@Bean("masterDataSource")
	public BasicDataSource getMasterDataSource(
			DataSourceVO dataSourceVO
			){
		log.error("driverClassName-{},maxActive-{},maxWait-{}",dataSourceVO.getMasterDriverClassName(),dataSourceVO.getPoolMaxActive(),dataSourceVO.getPoolMaxWait());
		BasicDataSource masterDataSource = new BasicDataSource();
		masterDataSource.setDriverClassName(dataSourceVO.getMasterDriverClassName());
		masterDataSource.setUrl(dataSourceVO.getMasterUrl());
		masterDataSource.setUsername(dataSourceVO.getMasterUsername());
		masterDataSource.setPassword(dataSourceVO.getMasterPassword());
		masterDataSource.setMaxActive(Integer.valueOf(dataSourceVO.getPoolMaxActive()));
		masterDataSource.setInitialSize(Integer.valueOf(dataSourceVO.getPoolInitialSize()));
		masterDataSource.setMaxWait(Long.valueOf(dataSourceVO.getPoolMaxWait()));
		masterDataSource.setMinIdle(Integer.valueOf(dataSourceVO.getPoolMinIdle()));
		initDataSource(masterDataSource);
		
		return masterDataSource;
	}
	
	@Bean("slaveDataSource")
	public BasicDataSource getSlaveDataSource(
			DataSourceVO dataSourceVO
			){
		BasicDataSource slaveDataSource = new BasicDataSource();
		slaveDataSource.setDriverClassName(dataSourceVO.getSlaveDriverClassName());
		slaveDataSource.setUrl(dataSourceVO.getSlaveUrl());
		slaveDataSource.setUsername(dataSourceVO.getSlaveUsername());
		slaveDataSource.setPassword(dataSourceVO.getSlavePassword());
		slaveDataSource.setMaxActive(Integer.valueOf(dataSourceVO.getPoolMaxActive()));
		slaveDataSource.setInitialSize(Integer.valueOf(dataSourceVO.getPoolInitialSize()));
		slaveDataSource.setMaxWait(Long.valueOf(dataSourceVO.getPoolMaxWait()));
		slaveDataSource.setMinIdle(Integer.valueOf(dataSourceVO.getPoolMinIdle()));
		initDataSource(slaveDataSource);
		
		return slaveDataSource;
	}
	
	private void initDataSource(BasicDataSource basicDataSource){
		basicDataSource.setTimeBetweenEvictionRunsMillis(3000);
		basicDataSource.setMinEvictableIdleTimeMillis(300000);
		basicDataSource.setValidationQuery("SELECT 1");
		basicDataSource.setTestWhileIdle(true);
		basicDataSource.setTestOnBorrow(false);
		basicDataSource.setTestOnReturn(false);
		basicDataSource.setPoolPreparedStatements(true);
	}
	
	@Bean("dataSource")
	public DynamicDataSource getDynamicDataSource(BasicDataSource masterDataSource,BasicDataSource slaveDataSource){
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("slave", slaveDataSource);
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
		
		return dynamicDataSource;
	}
	
	@Bean("transactionManager")
	public DataSourceTransactionManager getDataSourceTransactionManager(DynamicDataSource dataSource){
		DataSourceTransactionManager dataSourceTransationManager = new DataSourceTransactionManager();
		dataSourceTransationManager.setDataSource(dataSource);
		
		return dataSourceTransationManager;
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactoryBean(DynamicDataSource dataSource){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.ideacome.common.db.domain");
        bean.setConfigLocation(new ClassPathResource("mybatis/myBatisContext.xml"));
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        try {
        	bean.setMapperLocations(resolver.getResources("classpath:/com/ideacome/common/db/persistence/*.xml"));
			return bean.getObject();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@Bean("mapperScaner")
	public MapperScannerConfigurer getMapperScannerConfigurer(SqlSessionFactory sqlSessionFactory){
		MapperScannerConfigurer mapperScaner = new MapperScannerConfigurer();
		mapperScaner.setBasePackage("com.ideacome.common.db.mapper");
		mapperScaner.setSqlSessionFactory(sqlSessionFactory);
		
		return mapperScaner;
	}
	
}
