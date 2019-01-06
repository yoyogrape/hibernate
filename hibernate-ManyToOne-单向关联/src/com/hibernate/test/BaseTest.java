package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.bean.Country;
import com.hibernate.bean.Minister;
import com.hibernate.util.HbnUtil;

/**
 * @author songjn
 * @date 2018-12-31 上午10:01:12
 * @desc hibernate多对一，单向关联，测试类
 */ 

public class BaseTest {
	@Test
	public void testSave() {//保存多方
		Session session = HbnUtil.getSession();
		Country country = new Country("China");
		Minister minister=new Minister("haha");
		minister.setCountry(country);
		try {
			session.beginTransaction();
			session.save(minister);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
