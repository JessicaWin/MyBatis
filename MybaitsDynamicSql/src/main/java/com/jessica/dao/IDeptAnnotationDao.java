package com.jessica.dao;

import com.jessica.InsertListProvider;
import com.jessica.ParamProvider;
import com.jessica.UpdateDeptProvider;
import com.jessica.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IDeptAnnotationDao {
    @Select({"<script>",
            "select * from dept",
            "where 1=1",
            "<if test='depNo != null and depNo!=0'>",
            "and depNo = #{depNo}",
            "</if>",
            "<if test='depName!=null'>",
            "and depName like '%' #{depName} '%'",
            "</if>",
            "<if test='loc != null'>",
            "and loc = #{loc}",
            "</if>",
            "</script>"})
    List<Dept> selectDept1(Dept dept) throws IOException;

    @SelectProvider(type = ParamProvider.class, method = "queryDeptByParamChoose")
    List<Dept> selectDept2(Dept dept) throws IOException;

    @SelectProvider(type = ParamProvider.class, method = "queryDeptByParam")
    List<Dept> selectDept3(Dept dept) throws IOException;

    @Select("select * from ${value}")
    List<Dept> selectAll(String tableName) throws IOException;

    @UpdateProvider(type = UpdateDeptProvider.class, method = "updateDept")
    int updateDept(Dept dept) throws IOException;

    @Select({"<script>",
            "select * from dept",
            "where",
            "<trim prefix='' prefixOverrides='and|or' suffix='' suffixOverrides=','>",
            "<if test='depNo != null and depNo!=0'>",
            "and depNo = #{depNo}",
            "</if>",
            "<if test='depName!=null'>",
            "and depName like '%' #{depName} '%'",
            "</if>",
            "<if test='loc != null'>",
            "and loc = #{loc}",
            "</if>",
            "</trim>",
            "</script>"})
    List<Dept> findTrim(Dept dept) throws IOException;

    @InsertProvider(type= InsertListProvider.class, method = "insertDeptList")
    int insertForEach(List<Dept> deptList) throws IOException;

    @Select({"<script>",
          "select * from dept",
          "where depNo in",
          "<foreach collection='list' item='deptNo' open='(' close=')' separator=','>",
          "#{deptNo}",
          "</foreach>",
          "</script>"})
    List<Dept> findByList(List<Integer> keyList) throws IOException;

    @Select({"<script>",
            "select * from dept",
            "where depNo in" ,
            "<foreach collection='array' item='deptNo' open='(' close=')' separator=','>" ,
            "#{deptNo}",
            "</foreach>",
            "</script>"})
    List<Dept> findByArray(Integer[] keyArray) throws IOException;

    @Select({"<script>",
            "select * from dept",
            "where depNo in" ,
            "<foreach collection='keyMap.values' item='deptNo' open='(' close=')' separator=','>" ,
            "#{deptNo}",
            "</foreach>",
            "</script>"})
    List<Dept> findByMap(@Param(value = "keyMap") Map<String, Integer> keyMap) throws IOException;
}
