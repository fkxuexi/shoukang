package ${config.basePackage!}.${convention.packageName};

import ${config.basePackage!}.${entityConvention.packageName}.${data.javaDbName}${entityConvention.suffix};
import ${config.basePackage!}.${serviceConvention.packageName}.${data.javaDbName}${serviceConvention.suffix};
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import utils.BaseResult;
import utils.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/${data.javaDbName?uncap_first}")
public class ${data.javaDbName}${convention.suffix} {

	@Autowired
	private ${data.javaDbName}${serviceConvention.suffix} ${data.javaDbName?uncap_first}${serviceConvention.suffix};

	@RequestMapping("/from")
	@ResponseBody
	public BaseResult from(${data.javaDbName} ${data.javaDbName?uncap_first}){
		
		${data.javaDbName?uncap_first} = ${data.javaDbName?uncap_first}${serviceConvention.suffix}.get(<#rt>
		<#list data.pkList as pk>
		<#if pk_has_next>
			<#lt>${data.javaDbName?uncap_first}.get${pk.javaAttrName?cap_first}(),<#rt>
		<#else>
			<#lt>${data.javaDbName?uncap_first}.get${pk.javaAttrName?cap_first}()<#rt>
		</#if>
		</#list>
		<#lt>);
		
		BaseResult result = new BaseResult(ResultCode.SUCCESS,true,"获取成功",${data.javaDbName?uncap_first});
		return result;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public BaseResult page(@RequestParam(value = "pageSize", required = false, defaultValue = "30")Integer pageSize,
						   @RequestParam(value = "currentPage", required = false, defaultValue = "1")Integer currentPage,
						   @RequestParam(value = "${data.javaDbName?uncap_first}", required = false)${data.javaDbName} ${data.javaDbName?uncap_first}){
		
		if(${data.javaDbName?uncap_first} == null){
			${data.javaDbName?uncap_first} = new ${data.javaDbName}();
		}
	
		PageInfo<${data.javaDbName}> page = ${data.javaDbName?uncap_first}${serviceConvention.suffix}.page(${data.javaDbName?uncap_first}, pageSize, currentPage);
		
		BaseResult result = new BaseResult(ResultCode.SUCCESS,true,"获取成功",page);
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public BaseResult save(${data.javaDbName} ${data.javaDbName?uncap_first}){
		BaseResult result = null;
		// 在这里可以做一些校验
		if(${data.javaDbName?uncap_first} == null){
			result = new BaseResult(ResultCode.PARAM_NULL,false,"插入失败，参数不能为空");
			return result;
		}
		int effectRows = ${data.javaDbName?uncap_first}${serviceConvention.suffix}.save(${data.javaDbName?uncap_first});
		
		if(effectRows > 0){
			result = new BaseResult(ResultCode.SUCCESS,true,"插入成功");
			return result;
		}

		result = new BaseResult(ResultCode.FAILD,false,"插入失败");
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public BaseResult update(${data.javaDbName} ${data.javaDbName?uncap_first}){
		BaseResult result = null;
		// 在这里可以做一些校验
		if(${data.javaDbName?uncap_first} == null){
			result = new BaseResult(ResultCode.PARAM_NULL,false,"参数不能为空");
			return result;
		}
		
		int effectRows = ${data.javaDbName?uncap_first}${serviceConvention.suffix}.update(${data.javaDbName?uncap_first});
		
		if(effectRows > 0){
			result = new BaseResult(ResultCode.SUCCESS,true,"更新成功");
			return result;
		}

		result = new BaseResult(ResultCode.FAILD,false,"更新失败");
		return result;
	}

	
}