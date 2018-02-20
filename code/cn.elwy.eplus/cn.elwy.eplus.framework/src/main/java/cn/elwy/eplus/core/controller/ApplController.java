package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Appl;
import cn.elwy.eplus.core.service.ApplService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description ApplController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/appl")
public class ApplController extends BaseController<Appl> {

	public ApplController() {
		super("core/appl");
	}

	@Autowired
	public void setService(ApplService service) {
		super.setService(service);
	}

}