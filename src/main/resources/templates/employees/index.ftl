<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
    <!-- (2)自己写的div start -->
    <div id="wrapper" class="toggled">

        <#-- (3)边栏sidebar-->
        <#include  "../common/nav.ftl">

        <!-- (4) 主要内容content start -->
        <div class="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 start -->
                    <div class="col-md-12 column">
                        <#--显示系统时间-->
                        <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                        <form role="form" method="post" action="/personnel/employees/save">

                            <div class="form-group">
                                <label>员工照片</label>
                                <img height="100px;" width="100px;" src="${(employees.empPhoto)!''}" alt="该图片不存在!"/> <br/>
                                <input id="productIcon" name="empPhoto" type="text" placeholder="建议使用在线图床图片" value="${(employees.empPhoto)!''}" width="50%"/>
                            </div>

                            <div class="form-group">
                                <label>员工姓名</label>
                                <input type="text" class="form-control" id="productPrice" name="empName" value="${(employees.empName)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工性别</label>
                                    <#--<select name="empSex"  id="categoryType" class="form-control">
                                &lt;#&ndash;<option value="">--请选择--</option>&ndash;&gt;
                                    <option value="0" <#if employees.empSex?? && employees.empSex! ==0>selected</#if>>
                                        女
                                    </option>

                                    <option value="1" <#if employees.empSex?? && employees.empSex! ==1>selected</#if>>
                                        男
                                    </option>
                                    </select>-->

                                <input type="text" class="form-control" id="productStock" name="empSex" placeholder="0 为女性，1 为男性"
                                       value="${(employees.empSex)!''}"/>
                                <#--<input type="text" class="form-control" id="productStock" placeholder="0为女性，1为男性"
                                       name="getEmpSexEnum().message" value="${(employees.getEmpSexEnum().message)!''}"/>-->
                            </div>

                            <div class="form-group">
                                <label>员工邮箱</label><input type="text" class="form-control" id="productDescription" name="empEmail" value="${(employees.empEmail)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>员工手机号码</label><input type="text" class="form-control" id="productName" name="empPhone" value="${(employees.empPhone)!''}"/>
                            </div>
                            <#--<div class="form-group">
                                <label>员工部门</label><input type="text" class="form-control" id="productName" name="depName" value="${(employees.depName)!''}"/>
                            </div>-->
                            <div class="form-group">
                                <label>员工身份证号码</label><input type="text" class="form-control" id="productName" name="empIdCard" value="${(employees.empIdCard)!''}"/>
                            </div>

                            <#--
                            <div class="form-group">
                                <label>员工入职时间</label><input type="text" class="form-control" id="productName" name="productName" value="${(employees.empEntry)!''}"/>
                            </div>
                            -->
                            <div class="form-group">
                                <label>员工婚姻状态</label>
                                <#--<select name="empMarital" id="categoryType" class="form-control">
                                    &lt;#&ndash;<option value="">--请选择--</option>&ndash;&gt;
                                    <option value="0" <#if employees.empMarital?? && employees.empMarital! ==0>selected</#if>>
                                        未婚
                                    </option>

                                    <option value="1" <#if employees.empMarital?? && employees.empMarital! ==1>selected</#if>>
                                        已婚
                                    </option>
                                </select>-->

                                <input type="text" class="form-control" id="productName" name="empMarital" placeholder="0为未婚，1为已婚"
                                       value="${(employees.empMarital)!''}"/>
                                <#--<label>员工婚姻状态</label><input type="text" class="form-control" id="productName" name="getEmpMaritalEnum().message"
                                                            value="${(employees.getEmpMaritalEnum().message)!''}"/>-->
                            </div>

                            <div class="form-group">
                                <label>员工备注</label><input type="text" class="form-control" id="productName" name="empRemarks" value="${(employees.empRemarks)!''}"/>
                            </div>

                            <div class="form-group">
                                <label>部门规划</label>
                                <select name="depName" id="categoryType" class="form-control">
                                    <#--部门信息-->
                                   <#list departmentsList as departments>
                                        <option value="${departments.depName}"
                                        <#if (employees.depName)?? && employees.depName == departments.depName> selected </#if> >
                                            ${departments.depName}
                                        </option>
                                    </#list>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-default">提交结果</button>
                            <input  type="hidden" name="empId" value="${(employees.empId)!''}">
                        </form>
                    </div>
                    <!--  复制 从 http://www.ibootstrap.cn 里面下载的内容 end -->


                </div>
            </div>
        </div>
        <!-- (4) 主要内容content end -->

    </div>
    <!-- (2)自己写的div end -->
</body>
</html>
