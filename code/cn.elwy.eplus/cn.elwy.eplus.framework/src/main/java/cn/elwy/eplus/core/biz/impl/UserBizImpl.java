package cn.elwy.eplus.core.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import cn.elwy.common.entity.Parameter;
import cn.elwy.eplus.core.biz.UserBiz;
import cn.elwy.eplus.core.dao.UserDao;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.framework.annotation.DataAuth;
import cn.elwy.eplus.framework.annotation.Function;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
@Function(code = "user")
public class UserBizImpl extends BizImpl<User> implements UserBiz {

	/**
	 * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
	 */
	public static final String CONSTANT = "CONSTANT";
	/**
	 * 缓存的key
	 */
	public static final String QUERY_USER = "\"QUERY_USER\"";

	@Resource(name = "userDao")
	public void setUserDao(UserDao dao) {
		super.setDao(dao);
	}

	@Override
	@DataAuth(codes = { "tt" })
	@Cacheable(value = CONSTANT, key = "#parameter.toString()")
	public List<User> queryByCondition(Parameter parameter) {
		System.out.println(parameter);
		return super.queryByCondition(parameter);
	}

	@DataAuth(codes = { "tt" })
	@Cacheable(value = CONSTANT, key = "#parameter.toString()")
	public List<User> queryByCondition(Parameter parameter, int test) {
		System.out.println(parameter);
		return super.queryByCondition(parameter);
	}

	@Override
	@DataAuth(codes = { "tt" })
	@Cacheable(value = CONSTANT)
	public List<User> queryAll() {
		System.out.println("没走缓存");
		return super.queryAll();
	}

	@CacheEvict(value = CONSTANT, key = QUERY_USER)
	public User insert(User entity) {
		return super.insert(entity);
	}

}