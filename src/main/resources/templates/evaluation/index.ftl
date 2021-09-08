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
                    <form role="form" method="post" action="/personnel/evaluation/save">
                        <!--
                        <div class="form-group">
                            <label>员工ID</label><input type="text" class="form-control" id="empId" name="empId" ''}"/>
                        </div>
                        -->
                        <div class="form-group">
                            <label>员工出勤</label><input type="text" class="form-control" id="evaAttendance" placeholder="天数，满勤为22天"
                                                      name="evaAttendance" value="${(evaluation.evaAttendance)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工迟到</label><input type="text" class="form-control" id="evaLate" placeholder="迟到每人每天￥20"
                                                      name="evaLate" value="${(evaluation.evaLate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工评级</label>
                            <#--<select name="evaLevel" id="evaLevel" class="form-control">
                                &lt;#&ndash;<option value="">--请选择--</option>&ndash;&gt;
                                <option value="A" <#if evaluation.evaLevel?? && evaluation.evaLevel! =="A">selected</#if>>
                                    A
                                </option>

                                <option value="B" <#if evaluation.evaLevel?? && evaluation.evaLevel! =="B">selected</#if>>
                                    B
                                </option>

                                <option value="C" <#if evaluation.evaLevel?? && evaluation.evaLevel! =="C">selected</#if>>
                                    C
                                </option>

                                <option value="B" <#if evaluation.evaLevel?? && evaluation.evaLevel! =="D">selected</#if>>
                                    D
                                </option>

                            </select>-->
                            <input type="text" class="form-control" id="evaLevel" name="evaLevel" placeholder="A(优) B(良) C(中) D(差)"
                                   value="${(evaluation.evaLevel)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>加班工时</label><input type="text" class="form-control" id="evaOvertime" placeholder="按小时计算"
                                                      name="evaOvertime" value="${(evaluation.evaOvertime)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>员工备注</label><input type="text" class="form-control" id="evaRemarks" name="evaRemarks" value="${(evaluation.evaRemarks)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="empId" value="${(evaluation.empId)!''}">
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