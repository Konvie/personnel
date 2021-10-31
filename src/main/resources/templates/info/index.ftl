<html>
    <#include "../common/header.ftl">
    <body>
        <div id="wrapper" class="toggled">
            <#-- 边栏sidebar -->
            <#include "../common/nav.ftl">

            <#-- 主要内容content start -->
            <div class="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <#--显示系统时间-->
                            <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>

                            <form role="form" method="post" action="/personnel/info/save">
                                <div class="form-group">
                                    <label>员工姓名</label>
                                    <input name="empName" type="text" class="form-control" value="${(information.empName)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>学历</label>
                                    <input name="infEducation" type="text" class="form-control" value="${(information.infEducation)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>政治面貌</label>
                                    <input name="infPolitical" type="text" class="form-control" value="${(information.infPolitical)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>入职时间</label>
                                    <input name="infEntry" type="text" class="form-control" value="${(information.infEntry)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>籍贯</label>
                                    <input name="infPlace" type="number" class="form-control" value="${(information.infPlace)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>婚姻状况</label>
                                    <input name="infMarital" type="text" class="form-control" value="${(information.infMarital)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>备注</label>
                                    <input name="infRemarks" type="number" class="form-control" value="${(information.infRemarks)!''}"/>
                                </div>
                                <button type="submit" class="btn btn-default">提交</button>
                                <input type="hidden" name="empId" value="${(information.empId)!''}">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <#-- 主要内容content end -->
        </div>
    </body>
</html>
