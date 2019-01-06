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
 * @desc hibernate一对多，单向关联，一方维护，测试类
 * 
 * 不出错原则：谁维护就save谁。（这里是country进行维护，所以.save(country)）
 * 
 * 程序运行原理：
 * 一对多关系在进行保存的时候，先保存对方表数据，然后在保存自己表。
 * 如果save的是一方，那么先保存多方，在保存一方，再更新一方表的外键。update进行维护。
 * 如果save的是多方，那么先保存一方，再保存多方。insert进行维护。
 * 
 * 如下：
 * 一对多，save一方country，那么先插入minister，然后在插入country，最后更行minister的外键。
 */

public class BaseTest {
	@Test
	public void testSave() {
		Session session = HbnUtil.getSession();
		Country country = new Country("China");
		country.getMinisters().add(new Minister("haha"));
		country.getMinisters().add(new Minister("gaga"));
		country.getMinisters().add(new Minister("xixi"));
		try {
			session.beginTransaction();
			session.save(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
