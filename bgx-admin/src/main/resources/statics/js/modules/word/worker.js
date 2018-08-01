$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'word/worker/list',
        datatype: "json",
        colModel: [			
			{ label: 'wId', name: 'wId', index: 'w_id', width: 50,key: true },
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
            { label: '类型 ', name: 'type', index: 'type',
                formatter: function (cellvalue, options, rowObject) {
                    if (cellvalue == "2") {return "<font color='#663399'>劳务公司</font>";}
                    if (cellvalue == "3") {return "<font color='#8b4513'>包工侠</font>";}
                    if (cellvalue == "4") {return "<font color='#337ab7'>劳务</font>";}
                    else{return cellvalue;}
                }
            },
			{ label: '详细地址 ', name: 'address', index: 'address' }, 			
			{ label: '年龄 ', name: 'age', index: 'age' }, 			
			{ label: '出生日期 ', name: 'birthday', index: 'birthday' }, 			
			{ label: '身份证地址 ', name: 'cardAddress', index: 'card_address' }, 			
			{ label: '资质证书 ', name: 'certificate', index: 'certificate' }, 			
			{ label: '劳务所属公司 ', name: 'company', index: 'company' }, 			
			{ label: '施工工种 ', name: 'consType', index: 'cons_type' }, 			
			{ label: '创建时间 ', name: 'createTime', index: 'create_time' }, 			
			{ label: '信用等级 ', name: 'creditRating', index: 'credit_rating' }, 			
			{ label: '信用积分 ', name: 'creditScore', index: 'credit_score' }, 			
			{ label: '联系人姓名 ', name: 'dutyName', index: 'duty_name' }, 			
			{ label: '联系人电话 ', name: 'dutyPhone', index: 'duty_phone' }, 			
			{ label: '头像 ', name: 'headPortrait', index: 'head_portrait' },
			{ label: '邀请码 ', name: 'iCode', index: 'i_code' }, 			
			{ label: '身份证号 ', name: 'idCard', index: 'id_card' }, 			
			{ label: '工程相册 ', name: 'imgs', index: 'imgs' }, 			
			{ label: '自我介绍 ', name: 'introduction', index: 'introduction' }, 			
			{ label: '登录时间 ', name: 'loginTime', index: 'login_time' }, 			
			{ label: '最高薪资 ', name: 'maximum', index: 'maximum' }, 			
			{ label: '最低薪资 ', name: 'minimum', index: 'minimum' }, 			
			{ label: '名称 ', name: 'name', index: 'name' }, 			
			{ label: '所属职位 ', name: 'position', index: 'position' }, 			
			{ label: '所属地区 ', name: 'region', index: 'region' }, 			
			{ label: '备注 ', name: 'remark', index: 'remark' }, 			
			{ label: '性别 ', name: 'sex', index: 'sex' },
			{ label: '技术类型 ', name: 'technicalType', index: 'technical_type' }, 			
			{ label: '可工作地 ', name: 'workAddress', index: 'work_address' },
			{ label: '从业年限 ', name: 'workTime', index: 'work_time' }			
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
		worker: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.worker = {};
		},
		update: function (event) {
			var wId = getSelectedRow();
			if(wId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(wId)
		},
		saveOrUpdate: function (event) {
			var url = vm.worker.wId == null ? "word/worker/save" : "word/worker/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.worker),
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
			var wIds = getSelectedRows();
			if(wIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "word/worker/delete",
                    contentType: "application/json",
				    data: JSON.stringify(wIds),
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
		getInfo: function(wId){
			$.get(baseURL + "word/worker/info/"+wId, function(r){
                vm.worker = r.worker;
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