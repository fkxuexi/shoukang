package ${config.basePackage!}.${convention.packageName};

<#list data.importStr! as impor>
import ${impor!};
</#list>

/**
* @Auth 
* ${data.remark!}
*/
<#-- 字段是可以有默认值的，但是这里先不写 -->
public class ${data.javaDbName!}{
	
<#list data.allColList! as col>
	private ${col.javaAttrType!} ${col.javaAttrName!};  // 注释：${col.remark!}   
</#list>

<#list data.allColList! as col>
	public void set${col.javaAttrName?cap_first}(${col.javaAttrType!} ${col.javaAttrName}){
		this.${col.javaAttrName} = ${col.javaAttrName};
	}
	
	public ${col.javaAttrType!} get${col.javaAttrName?cap_first}(){
		return ${col.javaAttrName};
	}
	
</#list>

	@Override
	public String toString(){
		return "${data.javaDbName?cap_first}["  	
<#list data.allColList! as col>
		<#if col_index == 0>
				+ "${col.javaAttrName} = " + ${col.javaAttrName}
		<#else>
				+ " , ${col.javaAttrName} = " + ${col.javaAttrName}
		</#if> 
</#list>
				+ "]";
	}
}

