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
                    <form role="form" method="post" action="/personnel/departments/save">
                        <!--
                        <div class="form-group">
                            <label>部门ID</label><input type="text" class="form-control" id="depId" name="depId" !''}"/>
                        </div>
                        -->
                        <div class="form-group">
                            <label>部门名称</label><input type="text" class="form-control" id="depName" name="depName" value="${(departments.depName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>部门描述</label><input type="text" class="form-control" id="depDescribes" placeholder="简明扼要"
                                                      name="depDescribes" value="${(departments.depDescribes)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>备注</label><input type="text" class="form-control" id="depRemarks" name="depRemarks" value="${(departments.depRemarks)!''}"/>
                        </div>

                        <button type="submit" class="btn btn-default">提交结果</button>
                        <input  type="hidden" name="depId" value="${(departments.depId)!''}">
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