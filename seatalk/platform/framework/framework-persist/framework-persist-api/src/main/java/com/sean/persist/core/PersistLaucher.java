package com.sean.persist.core;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sean.log.core.LogFactory;
import com.sean.persist.config.PersistConfig;
import com.sean.persist.dictionary.DictionaryManager;

/**
 * 持久化框架启动器
 * @author sean
 */
public final class PersistLaucher
{
	private static final PersistLaucher instance = new PersistLaucher();
	private boolean isLauched = false;
	public static boolean isUnitTest = false;// 是否为单元测试标记
	private Logger logger = LogFactory.getFrameworkLogger();

	private PersistLaucher()
	{
	}

	public static PersistLaucher getInstance()
	{
		return instance;
	}

	/**
	 * <p>启动持久化框架</p>
	 * <p>只有框架启动后，才可以操作持久化</p>
	 */
	public synchronized void launch()
	{
		if (!isLauched)
		{
			try
			{
				logger.info("Persist start initializing...");
				isLauched = true;

				Map<String, List<Class<?>>> cls = collect();

				// 初始化实体管理器
				EntityManager entityManager = new EntityManager(cls.get("entitys"));

				// 初始化数据库访问接口
				EntityDaoManager entityDaoManager = new EntityDaoManager(entityManager);

				// 初始化动态数据字典
				DictionaryManager dynamicDicManager = new DictionaryManager(cls.get("dictionarys"), cls.get("dictionaryProviders"));

				// 创建PersistContext对象，常驻内存
				PersistContext.CTX = new PersistContext(entityDaoManager, dynamicDicManager);

				logger.info("Persist initialized successfully");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 扫描所有持久化元素
	 * @return
	 */
	private Map<String, List<Class<?>>> collect() throws Exception
	{
		// 扫描类
		ClassCollector collecter = new ClassCollector(PersistConfig.PacketNames.split(","));
		Map<String, List<Class<?>>> classes = collecter.collect();
		return classes;
	}
}
