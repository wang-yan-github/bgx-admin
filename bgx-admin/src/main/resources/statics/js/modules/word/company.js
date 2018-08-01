$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'word/company/list',
        datatype: "json",
        colModel: [
            { label: 'cId', name: 'cId', index: 'c_id', width: 50,key: true },
            { label: '状态 ', name: 'status', index: 'status',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "101") {return "<font color='#5bc0de'>信息待审核</font>";}
                    if (cellvalue == "102") {return "<font color='#5cb85c'>信息审核已通过</font>";}
                    if (cellvalue == "103") {return "<font color='#f0ad4e'>信息审核未通过</font>";}
                    if (cellvalue == "314") {return "<font color='#5bc0de'>合同待审核</font>";}
                    if (cellvalue == "316") {return "<font color='#5cb85c'>合同审核已通过</font>";}
                    if (cellvalue == "315") {return "<font color='#f0ad4e'>合同审核未通过</font>";}
                    else{return cellvalue;}
                }
            },
            { label: '发包方类型 ', name: 'companyType', index: 'company_type',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "1") {return "<font color='#337ab7'>个人</font>";}
                    if (cellvalue == "2") {return "<font color='#8b4513'>工程</font>";}
                    else{return cellvalue;}
                }
            },
            { label: '详细地址 ', name: 'address', index: 'address' },
            { label: '年龄 ', name: 'age', index: 'age' },
            { label: '企业认证授权书 ', name: 'authorization', index: 'authorization' },
            { label: '出生日期 ', name: 'birthday', index: 'birthday' },
            { label: '营业执照 ', name: 'bizlicense', index: 'bizlicense' },
            { label: '身份证地址 ', name: 'cardAddress', index: 'card_address' },
            { label: '创建时间 ', name: 'createTime', index: 'create_time' },
            { label: '信用等级 ', name: 'creditRating', index: 'credit_rating' },
            { label: '信用积分 ', name: 'creditScore', index: 'credit_score' },
            { label: '联系人姓名 ', name: 'dutyName', index: 'duty_name' },
            { label: '联系人电话 ', name: 'dutyPhone', index: 'duty_phone' },
            { label: '头像 ', name: 'headPortrait', index: 'head_portrait' },
            { label: '邀请码 ', name: 'iCode', index: 'i_code' },
            { label: '身份证号 ', name: 'idCard', index: 'id_card' },
            { label: '登录时间 ', name: 'loginTime', index: 'login_time' },
            { label: '名称 ', name: 'name', index: 'name' },
            { label: '开户许可证 ', name: 'openingPermit', index: 'opening_permit' },
            { label: '组织机构代码 ', name: 'orgcode', index: 'orgcode' },
            { label: '所属地区 ', name: 'region', index: 'region' },
            { label: '税务登记证 ', name: 'registration', index: 'registration' },
            { label: '备注 ', name: 'remark', index: 'remark' },
            { label: '性别 ', name: 'sex', index: 'sex' },
            { label: '缩略名称 ', name: 'shortName', index: 'short_name' },
            { label: '法人名称 ', name: 'tdutyName', index: 'tduty_name' },
            { label: '座机号码 ', name: 'tel', index: 'tel' }
        ],
        shrinkToFit:false,
        autoScroll: true,
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            //$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        company: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.company = {};
        },
        update: function (event) {
            var cId = getSelectedRow();
            if(cId == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(cId)
        },
        saveOrUpdate: function (event) {
            var url = vm.company.cId == null ? "word/company/save" : "word/company/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.company),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var cIds = getSelectedRows();
            if(cIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "word/company/delete",
                    contentType: "application/json",
                    data: JSON.stringify(cIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function(cId){
            $.get(baseURL + "word/company/info/"+cId, function(r){
                vm.company = r.company;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                page:page
            }).trigger("reloadGrid");
        }
    }
});