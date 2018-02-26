package ${config.basePackage!}.${convention.packageName};

import java.util.List;
import ${config.basePackage!}.${daoConvention.packageName}.${data.javaDbName}${daoConvention.suffix};
import ${config.basePackage!}.${entityConvention.packageName}.${data.javaDbName}${entityConvention.suffix};
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ${data.javaDbName}${convention.suffix} {
	
	@Autowired
	private ${data.javaDbName}${daoConvention.suffix} ${data.javaDbName?uncap_first}${daoConvention.suffix};



	public ${data.javaDbName} get(<#rt>
	<#list data.pkList as pk>
	<#if pk_has_next>
		<#lt>${pk.javaAttrType} ${pk.javaAttrName},<#rt>
	<#else>
		<#lt>${pk.javaAttrType} ${pk.javaAttrName}<#rt>
	</#if>
	</#list>
	<#lt>){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.get(<#rt>
	<#list data.pkList as pk>
	<#if pk_has_next>
		<#lt>${pk.javaAttrName},<#rt>
	<#else>
		<#lt>${pk.javaAttrName}<#rt>
	</#if>
	</#list>
	<#lt>);
	}
	
	public PageInfo<${data.javaDbName}> page(${data.javaDbName} ${data.javaDbName?uncap_first},int pageSize,int currentPage){
		PageHelper.startPage(currentPage, pageSize);
		List<${data.javaDbName}> ${data.javaDbName?uncap_first}List = ${data.javaDbName?uncap_first}${daoConvention.suffix}.getByAttrList(${data.javaDbName?uncap_first});
		return new PageInfo<${data.javaDbName}>(${data.javaDbName?uncap_first}List);
	}
	
	public List<${data.javaDbName}> getByAttrList(${data.javaDbName} ${data.javaDbName?uncap_first}){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.getByAttrList(${data.javaDbName?uncap_first});
	}
	
	public ${data.javaDbName} getByAttrSingle(${data.javaDbName} ${data.javaDbName?uncap_first}){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.getByAttrSingle(${data.javaDbName?uncap_first});
	}
	
	public int update(${data.javaDbName} ${data.javaDbName?uncap_first}){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.update(${data.javaDbName?uncap_first});
	}
	
	
	public int save(${data.javaDbName} ${data.javaDbName?uncap_first}){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.insert(${data.javaDbName?uncap_first});
	}
	
	
	public int delete(<#rt>
	<#list data.pkList as pk>
	<#if pk_has_next>
		<#lt>${pk.javaAttrType} ${pk.javaAttrName},<#rt>
	<#else>
		<#lt>${pk.javaAttrType} ${pk.javaAttrName}<#rt>
	</#if>
	</#list>
	<#lt>){
		return ${data.javaDbName?uncap_first}${daoConvention.suffix}.delete(<#rt>
	<#list data.pkList as pk>
	<#if pk_has_next>
		<#lt>${pk.javaAttrName},<#rt>
	<#else>
		<#lt>${pk.javaAttrName}<#rt>
	</#if>
	</#list>
	<#lt>);
	}
}