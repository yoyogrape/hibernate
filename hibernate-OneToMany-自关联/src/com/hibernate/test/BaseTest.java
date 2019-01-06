package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.bean.NewsLabel;
import com.hibernate.util.HbnUtil;

/**
 * @author songjn
 * @date 2018-12-31 上午10:01:12
 * @desc hibernate一对多，自关联，测试类
 * 
 * 
 */

public class BaseTest {
	@Test
	public void testSave1() {//保存一方
		Session session = HbnUtil.getSession();
		NewsLabel child1 = new NewsLabel("篮球", "哈哈");
		NewsLabel child2 = new NewsLabel("足球", "呵呵");
		NewsLabel parent = new NewsLabel("体育", "父类");
		parent.getChildrens().add(child1);
		parent.getChildrens().add(child2);
		try {
			session.beginTransaction();
			session.save(parent);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	@Test
	public void testSave2() {//保存多方
		Session session = HbnUtil.getSession();
		NewsLabel child1 = new NewsLabel("篮球", "哈哈");
		NewsLabel child2 = new NewsLabel("足球", "呵呵");
		NewsLabel parent = new NewsLabel("体育", "父类");
		child1.setParent(parent);
		child2.setParent(parent);
		try {
			session.beginTransaction();
			session.save(child1);
			session.save(child2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
