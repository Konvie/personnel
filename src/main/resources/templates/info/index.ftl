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

                            <form role="form" method="post" action="/personnel/information/save">
                                <div class="form-group">
                                    <label>员工姓名</label>
                                    <input name="empName" type="text" class="form-control" value="${(information.empName)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>基本金额</label>
                                    <input name="salBase" type="number" class="form-control" value="${(information.salBase)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>奖金金额</label>
                                    <input name="salBonus" type="number" class="form-control" value="${(information.salBonus)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>奖金描述</label>
                                    <input name="salBonusDescribes" type="text" class="form-control" value="${(information.salBonusDescribes)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>扣除金额</label>
                                    <input name="salFine" type="number" class="form-control" value="${(information.salFine)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>扣除描述</label>
                                    <input name="salFineDescribes" type="text" class="form-control" value="${(information.salFineDescribes)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>保险福利</label>
                                    <input name="salBenefits" type="number" class="form-control" value="${(information.salBenefits)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>备注</label>
                                    <input name="salRemarks" type="text" class="form-control" value="${(information.salRemarks)!''}"/>
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
