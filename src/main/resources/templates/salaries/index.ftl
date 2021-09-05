<html>
    <#include "../common/header.ftl">

    <body>
        <div id="wrapper" class="toggled">
            <#-- 边栏sidebar -->
            <#include "../common/nav.ftl">

            <#-- 主要内容content start -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <form role="form" method="post" action="/personnel/salaries/save">
                                <div class="form-group">
                                    <label>员工姓名</label>
                                    <input name="empName" type="text" class="form-control" value="${(salaries.empName)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>基本金额</label>
                                    <input name="salBase" type="text" class="form-control" value="${(salaries.salBase)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>奖金金额</label>
                                    <input name="salBonus" type="text" class="form-control" value="${(salaries.salBonus)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>奖金描述</label>
                                    <input name="salBonusDescribes" type="text" class="form-control" value="${(salaries.salBonusDescribes)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>扣除金额</label>
                                    <input name="salFine" type="text" class="form-control" value="${(salaries.salFine)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>扣除描述</label>
                                    <input name="salFineDescribes" type="text" class="form-control" value="${(salaries.salFineDescribes)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>保险福利</label>
                                    <input name="salBenefits" type="text" class="form-control" value="${(salaries.salBenefits)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>最终金额</label>
                                    <input name="salFinal" type="text" class="form-control" value="${(salaries.salFinal)!''}"/>
                                </div>
                                <div class="form-group">
                                    <label>备注</label>
                                    <input name="salRemarks" type="text" class="form-control" value="${(salaries.salRemarks)!''}"/>
                                </div>
                                <button type="submit" class="btn btn-default">提交</button>
                                <input type="hidden" name="empId" value="${(salaries.empId)!''}">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <#-- 主要内容content end -->
        </div>
    </body>
</html>
