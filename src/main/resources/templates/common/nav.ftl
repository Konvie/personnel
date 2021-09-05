<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                人事管理系统
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 在职 <span class="caret"></span></a>
            <li class="dropdown-header">员工信息</li>

            <li><a href="/personnel/employees/list">员工</a></li>
            <li><a href="/personnel/employees/index">新增</a></li>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 综合 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">业绩评价</li>
                <li><a href="/sell/seller/category/list">列表</a></li>
                <#--<li><a href="/sell/seller/category/index">新增</a></li>-->

                <li class="dropdown-header">工资发放</li>
                <li><a href="/personnel/salaries/list">列表</a></li>
                <li><a href="/personnel/salaries/index">新增</a></li>

            </ul>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 部门 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">部门调整</li>
                <li><a href="/sell/seller/category/list">列表</a></li>
                <li><a href="/sell/seller/category/index">新增</a></li>
            </ul>
        </li>

        <li>
            <a href="/personnel/seller/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>