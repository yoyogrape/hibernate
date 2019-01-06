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
 * @desc hibernate一对多，双向关联，测试类
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
 * 
 * 注意：
 * 1.双向关联的时候toString()时，只要求一方可以输出对方即可。若双方都输出对方，会形成递归，会出错。
 * 2.多方在many-to-one的里面需要标明外键countryId，必须和一方表的外键相同。
 */

public class BaseTest {
	@Test
	public void testSave1() {//保存一方
		Session session = HbnUtil.getSession();
		Country country = new Country("China");
		country.getMinisters().add(new Minister("haha"));
		try {
			session.beginTransaction();
			session.save(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	@Test
	public void testSave2() {//保存多方
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
