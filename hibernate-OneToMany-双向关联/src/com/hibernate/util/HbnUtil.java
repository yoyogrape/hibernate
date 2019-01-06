package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author songjn
 * @date 2019-1-1 上午10:27:28
 * @desc 获取session工具类
 */

public class HbnUtil {
	private static SessionFactory sessionFactory;

	public static Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null||sessionFactory.isClosed()) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
}
