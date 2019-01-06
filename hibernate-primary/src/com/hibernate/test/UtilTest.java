package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.bean.Student;
import com.hibernate.util.HbnUtil;

/**
 * @author songjn
 * @date 2019-1-1 下午01:46:34
 * @desc 制作完工具类之后的测试
 */

public class UtilTest {
	/**
	 * 
	 * @author songjn
	 * @date 2019-1-1 下午01:56:10
	 * @desc: 增
	 */
	@Test
	public void testSave() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = new Student("zhangsna", 26, 99.00);
			session.save(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//5.事务回滚
			session.getTransaction().rollback();
		}

	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:04:55
	 * @desc:  persist：保证当它在一个事物外部被调用时，并不立即转换成 insert 语句
	 */
	@Test
	public void testPersist() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = new Student("zhangsna", 26, 99.00);
			session.persist(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//5.事务回滚
			session.getTransaction().rollback();
		}
		
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:46:06
	 * @desc: saveOrUpdate:有id执行update（若该id不存在则抛出异常），没有id执行save；
	 */
	@Test
	public void testSaveOrUpdate() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = new Student("zhangsna", 26, 99.00);
			student.setId(20);
			session.saveOrUpdate(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}

	}
	/**
	 * 
	 * @author songjn
	 * @date 2019-1-1 下午01:56:50
	 * @desc: 删
	 */
	@Test
	public void testDel() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = new Student();
			//删除的条件是对象要有Id
			student.setId(1);
			session.delete(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//5.事务回滚
			session.getTransaction().rollback();
		}
		
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午01:57:54
	 * @desc: 改
	 */
	@Test
	public void testUpdate() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = new Student("haha",29,99.0);
			//修改的条件是有Id	
			student.setId(5);
			session.update(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:05:50
	 * @desc: get查：如果该id不存在查出来的为null。
	 */
	@Test
	public void testSelect() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = session.get(Student.class,10);
			System.out.println(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:09:02
	 * @desc: load查：如果该id不存在会直接抛出异常。
	 */
	@Test
	public void testLoad() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = session.load(Student.class,10);
			System.out.println(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:55:32
	 * @desc: 测试查询操作是否可以在非事务下进行。
	 */
	@Test
	public void testTransaction() {
		// 1.加载主配置文件
		//通过getCurrentSession获取的session查询操作必须在事务中执行。
		//Session session = HbnUtil.getSession();
		//通过openSession获取的session查询可以不在事务中执行。
		Session session = new Configuration().buildSessionFactory().openSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = session.load(Student.class,10);
			System.out.println(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午02:58:30
	 * @desc: 增删改查放到一个事务中会有默认的顺序。
	 * 默认顺序为：增、改、删，可以用session.flush()去按照自己的顺序执行。
	 */
	@Test
	public void testCURD() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			// 3.执行操作
			Student student = session.load(Student.class,10);
			System.out.println(student);
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
	}
}
