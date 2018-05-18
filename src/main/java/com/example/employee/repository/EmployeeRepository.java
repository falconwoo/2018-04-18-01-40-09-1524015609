package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //以下所有的*都代表变量

    //1.查询名字是*的第一个employee
    Employee findFirstEmployeeByName(String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
    Employee findFirstEmployeeByNameContainingAndSalaryGreaterThan(String name, int salary);

    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
    Employee findTopEmployeeByCompanyIdOrderBySalaryDesc(int companyId);

    //4.实现对Employee的分页查询，每页两个数据

    //5.查找**的所在的公司的公司名称
    @Query("select c.companyName from Company c join Employee e on c.id = e.id and e.name=:name")
    String findCompanyNameByEmployeeName(@Param("name") String employName);

    //6.将*的名字改成*,输出这次修改影响的行数
    @Modifying
    @Query("update Employee set name = ?2 where name = ?1")
    int changeEmployeeName(String originalName, String newName);

    //7.删除姓名是*的employee
    @Modifying
    @Query("delete from Employee where name = :name")
    void deleteEmplyeeByName(@Param("name") String name);
}
