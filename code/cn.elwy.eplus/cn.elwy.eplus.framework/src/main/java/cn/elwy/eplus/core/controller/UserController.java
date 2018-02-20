package cn.elwy.eplus.core.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.core.service.UserService;
import cn.elwy.eplus.framework.annotation.Function;
import cn.elwy.eplus.framework.controller.BaseController;
import cn.elwy.eplus.framework.web.WebUtil;

/**
 * @description UserController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@Function(code = "user")
@RequestMapping(value = "/user")
public class UserController extends BaseController<User> {

	public UserController() {
		super("core/user");
	}

	@Autowired
	public void setService(UserService service) {
		super.setService(service);
	}

	@Override
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("list");
		return super.list(request, response);
		// mv.addObject(OPERATE, OPERATE_LIST);
	}

	@Override
	public ResultDto query(HttpServletRequest request, HttpServletResponse response) {
		return super.query(request, response);
	}

	@Override
	public ResultDto queryAll(HttpServletRequest request, HttpServletResponse response) {
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		rd = service.queryAll();
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@RequestMapping(value = "/saveUser")
	public ResultDto save(HttpServletRequest request, HttpServletResponse response) {
		ResultDto rd = null;
		String id = WebUtil.getString(request, "id");
		String operate = WebUtil.getString(request, OPERATE);
		User user = new User();
		user.setUserName("userName");
		user.setUserCode("userCode");
		user.setUserType("userType");
		user.setNickname("nickname");
		user.setRoleId("11");
		user.setOrgId("11");
		user.setPostId("11");
		user.setEditState(1);
		user.setAuditState(1);
		user.setPassword("sddfsd");
		user.setCreateTime(new Date());
		user.setCreatorId("11");

		if (AssertUtil.isNotEmpty(id) && AssertUtil.isNotEmpty(operate) && operate.equals(OPERATE_EDIT)) {
			rd = service.updateByPrimaryKey(user);
		} else {
			rd = service.insert(user);
		}
		return rd;
	}

}