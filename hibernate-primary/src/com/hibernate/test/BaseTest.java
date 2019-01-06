package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.bean.Student;

/**
 * @author songjn
 * @date 2018-12-31 上午10:01:12
 * @desc hibernate基础测试类 
 */

public class BaseTest {
	@Test
	public void testSave() {
		// 1.加载主配置文件
		Configuration configuration = new Configuration().configure();
		//Configuration configuration = new Configuration().configure("xxx.cfg.xml");//重载的方法里面可以传参
		// 2.创建session工厂对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 3.获取session对象
		//getCurrentSession：底层是用HashMap实现的，查询当前线程map中是否存在，如果存在则获取对应的session。
		//否则调用openSession方法创建（然后将创建的session保存到map中，key=当前线程，val=session）
		//需要在配置文件中进行注册
		Session session = sessionFactory.getCurrentSession();//session1==session2，返回true。
		//Session session = sessionFactory.openSession()//另一种获取session的方式，session1==session2，返回false。
		try {
			// 4.开启事务
			session.beginTransaction();
			// 5.执行操作
			Student student = new Student("赵六", 26, 99.00);
			session.save(student);
			//6.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//事务回滚
			session.getTransaction().rollback();
		}

	}
}
