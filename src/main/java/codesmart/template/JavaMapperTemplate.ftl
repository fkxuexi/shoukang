package ${config.basePackage!}.${convention.packageName!};

import ${config.basePackage!}.${entityConvention.packageName!}.${data.javaDbName!};
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ${data.javaDbName!}${convention.suffix!} {
	
	
	int insert(${data.javaDbName?cap_first} ${data.javaDbName});
	
	
<#if data.pkList?size == 1>
	${data.javaDbName} get(@Param("${data.pkList[0].javaAttrName}") ${data.pkList[0].javaAttrType!} ${data.pkList[0].javaAttrName});
<#else>
	${data.javaDbName} get(<#rt>
	<#list data.pkList as pk>
		<#if pk_has_next>
			<#lt>@Param("${pk.javaAttrName}") ${pk.javaAttrType!} ${pk.javaAttrName},<#rt>
		<#else>
			<#lt>@Param("${pk.javaAttrName}") ${pk.javaAttrType!} ${pk.javaAttrName}<#rt>
		</#if>
	</#list>
	<#lt>);
</#if>
	
	List<${data.javaDbName?cap_first}> getByAttrList(${data.javaDbName?cap_first} ${data.javaDbName});	
	
	${data.javaDbName?cap_first} getByAttrSingle(${data.javaDbName?cap_first} ${data.javaDbName});
	
	int update(${data.javaDbName?cap_first} ${data.javaDbName});
	
<#if data.pkList?size == 1>
	int delete(@Param("${data.pkList[0].javaAttrName}") ${data.pkList[0].javaAttrType!} ${data.pkList[0].javaAttrName});
<#else>
	int delete(<#rt>
	<#list data.pkList as pk>
		<#if pk_has_next>
			<#lt>@Param("${pk.javaAttrName}") ${pk.javaAttrType!} ${pk.javaAttrName},<#rt>
		<#else>
			<#lt>@Param("${pk.javaAttrName}") ${pk.javaAttrType!} ${pk.javaAttrName}<#rt>
		</#if>
	</#list>
	<#lt>);
</#if>


}

