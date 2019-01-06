package com.hibernate.test;

import java.util.Iterator;
import java.util.List;

import javassist.convert.Transformer;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.hibernate.bean.Student;
import com.hibernate.util.HbnUtil;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

/**
 * @author songjn
 * @date 2019-1-1 下午10:17:32
 * @desc HQL语言demo
 */

public class HQLDemo {
	/**
	 * @author songjn
	 * @date 2019-1-1 下午10:18:12
	 * @desc: 向数据库中增加10条数据，为后续查询准备
	 */
	@Test
	public void saveDemoData() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			for (int i = 1; i < 11; i++) {
				// 3.执行操作
				Student student = new Student("songjn"+i, 20+i, 99.00-i);
				session.save(student);
			}
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			//5.事务回滚
			session.getTransaction().rollback();
		}

	}
	/**
	 * @author songjn
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 查询全部（原生sql查询）
	 */
	@Test
	public void selectAllSQL() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			String sql="select * from t_student";
			List<Student> list = session.createSQLQuery(sql).addEntity(Student.class).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 查询全部（hql查询）
	 */
	@Test
	public void selectAllHql() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			/*
			String hql="from Student";
			List<Student> list = session.createQuery(hql).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			*/
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 投影查询（hql查询）
	 */
	@Test
	public void selectTouYing() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			/*
			//需要个双参构造器
			String hql="select new Student(name,age) from Student";
			List<Student> list = session.createQuery(hql).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			*/
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 查询全部（标准查询）纯面向对象
	 */
	@Test
	public void selectAllCriteria() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			//按照年龄降序
			List<Student> list = session.createCriteria(Student.class).addOrder(Order.desc("age")).list();
			//List<Student> list = session.createCriteria(Student.class).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			 
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 动态参数绑定（sql查询）
	 */
	@Test
	public void selectAllByParam() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			//别名必须以：开头。
			String sql="select * from t_student where tage>:myage and tscore>:myscore";
			List<Student> list = ((SQLQuery) session.createSQLQuery(sql)
										.setInteger("myage", 25)
										.setDouble("myscore", 90))
										.addEntity(Student.class).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc 分页查询（sql查询）
	 */
	@Test
	public void selectAllByPage() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			int pageNo=2;
			int pageSize=3;
			int startIndex=(pageNo - 1)*pageSize;
			String sql="select * from t_student";
			List<Student> list = session.createSQLQuery(sql)
								.setFirstResult(startIndex)
								.setMaxResults(pageSize)
								.addEntity(Student.class).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 模糊查询（sql查询）
	 */
	@Test
	public void selectAllByLike() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			//别名必须以：开头。
			String sql="select * from t_student t where t.tname like :myname";
			List<Student> list = ((SQLQuery) session.createSQLQuery(sql)
										.setString("myname", "%2%"))
										.addEntity(Student.class)
										.list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 根据id查询（sql查询）
	 */
	@Test
	public void selectOne() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			//别名必须以：开头。
			String sql="select * from t_student where cid=:myid";
			Student student=(Student)session.createSQLQuery(sql)
											.addEntity(Student.class)
											.setInteger("myid", 2)
											.uniqueResult();
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 投影查询（sql查询），只查询两个参数。
	 * 注意：.list()方法不会从缓存中读取数据，每次都是从数据库中进行数据的读取。
	 */
	@Test
	public void selectTouYing2() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			//别名必须以：开头。
			String sql="select tname name,tage age from t_student";
			List<Student> list=(List<Student>)session.createSQLQuery(sql)
			.setResultTransformer(Transformers.aliasToBean(Student.class))
			.list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
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
	 * @date 2019-1-1 下午11:07:30
	 * @desc: 缓存查询说明（原生sql查询）
	 * .list()方法不会从缓存中读取数据，每次都是从数据库中进行数据的读取。
	 * .iterate():查询先上缓存中查找，人如果哦没有再去是数据库中进行查找。
	 */
	@Test
	public void selectFromSession() {
		// 1.加载主配置文件
		Session session = HbnUtil.getSession();
		try {
			// 2.开启事务
			session.beginTransaction();
			String sql="select * from t_student";
			List<Student> list = session.createSQLQuery(sql).addEntity(Student.class).list();
			for(Student s:list){
				System.out.println("------");
				System.out.println(s);
			}
			System.out.println("======================");
			//异常：sql不支持iterate，需要用hql进行查询师范
			Iterator<Student> iterate = session.createSQLQuery(sql).addEntity(Student.class).iterate();
			while (iterate.hasNext()) {
				Student next = iterate.next();
				System.err.println(next);
				
			}
			//4.事务提交
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//5.事务回滚
			session.getTransaction().rollback();
		}
		
	}

}
