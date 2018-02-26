<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${config.basePackage!}.${daoConvention.packageName!}.${data.javaDbName!}${convention.suffix!}">
	
	<resultMap id="baseMap" type="${data.javaDbName!}">
	<#list data.pkList! as pk>
		<id property="${pk.javaAttrName!}" column="${pk.dbAttrName!}" />
	</#list>	
	<#list data.colList! as col>
		<result property="${col.javaAttrName!}" column="${col.dbAttrName!}"/>
	</#list>
	</resultMap>
	
	<sql id="selectSql">
		<trim prefix="where" prefixOverrides="AND |OR ">
		<#list data.pkList! as pk>
			<if test="${pk.javaAttrName!} != null"> and ${pk.dbAttrName!} = ${r'#{'}${pk.javaAttrName!}${r'}'} </if>
		</#list>	
		</trim>
	</sql>
	
	<sql id="updateSql">
		<trim prefix="set" suffixOverrides=",">
		<#list data.colList! as col>
			<if test="${col.javaAttrName!} != null">  ${col.dbAttrName!} = ${r'#{'}${col.javaAttrName!}${r'}'} ,</if>
		</#list>
		</trim>
		<trim prefix="where" prefixOverrides="AND |OR ">
		<#list data.pkList! as pk>
			<if test="${pk.javaAttrName!} != null"> and ${pk.dbAttrName!} = ${r'#{'}${pk.javaAttrName!}${r'}'} </if>
		</#list>
		</trim>
	</sql>
	
	
	
	<select id="get" resultMap="baseMap">
		select * from ${data.dbName!}
		<include refid="selectSql" />
	</select>
	
	<select id="getByAttrList" resultMap="baseMap">
		select * from ${data.dbName!}
		<trim prefix="where" prefixOverrides="AND |OR ">
		<#list data.colList! as col>
			<if test="${col.javaAttrName!} != null"> and ${col.dbAttrName!} = ${r'#{'}${col.javaAttrName!}${r'}'} </if>
		</#list>
		</trim>
	</select>
	
	<select id="getByAttrSingle" resultMap="baseMap">
		select * from ${data.dbName!}
		<trim prefix="where" prefixOverrides="AND |OR ">
		<#list data.colList! as col>
			<if test="${col.javaAttrName!} != null"> and ${col.dbAttrName!} = ${r'#{'}${col.javaAttrName!}${r'}'} </if>
		</#list>
		</trim>
	</select>
	
	<update id="update" parameterType="${data.javaDbName!}"> 
		update ${data.dbName!}
		<include refid="updateSql" />	
	</update>
	
<#if data.pkList?size == 1>	
	<insert id="insert" parameterType="${data.javaDbName}" useGeneratedKeys="true" keyProperty="${data.pkList[0].javaAttrName!}">
		insert into ${data.dbName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		<#list data.colList! as col>
			<if test="${col.javaAttrName!} != null">  ${col.dbAttrName!} ,</if>
		</#list>			
		</trim>
		<trim prefix="value (" suffix=")" suffixOverrides=",">
		<#list data.colList! as col>
			<if test="${col.javaAttrName!} != null"> ${r'#{'}${col.javaAttrName!}${r'}'} ,</if>
		</#list>
		</trim>
<#else>
	<insert id="insert" parameterType="${data.javaDbName}">
	insert into ${data.dbName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
		<#list data.allColList! as col>
			<if test="${col.javaAttrName!} != null">  ${col.dbAttrName!} ,</if>
		</#list>			
		</trim>
		<trim prefix="value(" suffix=")" suffixOverrides=",">
		<#list data.allColList! as col>
			<if test="${col.javaAttrName!} != null"> ${r'#{'}${col.javaAttrName!}${r'}'} ,</if>
		</#list>
		</trim>
</#if>	
	</insert>
	
	<delete id="delete">
		delete from ${data.dbName}
		<trim prefix="where" prefixOverrides="AND |OR ">
		<#list data.pkList! as pk>
			<if test="${pk.javaAttrName!} != null"> and ${pk.dbAttrName!} = ${r'#{'}${pk.javaAttrName!}${r'}'} </if>
		</#list>
		</trim>
	</delete>
	
	
	
</mapper>