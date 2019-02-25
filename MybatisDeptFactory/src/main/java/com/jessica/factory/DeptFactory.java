package com.jessica.factory;

import com.jessica.entity.Dept;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class DeptFactory extends DefaultObjectFactory {
    @Override
    public Object create(Class type) {
        Dept dept = null;
        if (type == Dept.class) {
            dept = (Dept)super.create(type);
            dept.setCountry("China");
            return dept;
        } else {
            return super.create(type);
        }
    }
}
