package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.bean.Course;
import com.hibernate.bean.Student;
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
		Student s1 = new Student("zhang3");
		Student s2 = new Student("li4");
		s1.getCourses().add(new Course("javaSE"));
		s1.getCourses().add(new Course("msd"));
		s2.getCourses().add(new Course("cad"));
		s2.getCourses().add(new Course("javaEE"));

		try {
			session.beginTransaction();
			session.save(s1);
			session.save(s2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
}
