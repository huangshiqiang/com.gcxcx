package cn.elwy.eplus.framework.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;

/**
 * @description 对Bean进行操作的相关工具方法
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class BeanUtils1 {
	/**
	 * 将Bean对象转换成Map对象，将忽略掉值为null或size=0的属性
	 * @param obj 对象
	 * @return 若给定对象为null则返回size=0的map对象
	 */
	public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && !name.equals("class")) {
				map.put(name, value);
			}
		}
		return map;
	}

	/**
	 * 该方法将给定的所有对象参数列表转换合并生成一个Map，对于同名属性，依次由后面替换前面的对象属性
	 * @param objs 对象列表
	 * @return 对于值为null的对象将忽略掉
	 */
	public static Map<String, Object> toMap(Object... objs) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object object : objs) {
			if (object != null) {
				map.putAll(toMap(object));
			}
		}
		return map;
	}

}