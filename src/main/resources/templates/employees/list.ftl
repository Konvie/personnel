<html>

<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  -->
<!-- 自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/nav.ftl">
    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <#--显示系统时间-->
                <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                <!-- 表格内容 start  -->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <th>序号</th>
                        <th>员工ID</th>
                        <th>员工照片</th>
                        <th>员工姓名</th>
                        <th>员工性别</th>
                        <th>员工邮箱</th>
                        <th>员工手机号码</th>
                       <#-- <th>员工部门编号</th>-->
                        <th>员工部门</th>
                        <th>员工身份证号码</th>
                        <th>员工入职时间</th>
                        <th>员工婚姻状态</th>
                        <th>员工备注</th>

                        <th colspan="2">操作</th>
                        </thead>

                        <tbody>
                        <#if employeesPageList.content??>
                            <#list employeesPageList.content as employees>
                                <tr>
                                    <td>${employees_index + 1}</td>
                                    <td>${employees.empId}</td>
                                    <#--<td>${employees.empId}</td>-->
                                    <td><img height="100" width="100" src="${employees.empPhoto}" alt="该图片不存在!"></td>

                                    <td>${employees.empName}</td>
                                    <td>${employees.getEmpSexEnum().message}</td>
                                    <td>${employees.empEmail}</td>
                                    <td>${employees.empPhone}</td>
                                    <#--<td>${employees.depId}</td>-->
                                    <td>${employees.depName}</td>

                                    <#--<td>${employees.depName}</td>-->
                                    <td>${employees.empIdCard}</td>

                                    <td>${employees.empEntry}</td>
                                    <td>${employees.getEmpMaritalEnum().message}</td>
                                    <td>${employees.empRemarks}</td>

                                    <td><a href="/personnel/employees/index?empId=${employees.empId}">修改</a></td>

                                </tr>
                            </#list>
                        </#if>
                        </tbody>

                        <#--主要内容content end -->
                    </table>
                </div>
                <!-- 表格内容 end  -->

                <!-- 分页 start -->
                <div class="col-md-12 column">
                    <!-- 让分页居右-->
                    <ul class="pagination pull-right">

                        <!-- 上一页处理  start-->
                        <#if currentPage lte 1>
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/employees/list?page=${currentPage - 1}&size=${pageSize}">上一页</a>
                            </li>
                        </#if>

                        <!-- 上一页处理  end-->
                        <!-- 代循环遍历(根据DB中查询出来的 带分页查询所有的订单列表) start-->
                        <#list 1..employeesPageList.getTotalPages() as index>
                            <!--  让当前页置灰  -->
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/employees/list?page=${index}&size=${pageSize}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/employees/list?page=${index}&size=${pageSize}">${index}</a>
                                </li>
                            </#if>
                        </#list>

                        <!-- 代循环遍历(根据DB中查询出来的 带分页查询所有的订单列表) start-->
                        <!-- 下一页处理  start-->
                        <#if currentPage gte employeesPageList.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/employees/list?page=${currentPage + 1}&size=${pageSize}">上一页</a>
                            </li>
                        </#if>
                        <!-- 下一页处理  end-->
                    </ul>
                </div>
                <!-- 分页 end -->

            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end -->
</div>
<!-- (2)自己写的div end -->
</body>
</html>
