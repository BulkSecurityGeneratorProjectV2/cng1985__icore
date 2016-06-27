package com.ada.admin.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ada.admin.entity.Menu;
import com.ada.admin.service.MenuService;
import com.ada.shiro.utils.UserUtil;
import com.young.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class MenuChildsDirective implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {

		// 其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断
		Integer id = DirectiveUtils.getInt("id", params);
		Integer size = DirectiveUtils.getInt("size", params);

		List<Menu> menus = menuService.findChild(id);


		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		paramWrap.put("list", ObjectWrapper.BEANS_WRAPPER.wrap(menus));
		Map<String, TemplateModel> origMap = DirectiveUtils.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
	MenuService menuService;
}